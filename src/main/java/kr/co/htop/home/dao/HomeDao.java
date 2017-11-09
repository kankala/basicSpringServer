package kr.co.htop.home.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.htop.home.bean.HomeBean;

public interface HomeDao {

	public HomeBean selectId(String id) throws SQLException;

	public void saveQuery(Map map) throws SQLException;

	public void saveQuery2(Map map) throws SQLException;

}
