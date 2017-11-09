package kr.co.htop.login.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.login.bean.LoginBean;




public class LoginDaoImpl implements LoginDao {
	
	@Resource(name="sqlSession")
	SqlSession sqlSession;

	@Override
	public UserBean getUser(LoginBean bean){
		UserBean userBean = sqlSession.selectOne("login.getUser",bean);
		
		/*if(userBean != null){
			uBeans = sqlSession.selectList("login.getUser2",userBean.getIdx());
			userBean.setList(uBeans);
		}*/
		
		
		return userBean;
	}



	
	

}
