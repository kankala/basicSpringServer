package kr.co.htop.admin.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.htop.admin.bean.AdminBean;

public interface AdminService {
	
	void add(AdminBean bean);
	
	void update(AdminBean bean);
	
	AdminBean get(String id);
	
	List<AdminBean> list();
	
	void delete(int id);

	List<AdminBean> listByName(String keyword);
	
	public AdminBean SelectId(String id) throws SQLException;
	
	public boolean fileUpload(MultipartHttpServletRequest mRequest) throws SQLException;

}
