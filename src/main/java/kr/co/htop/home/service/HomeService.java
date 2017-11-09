package kr.co.htop.home.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.htop.home.bean.HomeBean;


public interface HomeService {
	
	void add(HomeBean bean);
	
	void update(HomeBean bean);
	
	HomeBean get(String id);
	
	List<HomeBean> list();
	
	void delete(int id);

	List<HomeBean> listByName(String keyword);
	
	public HomeBean SelectId(String id) throws SQLException;

}
