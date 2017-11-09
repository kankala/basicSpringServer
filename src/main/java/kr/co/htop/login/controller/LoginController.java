package kr.co.htop.login.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.login.bean.LoginBean;
import kr.co.htop.login.service.LoginService;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired LoginService loginService;
	
	/*
	String device = null;
	
	@RequestMapping(value = "/mobile/", method = RequestMethod.GET)
    public void mobile(Model model, Device device,SitePreference sitePreference) {
		System.out.println("모델은 "+model+", 디바이스는 "+device+", 사이트프리펀스는 "+sitePreference);
		device = (Device)device;
    }
	
	*/
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("login") @Valid LoginBean bean, Locale locale, HttpSession session , HttpServletRequest request) {
		
		//logger.info("Welcome login! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		
		String formattedDate = dateFormat.format(date);
		
	

		
		//model.addAttribute("serverTime", formattedDate );
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("redirect:/view/home.jsp");
		modelAndView.setViewName("login.login");
		modelAndView.addObject("serverTime",formattedDate);
		modelAndView.addObject("login",new LoginBean());
		
		return modelAndView;
	}
	
	
	
	
	
	@RequestMapping(value = "/go.do", method = RequestMethod.POST)
	public ModelAndView uploadSubmit(@ModelAttribute("login") @Valid LoginBean bean, BindingResult errors, Locale locale,HttpSession session, SessionStatus status, HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		if(errors.hasErrors()){
			modelAndView.setViewName("login.login");
			modelAndView.addObject("login",bean);
			return modelAndView;
		}else{
			
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
			
			
			// 사용자의 비밀번호 String password = "!@#$password1234"; 
			// 위 비밀번호의 BCrypt 알고리즘 해쉬 생성, passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다. 
			//String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt()); 
			// 위 문장은 아래와 같다. 숫자가 높아질수록 해쉬를 생성하고 검증하는 시간은 느려진다. 
			//즉, 보안이 우수해진다. 하지만 그만큼 응답 시간이 느려지기 때문에 적절한 숫자를 선정해야 한다. 기본값은 10이다. 
			//String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt(10)); 
			// 생성된 해쉬를 원래 비밀번호로 검증한다. 맞을 경우 true를 반환한다. 주로 회원 로그인 로직에서 사용된다. 
			//boolean isValidPassword = BCrypt.checkpw(password, passwordHashed);

			
			
			
			
			bean.setId(new String(bean.getId().getBytes("8859_1"),"UTF-8"));
			UserBean userBean = loginService.getUser(bean);
			//modelAndView.addObject("getName",beans.getName());
			//System.out.println(new String(bean.getId().getBytes("8859_1"),"UTF-8"));
			try{
				userBean.getIdx();
				userBean.setIp(ip);
			}catch(Exception e){
				modelAndView.addObject("loginFail","fail");
				modelAndView.setViewName("login.login");
				modelAndView.addObject("login",bean);
				return modelAndView;
			}
			session.setAttribute("user",userBean);
			
			modelAndView.setViewName("redirect:/admin/index.do");
		}
		return modelAndView;
		
		
	}
	@RequestMapping(value = "/go.do", method = RequestMethod.GET)
	public ModelAndView uploadSubmit(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/login/login.do");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public ModelAndView logoutsubmit(@ModelAttribute LoginBean bean, BindingResult errors, Locale locale,HttpSession session, SessionStatus status){
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		
		
		session.removeAttribute("user");
		session.setMaxInactiveInterval(36000);
		//HomeBean beans = homeService.get(bean.getId());
		//modelAndView.addObject("getName",beans.getName());
		modelAndView.setViewName("redirect:/admin/index.do");
		//System.out.println("로그아웃 실행댐");
		
		return modelAndView;
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logoutsubmitGET(@ModelAttribute LoginBean bean, BindingResult errors, Locale locale,HttpSession session, SessionStatus status){
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		
		
		session.removeAttribute("user");
		session.setMaxInactiveInterval(36000);
		//HomeBean beans = homeService.get(bean.getId());
		//modelAndView.addObject("getName",beans.getName());
		modelAndView.setViewName("redirect:/admin/index.do");
		//System.out.println("로그아웃 실행댐");
		
		return modelAndView;
	}
	
	/*@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String upload(@ModelAttribute("home") Model model) {
		System.out.println("55555");
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		model.addAttribute("home",new HomeBean());
		return "/insert.do";
		
	}*/
	
	
}
