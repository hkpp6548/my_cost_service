package com.skyhuang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hk on 2017/8/31.
 */
public class PropertyUtils {

    public static String getPropertyValueThrows(String path, String keyName) throws IOException {
        InputStream is = PropertyUtils.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(is);
        is.close();
        return properties.getProperty(keyName).trim();
    }

    public static Properties getProperties(String path) throws IOException {
        InputStream is = PropertyUtils.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        properties.load(is);
        is.close();
        return properties;
    }

    public static String getPropertyValue(String path, String keyName){
        InputStream is = PropertyUtils.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String value = properties.getProperty(keyName).trim();
        return value;
    }

    public static void main(String[] args) {
        try {
            String url = PropertyUtils.getPropertyValue("datasrc.properties", "url");
            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
