package cn.skyhuang.estore.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/** 邮件发送工具类
 * Created by dahoufang the one on 2017/10/30.
 */
public class SendEmailUtil {

    /**
     * 发送邮件
     * @param emailAddress  邮箱地址
     * @param emailMsg  邮件内容
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMail(String emailAddress, String emailMsg) throws AddressException, MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15216100570", "1qaz2WSX");
            }
        };
        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("15216100570@163.com")); // 设置发送者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailAddress)); // 设置发送方式与接收者
        message.setSubject("用户激活");
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }



    /**
     * 获取网络连接的会话信息Session
     * @Title: getSession
     * @param protocol 邮件协议类型
     * @return Session
     */
    /*private static Session getSession(String protocol) {
        Properties mailProps = new Properties();
        mailProps.put("mail.smtp.auth", "true");// 向SMTP服务器提交用户认证
        mailProps.put("mail.transport.protocol", protocol);// 指定发送邮件协议
        // getInstance每次都会拿一个新的session,而getDefaultInstance拿的是同一个session
        Session session = Session.getDefaultInstance(mailProps);
        // session.setDebug(true);//调试模式
        return session;
    }*/
    /**
     * 发送邮件
     * @Title: sendEmail
     * @param message
     * @param protocol
     * @throws MessagingException
     * @return void
     */
    /*private static void sendEmail(MimeMessage message, String protocol) throws MessagingException {
        //连接发送方的SMTP服务器
        String host = "smtp.mxhichina.com";
        //用户名
        String user = "resource@dahoufang.com.cn";
        //密码
        String password = ParameterFactory.getString(AppApiConstant.SYS_PARAM_HG_EMAIL_FROM_PASSWORD, null);
        // 从session中取mail.smtp.protocol指定协议的Transport
        SystemLogger.info("正在连接服务器。。。。");
        Transport transport = getSession(protocol).getTransport();
        // 建立与指定的SMTP服务器的连接
        transport.connect(host, user, password);
        SystemLogger.info("正在发送邮件。。。。");
        // 发给所有指定的收件人,若使用message.getAllRecipients()则还包括抄送和暗送的人
        transport.sendMessage(message, message.getRecipients(RecipientType.TO));
        transport.sendMessage(message, message.getRecipients(RecipientType.CC));
        // 关闭连接
        transport.close();
        SystemLogger.info("邮件发送完成！");

//         Transport的send静态方法包括了connect,saveChanges,sendMessage,close等一系列操作，
//         但它连接同一个SMTP服务器每发一封邮件给服务器都得重新建立连接和断开连接, 虽然使用较方便，但开销较大,不值得推荐。

        // Transport.send(message, message.getRecipients(RecipientType.TO));
    }*/
    /**
     * 获取邮件内容
     * @Title: getTextMessage
     *		@param session 回话session
     *		@param fileName	附件路径
     *		@throws AddressException
     *		@throws MessagingException
     *		@throws UnsupportedEncodingException
     * @return MimeMessage
     */
    /*private static MimeMessage getTextMessage(Session session, String fileName)
            throws AddressException, MessagingException,
            UnsupportedEncodingException {
        MimeMessage message = new MimeMessage(session);
        String agoDay = CreateExcel.getAgoDay(-4);
        //发件人
        String from = "resource@dahoufang.com.cn";
        message.setFrom(new InternetAddress(from));
        // message.setRecipient(RecipientType.TO, new InternetAddress(to));
        //收件人
        String to = ParameterFactory.getString(AppApiConstant.SYS_PARAM_HG_EMAIL_TO, null);
        if (!"".equals(to)) {
            String[] tos = to.split(",");
            InternetAddress[] sendTos = new InternetAddress[tos.length];
            for (int i = 0; i < tos.length; i++) {
                SystemLogger.info("发送到:" + tos[i]);
                sendTos[i] = new InternetAddress(tos[i]);
            }
            message.setRecipients(RecipientType.TO, sendTos);
        }

        //抄送
        String cc = ParameterFactory.getString(AppApiConstant.SYS_PARAM_HG_EMAIL_CC, null);
        if (!"".equals(cc)) {
            String[] ccs = cc.split(",");
            InternetAddress[] sendToCCs = new InternetAddress[ccs.length];
            for (int i = 0; i < ccs.length; i++) {
                SystemLogger.info("抄送到:" + ccs[i]);
                sendToCCs[i] = new InternetAddress(ccs[i]);
            }
            message.setRecipients(RecipientType.CC, sendToCCs);
        }

        //主题
        String subject = ParameterFactory.getString(AppApiConstant.SYS_PARAM_HG_EMAIL_SUBJECT, null);
        subject += agoDay;
        message.setSubject(subject);
        message.setSentDate(new Date());// 发送时间
        MimeBodyPart attached1BodyPart = getAttachedBodyPart(fileName);// 注意附件名是中文的
        // 设置邮件的文本内容
        BodyPart contentPart = new MimeBodyPart();
        String text = ParameterFactory.getString(AppApiConstant.SYS_PARAM_HG_EMAIL_TEXT, null);
        text = agoDay + text;
        contentPart.setText(text);
        MimeMultipart mmp = new MimeMultipart("mixed");// MIME消息头组合类型是mixed(html+附件)
        mmp.addBodyPart(attached1BodyPart);
        mmp.addBodyPart(contentPart);
        message.setContent(mmp);
        message.saveChanges();
        return message;
    }*/

    /**
     * 处理文件名 此处是针对Window下的。
     * @param filePath
     * @return
     */
    /*private static String doHandlerFileName(String filePath) {
        String fileName = filePath;
        if (null != filePath && !"".equals(filePath)) {
            fileName = filePath.substring(filePath.lastIndexOf("//") + 1);
        }
        return fileName;
    }

    private static MimeBodyPart getAttachedBodyPart(String filePath)
            throws MessagingException, UnsupportedEncodingException {
        MimeBodyPart attached = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(filePath);
        attached.setDataHandler(new DataHandler(fds));
        String agoDay = CreateExcel.getAgoDay(-4);
        String fileName = doHandlerFileName("APPUsing" + agoDay + ".xls");
        attached.setFileName(MimeUtility.encodeWord(fileName));// 处理附件文件的中文名问题
        return attached;
    }*/
    /**
     * 发送指定路径文件到指定邮箱
     * @Title: sendToEmail
     *		@param path 文件路径
     *		@throws Exception
     * @return void
     */
    /*public static void sendToEmail(String path) throws Exception {
        String protocol = "smtp";
        sendEmail(getTextMessage(getSession(protocol),path), protocol);
    }*/

}
