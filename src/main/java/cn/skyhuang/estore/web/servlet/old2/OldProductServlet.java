package cn.skyhuang.estore.web.servlet.old2;

/** 商品控制器（id查找, 查找所有）；
 * Created by dahoufang the one on 2017/11/4.
 */
/*
@WebServlet(name = "OldProductServlet", urlPatterns = "old/product")
public class OldProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            String method = request.getParameter(StringStaticUtils.PARAM_METHOD);
            //临时处理index.jsp页面参数传递不过来的问题。
            if(null == method){
                String queryString = request.getQueryString();
                String[] split = queryString.split("method=");
                method = split[1];
            }
            if ("findById".equals(method)) {            //id查找
                findProductById(request, response);
            } else if ("findAll".equals(method)) {      //查找所有
                findAllProducts(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    */
/**
     *  查找所有商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *//*

    public void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.查询所有商品
        ProductService service = new ProductService();
        try {
            List<Product> ps = service.findAll();
            //2.将所有商品存储到request域。
            request.setAttribute("ps", ps);
            RequestSendUtiles.requestForward("home.jsp", request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    */
/**
     * 根据商品id查找商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *//*

    public void findProductById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.得到商品id
        String id = request.getParameter("id");
        // 2.调用service,dao完成查询商品操作
        ProductService service = new ProductService();
        try {
            Product p = service.findById(id);
            // 将p存储到request域，请求转发到productInfo.jsp页面，展示 商品信息.
            request.setAttribute("p", p);
            String imgurl = p.getImgurl();//图片真实路径
            //缩略图
            int subnum = imgurl.lastIndexOf(".");
            String pathName = imgurl.substring(0, subnum);
            String newName = pathName + "_s" + imgurl.substring(subnum);
            request.setAttribute("img_s", newName);
            RequestSendUtiles.requestForward("productInfo.jsp", request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
*/
