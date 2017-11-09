package kr.co.htop.intercepter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import kr.co.tvking.admin.bean.UserBean;






import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import com.incross.dto.UserDTO;

import kr.co.htop.admin.bean.UserBean;

@Service
public class loginIntercepter extends HandlerInterceptorAdapter {
 //HandlerInterceptorAdapter 를 상속 받아야 intercepter 등록이 가능함
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException{
		boolean result   =  true;
		HttpSession session = request.getSession();
		
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("HTTP_CLIENT_IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		    ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		    ip = request.getRemoteAddr(); 
		}
		/*if(ip.equals("117.52.97.80") || ip.equals("117.52.97.211") || ip.equals("106.251.236.242") ){
			return result;
		}*/
		

		
		UserBean user = null;
		
		
		
		
		try{
			user = (UserBean)session.getAttribute("user");
			
			if(user.getIdx() < 1){
				
				
				response.sendRedirect("/login/login.do");
				//System.out.println("세션 X");
			}
		}catch(Exception e){
			
			result = false;
			//System.out.println("세션 X");
			response.sendRedirect("/login/login.do");
		}
		
		

		return result;
	}
}