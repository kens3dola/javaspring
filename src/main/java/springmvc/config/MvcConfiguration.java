package springmvc.config;
import javax.sql.DataSource;

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
import springmvc.daoImpl.AccountDAOImpl;
import springmvc.daoImpl.AssignmentDAOImpl;
import springmvc.daoImpl.CommentDAOImpl;
import springmvc.daoImpl.CourseDAOImpl;
import springmvc.daoImpl.EnrolmentDAOImpl;
import springmvc.daoImpl.FileDAOImpl;
import springmvc.daoImpl.ForumDAOImpl;
import springmvc.daoImpl.MaterialDAOImpl;
import springmvc.daoImpl.NotificationDAOImpl;
import springmvc.daoImpl.StudentDAOImpl;
import springmvc.daoImpl.TeacherDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan(basePackages="springmvc")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
 
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3000/fit?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
         
        return dataSource;
    }
     
    @Bean
    public AccountDAO getAccountDAO() {
        return new AccountDAOImpl(getDataSource());
    }
    @Bean
    public NotificationDAO notificationDAO() {
        return new NotificationDAOImpl(getDataSource());
    }
    @Bean
    public AssignmentDAO assignmentDAO() {
        return new AssignmentDAOImpl(getDataSource());
    }
    @Bean
    public CommentDAO commentDAO() {
        return new CommentDAOImpl(getDataSource());
    }
    @Bean
    public CourseDAO courseDAO() {
        return new CourseDAOImpl(getDataSource());
    }
    @Bean
    public EnrolmentDAO enrolmentDAO() {
        return new EnrolmentDAOImpl(getDataSource());
    }
    @Bean
    public FileDAO fileDAO() {
        return new FileDAOImpl(getDataSource());
    }
    @Bean
    public ForumDAO forumDAO() {
        return new ForumDAOImpl(getDataSource());
    }
    @Bean
    public MaterialDAO materialDAO() {
        return new MaterialDAOImpl(getDataSource());
    }
    @Bean
    public StudentDAO studentDAO() {
        return new StudentDAOImpl(getDataSource());
    }
    @Bean
    public TeacherDAO teacherDAO() {
        return new TeacherDAOImpl(getDataSource());
    }
    
}
