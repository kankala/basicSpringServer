package kr.co.htop.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/*

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
public class ExcelRead {
	String uploadPath = "";
	String extension = "";
	File[] fileList;
	File dir;
	File file;
	FileInputStream input;
	/*List<ChannelBean> channelBean = new ArrayList<ChannelBean>();
	
	
	
	public List<ChannelBean> excelRead(BcBean bcbean,HttpServletRequest request){
		
		
		bcbean.getBc1();
		bcbean.getBc2();
		
		if(System.getProperty("os.name").contains("Windows")){
			uploadPath = request.getSession().getServletContext().getRealPath("/")+"\\resources\\excel\\";
		}else{
			uploadPath = "/home/tomcat/webapps/excel/";
		}
		dir= new File(uploadPath);
		
		fileList = dir.listFiles(); 
		
		for(int i = 0 ; i < fileList.length ; i++){
			file = fileList[i]; 
			if(file.isFile()){
				if(file.getName().contains("xls")){
					extension = "xls";
				}else if(file.getName().contains("xlsx")){
					extension = "xlsx";
				}
				if(file.getName().contains(bcbean.getBc1()+"_"+bcbean.getBc2()+"."+extension)){
					try {
						input = new FileInputStream(uploadPath+file.getName());	
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					
					
					channelBean = excelCreate();
				}
			}
		}
		return channelBean;
	}
	
	private List<ChannelBean> excelCreate(){
		StringBuffer name = null;
		StringBuffer number = null;
		StringBuffer alt = null;
		StringBuffer titleRow = null;
		ChannelBean bean = null;
		
		if(extension.equals("xls")){
			
		    // Workbook 지정
		    
			HSSFWorkbook workBook = null;
			try {
				workBook = new HSSFWorkbook(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int s = 0; s < workBook.getNumberOfSheets(); s++){
				name = new StringBuffer();
				number = new StringBuffer();
				alt = new StringBuffer();
				titleRow = new StringBuffer();
				bean = new ChannelBean();
			    // 읽어들이고자 하는 시트 지정
			    HSSFSheet sheet = workBook.getSheetAt(s);
			    //
			    HSSFRow rowEx = sheet.getRow(0);
			    // 시트에 있는 Row의 끝가지 루프
			    int x = 0;
			    int y = 0;
			    while(x < rowEx.getPhysicalNumberOfCells()){
			    	int i = 0;
			    	int ii= 0;
				    while (i < sheet.getPhysicalNumberOfRows()) {
				    	y=x;
				        // 시트에서 Row 가져오기
				        HSSFRow row = sheet.getRow(i);
				        if(cellGetF(row.getCell(y)) != null && row.getCell(y) != null){
				        	String result = null;
			        		String addHd = "";
			        		number.append(cellGetF(row.getCell(y))+"aa");
			        		y++;
			        		
			        		if(cellGetF(row.getCell(y)) != null){
			        			alt.append(cellGetF(row.getCell(y))+"aa");
			        			result = cellGetF(row.getCell(y));
			        			if(result.indexOf("(") == -1){
				        			if(result.getBytes().length > 21){
					        			if(result.indexOf("HD") > -1){
					        				addHd = "HD";
					        				result = result.replaceAll("HD", "");
					        			}
					        			while(result.getBytes().length > 21){
					        				result = result.substring(0,result.length()-1);
					        			}
					        			name.append(result+".."+addHd+"aa");
				        			}else{
				        				name.append(cellGetF(row.getCell(y))+"aa");
				        			}
			        			}else{
			        				name.append(cellGetF(row.getCell(y))+"aa");
			        			}
			        		}else{
			        			alt.append(cellGetF(row.getCell(y))+"aa");
			        			name.append(cellGetF(row.getCell(y))+"aa");
			        		}
			        		
					        ii++;
				        	
				    	}else{
				    		y++;
				    	}
			        	
				        i++;
				        // Row에서 데이터 가져오기
				    }
				    titleRow.append(ii+"aa");
				    x += 2;
				    
			    }
			    bean.setTitleRow(titleRow.toString().split("aa"));
	    		bean.setType(sheet.getSheetName());
			    bean.setNumber(number.toString().split("aa"));
			    bean.setName(name.toString().split("aa"));
			    bean.setAlt(alt.toString().split("aa"));
			    channelBean.add(bean);
			}
			
		}else if(extension.equals("xlsx")){
			
		    // Workbook 지정
		
			XSSFWorkbook workBook = null;
			try {
				workBook = new XSSFWorkbook(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int s = 0; s < workBook.getNumberOfSheets(); s++){
				name = new StringBuffer();
				number = new StringBuffer();
				alt = new StringBuffer();
				titleRow = new StringBuffer();
				bean = new ChannelBean();
			    // 시트 지정
			    XSSFSheet sheet = workBook.getSheetAt(s);
			    XSSFRow rowEx = sheet.getRow(0);
			    // 시트에 있는 Row의 끝가지 루프
			    int x = 0;
			    int y = 0;
			    while(x < rowEx.getPhysicalNumberOfCells()){
			    	int i = 0;
			    	int ii= 0;
				    while (i < sheet.getPhysicalNumberOfRows()) {
				    	y=x;
				        // 시트에서 Row 가져오기
				    	XSSFRow row = sheet.getRow(i);
				    	if(cellGetX(row.getCell(y)) != null && row.getCell(y) != null ){
				    		String result = null;
				    		String addHd = "";
				    		number.append(cellGetX(row.getCell(y))+"aa");
			        		y++;
			        		if(cellGetX(row.getCell(y)) != null){
			        			alt.append(cellGetX(row.getCell(y))+"aa");
			        			result = cellGetX(row.getCell(y));
			        			if(result.indexOf("(") == -1){
				        			if(result.getBytes().length > 21){
				        				
					        			if(result.indexOf("HD") > -1){
					        				addHd = "HD";
					        				result = result.replaceAll("HD", "");
					        			}
					        			while(result.getBytes().length > 21){
					        				result = result.substring(0,result.length()-1);
					        			}
					        			name.append(result+".."+addHd+"aa");
				        			}else{
				        				name.append(cellGetX(row.getCell(y))+"aa");
				        			}
			        			}else{
			        				name.append(cellGetX(row.getCell(y))+"aa");
			        			}
			        		}else{
			        			alt.append(cellGetX(row.getCell(y))+"aa");
			        			name.append(cellGetX(row.getCell(y))+"aa");
			        		}
			        		name.append(cellGetX(row.getCell(y))+"aa");
					        ii++;
				        	
				    	}else{
				    		y++;
				    	}
			        	
				        i++;
				        // Row에서 데이터 가져오기
				    }
				    titleRow.append(ii+"aa");
				    x += 2;
				    
			    }
			    bean.setTitleRow(titleRow.toString().split("aa"));
	    		bean.setType(sheet.getSheetName());
			    bean.setNumber(number.toString().split("aa"));
			    bean.setName(name.toString().split("aa"));
			    bean.setAlt(alt.toString().split("aa"));
			    channelBean.add(bean);
			}
		}
		return channelBean;
	}
	
	
	private String cellGetF(HSSFCell cell){
		String result = null;
		if(cell != null){
			switch(cell.getCellType()){
				case HSSFCell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;
				
				case HSSFCell.CELL_TYPE_NUMERIC:
				result = ""+cell.getNumericCellValue();
				result = String.valueOf((int)Double.parseDouble(result));
				
				break;
				
				case HSSFCell.CELL_TYPE_STRING:
				result = ""+cell.getStringCellValue();
				if(result.equals(".")){
					result = null;
				}
				break;
				
				case HSSFCell.CELL_TYPE_BLANK:
				//result = ""+cell.getBooleanCellValue();
					result = null;
				break;
				
				case HSSFCell.CELL_TYPE_ERROR:
				result = ""+cell.getErrorCellValue();
				
				break;
			}
		}
		if(result == "false" || result == "." || result == "" || result == "null"){
			result = null;
		}
		
		
		return result;
	}
	
	private String cellGetX(XSSFCell cell){
		String result = null;
		if(cell != null){
			switch(cell.getCellType()){
				case XSSFCell.CELL_TYPE_FORMULA:
				result = cell.getCellFormula();
				break;
				
				case XSSFCell.CELL_TYPE_NUMERIC:
				result = ""+cell.getNumericCellValue();
				result = String.valueOf((int)Double.parseDouble(result));
				break;
				
				case XSSFCell.CELL_TYPE_STRING:
				result = ""+cell.getStringCellValue();
				if(result.equals(".")){
					result = null;
				}
				break;
				
				case XSSFCell.CELL_TYPE_BLANK:
					//result = ""+cell.getBooleanCellValue();
					result = null;
				break;
				
				case XSSFCell.CELL_TYPE_ERROR:
				result = ""+cell.getErrorCellValue();
				break;
			}
		}
		if(result == "false" || result == "." || result == "" || result == "null"){
			result = null;
		}
		
		return result;
	}
*/
}

