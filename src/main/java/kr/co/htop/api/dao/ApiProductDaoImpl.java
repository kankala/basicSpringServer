package kr.co.htop.api.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.TransactionManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.tools.ant.taskdefs.SQLExec.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import kr.co.htop.api.bean.ApiProductBean;





public class ApiProductDaoImpl implements ApiProductDao {
	
	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	/*@Resource(name="transactionManager")
    private DataSourceTransactionManager transactionManager;*/
	
	
	@Override
	public int putProduct(List<ApiProductBean> beanList) {
		Integer result = 0;
		
		/*DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("example-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);*/
		
		
        for(ApiProductBean bean : beanList) {
        	/*try {*/
	        	sqlSession.insert("apiProduct.putProduct",bean);
	        	
	        	sqlSession.insert("apiProduct.putProduct_img",bean);
	        	
	        	result = sqlSession.insert("apiProduct.putProduct_img_cnt",bean);
        	/*} catch (Exception e) {
                // TODO: handle exception
                transactionManager.rollback(status);
                e.printStackTrace();
            }
        	transactionManager.commit(status);*/
        }
		
		
		return result;
	}

	
	




	




	


	
	
}
