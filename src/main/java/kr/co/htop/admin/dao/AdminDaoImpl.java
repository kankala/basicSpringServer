package kr.co.htop.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.htop.admin.bean.AdminBean;
import kr.co.htop.admin.bean.FileBean;



public class AdminDaoImpl implements AdminDao {
	
	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	public AdminBean selectId(String id) throws SQLException {
		//AdminBean result = sqlSession.selectOne("home.selectQuery",id);
		AdminBean result = new AdminBean();
		return result;
	}

	
	public void saveQuery(Map map) throws SQLException {
		//sqlSession.insert("home.saveQuery",map);
	}

	public void saveQuery2(Map map) throws SQLException {
		//sqlSession.insert("home.saveQuery",map);
	}
	
	public FileBean saveFile(FileBean bean) throws SQLException {
		//AdminBean result = sqlSession.selectOne("home.selectQuery",id);
		int result = sqlSession.insert("admin.saveFile",bean);
		if(result <= 0){
			
		}
		return bean;
	}
	


	
	

}
