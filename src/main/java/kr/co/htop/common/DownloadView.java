package kr.co.htop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {
	
	public DownloadView() {
        setContentType("applicaiton/download;charset=utf-8");
    }
	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0,
			HttpServletRequest arg1, HttpServletResponse arg2) throws Exception {
		
		
		/*FileBean bean = (FileBean) arg0.get("downloadFile");
		 File file = new File(bean.getFilePath()+bean.getIdx());
        
		arg2.setContentType(getContentType());
		arg2.setContentLength((int)file.length());
        String fileName = java.net.URLEncoder.encode(new String(bean.getOriginalName().getBytes("8859_1"),"UTF-8"), "UTF-8");
         
        
        if(System.getProperty("os.name").contains("Windows")){
        	arg2.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
        }else{
        	arg2.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
        }
        
        
        arg2.setHeader("Content-Transfer-Encoding", "binary");
         
        OutputStream out = arg2.getOutputStream();
        FileInputStream fis = null;
         
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) { try { fis.close(); } catch (Exception e2) {}}
        }
        out.flush();*/
		
	}

}
