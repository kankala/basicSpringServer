package kr.co.htop.common;

public class ChangeString{

	public String replaceAl(String strOriginal, String from, String to){
	 
		int startPos, endPos;
		 
		String strReplacedString = strOriginal;
		 
		while(strReplacedString.indexOf(from) != -1){
			startPos = strReplacedString.indexOf(from);
			strReplacedString = strReplacedString.substring(0, startPos) + to + strReplacedString.substring(startPos + from.length());
		}

		return strReplacedString;
	}

}