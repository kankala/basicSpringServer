package kr.co.htop.home.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import kr.co.htop.home.bean.HomeBean;
import kr.co.htop.home.service.HomeService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;
import java.net.UnknownHostException;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired HomeService homeService;
	
	/*
	String device = null;
	
	@RequestMapping(value = "/mobile/", method = RequestMethod.GET)
    public void mobile(Model model, Device device,SitePreference sitePreference) {
		System.out.println("모델은 "+model+", 디바이스는 "+device+", 사이트프리펀스는 "+sitePreference);
		device = (Device)device;
    }
	
	*/
	
	/*@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView home(HomeBean bean, Locale locale) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String ip = null;
		try {
			InetAddress iip = InetAddress.getLocalHost();
			ip = iip.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String formattedDate = dateFormat.format(date);
		
		long start = System.currentTimeMillis();
		
		Random r = new Random();
		for(int i = 0; i < 1580000;i++){
			r.nextInt(633);
		}
		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
		
		//model.addAttribute("serverTime", formattedDate );
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("redirect:/view/home.jsp");
		modelAndView.setViewName("tiles.home.index");
		modelAndView.addObject("serverTime",formattedDate);
		modelAndView.addObject("clientIp",ip);
		modelAndView.addObject("home",new HomeBean());
		//System.out.println("asdasd");
		return modelAndView;
	}
	
	
	
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView uploadSubmit(@ModelAttribute("home")HomeBean bean, BindingResult errors, Locale locale, SessionStatus status){
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		if(errors.hasErrors()){
			modelAndView.setViewName("home.index");
			modelAndView.addObject("home",bean);
			return modelAndView;
		}else{
			HomeBean beans = null;
			try {
				beans = homeService.SelectId(bean.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modelAndView.addObject("getName",beans.getName());
			modelAndView.setViewName("/home/endPage");
		}
		return modelAndView;
		
		
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public ModelAndView uploadSubmit(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/home/index.do");
		return modelAndView;
		
		
	}
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String upload(@ModelAttribute("home") Model model) {
		System.out.println("55555");
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		model.addAttribute("home",new HomeBean());
		return "/insert.do";
		
	}
	
	
	@Qualifier("internal")
	
	<bean id="articleSearchService" class="LuceneSearchService">
    <qualifier value="internal" />
    </bean>
    <bean id="contentSearchService" class="QueryJetSearchService">
    <qualifier value="external" />
    </bean>
    
	
	
	@RequestMapping(value="/ajax.do", method = RequestMethod.POST) 
	public @ResponseBody String getTime(@ModelAttribute("home")HomeBean bean) {
	
		String result = "Time for is " + new Date().toString();
		try{
			result = result+", id="+bean.getId();
		}catch(Exception e){
		}
		return result;
	}*/
	
}
