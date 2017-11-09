package kr.co.htop.home.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.htop.home.bean.HomeBean;


public class HomeDaoImpl implements HomeDao {
	
	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	public HomeBean selectId(String id) throws SQLException {
		HomeBean result = sqlSession.selectOne("home.selectQuery",id);
		return result;
	}

	
	public void saveQuery(Map map) throws SQLException {
		//sqlSession.insert("home.saveQuery",map);
	}

	public void saveQuery2(Map map) throws SQLException {
		//sqlSession.insert("home.saveQuery",map);
	}
	


	
	

}
