package com.icode.chengcheng.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/*
 * MD5åŠ å¯†
 * 
 * ä½œè?…ï¼šé­é¹è¾?
 * æ—¶é—´ï¼?2017.6.13
 * ä½œç”¨ï¼šä¸ºæ•°æ®åŠ å¯†æä¾›MD5æ¥å£ï¼Œä»¥åŠ å¯†æ•°æ®
 */
public class MD5 {

	// ï¿½ï¿½ï¿½ï¿½BASE64Encoderï¿½ï¿½ï¿½Ğ¼ï¿½ï¿½ï¿½ï¿½Ö´ï¿½
		public static String EncoderByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

			// Éú³ÉÒ»¸öMD5¼ÓÃÜ¼ÆËãÕªÒª
			MessageDigest md = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();

			// Ê¹ÓÃbase64ÖØĞÂ±àÂë
			String newstr = base64en.encode(md.digest(str.getBytes("utf-8")));
			return newstr;
		}

		// ï¿½Ğ¶ï¿½ï¿½Ö·ï¿½ï¿½ï¿½ï¿½Ç·ï¿½Ò»ï¿½ï¿½
		public static boolean CheckStr(String newstr,String oldstr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			
			if(EncoderByMD5(newstr).equals(oldstr)){
				return true;
			}else{
				return false;
			}
			}

		
		// ï¿½ï¿½ï¿½ï¿½BASE64Decoderï¿½ï¿½ï¿½ï¿½ï¿½Ö·ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
		public static String DecoderByMD5(String str){
			BASE64Decoder base64de = new BASE64Decoder();
			
			String b = "";
			byte[] newstr;
			try {
				newstr = base64de.decodeBuffer(str);
				b = new String(newstr);
				b.getBytes("utf-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return b;
			
		}
	
}
