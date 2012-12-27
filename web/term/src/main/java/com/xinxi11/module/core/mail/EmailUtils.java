package com.xinxi11.module.core.mail;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinxi11.module.core.utils.FreemarkerUtils;

import freemarker.template.TemplateException;

/**
 * 发送邮件
 */
public class EmailUtils {
	private static Logger log = LoggerFactory.getLogger(EmailUtils.class);

	private static Session session;

	static {
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp"); // 设置协议
		prop.put("mail.smtp.host", MailProperties.host); // 设置接收邮件的服务器
		prop.put("mail.smtp.port", 25); // 设置端口号
		session = Session.getDefaultInstance(prop);
	}

	/** 发送邮件 */
	public static void sendMail(MailMessageData mailData) {
		try {
			MimeMessage message = _getMimeMessage(mailData);
			Transport transport = session.getTransport("smtp");
			transport.connect(MailProperties.host, MailProperties.user, MailProperties.passworld);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (NoSuchProviderException e) {
			_logFailInfo(mailData);
			log.error("发送邮件失败-邮件认证失败!", e);
		} catch (MessagingException e) {
			_logFailInfo(mailData);
			log.error("发送邮件失败!", e);
		} catch (IOException e) {
			_logFailInfo(mailData);
			log.error("发送邮件失败!", e);
		} catch (TemplateException e) {
			_logFailInfo(mailData);
			log.error("发送邮件失败-邮件模块解析错误!", e);
		}
	}

	/** 记录邮件发送失败时的邮件信息,方便查找原因 */
	private static void _logFailInfo(MailMessageData mailData) {
		StringBuilder sb = new StringBuilder();
		sb.append("<br>邮件发送失败.邮件信息:");
		sb.append("<br>主题:").append(mailData.getSubject());
		sb.append("<br>收件人");
		for (String mail : mailData.getTo()) {
			sb.append(mail).append(",");
		}
		sb.append("<br>正文").append(mailData.getContent());
		sb.append("<br>邮件模块:").append(MailProperties.templatePath).append(mailData.getTemplateName());
		log.error(sb.toString());
	}

	/** 封装邮件信息 */
	private static MimeMessage _getMimeMessage(MailMessageData mailData) throws MessagingException, IOException,
			TemplateException {
		MimeMessage message = new MimeMessage(session);// 创建过程对象
		message.setFrom(new InternetAddress(MailProperties.name));// 设置发送邮件地址
		message.setSentDate(new Date());// 设置时间

		// 群发地址
		InternetAddress[] address = new InternetAddress[mailData.getTo().length];
		for (int i = 0; i < mailData.getTo().length; i++) { // 循环发送
			address[i] = new InternetAddress((mailData.getTo())[i]);
		}
		message.setRecipients(Message.RecipientType.TO, address);
		// 设置主题
		message.setSubject(mailData.getSubject());
		// 邮件信息
		Multipart multipart = new MimeMultipart();
		// 设置邮件正文
		MimeBodyPart textBody = new MimeBodyPart();
		// 新建一个存放信件内容的BodyPart对象
		// 给BodyPart对象设置内容和格式/编码方式
		if (mailData.getContent() == null) {
			String text = _getMailContent(mailData.getTemplateName(), mailData.getTemplateData());
			textBody.setContent(text, "text/html;charset=UTF-8");
		} else {
			textBody.setText(mailData.getContent());
		}
		multipart.addBodyPart(textBody);

		// 设置邮件附件
		if (mailData.getAttachment() != null) {
			for (File file : mailData.getAttachment()) {
				MimeBodyPart fileBody = new MimeBodyPart();
				fileBody.attachFile(file);
				multipart.addBodyPart(fileBody);
			}
		}
		// 追加到邮件消息对象中
		message.setContent(multipart);
		message.saveChanges();

		return message;
	}

	/** 解析邮件正文 */
	private static String _getMailContent(String ftlFile, Map<String, Object> data) throws TemplateException,
			IOException {
		String ftldPath = EmailUtils.class.getResource(MailProperties.templatePath).getPath() + ftlFile;
		File file = new File(ftldPath);
		return FreemarkerUtils.execute(file, data);
	}

}
