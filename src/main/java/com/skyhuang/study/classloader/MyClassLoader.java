package com.skyhuang.study.classloader;

import java.io.*;

/** 自定义类加载器
 * Created by hk on 2017/10/26.
 */
public class MyClassLoader extends ClassLoader{

    private String rootDir;//项目的classes的根目录

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {

        String extname = name.replace(".", "\\");
        String filename = rootDir + "\\" + extname + ".class";//自定义的classes的路径

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream is = new FileInputStream(filename);
            int len = -1;
            byte[] b = new byte[1024];

            while ((len = is.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            baos.flush();
            baos.close();
            is.close();

            byte[] data = baos.toByteArray();//这个数组装入的就是.class的内容

            return defineClass(name, data, 0, data.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
