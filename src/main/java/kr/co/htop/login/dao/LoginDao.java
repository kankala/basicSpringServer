package kr.co.htop.login.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.htop.admin.bean.UserBean;
import kr.co.htop.login.bean.LoginBean;

public interface LoginDao {

	public UserBean getUser(LoginBean bean);

}
