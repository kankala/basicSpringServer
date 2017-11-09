package kr.co.htop.admin.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.htop.admin.bean.ProductBean;
public interface ProductDao {

	List<ProductBean> getProductList(ProductBean bean);

	/*public List<BoardBean> getBoardList(BoardBean bean) throws SQLException;
	
	public int getBoardListTotal(BoardBean bean) throws SQLException;
	
	public int changeBoard(BoardBean bean) throws SQLException;
	
	
	public FileBean saveFile(FileBean bean) throws SQLException;
	
	public List<FileBean> viewFileAll(FileBean bean) throws SQLException;
	
	public void deleteFile(FileBean bean) throws SQLException;

	public List<FileBean> getFile(FileBean bean);*/
}
