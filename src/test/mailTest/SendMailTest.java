package mailTest;

import cn.skyhuang.estore.utils.SendEmailUtil;
import org.junit.Test;

import javax.mail.MessagingException;

/** 发送邮件测试
 * Created by dahoufang the one on 2017/10/30.
 */
public class SendMailTest {

    @Test
    public void sendMailTest(){
        try {
            SendEmailUtil.sendMail("510373198@qq.com","test");
            System.out.println("发送成功！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
