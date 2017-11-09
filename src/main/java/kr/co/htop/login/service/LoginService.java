package kr.co.htop.login.service;

import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.login.bean.LoginBean;

public interface LoginService {
	
	UserBean getUser(LoginBean bean);
	

}
