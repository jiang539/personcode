package com.xinxi11.module.core.mail;

public class MailProperties {

	/** 系统是否发送邮件,默认不发送 */
	public static Boolean isSendMail = false;

	/** 邮件服务器  */
	public static String host = null;

	/** 发送人邮箱地址 */
	public static String user = null;

	/** 发送人呢称 */
	public static String name = "系统管理员";

	/** 密码 */
	public static String passworld = null;

	/** 邮件 freemarker 模板路径 */
	public static String templatePath = "/WEB-INF/template/mailTemplate/";

}
