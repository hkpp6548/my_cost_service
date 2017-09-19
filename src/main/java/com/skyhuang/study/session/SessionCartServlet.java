package com.skyhuang.study.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** session简单的购物车
 * Created by dahoufang the one on 2017/9/14.
 */
@WebServlet(name = "SessionCartServlet",urlPatterns = "/session/cart")
public class SessionCartServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		//获取购物车。
		Object cart = session.getAttribute("cart");
		//获取参数
		Integer  id = Integer.parseInt(request.getParameter("id"));
		//商品列表
		String [] productNames = new String []{"手电筒","冰箱","电视","洗衣机","电脑"};
		//查看是否是第一次访问
		if(cart == null){
			//新建一个购物车
			Map<String, Integer> newCart = new HashMap<String, Integer>();
			//获取商品名称
			String productName = productNames[id - 1];
			//商品添加进购物车
			newCart.put(productName, 1);
			//将购物车放入session
			session.setAttribute("cart", newCart);
		}else {
			//获取原有购物车
			Map<String, Integer> oldCart = (Map<String, Integer>)cart;
			//获取商品名称
			String productName = productNames[id - 1];
			//获取购物车中的所有商品名称
			Set<String> names = oldCart.keySet();
			int has = 0;
			for (String name: names) {
				if(name.equals(productName)){
					Integer num = oldCart.get(name);
					num++;
					has++;
					oldCart.put(productName, num);
				}
			}
			if(has == 0){
				oldCart.put(productName, 1);
			}
			/*if(names.contains(productName)){

			}else{

			}*/
			//将购物车放入session中
			session.setAttribute("cart", oldCart);
		}
		// 继续购物或者结算
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3><a href='/session/cartList.jsp'>继续购物</a> | <a href='/session/pay.jsp'>去结算</a></h3>");
	}
}
