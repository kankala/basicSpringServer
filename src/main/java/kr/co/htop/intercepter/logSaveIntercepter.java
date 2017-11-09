package kr.co.htop.intercepter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import net.kankala.spring.admin.bean.UserBean;








import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Service
public class logSaveIntercepter extends HandlerInterceptorAdapter {
 //HandlerInterceptorAdapter 를 상속 받아야 intercepter 등록이 가능함
	//@Resource(name="logDao")
	//LogDao logDao;
	

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException{
		
		//String project = "cgv";
		//String project = "lohbs";
		
		
		boolean result   =  true;
		HttpSession session = request.getSession();
		/*
		boolean result   =  true;
		String address = null;
		Integer server = null;
		
		
		server = (Integer) session.getAttribute("homeServer");
		
		if(server != null){
			if(server == 1 || server == 2|| server == 3){
				return result;
			}
		}
		
		
		InetAddress inet= InetAddress.getLocalHost();
		
		address = inet.getHostAddress();
		
		
		if(address.equals("117.52.97.211")){
			server = 1;
		}else if(address.equals("117.52.97.80")){
			server = 2;
		}else if(address.equals("106.251.236.242")){
			server = 3;
		}else{
			System.out.println(address);
			server = 1;
		}
		*/
		/*String tempPoroject = null;
		try {
			tempPoroject = (String)session.getAttribute("project");
			if(tempPoroject == null){
				//session.setAttribute("project","lohbs");
				session.setAttribute("project",project);
			}else{
				if(!tempPoroject.equals(project)){
					session.setAttribute("project",project);
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
				
		
		
		
		
		
		
		
		return result;
	}
	
	
}