package com.xianzhifengshui.api.des;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @desc MD5加密工具类
 *
 * @author zhangtb
 * @date 2016年10月4日下午8:58:59
 * @since 1.0.0
 * @version 1.0.0
 */
public class Md5Utils {
	
	/**
	 * @desc 标准的md5加密算法
	 *
	 * @author zhangtb
	 * @date 2016年10月4日下午8:58:45
	 * @since 1.0.0
	 * @version 1.0.0
	 * @param plainText
	 * @return
	 */
	public static String md5s(String plainText) {
		String str = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuilder buf = new StringBuilder("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
					i += 256;
				}
				if (i < 16){
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}

	
}
