package com.xianzhifengshui.api.des;

import android.util.Base64;
import android.util.Log;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @desc 对称加密工具类
 *
 * @author zhangtb
 * @date 2016年10月4日下午8:31:26
 * @since 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("restriction")
public class DESUtils {
	
    private static final String DES = "DES";

    private static final String TAG = "DESUtils";

    /**
     * 密钥，长度必须是8位
     */
    private static final String keyString = "tbframew";
    
    /**
     * 虚拟密钥，长度必须是8位
     */
    private static final String ivString = "vpRZ1kmU";

    /**
     * Description 根据键值进行加密
     *
     * @param data the data
     * @return string string
     */
    public static String encrypt(String data) {
        byte[] bt = new byte[0];
        try {
            bt = encrypt(data.getBytes(), keyString.getBytes());
            String strs = DESPlus.byteArr2HexStr(bt);
            return strs;
        } catch (Exception e) {
            Log.e(TAG, "encrypt error:"+e.getLocalizedMessage());
            return "";
        }


    }

    /**
     * Description 根据键值进行解密
     *
     * @param data the data
     * @return string string
     */
    public static String decrypt(String data)  {
        if (data == null) {
        	return null;
        }
        byte[] buf = new byte[0];
        try {
            buf = DESPlus.hexStr2ByteArr(data);
            byte[] bt = decrypt(buf, keyString.getBytes());
            return new String(bt);
        } catch (Exception e) {
            Log.e(TAG, "decrypt error:"+e.getLocalizedMessage());
            return "";

        }


    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        //SecureRandom sr = new SecureRandom();
        IvParameterSpec iv = new IvParameterSpec(ivString.getBytes());
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        //SecureRandom sr = new SecureRandom();
        IvParameterSpec iv = new IvParameterSpec(ivString.getBytes());
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);

        return cipher.doFinal(data);
    }

    /**
     * @param message   the message
     * @param keyString the key string
     * @return the string
     */
    public static String desEncryptForFinance(String message,String keyString) {
        String result = ""; // DES加密字符串
        try {
            SecretKey secretKey = new SecretKeySpec(keyString.getBytes(), "DESede");// 获得密钥
            Cipher cipher = null;
			/* 获得一个私鈅加密类Cipher，DESede是算法，ECB是加密模式，PKCS5Padding是填充方式 */
            cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // 设置工作模式为加密模式，给出密钥
            byte[] resultBytes = cipher.doFinal(message.getBytes("UTF-8")); // 正式执行加密操作
            result = Base64.encodeToString(resultBytes,Base64.NO_WRAP);// 进行BASE64编码
        } catch (Exception e) {
        	System.err.println("DES error");
            e.printStackTrace();
        }
        return result;
    }


}