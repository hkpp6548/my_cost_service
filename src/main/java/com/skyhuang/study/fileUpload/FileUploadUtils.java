package com.skyhuang.study.fileUpload;

import java.util.UUID;

/** 文件上传帮助类
 * Created by hk on 2017/10/14.
 */
public class FileUploadUtils {

    /**
     * 获取上传文件的真是名字
     * c:\a.txt  或者 a.txt
     * @param fileName
     * @return
     */
    public static String getRealName(String fileName){
        int index = fileName.lastIndexOf("\\") + 1;
        return fileName.substring(index);
    }

    /**
     * 获取文件名的uuid的随机名称
     * @param fileName
     * @return
     */
    public static String getUUIDFileName(String fileName){
        int index = fileName.lastIndexOf(".");
        if(index != -1){
            return UUID.randomUUID() + fileName.substring(index);
        } else {
            return UUID.randomUUID().toString();
        }
    }

    public static String getRandomDirectory(String fileName){
        // int hashcode = filename.hashCode();
        //
        // // System.out.println(hashcode);
        //
        // // int类型数据在内存中占32位。转换成16进制数，就得到8个16进制数
        // String hex = Integer.toHexString(hashcode);
        //
        // // System.out.println(hex); // 056d9363
        //
        // return "/" + hex.charAt(0) + "/" + hex.charAt(1);
        int hashcode = fileName.hashCode();
        System.out.println(Integer.toBinaryString(hashcode));
        int a = hashcode & 0xf;
        hashcode = hashcode >>> 4;
        int b = hashcode & 0xf;
        return "/" + a + "/" + b;
    }

}
