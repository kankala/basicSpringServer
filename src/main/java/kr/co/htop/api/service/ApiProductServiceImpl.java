package kr.co.htop.api.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.htop.api.bean.ApiProductBean;
import kr.co.htop.api.dao.ApiProductDao;

@Service
@Transactional
public class ApiProductServiceImpl implements ApiProductService {
	@Resource(name="apiProductDao")
	ApiProductDao apiProductDao;
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
	
	

	@Override
	public int putProduct(List<ApiProductBean> list) {
		int result = apiProductDao.putProduct(list);
		return result;
	}
	

	public String intToString(String s,Integer o){
		String result = null;
		if(s.equals("이펙트")){
			if(o.equals(1)){
				result = "옆에서밀어내기";
			}else if(o.equals(2)){
				result = "올라오기";
			}else if(o.equals(3)){
				result = "회전";
			}else if(o.equals(4)){
				result = "사라지기";
			}else if(o.equals(5)){
				result = "밝기변화";
			}
		}
		return result;
	}

	public Integer intToint(String s,Integer o,int effectWay){
		Integer result = null;
		if(s.equals("이펙트")){
			if(o.equals(1)){
				if(effectWay == 1){
					result = 48;
				}else if(effectWay == 2){
					result = 46;
				}
			}else if(o.equals(2)){
				result = 47;
			}else if(o.equals(3)){
				result = 29;
			}else if(o.equals(4)){
				result = 25;
			}else if(o.equals(5)){
				result = 34;
			}
		}
		return result;
	}
	
	public String StringToString(String s,String o){
		String result = null;
		if(s.equals("날짜")){
			if(o.equals("24:00")){
				result = "23:59";
			}else{
				result = o;
			}
		}
		return result;
	}




	

	
	







	
	
}
