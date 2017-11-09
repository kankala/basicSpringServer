package kr.co.htop.common;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;*/
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;


@Component("excelView")
public class ExcelView/* extends AbstractExcelView*/{

	/*@SuppressWarnings("unchecked")
	@Override
    protected void buildExcelDocument(Map<String,Object> model,HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception{
		@SuppressWarnings("unchecked")
		List<OrderBean> list = (List<OrderBean>)model.get("excelList");
		int target = list.get(0).getIdx();
		String excelName;
		HSSFSheet worksheet = null;
		HSSFRow row = null;
  
		String s = "접수일,완료일,상태,이름,고객번호,계약ID,휴대폰,전화번호"
		+ ",주소,전략프로모션,방송국,업체"
		+ ",지역,약정,상품타입,상품명,상품명2,DV유무,사은픔,타사전환여부"
		+ ",사이트,접수자,비고,관리자비고,접수처리점메모";
		String[] names = s.split(",");
		if(target == 1){
			excelName=URLEncoder.encode("접수리스트","UTF-8");
			
			worksheet = workbook.createSheet(excelName+ " WorkSheet");
			row = worksheet.createRow(0);
			for(int i = 0; i <names.length ; i++ ){
				row.createCell(i).setCellValue(names[i]);
			}
			int x = 1;
			
			for(OrderBean bean : list){
				int y = 0;
				row = worksheet.createRow(x);
				row.createCell(y++).setCellValue(bean.getAcceptDate().toString().split(" ")[0]);
				row.createCell(y++).setCellValue(bean.getWantDate());
				row.createCell(y++).setCellValue(orderInteger("희망시간",bean.getWantTime()));
		        row.createCell(y++).setCellValue(orderInteger("완료일",bean.getCompleteDate().toString().split(" ")[0]));
		        row.createCell(y++).setCellValue(orderInteger("상태",bean.getStatus()));
		        row.createCell(y++).setCellValue(bean.getGuestName());
		        row.createCell(y++).setCellValue(bean.getGuestId());
		        row.createCell(y++).setCellValue(bean.getContractId());
		        row.createCell(y++).setCellValue(bean.getGuestHandPhone1()+"-"+bean.getGuestHandPhone2()+"-"+bean.getGuestHandPhone3());
		        row.createCell(y++).setCellValue(bean.getGuestPhone1()+"-"+bean.getGuestPhone2()+"-"+bean.getGuestPhone3());
		        row.createCell(y++).setCellValue(bean.getAddress()+" "+bean.getAddressMore());
		        row.createCell(y++).setCellValue(orderInteger("전략프로모션",bean.getTactic()));
		        
		        
		        
		        row.createCell(y++).setCellValue(bean.getBc1_name());
		        row.createCell(y++).setCellValue(bean.getBc2_name());
		        row.createCell(y++).setCellValue(bean.getBc3_name());
		        row.createCell(y++).setCellValue(orderInteger("약정",bean.getGuestContract()));
		        
		        
		        
		        row.createCell(y++).setCellValue(orderInteger("아이템타입",bean.getItemType()));
		        
		        if(bean.getItem_name().indexOf("+") != -1){
		        	String[] temp = bean.getItem_name().split("\\+"); 
		        	
		        	
		        	row.createCell(y++).setCellValue(temp[0]);
		        	row.createCell(y++).setCellValue(temp[1]);
		        }else{
		        	row.createCell(y++).setCellValue(bean.getItem_name());
		        	row.createCell(y++).setCellValue("");
		        }
		        
		        
		        row.createCell(y++).setCellValue(orderInteger("DV유무",bean.getGuestDV()));
		        row.createCell(y++).setCellValue(bean.getMainFreebie());
		        row.createCell(y++).setCellValue(orderInteger("타사전환여부",bean.getNewMember()));
		        
		        
		        row.createCell(y++).setCellValue(bean.getSite_name());
		        row.createCell(y++).setCellValue(bean.getUserName());
		        
		        row.createCell(y++).setCellValue(bean.getSubFreebie());
		        
		        row.createCell(y++).setCellValue(orderInteger("콜분류",bean.getGuestCall()));
		        
		        row.createCell(y++).setCellValue(bean.getGuestCount());
		        
		        
		         row.createCell(y++).setCellValue(bean.getGuestRRN());
		        row.createCell(y++).setCellValue(bean.getEmail());
		        row.createCell(y++).setCellValue(orderInteger("고객유형",bean.getGuestType()));
		        row.createCell(y++).setCellValue(orderInteger("납부타입",bean.getPayType()));
		        
		        
		        row.createCell(y++).setCellValue(bean.getUserMemo());
		        row.createCell(y++).setCellValue(bean.getAdminMemo());
		        row.createCell(y++).setCellValue(bean.getProcessMemo());
		        
		        x++;
			}
			for(int i = 0; i <names.length ; i++ ){
				worksheet.autoSizeColumn(i);
			}
		      
			//System.out.println("왔다 엑셀스");

			response.setHeader("Content-Disposition", "attachment; Filename="+excelName+"-excel.xls");
			
			
			response.setHeader("Content-Transfer-Encoding", "binary");
			

		}
		
    }
	
	public String orderInteger(String s,Integer o){
		String result = null;
		if(s.equals("희망시간")){
			if(o.equals(1)){
				result = "9시";
			}else if(o.equals(2)){
				result = "10시";
			}else if(o.equals(3)){
				result = "11시";
			}else if(o.equals(4)){
				result = "12시";
			}else if(o.equals(5)){
				result = "13시";
			}else if(o.equals(6)){
				result = "14시";
			}else if(o.equals(7)){
				result = "15시";
			}else if(o.equals(8)){
				result = "16시";
			}else if(o.equals(9)){
				result = "17시";
			}else if(o.equals(10)){
				result = "18시";
			}
		}else if(s.equals("완료일")){
			if(o.equals("1986-05-07")){
				result = "미완료";
			}
		}else if(s.equals("상태")){
			if(o.equals(1)){
				result = "신청완료";
			}else if(o.equals(2)){
				result = "접수완료";
			}else if(o.equals(3)){
				result = "설치완료";
			}else if(o.equals(4)){
				result = "보류";
			}else if(o.equals(5)){
				result = "취소";
			}else if(o.equals(6)){
				result = "확인요망";
			}else if(o.equals(7)){
				result = "설치불가";
			}else if(o.equals(8)){
				result = "이의제기";
			}else if(o.equals(9)){
				result = "이의완료";
			}else if(o.equals(10)){
				result = "정산이월";
			}else if(o.equals(11)){
				result = "정산확인";
			}else if(o.equals(12)){
				result = "서부설치완료";
			}else if(o.equals(13)){
				result = "북부설치완료";
			}
		}else if(s.equals("콜분류")){
			if(o.equals(1)){
				result = "일반전화";
			}else if(o.equals(2)){
				result = "온라인전화";
			}else if(o.equals(3)){
				result = "온라인가입";
			}else if(o.equals(4)){
				result = "블로그";
			}else if(o.equals(5)){
				result = "방문판매";
			}
		}else if(s.equals("약정")){
			if(o.equals(1)){
				result = "무약정";
			}else if(o.equals(2)){
				result = "1년";
			}else if(o.equals(3)){
				result = "2년";
			}else if(o.equals(4)){
				result = "3년";
			}else if(o.equals(5)){
				result = "4년";
			}else if(o.equals(6)){
				result = "5년";
			}
		}else if(s.equals("DV유무")){
			if(o.equals(0)){
				result = "";
			}else if(o.equals(1)){
				result = "DV폰(신규)";
			}else if(o.equals(2)){
				result = "DV폰(번호이동)";
			}
		}else if(s.equals("고객유형")){
			if(o.equals(1)){
				result = "일반";
			}else if(o.equals(2)){
				result = "장애인";
			}else if(o.equals(3)){
				result = "국가유공자";
			}else if(o.equals(4)){
				result = "생활보호대상자";
			}
		}else if(s.equals("납부타입")){
			if(o.equals(1)){
				result = "기사방문시";
			}else if(o.equals(2)){
				result = "은행자동이체";
			}else if(o.equals(3)){
				result = "카드결제";
			}
		}else if(s.equals("타사전환여부")){
			if(o.equals(1)){
				result = "신규신청자";
			}else if(o.equals(2)){
				result = "상품전환건";
			}else if(o.equals(3)){
				result = "기존추가건";
			}
		}else if(s.equals("전략프로모션")){
			if(o.equals(0)){
				result = "미선택";
			}else if(o.equals(1)){
				result = "전략";
			}else if(o.equals(2)){
				result = "순수";
			}
		}else if(s.equals("아이템타입")){
			if(o.equals(0)){
				result = "전체";
			}else if(o.equals(1)){
				result = "인터넷";
			}else if(o.equals(2)){
				result = "디지털";
			}else if(o.equals(3)){
				result = "케이블";
			}else if(o.equals(4)){
				result = "인터넷+디지털";
			}else if(o.equals(5)){
				result = "인터넷+케이블";
			}else if(o.equals(6)){
				result = "인터넷전화";
			}else if(o.equals(7)){
				result = "대표번호서비스";
			}
		}else{}
		
		return result;
	}
	
	public String orderInteger(String s,String o){
		String result = null;

		if(s.equals("완료일")){
			if(o.equals("1986-05-07")){
				result = "미완료";
			}else{
				result = o;
			}
		}
		return result;
	}*/
}