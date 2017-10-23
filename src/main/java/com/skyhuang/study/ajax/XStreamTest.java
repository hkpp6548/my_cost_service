package com.skyhuang.study.ajax;

import com.skyhuang.domain.Person;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
public class XStreamTest {
    // 将person对象转换成xml
    @Test
    public void fun1() {
        Person p = new Person(1, "tom", 20);

        XStream xs = new XStream();

        // 设置别名
        // xs.alias("person", Person.class);

        // 要想让注解生效，必须开启
        // xs.autodetectAnnotations(true);

        String xml = xs.toXML(p);

        System.out.println(xml);
    }

    // 将List<Person>转换成xml
    @Test
    public void fun2() {
        List<Person> ps = new ArrayList<Person>();
        ps.add(new Person(1, "tom", 20));
        ps.add(new Person(2, "fox", 30));

        XStream xs = new XStream();

        // xs.alias("person", Person.class);
        // xs.alias("persons", List.class);

        String xml = xs.toXML(ps);

        System.out.println(xml);
    }

    // 将一个xml解析成java对象.
    @Test
    public void fun3() throws FileNotFoundException {
        XStream xs = new XStream();
        // xs.autodetectAnnotations(true);

        xs.alias("person", Person.class);

        Object obj = xs.fromXML(new FileInputStream(
                "D:\\java1110\\workspace\\day23_3\\src\\person.xml"));

        System.out.println(obj);
    }
}
