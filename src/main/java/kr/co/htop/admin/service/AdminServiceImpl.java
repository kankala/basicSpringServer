package kr.co.htop.admin.service;

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

import kr.co.htop.admin.bean.AdminBean;
import kr.co.htop.admin.bean.FileBean;
import kr.co.htop.admin.dao.AdminDao;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Resource(name="adminDao")
	AdminDao adminDao;

	public void add(AdminBean bean) {
		//bean.setJoined(new Date());
		//dao.add(bean);
	}

	public void delete(int id) {
		//dao.delete(id);
	}

	public AdminBean get(String id) {
		//return dao.get(id);
		return new AdminBean();
	}

	

	public void update(AdminBean bean) {
		//dao.update(bean);
	}

	@Override
	public List<AdminBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminBean> listByName(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminBean SelectId(String id) throws SQLException {
		AdminBean bean;
		bean = (adminDao.selectId(id));
		
		return bean;
	}
	

	@Override
	public boolean fileUpload(MultipartHttpServletRequest mRequest) throws SQLException {

		boolean isSuccess = false;
		FileBean bean = new FileBean();

		String uploadPath = mRequest.getSession().getServletContext().getRealPath("/")+"\\resources\\upload\\";
		System.out.println("Path is "+uploadPath);

		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {

			dir.mkdirs();

		}

		Iterator<String> iter = mRequest.getFileNames();

		while(iter.hasNext()) {

			String uploadFileName = iter.next();

			MultipartFile mFile = mRequest.getFile(uploadFileName);

			String originalFileName = mFile.getOriginalFilename();
			
			
			bean.setPath(uploadPath);
			bean.setOriginalName(originalFileName);
			
			FileBean count = adminDao.saveFile(bean);

			String saveFileName = null;

			//saveFileName = Integer.toString(count.getIdx()) + "_" + System.currentTimeMillis();
			saveFileName = Integer.toString(count.getIdx());


			try {

				mFile.transferTo(new File(uploadPath + saveFileName));

				isSuccess = true;				

			} catch (IllegalStateException e) {

				e.printStackTrace();

				isSuccess = false;

			} catch (IOException e) {

				e.printStackTrace();

				isSuccess = false;

			}

		} // if end

	return isSuccess;

	} // fileUpload end
}
