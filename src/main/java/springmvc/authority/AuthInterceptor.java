package springmvc.authority;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {
	public Auth.Role getAuthRole(String role){
		if("LOGIN".equals(role)) {
			return Auth.Role.LOGIN;
		}else if("ADMIN".equals(role)) {
			return Auth.Role.ADMIN;
		}else if("STUDENT".equals(role)) {
			return Auth.Role.STUDENT;
		}else if("TEACHER".equals(role)){
			return Auth.Role.TEACHER;
		}else
			return null;
	}
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        
        Auth roleAnnotation = AnnotationUtils
                .findAnnotation(method, Auth.class);
        
        Auth.Role role = roleAnnotation != null ? roleAnnotation.role() : null;
 
        HttpSession session = request.getSession();      
        boolean isLogined = session.getAttribute("isLogin") != null ? (Boolean) session
                .getAttribute("isLogin") : false;
        Auth.Role loginRole = session.getAttribute("role") != null ? getAuthRole((String)session.getAttribute("role")) : null;
        System.out.println(roleAnnotation+" "+loginRole+" "+isLogined+" "+session.getAttribute("teacherID"));
        if (role != null) {
            if (!isLogined) {
                response.sendRedirect("/spring-mvc/guess");
                return false;
            } else {
            	
                if (role != Auth.Role.LOGIN && role != loginRole) {
                    response.sendRedirect("deny?url=\""
                            + request.getRequestURL().toString() + "?"
                            + request.getQueryString() + "\"&role=" + role);
                    return false;
                }
            }
        }
        return true;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
