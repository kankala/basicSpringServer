package kr.co.htop.common.messageSource;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;


public class MyResourceBundleMessageSource extends ResourceBundleMessageSource {
	  protected String charset = "UTF-8";
	  public void setCharset(String charset){ this.charset = charset; }
	  protected String getMessageInternal(String code, Object[] args, Locale locale) { 
	   String originalMessage = super.getMessageInternal(code,args,locale); 
	   if(originalMessage == null)
	     return null;
	   try {
	     return new String( originalMessage.getBytes("8859_1"), charset ); 
	   } catch (UnsupportedEncodingException e) { 
	     e.printStackTrace(); 
	     return null; 
	   } 
	  } 
	 }