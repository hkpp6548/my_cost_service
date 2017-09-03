package com.skyhuang.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5的全称是Message-Digest Algorithm 5（信息-摘要算法）
 * MD5加密解密工具类
 * Created by skyhuang on 2017/8/29.
 */
public class MD5Utils {

    /**
     *  利用MD5进行字符串加密
     * @param src 需要加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5 (String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64 base64 = new Base64();
        //加密字符串
        String target = base64.encode(md5.digest(src.getBytes("UTF-8")));
        return target;
    }

    /**
     *  判断用户输入的密码是否正确
     * @param src   需要判断的值
     * @param target    目标值
     * @return boolean 正确返回true 错误返货false
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkPassWord(String src, String target) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        if (encoderByMd5(src).equals(target)){
            return true;
        } else {
            return false;
        }
    }

}
