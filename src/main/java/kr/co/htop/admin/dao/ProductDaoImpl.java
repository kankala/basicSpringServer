package kr.co.htop.admin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import kr.co.htop.admin.bean.ProductBean;



public class ProductDaoImpl implements ProductDao {
	
	@Resource(name="sqlSession")
	SqlSession sqlSession;

	@Override
	public List<ProductBean> getProductList(ProductBean bean) {
		List<ProductBean> list;

		list = sqlSession.selectList("product.getProduct",bean);
		
		
		//List<CodeBean> list = null;
		return list;
	}
	

	
	/*@Override
	public List<BoardBean> getBoardList(BoardBean bean) throws SQLException {
		List<BoardBean> list;

		list = sqlSession.selectList("board.getBoardList",bean);
		
		
		//List<CodeBean> list = null;
		return list;
	}
	
	@Override
	public int getBoardListTotal(BoardBean bean) throws SQLException {
		
		//System.out.println(bean.getPageNum());
		//System.out.println(bean.getTotal());
		int count = sqlSession.selectOne("board.getBoardListTotal",bean);
		//System.out.println(count);
		//int count = 0;
		//List<CodeBean> list = null;
		return count;
	}
	
	@Override
	public int changeBoard(BoardBean bean) throws SQLException{
		
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();

		
        
        
		int result = 0;
		
		int changeMode = bean.getChangeMode();
		if(changeMode == 1){
			sqlSession.insert("board.insertBoard",bean);
			result = bean.getIdx();

		}else if(changeMode == 2){
			result = bean.getIdx();
			sqlSession.update("board.modifyBoard",bean);

		}else if(changeMode == 3){
			result = bean.getIdx();
			sqlSession.delete("board.deleteBoard",bean);

		}
		

		
		if(result <= 0){
			
		}
		
		
		return result;
	}
	
	
	@Override
	public FileBean saveFile(FileBean bean) throws SQLException {
		//AdminBean result = sqlSession.selectOne("home.selectQuery",id);
		int result = sqlSession.insert("board.saveFile",bean);
		if(result <= 0){
			
		}
		return bean;
	}
	
	@Override
	public List<FileBean> viewFileAll(FileBean bean) throws SQLException {
		//AdminBean result = sqlSession.selectOne("home.selectQuery",id);
		List<FileBean> result = sqlSession.selectList("board.viewFileAll",bean);
		
		return result;
	}
	
	@Override
	public void deleteFile(FileBean bean) throws SQLException {
		//AdminBean result = sqlSession.selectOne("home.selectQuery",id);
		int result = sqlSession.delete("board.deleteFile",bean);
		if(result <= 0){
			
		}
	}

	@Override
	public List<FileBean> getFile(FileBean bean) {
		List<FileBean> result = sqlSession.selectList("board.getFile",bean);
		
		return result;
	}*/

	

}
