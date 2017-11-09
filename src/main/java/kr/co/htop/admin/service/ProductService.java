package kr.co.htop.admin.service;



import java.sql.SQLException;
import java.util.List;







import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.htop.admin.bean.ProductBean;


public interface ProductService {

	List<ProductBean> getProductList(ProductBean bean);
	
	/*public List<BoardBean> getBoardList(BoardBean bean) throws SQLException;
	
	public int getBoardListTotal(BoardBean bean) throws SQLException;
	
	public int changeBoard(BoardBean bean,MultipartHttpServletRequest mRequest) throws SQLException;

	public List<FileBean> getFile(FileBean bean);

	public void deleteFile(FileBean bean,HttpServletRequest request);*/

	

}
