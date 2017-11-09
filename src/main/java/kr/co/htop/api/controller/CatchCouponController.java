package kr.co.htop.api.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import kr.co.htop.api.bean.ApiCatchCouponBean;
import kr.co.htop.api.service.ApiProductService;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/api/v1/catchCoupon/catchCoupon")
public class CatchCouponController {
	
	private static final Logger logger = LoggerFactory.getLogger(CatchCouponController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired ApiProductService service;
	
	
	@RequestMapping(value = "/catchedCoupon.do", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody ModelAndView catchedCoupon(@RequestBody ApiCatchCouponBean bean,Locale locale,HttpServletRequest request) {
		//System.out.println(bean.toString());
		/*Date date = new Date();
		Timestamp stmp = new Timestamp(date.getTime());
		bean.setRegisterDate(stmp);*/
		//List<ProductBean> list;
		
		
		
		
		//for(ApiProductBean beans: bean.getProductList()){
			//System.out.println(beans.toString());
		//}
		
		
		

		
		
		int i = 0;
		int s = 0;
		try{
			//s = service.putProduct(bean.getProductList());
		}catch(Exception e){
			i = 1;
		}
		
		
		//list.add(bean);
		
		//System.out.println(bean.getIdx() + " : " + bean.getName());
		//bean.setIdx(0);

		JSONObject json = new JSONObject();
		json.accumulate("errorCode", i);
		json.accumulate("result", s);
		
		ModelAndView mav = new ModelAndView("jsonView",json);
		mav.setStatus(HttpStatus.valueOf(400));
		return mav;
	}
	
	
	
}
