package kr.co.htop.admin.controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.htop.admin.bean.ProductBean;
import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.admin.service.ProductService;
import kr.co.htop.common.getBeanListToJson;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired ProductService productService;
	
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,Locale locale, Model model ) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("user");
		
		/*String contract_name = (String)map.get("contract_name");
		if(contract_idx == null){
			contract_idx = "0";
		}*/
		
		
		
		modelAndView.addObject("user",user);
		//modelAndView.addObject("contract_name",contract_name);
		modelAndView.addObject("serverTime", formattedDate );
		
		String project = (String)session.getAttribute("project");
		modelAndView.setViewName("tiles.admin.product.index");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/productList.do", method={RequestMethod.POST})
	public @ResponseBody ModelAndView getProductList(@RequestBody ProductBean bean) throws SQLException {
		
		//System.out.println(bean.getSeachType()+" : "+bean.getSeachText());
		//System.out.println("board");
		List<ProductBean> list = null;
		int count = 0;
		
		//System.out.println(bean.getPageNum());
		
		list = productService.getProductList(bean);
		/*count = productService.getProductListTotal(bean);*/
		
		//System.out.println(list.get(0).toString());
		
		JSONObject json = getBeanListToJson.getBeanListToJson(list, "beanlist");
		
		//json.accumulate("productTotal",count );
		
		
	  
		ModelAndView mav = new ModelAndView("jsonView",json);
		return mav;
	}
	
	
	/*@RequestMapping(value="/changeBoard.do", method={RequestMethod.POST})
	public @ResponseBody ResponseEntity<JSONObject> changeBoard(@RequestParam Map<String, Object> paramMap,  MultipartHttpServletRequest mRequest) throws SQLException {
		
		Date date = new Date();
		Timestamp stmp = new Timestamp(date.getTime());
		JSONObject json = new JSONObject();
		BoardBean bean = new BoardBean();
		
		bean.setDate(stmp);
		
		if((String)paramMap.get("changeMode") != null){
			if(!((String)paramMap.get("changeMode")).equals("undefined")){
				bean.setChangeMode(Integer.parseInt((String)paramMap.get("changeMode")));
			}
		}
		
		if((String)paramMap.get("idx") != null){
			if(!((String)paramMap.get("idx")).equals("undefined")){
				bean.setIdx(Integer.parseInt((String)paramMap.get("idx")));
			}
		}
		
		bean.setTitle((String)paramMap.get("title"));
		bean.setContent((String)paramMap.get("content"));
		
		
		
		
		
	
		//System.out.println(bean.toString());
		int a = boardService.changeBoard(bean,mRequest);
		
		
	    
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8"); 
		return new ResponseEntity<JSONObject>(json, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getBoardList.do", method={RequestMethod.POST})
	public @ResponseBody ModelAndView getBoardList(@RequestBody BoardBean bean) throws SQLException {
		
		//System.out.println(bean.getSeachType()+" : "+bean.getSeachText());
		//System.out.println("board");
		List<BoardBean> list = null;
		int count = 0;
		
		//System.out.println(bean.getPageNum());
		
		list = boardService.getBoardList(bean);
		count = boardService.getBoardListTotal(bean);
		
		//System.out.println(list.get(0).toString());
		
		JSONObject json = getBeanListToJson.getBeanListToJson(list, "beanlist");
		
		json.accumulate("boardTotal",count );
		
		
	  
		ModelAndView mav = new ModelAndView("jsonView",json);
		return mav;
	}
	
	@RequestMapping(value = "/getFile.do", method = RequestMethod.POST)
    public @ResponseBody ModelAndView getFile(@RequestBody FileBean bean) throws SQLException {
		List<FileBean> list = null;
		list = boardService.getFile(bean);
		
		JSONObject json = getBeanListToJson.getBeanListToJson(list, "beanlist");
		ModelAndView mav = new ModelAndView("jsonView",json);
		return mav;
	}
	
	@RequestMapping(value = "/fileDown.do", method = RequestMethod.POST)
    public ModelAndView fileDown(@ModelAttribute("fileDown") FileBean bean) throws SQLException {
		
        return new ModelAndView("download", "downloadFile", bean);
	}
	
	@RequestMapping(value = "/deleteFile.do", method = RequestMethod.POST)
    public @ResponseBody ModelAndView fileDelete(@RequestBody FileBean bean,HttpServletRequest request) throws SQLException {
		
		boardService.deleteFile(bean,request);
		
		
		ModelAndView mav = new ModelAndView("jsonView");
		return mav;
	}*/
	
	
	
}
