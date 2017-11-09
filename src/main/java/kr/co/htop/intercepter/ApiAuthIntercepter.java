package kr.co.htop.intercepter;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

//import net.kankala.spring.admin.bean.UserBean;








import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;



@Service
public class ApiAuthIntercepter extends HandlerInterceptorAdapter {
 //HandlerInterceptorAdapter 를 상속 받아야 intercepter 등록이 가능함
	//@Resource(name="logDao")
	//LogDao logDao;
	

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException,ParseException{
		
		
		boolean result   =  true;
		String Authorization = request.getHeader("Authorization");
		if(Authorization != null && Authorization != ""){
			System.out.println(Authorization);
			String key = "#f3hwaks#cr#7";
			String base64Key = DatatypeConverter.printBase64Binary(key.getBytes());
			byte[] secretBytes = DatatypeConverter.parseBase64Binary(base64Key);
			
			try {
				//JWSVerifier verifier = new MACVerifier(key);
				
				
				
				//String jwtString = "";
				SignedJWT signedJWT = (SignedJWT)SignedJWT.parse(Authorization);
				 
				// check payload and applied algorithm in header
				//System.out.println(signedJWT.getPayload().toJSONObject());
				//System.out.println(signedJWT.getHeader().getAlgorithm());
				 
				// verification
				
				//assertThat(signedJWT.verify(verifier), is(true));
				
			} catch (ParseException e){
				result = false;
			}
		}else{
			result = false;
		}

		
		return result;
	}

	
}