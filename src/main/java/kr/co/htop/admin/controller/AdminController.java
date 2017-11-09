package kr.co.htop.admin.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.htop.admin.bean.AdminBean;
import kr.co.htop.admin.service.AdminService;

import java.net.InetAddress;
import java.net.UnknownHostException;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired AdminService adminService;
	
	/*
	String device = null;
	
	@RequestMapping(value = "/mobile/", method = RequestMethod.GET)
    public void mobile(Model model, Device device,SitePreference sitePreference) {
		System.out.println("모델은 "+model+", 디바이스는 "+device+", 사이트프리펀스는 "+sitePreference);
		device = (Device)device;
    }
	
	*/
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView home(AdminBean bean, Locale locale) {
		
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
		
	

		
		//model.addAttribute("serverTime", formattedDate );
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("redirect:/view/home.jsp");
		modelAndView.setViewName("tiles.admin.index");
		modelAndView.addObject("serverTime",formattedDate);
		modelAndView.addObject("clientIp",ip);
		modelAndView.addObject("home",new AdminBean());
		
		return modelAndView;
	}
	
	
	
	
	/*
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView uploadSubmit(@ModelAttribute("home") @Valid HomeBean bean, BindingResult errors, Locale locale, SessionStatus status){
		ModelAndView modelAndView = new ModelAndView();
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		if(errors.hasErrors()){
			modelAndView.setViewName("admin.index");
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
	*/
	/*@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String upload(@ModelAttribute("home") Model model) {
		System.out.println("55555");
		//model.addAttribute("serverTime", formattedDate );
		//modelAndView.setViewName("redirect:/view/home.jsp");
		model.addAttribute("home",new HomeBean());
		return "/insert.do";
		
	}*/
	
	/*
	@Qualifier("internal")
	
	<bean id="articleSearchService" class="LuceneSearchService">
    <qualifier value="internal" />
    </bean>
    <bean id="contentSearchService" class="QueryJetSearchService">
    <qualifier value="external" />
    </bean>
    */
	
	
	@RequestMapping(value="/fileUploadAjax.do", method = RequestMethod.POST) 
	public ModelAndView fileUploadAjax(MultipartHttpServletRequest mRequest, @RequestParam Map<String, Object> paramMap) throws SQLException {
	
		ModelAndView mav = new ModelAndView();
		
		System.out.println(paramMap.get("id"));

		if(adminService.fileUpload(mRequest)) {

			mav.addObject("result", "SUCCESS");

		} else {

			mav.addObject("result", "FAIL");

		}

		mav.setViewName("JSON");

		return mav;
	}
	
}
