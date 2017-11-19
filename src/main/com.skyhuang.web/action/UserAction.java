package com.skyhuang.web.action;

import com.com.skyhuang.exception.FindByIdException;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.skyhuang.domain.User;
import com.skyhuang.service.UserService;
import com.skyhuang.utils.FileUploadUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 用户控制器action
 * Created by hk on 2017/11/18.
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();

    private List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getModel() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // 上传文件信息
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    // 根据id查询
    public String findById() throws FindByIdException {
        UserService service = new UserService();

        try {
            user = service.findById(user.getUserID());
        } catch (SQLException e) {
            //e.printStackTrace();

            throw new FindByIdException();
        }

        return "findById_success";

    }

    // 修改前的查询
    public String updateForFind() {
        UserService service = new UserService();

        try {
            user = service.findById(user.getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "updateForFind_success";
    }

    // 根据id删除操作
    public String del() {
        UserService service = new UserService();
        try {

            // 先查询用户，判断是否有简历，如果有简历，将简历删除。
            user = service.findById(user.getUserID());
            String path = user.getPath();

            if (path != null) {
                // 有简历，将简历删除
                new File(path).delete();
            }
            service.delById(user.getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "del_success";

    }

    // 添加用户操作
    @InputConfig(resultName = "add_input")
    public String add() throws IOException {
        // 1.完成上传
        if (upload != null) {
            String uuidname = FileUploadUtils.getUUIDFileName(uploadFileName);
            File dest = new File("d:/upload", uuidname);
            FileUtils.copyFile(upload, dest);
            // 2.调用service，dao完成添加操作
            user.setPath("d:/upload/" + uuidname);
            user.setFilename(uploadFileName);
        }
        UserService service = new UserService();

        try {
            service.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            this.addActionError("添加失败");

            return "input";
        }

        return "add_success";
    }


    // 条件查询
    public String listSelect() {

        // 调用service中条件查询操作
        UserService service = new UserService();

        try {
            users = service.findBySelect(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "listSelect_success";
    }


    // 查询所有
    public String list() {
        UserService service = new UserService();
        try {
            users = service.findAll();

            // 手动
            // ValueStack vs=ActionContext.getContext().getValueStack();
            // vs.set("users", users);

            // 自动:将users声明成成员变量，提供get/set
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "list_success";
    }



    // 登录操作
    @InputConfig(resultName = "login_input")
    public String login() {
        // 调用service中登录方法.
        UserService service = new UserService();
        try {
            user = service.login(user.getLogonName(), user.getLogonPwd());
            if (user == null) {
                this.addActionError("用户名或密码错误");
                return Action.LOGIN;
            }
            ServletActionContext.getRequest().getSession().setAttribute("user", user);
        } catch (SQLException e) {
            e.printStackTrace();
            // throw new LoginException();
            this.addActionError("登录失败");
            return Action.LOGIN;
        }

        return "login_success";
    }

}
