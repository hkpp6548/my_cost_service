package com.skyhuang.study.ajax;

import com.skyhuang.domain.City;
import com.skyhuang.domain.Province;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/24.
 */
@WebServlet(name = "ProvinceAndCityServlet",urlPatterns = "/provinceAndCityServlet")
public class ProvinceAndCityServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Province province1 =  new Province();
        province1.setName("江西");
        Province province2 =  new Province();
        province2.setName("广东");
        List<City> citys1 = new ArrayList<City>();
        List<City> citys2 = new ArrayList<City>();
        City city1 = new City("南昌");
        City city2 = new City("抚州");
        citys1.add(city1);
        citys1.add(city2);
        City city3 = new City("深圳");
        City city4 = new City("广州");
        citys2.add(city3);
        citys2.add(city4);
        province1.setCitys(citys1);
        province2.setCitys(citys2);

        JSONArray array = new JSONArray();
        array.add(province1);
        array.add(province2);

        PrintWriter writer = response.getWriter();
        writer.print(array.toString());
        writer.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
