package springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import springmvc.authority.Auth;
import springmvc.dao.AccountDAO;
import springmvc.dao.AssignmentDAO;
import springmvc.dao.CommentDAO;
import springmvc.dao.CourseDAO;
import springmvc.dao.EnrolmentDAO;
import springmvc.dao.FileDAO;
import springmvc.dao.ForumDAO;
import springmvc.dao.MaterialDAO;
import springmvc.dao.NotificationDAO;
import springmvc.dao.StudentDAO;
import springmvc.dao.TeacherDAO;
import springmvc.model.Account;
import springmvc.model.Assignment;
import springmvc.model.Comment;
import springmvc.model.Course;
import springmvc.model.Enrolment;
import springmvc.model.FileAs;
import springmvc.model.Forum;
import springmvc.model.Material;
import springmvc.model.Notification;
import springmvc.model.Student;
import springmvc.model.Teacher;

@Controller
public class HomeController {
	@Autowired
	NotificationDAO notificationDAO;
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	AssignmentDAO assignmentDAO;
	@Autowired
	CommentDAO commentDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	EnrolmentDAO enrolmentDAO;
	@Autowired
	FileDAO fileDAO;
	@Autowired
	ForumDAO forumDAO;
	@Autowired
	MaterialDAO materialDAO;
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	TeacherDAO teacherDAO;

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/home")
	public ModelAndView studentHome(ModelAndView model, HttpSession session) throws IOException, SQLException {
		model.addObject("username", session.getAttribute("user"));
		model.addObject("userrole", session.getAttribute("role"));
		Student stdn = studentDAO.get((String) session.getAttribute("user"));
		if (stdn == null) {
			model.addObject("user", session.getAttribute("user"));
			model.addObject("student", new Student());
			model.addObject("studentO", new Student());
			model.setViewName("webuse/updateProfile");
		} else {
			session.setAttribute("studentID", stdn.getStudentID());
			model.addObject("enrolments", enrolmentDAO.list(stdn.getStudentID()));
			model.addObject("notifications", notificationDAO.list());
			model.setViewName("webuse/studentHome");
		}

		return model;
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/viewAllCourse")
	public ModelAndView viewAllCourse(ModelAndView model, HttpSession session) throws IOException {
		model.addObject("username", session.getAttribute("user"));
		model.addObject("userrole", session.getAttribute("role"));
		model.addObject("courses", courseDAO.list());
		model.setViewName("webuse/allcourse");
		return model;
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/course/{courseID}")
	public ModelAndView courseDetail(ModelAndView model, @PathVariable("courseID") String courseID) {
		model.addObject("course", courseDAO.get(courseID));
		List<Forum> f =  forumDAO.list(courseID);
		List<Material> m = materialDAO.list(courseID);
		List<Assignment> a = assignmentDAO.list(courseID);
		if(f.size()==0) {
			model.addObject("fmsg", "No forum!");
		}else {
			model.addObject("forums",f);
		}
		if(m.size()==0) {
			model.addObject("mmsg", "No material");
		}else {
			model.addObject("materials",m);
		}
		if(a.size()==0) {
			model.addObject("amsg", "No assignment!");
		}else {
			model.addObject("assignments", a);
		}
		model.setViewName("/webuse/CourseDetail");
		return model;
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/coursetoenroll/{courseID}")
	public ModelAndView courseToEnroll(ModelAndView model, @PathVariable("courseID") String courseID,
			HttpSession session) {
		if (enrolmentDAO.isEnroll((int) session.getAttribute("studentID"), courseID) != null) {
			model.addObject("isenroll", "Unenroll");
		} else {
			model.addObject("isenroll", "Enroll");
		}
		Course course = courseDAO.get(courseID);
		model.addObject("course", course);
		model.addObject("teacher", teacherDAO.get(course.getTeacherID()));
		model.setViewName("/webuse/coursetoenroll");
		return model;
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/coursetoenroll/{courseID}/Unenroll")
	public ModelAndView courseUnenroll(ModelAndView model, @PathVariable("courseID") String courseID,
			HttpSession session) {
		enrolmentDAO.unenrol((int) session.getAttribute("studentID"), courseID);
		model.setViewName("redirect:/STUDENT/coursetoenroll/" + courseID);
		return model;
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/coursetoenroll/{courseID}/Enroll")
	public ModelAndView courseEnroll(ModelAndView model, @PathVariable("courseID") String courseID,
			HttpSession session) {
		enrolmentDAO.enrol((int) session.getAttribute("studentID"), courseID);
		model.setViewName("redirect:/STUDENT/coursetoenroll/" + courseID);
		return model;
	}

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/updateProfile")
	public ModelAndView updateProfile(ModelAndView model, HttpSession session) {
		model.addObject("role", session.getAttribute("role"));
		if ("STUDENT".equals(session.getAttribute("role"))) {
			model.addObject("studentO", studentDAO.get((int) session.getAttribute("studentID")));
			model.addObject("student", new Student());
		} else {
			model.addObject("teacherO", teacherDAO.get((int) session.getAttribute("teacherID")));
			model.addObject("teacher", new Teacher());
		}
		model.setViewName("/webuse/updateProfile");
		return model;
	}

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public String updateProfilePost(HttpSession session, @ModelAttribute Student student,
			@ModelAttribute Teacher teacher) {
		if ("STUDENT".equals(session.getAttribute("role"))) {
			student.setUserName((String) session.getAttribute("user"));
			if (studentDAO.get(student.getStudentID()) != null) {
				if (studentDAO.get(student.getStudentID()).getUserName().equals((String) session.getAttribute("user"))) {
					studentDAO.update(student);
				}
			} else {
				studentDAO.create(student);
			}
		} else {
			teacher.setUserName((String) session.getAttribute("user"));
			if (teacherDAO.get(teacher.getTeacherID()) != null) {
				if (teacherDAO.get(teacher.getTeacherID()).getUserName().equals((String) session.getAttribute("user"))) {
					teacherDAO.update(teacher);
				}
			} else {
				teacherDAO.create(teacher);
			}
		}
		return "redirect:guess";
	}

	@Auth(role = Auth.Role.STUDENT)
	@RequestMapping(value = "/STUDENT/grades")
	public ModelAndView grades(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.addObject("enrolment", enrolmentDAO.list((int) session.getAttribute("studentID")));
		model.setViewName("webuse/grades");
		return model;
	}
	@Auth(role = Auth.Role.ADMIN)
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		List<Notification> list1 = notificationDAO.list();
		List<Teacher> list2 = accountDAO.listTeacher();
		List<Student> list3 = accountDAO.listStudent();
		List<Course> list4 = courseDAO.list();
		model.addObject("notifications", list1.size());
		model.addObject("teachers", list2.size());
		model.addObject("students", list3.size());
		model.addObject("courses", list4.size());
		model.setViewName("admin/home");
		return model;
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/course", method=RequestMethod.GET)
	public ModelAndView courseList() {
		ModelAndView mav = new ModelAndView();
		Course course = new Course();
		List<Course> courseList = courseDAO.list();
		if(courseList.size()!=0) {
			mav.addObject("courseList", courseList);
		}else {
			mav.addObject("noCourse", "No course found");
		}
		mav.addObject("course", course);
		mav.setViewName("/admin/courseList");	
		return mav;
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/accounts", method=RequestMethod.GET)
	public ModelAndView inactiveAcc() {
		ModelAndView mav = new ModelAndView();
		List<Account> inactive = accountDAO.listAccount();
		mav.addObject("inactive", inactive);
		mav.setViewName("/admin/inactive");
		return mav;
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/users", method=RequestMethod.GET)
	public ModelAndView users() {
		ModelAndView mav = new ModelAndView();
		List<Teacher> teacherList = teacherDAO.list();
		List<Student> studentList = studentDAO.list();
		if(teacherList.size()==0) {
			mav.addObject("noTeacher","No teacher found!");
		}else {
			mav.addObject("teacherList", teacherList);
		}
		if(studentList.size()==0) {
			mav.addObject("noStudent", "No student found!");
		}else {
			mav.addObject("studentList", studentList);
		}
		mav.setViewName("/admin/userList");
		return mav;
	}
	/*      
	 * ____________________________________________________Course_______________________________________________________________
	 * */
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/createCourse", method=RequestMethod.POST)
	public ModelAndView createCourse(@ModelAttribute(name = "course") Course course) {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin/course");
		if(courseDAO.get(course.getCourseID())==null && teacherDAO.get(course.getTeacherID())!=null) {
			courseDAO.create(course);
			return courseList().addObject("msg", "Added");
		}else {
			return courseList().addObject("msg"	, "Duplicate course id or invalid teacher id");
		}
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/course/update/{cName}", method=RequestMethod.GET)
	public ModelAndView updateCourse(@PathVariable(value="cName") String cName) {
		Course courseO = courseDAO.get(cName);
		Course course = new Course();
		ModelAndView mav = new ModelAndView();
		mav.addObject("courseO", courseO);
		mav.addObject("course", course);
		mav.setViewName("admin/courseUpdate");
		return mav;
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/course/updateSubmit", method=RequestMethod.POST)
	public ModelAndView updateCourse(@ModelAttribute Course course) {
		if(courseDAO.get(course.getCourseID())!=null) {
		courseDAO.update(course);
		return courseList().addObject("msg", "Updated");
		}
		else {
			return courseList().addObject("msg", "Cannot found course"+course.getCourseID());
		}
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/course/delete/{id}", method=RequestMethod.GET)
	public String deleteCourse(@PathVariable(value="id") String id) {
		courseDAO.delete(id);
		return "redirect:/admin/course";
	}
	/*
	 * ___________________________________________________________ACC_______________________________________________________
	 * */
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/users/delete/{username}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable(value="username") String username) {
		accountDAO.delete(username);
		return "redirect:/admin/users";
	}
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value="/admin/inactive/delete/{username}", method=RequestMethod.GET)
	public String deleteInactive(@PathVariable(value="username") String username) {
		accountDAO.delete(username);
		return "redirect:/admin/accounts";
	}
	@RequestMapping(value="/guess")
	public ModelAndView guess(HttpSession session) {
		ModelAndView model = new ModelAndView();
		if((Boolean)session.getAttribute("isLogin")!=null&&(Boolean)session.getAttribute("isLogin")==true) {
			if("ADMIN".equals(session.getAttribute("role"))) {
				model.setViewName("redirect:/admin");
				return model;
			}
			model.setViewName("redirect:/"+session.getAttribute("role")+"/home");
			return model;
		}
		List<Notification> list1 = notificationDAO.list();
		List<Teacher> list2 = teacherDAO.list();
        Account acc = new Account();
        model.addObject("account", acc);
        if(list1.size()!=0) {
    		model.addObject("listNotification", list1);
        }else {
        	model.addObject("noNotification", "No notification found");
        }
        if(list2.size()!=0) {

    		model.addObject("listTeacher", list2);
        }else {
        	model.addObject("noTeacher", "No teacher found");
        }
		model.setViewName("guess/home");
		return model;
	}
	@Auth(role =Auth.Role.ADMIN)
	@RequestMapping(value="admin/register", method = RequestMethod.GET)
	public ModelAndView register(ModelAndView model) {
		Account account = new Account();
		model.addObject("account", account);
		model.setViewName("admin/register");
		return model;
	};
	
	@Auth(role =Auth.Role.ADMIN)
	@RequestMapping(value="/admin/register", method=RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute Account account ) throws SQLException{
		if(accountDAO.validateAcc(account)==null) {
		accountDAO.register(account);
		return register(new ModelAndView()).addObject("msg", "Created!");
		}else {
			return register(new ModelAndView()).addObject("msg", "Username existed!");
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session, ModelAndView model) {
        if (session.getAttribute("isLogin") != null
                && (Boolean) session.getAttribute("isLogin") == true) {
            model.setViewName("redirect:/spring-mvc/guess");
            return model;
        }
        Account acc = new Account();
        model.addObject("account", acc);
        model.setViewName("redirect:/spring-mvc/guess");
        return model;
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkLogin(Account account, HttpSession session) {
        if ("admin".equals(account.getPassWord())&&"admin".equals(account.getUserName())) {
               session.setAttribute("isLogin", true);
                session.setAttribute("user", account.getUserName());
                session.setAttribute("role", "ADMIN");
                return new ModelAndView("redirect:/admin");
            }
        Account acc = accountDAO.validateAcc(account);
    	if(acc!=null) {	
                session.setAttribute("isLogin", true);
                session.setAttribute("user", acc.getUserName());
                System.out.println(acc.getUserRole());
                session.setAttribute("role",	acc.getUserRole());
                ModelAndView model = new ModelAndView("redirect:/"+session.getAttribute("role")+"/home");
                model.addObject("account", acc);
                return model;
         }
 
        return new ModelAndView("redirect:/guess");
    }
 
    @RequestMapping(value = "/deny", method = RequestMethod.GET)
    public String deny() {
 
        return "webuse/deny";
    }
    
    @Auth(role = Auth.Role.LOGIN)
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("user");
        session.removeAttribute("role");
        session.removeAttribute("studentID");
        session.removeAttribute("teacherID");
        return "redirect:/guess";
    }
	private FileOutputStream output;

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/material/{materialID}")
	public ModelAndView viewMaterial(ModelAndView model, @PathVariable("materialID") int materialID, HttpSession session) {
		Material m = materialDAO.get(materialID);
		model.addObject("role", session.getAttribute("role"));
		System.out.println(session.getAttribute("role"));
		model.addObject("material", m);
		model.setViewName("/course/material");
		return model;
	}

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/assignment/{assignmentID}")
	public ModelAndView viewStudentAssignment(ModelAndView model, @PathVariable("assignmentID") int assignmentID,
			HttpSession session) {
		Assignment a = assignmentDAO.get(assignmentID);
		Student stdn = studentDAO.get((int) session.getAttribute("studentID"));
		FileAs f = fileDAO.get(assignmentID, stdn.getUserName());
		model.addObject("assignment", a);
		model.addObject("file", f);
		model.setViewName("/course/assignment");
		return model;
	}

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/upload/{assignmentID}")
	public ModelAndView uploadForm(ModelAndView model, HttpSession session, @PathVariable("assignmentID") int assignmentID) {
		session.setAttribute("asID", assignmentID);
		model.setViewName("course/upload");
		return model;
	}

	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/uploadm/{materialID}")
	public ModelAndView uploadMaterial(ModelAndView model, HttpSession session, @PathVariable("materialID") int materialID) {
		session.setAttribute("matID", materialID);
		model.setViewName("course/uploadm");
		return model;
	}
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadForm(ModelAndView model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");
		FileAs file = new FileAs();
		file.setTitle(ServletRequestUtils.getStringParameter(request, "title"));
		file.setFile(multipartFile.getBytes());
		int assignmentID = (int)session.getAttribute("asID");
		file.setAssignmentID(assignmentID);
		Student s = studentDAO.get((int)session.getAttribute("studentID"));
		file.setUserName(s.getUserName());
		fileDAO.create(file);
		session.removeAttribute("asID");
		return new ModelAndView("redirect:/assignment/"+assignmentID);
	}
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/uploadm", method = RequestMethod.POST)
	public ModelAndView uploadMaterial(ModelAndView model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");
		int materialID = (int)session.getAttribute("matID");
		materialDAO.upload(materialID, multipartFile.getBytes());
		session.removeAttribute("asID");
		return new ModelAndView("redirect:/material/"+materialID);
	}
	
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "assignment/{assignmentID}/file/{fileID}/delete", method = RequestMethod.GET)
	public String deleteFile(@PathVariable("assignmentID") int assignmentID, @PathVariable("fileID") int fileID) {
		fileDAO.delete(fileID);
		return "redirect:/assignment/"+assignmentID;
	}
	
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/forum/{forumID}")
	public ModelAndView viewForum(ModelAndView model, @PathVariable("forumID") int forumID,
			HttpSession session) {
		Comment comment= new Comment();
		if(session.getAttribute("studentID")!=null){
			comment.setUserName(studentDAO.get((int)session.getAttribute("studentID")).getUserName());
		}else {
			comment.setUserName(teacherDAO.get((int)session.getAttribute("teacherID")).getUserName());
		}
		Forum f = forumDAO.get(forumID);
		model.addObject("forum",f);
		model.addObject("comment", comment);
		model.addObject("comments", commentDAO.list(forumID));
		model.setViewName("/course/forum");
		return model;
	}
	
	@Auth(role= Auth.Role.LOGIN)
	@RequestMapping(value="/forum/{forumID}/comment")
	public String comment(@PathVariable("forumID") int forumID, @ModelAttribute Comment comment) {
		System.out.println(comment.toString());
		commentDAO.create(comment);
		return "redirect:/forum/{forumID}";
	}
	
/*
 * 
 * 
 * 
 * 
 * */	
	@Auth(role= Auth.Role.LOGIN)
	@RequestMapping(value="/material/{materialID}/download")
	public ModelAndView downloadFile(@PathVariable("materialID") int materialID, HttpSession session) throws IOException {
		File f = new File("file.zip");
		output = new FileOutputStream(f);
		byte[] input = materialDAO.file(materialID);
		output.write(input);
		return viewMaterial(new ModelAndView(), materialID, session).addObject("msg", "Downloaded: 'file.zip' to Desktop");
	}
	@Auth(role= Auth.Role.LOGIN)
	@RequestMapping(value="/assignment/{assignmentID}/file/{fileID}/download")
	public ModelAndView downloadAssignmentFile(@PathVariable("assignmentID") int assignmentID, @PathVariable("fileID") int fileID, HttpSession session) throws IOException {
		FileAs fi = fileDAO.get(fileID);
		String filename = fi.getTitle()+".zip";
		File f = new File(filename);
		output = new FileOutputStream(f);
		byte[] input = fileDAO.fileAs(fileID);
		output.write(input);
		return viewAssignment(new ModelAndView(), assignmentID, session).addObject("msg", "Downloaded: '"+filename+"' to Desktop");
	}
	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/TEACHER/home")
	public ModelAndView teacherHome(ModelAndView model, HttpSession session) throws IOException {
		model.addObject("username", session.getAttribute("user"));
		model.addObject("userrole", session.getAttribute("role"));
		Teacher tchr = teacherDAO.get((String) session.getAttribute("user"));
		if (tchr == null) {
			model.addObject("user", session.getAttribute("user"));
			model.addObject("teacher", new Teacher());
			model.addObject("teacherO", new Teacher());
			model.setViewName("webuse/updateProfile");
			return model;
		} else {
			session.setAttribute("teacherID", tchr.getTeacherID());
			model.addObject("notifications", notificationDAO.list());
			model.addObject("courses", courseDAO.teachList(tchr.getTeacherID()));
			model.setViewName("teacher/home");
			return model;
		}
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/TEACHER/course/{courseID}")
	public ModelAndView courseDetail(ModelAndView model, @PathVariable("courseID") String courseID,
			HttpSession session) {
		model.addObject("course", courseDAO.get(courseID));
		List<Forum> f =  forumDAO.list(courseID);
		List<Material> m = materialDAO.list(courseID);
		List<Assignment> a = assignmentDAO.list(courseID);
		if(f.size()==0) {
			model.addObject("fmsg", "No forum!");
		}else {
			model.addObject("forums",f);
		}
		if(m.size()==0) {
			model.addObject("mmsg", "No material");
		}else {
			model.addObject("materials",m);
		}
		if(a.size()==0) {
			model.addObject("amsg", "No assignment!");
		}else {
			model.addObject("assignments", a);
		}
		session.setAttribute("courseID", courseID);
		model.setViewName("/teacher/CourseDetail");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{courseID}/students")
	public ModelAndView studentList(ModelAndView model, @PathVariable("courseID") String courseID,
			HttpSession session) {
		List<Enrolment> en = enrolmentDAO.stnList(courseID);
		Iterator<Enrolment> enitor = en.iterator();
		List<Student> stdn = new ArrayList<Student>();
		while (enitor.hasNext()) {
			stdn.add(studentDAO.get(enitor.next().getStudentID()));
		}
		System.out.println(stdn.size() + "  " + en.size());
		model.addObject("students", stdn);
		model.addObject("enrolments", en);
		model.setViewName("teacher/listStudent");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/TEACHER/assignment/{assignmentID}")
	public ModelAndView viewAssignment(ModelAndView model, @PathVariable("assignmentID") int assignmentID,
			HttpSession session) {
		List<FileAs> files = fileDAO.list(assignmentID);
		model.addObject("courseID", session.getAttribute("courseID"));
		model.addObject("assignment", assignmentDAO.get(assignmentID));
		model.addObject("files", files);
		model.setViewName("/teacher/assignment");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{courseID}/material/add")
	public ModelAndView createMaterial(@PathVariable("courseID") String courseID, HttpSession session) {
		Material mat = new Material();
		mat.setCourseID(courseID);
		ModelAndView model = new ModelAndView();
		model.setViewName("/teacher/addMaterial");
		model.addObject("material", mat);
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/material/add", method = RequestMethod.POST)
	public ModelAndView addMaterial(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Material material) throws SQLException, IOException {
		materialDAO.create(material);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/material/{materialID}/delete", method = RequestMethod.GET)
	public ModelAndView deleteMaterial(@PathVariable("materialID") int materialID, HttpSession session) {
		materialDAO.delete(materialID);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{courseID}/assignment/add")
	public ModelAndView createAssignment(@PathVariable("courseID") String courseID, HttpSession session) {
		Assignment ass = new Assignment();
		ass.setCourseID(courseID);
		ModelAndView model = new ModelAndView();
		model.setViewName("/teacher/addAssignment");
		model.addObject("assignment", ass);
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "assignment/{assignmentID}/update")
	public ModelAndView updateMaterial(@PathVariable("assignmentID") int assignmentID, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Assignment ass = assignmentDAO.get(assignmentID);
		model.addObject("assignmentO", ass);
		Assignment a = new Assignment();
		model.addObject("assignment", a);
		model.setViewName("teacher/updateAssignment");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/assignment/{assignmentID}/update", method = RequestMethod.POST)
	public ModelAndView updateAssignment(@ModelAttribute("assigment") Assignment assignment,
			@PathVariable("assignmentID") int assignmentID, HttpSession session) {
		assignmentDAO.update(assignment, assignmentID);
		System.out.println(assignment.toString());
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "forum/{forumID}/update")
	public ModelAndView updateForum(@PathVariable("forumID") int forumID, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Forum f = forumDAO.get(forumID);
		model.addObject("forumO", f);
		Forum forum = new Forum();
		model.addObject("forum", forum);
		model.setViewName("teacher/updateForum");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/forum/{forumID}/update", method = RequestMethod.POST)
	public ModelAndView updateForumPost(HttpSession session, @ModelAttribute("forum") Forum forum, @PathVariable("forumID") int forumID) {
		System.out.println(forum.getTitle());
		forumDAO.update(forum, forumID);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/assignment/add", method = RequestMethod.POST)
	public ModelAndView addAssignment(@ModelAttribute("assigment") Assignment assignment, HttpSession session) {
		assignmentDAO.create(assignment);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/assignment/{assignmentID}/delete", method = RequestMethod.GET)
	public ModelAndView deleteAssignment(HttpSession session, @PathVariable("assignmentID") int assignmentID) {
		assignmentDAO.delete(assignmentID);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{courseID}/forum/add")
	public ModelAndView creatForum(@PathVariable("courseID") String courseID, HttpSession session) {
		Forum f = new Forum();
		f.setCourseID(courseID);
		ModelAndView model = new ModelAndView();
		model.setViewName("/teacher/addForum");
		model.addObject("forum", f);
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/forum/add", method = RequestMethod.POST)
	public ModelAndView addForum(@ModelAttribute("forum") Forum forum, HttpSession session) {
		forumDAO.create(forum);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/notification/{forumID}/delete", method = RequestMethod.GET)
	public ModelAndView deleteNotification(@PathVariable("forumID") int forumID, HttpSession session) {
		notificationDAO.delete(forumID);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{enrolmentID}/mark")
	public ModelAndView updateMark(ModelAndView model, HttpSession session,
			@PathVariable("enrolmentID") int enrolmentID) {
		Enrolment en = enrolmentDAO.getEnrolment(enrolmentID);
		Student stdn = studentDAO.get(en.getStudentID());
		Course c = courseDAO.get(en.getCourseID());
		model.addObject("enrolment", en);
		model.addObject("student", stdn);
		model.addObject("course", c);
		session.setAttribute("courseID", en.getCourseID());
		model.setViewName("/teacher/updateMark");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/{enrolmentID}/mark", method = RequestMethod.POST)
	public String updateMark(@ModelAttribute Enrolment enrolment, HttpSession session) {
		String courseID = (String) session.getAttribute("courseID");
		System.out.println(courseID);
		session.removeAttribute("courseID");
		enrolmentDAO.enterMark(enrolment);
		return "redirect:/" + courseID + "/students";
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/forum/{forumID}/delete", method = RequestMethod.GET)
	public String deleteForum(@PathVariable("forumID") int forumID) {
		forumDAO.delete(forumID);
		;
		return "redirect:/TEACHER/home/";
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/notification/add", method = RequestMethod.GET)
	public ModelAndView addNotification(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.addObject("teacherID", teacherDAO.get((String) session.getAttribute("user")).getTeacherID());
		model.addObject("notification", new Notification());
		model.setViewName("teacher/addNotification");
		return model;
	}

	@Auth(role = Auth.Role.TEACHER)
	@RequestMapping(value = "/notification/add", method = RequestMethod.POST)
	public ModelAndView addNotPost(@ModelAttribute("notification") Notification notification, HttpSession session) {
		notificationDAO.create(notification);
		return courseDetail(new ModelAndView(),(String) session.getAttribute("courseID"), session);
	}
}