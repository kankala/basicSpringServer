package kr.co.htop.home.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.htop.home.bean.HomeBean;
import kr.co.htop.home.dao.HomeDao;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
	@Resource(name="homeDao")
	HomeDao homeDao;

	public void add(HomeBean bean) {
		//bean.setJoined(new Date());
		//dao.add(bean);
	}

	public void delete(int id) {
		//dao.delete(id);
	}

	public HomeBean get(String id) {
		//return dao.get(id);
		return new HomeBean();
	}

	

	public void update(HomeBean bean) {
		//dao.update(bean);
	}

	@Override
	public List<HomeBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HomeBean> listByName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HomeBean SelectId(String id) throws SQLException {
		HomeBean bean;
		bean = (homeDao.selectId(id));
		
		return bean;
	}
}
