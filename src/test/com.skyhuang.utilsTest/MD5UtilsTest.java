package com.skyhuang.utilsTest;

import com.skyhuang.utils.MD5Utils;
import org.junit.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/** 单元测试 MD5Utils
 * Created by hk on 2017/9/3.
 */
public class MD5UtilsTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @Ignore
    public void testEncoderByMd5(){
        try {
            String byMd5Str = MD5Utils.encoderByMd5("123");
            System.out.println(byMd5Str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Test
    public void testCheckPassWord(){
        try {
            String target = MD5Utils.encoderByMd5("124");
            boolean trueOrfalse = MD5Utils.checkPassWord("123", target);
            if (trueOrfalse){
                System.out.println("密码正确");
            } else {
                System.out.println("密码错误");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



}
