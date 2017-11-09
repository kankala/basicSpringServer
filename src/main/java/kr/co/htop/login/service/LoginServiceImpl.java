package kr.co.htop.login.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.login.bean.LoginBean;
import kr.co.htop.login.dao.LoginDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Resource(name="loginDao")
	LoginDao loginDao;
	
	@Override
	public UserBean getUser(LoginBean bean) {
		UserBean userBean = loginDao.getUser(bean);
		return userBean;
	}
	
	

	
}
