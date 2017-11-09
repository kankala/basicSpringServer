package kr.co.htop.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.htop.admin.bean.AdminBean;
import kr.co.htop.admin.bean.FileBean;

public interface AdminDao {

	public AdminBean selectId(String id) throws SQLException;
	

	public void saveQuery(Map map) throws SQLException;

	public void saveQuery2(Map map) throws SQLException;
	
	public FileBean saveFile(FileBean bean) throws SQLException;

}
