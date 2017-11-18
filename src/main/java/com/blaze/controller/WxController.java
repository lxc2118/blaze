package com.blaze.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blaze.util.EncryptUtil;

@Controller
public class WxController {
	
	@RequestMapping("/wx")
	@ResponseBody
	public String test(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String method = req.getMethod();
	    if(check_signature(signature, timestamp, nonce, "123"))
            return echostr;
		if ("GET".equals(method)) {

		}
		return "";
	}
	
	public static boolean check_signature(String signature, String timestamp, String nonce, String token) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    String[] arr = new String[] { timestamp, nonce, token };
	    Arrays.sort(arr);
	    String s = arr[0] + arr[1] + arr[2];
	    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
	    byte[] digest = messageDigest.digest(s.getBytes("utf-8"));
	    return signature.equals(bytes2HexString(digest));
	}
	
	public static String bytes2HexString(byte[] src){   
	    StringBuilder stringBuilder = new StringBuilder("");   
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }   
	    for (int i = 0; i < src.length; i++) {   
	        int v = src[i] & 0xFF;   
	        String hv = Integer.toHexString(v);   
	        if (hv.length() < 2) {   
	            stringBuilder.append(0);   
	        }   
	        stringBuilder.append(hv);   
	    }   
	    return stringBuilder.toString();   
	}   
}
