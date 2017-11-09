package kr.co.htop.admin.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.htop.admin.bean.ProductBean;
import kr.co.htop.admin.dao.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Resource(name="productDao")
	ProductDao dao;

	@Override
	public List<ProductBean> getProductList(ProductBean bean) {
		List<ProductBean> list = dao.getProductList(bean);
		return list;
	}
	
	/*@Override
	public List<BoardBean> getBoardList(BoardBean bean) throws SQLException {
		List<BoardBean> list = dao.getBoardList(bean);
		return list;
	}
	
	@Override
	public int getBoardListTotal(BoardBean bean) throws SQLException {
		int count = dao.getBoardListTotal(bean);
		return count;
	}
	
	@Override
	public int changeBoard(BoardBean bean,MultipartHttpServletRequest mRequest) throws SQLException{
		int a= 0;
		
		HttpSession session = mRequest.getSession();
		
		String project = (String)session.getAttribute("project");
		FileBean fbean = new FileBean();
		String uploadPath = null;
	 	if(System.getProperty("os.name").contains("Windows")){
	 	     uploadPath = "C:\\"+project+"\\uploadBoard\\";
	 		
			 //uploadPath = mRequest.getSession().getServletContext().getRealPath("/")+"\\resources\\uploadBoard\\";

	 	}else{
	    	 uploadPath = "/home/tomcat/webapps/uploadBoard/";
	 	}
	 	
		if(bean.getChangeMode() != 3){
			
			 
			 
			//System.out.println("Path is "+uploadPath);
	
			File dir = null;
			dir = new File(uploadPath);
			if (!dir.isDirectory()) {
	
				dir.mkdirs();
	
			}
			
			Iterator<String> iter = mRequest.getFileNames();
			a = dao.changeBoard(bean);
			
			fbean.setB_idx(a);
			while(iter.hasNext()) {
				String uploadFileName = iter.next();
	
				MultipartFile mFile = mRequest.getFile(uploadFileName);
				Long L = mFile.getSize();
				if(L > 15728640){
					break;
				}
				
				
				String originalFileName = mFile.getOriginalFilename();
				if(!mFile.isEmpty()){
					fbean.setFilePath(uploadPath);
					fbean.setOriginalName(originalFileName);
				

					FileBean count = dao.saveFile(fbean);
					
					

					String saveFileName = null;
					//saveFileName = Integer.toString(count.getIdx()) + "_" + System.currentTimeMillis();
					saveFileName = Integer.toString(count.getIdx());
					//fList[flagf] = saveFileName;
					
					
					try {
						
						mFile.transferTo(new File(uploadPath + saveFileName));
						
						

		
					} catch (IllegalStateException e) {
		
						e.printStackTrace();
		

		
					} catch (IOException e) {
		
						e.printStackTrace();

		
					}
				}
				
			} // if end
			
			
		}else if(bean.getChangeMode() == 3){
			
			
			fbean.setB_idx(bean.getIdx());
			
			List<FileBean> s = dao.viewFileAll(fbean);
			Iterator<FileBean> fIter = s.iterator();
			while(fIter.hasNext()) {
				FileBean files = fIter.next();
				File uf = new File(uploadPath + files.getIdx());
				if(uf.exists()) {
	                boolean delFlag = uf.delete();
	                    if(delFlag) {
	                        //System.out.println("WAS 저장파일 삭제 성공!");
	                    } else {
	                        System.out.println("WAS 저장파일 삭제 실패!");
	                    }                                            
	            } else {
	                System.out.println("삭제할 파일이 존재하지 않습니다.");
	            }
				
				
			}
			dao.changeBoard(bean);
		}
		
		return a;
	}

	@Override
	public List<FileBean> getFile(FileBean bean) {
		List<FileBean> list = dao.getFile(bean);
		return list;
	}

	@Override
	public void deleteFile(FileBean bean,HttpServletRequest request) {
		String uploadPath = null;
		
		HttpSession session = request.getSession();
		
		String project = (String)session.getAttribute("project");
	 	if(System.getProperty("os.name").contains("Windows")){
			 //uploadPath = request.getSession().getServletContext().getRealPath("/")+"\\resources\\uploadBoard\\";
			 uploadPath = "C:\\"+project+"\\uploadBoard\\";
	 	}else{
	    	 uploadPath = "/home/tomcat/webapps/uploadBoard/";
	 	}
	 	
		File uf = new File(uploadPath + bean.getIdx());
		if(uf.exists()) {
            boolean delFlag = uf.delete();
                if(delFlag) {
                    //System.out.println("WAS 저장파일 삭제 성공!");
                } else {
                    System.out.println("WAS 저장파일 삭제 실패!");
                }                                            
        } else {
            System.out.println("삭제할 파일이 존재하지 않습니다.");
        }
		try {
			dao.deleteFile(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
