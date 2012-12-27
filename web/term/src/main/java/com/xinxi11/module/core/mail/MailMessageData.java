package com.xinxi11.module.core.mail;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邮件的基本内容信息
 */
public class MailMessageData {

	/** freemarker模板数据 */
	private Map<String, Object> templateData;
	/** 模板文件名,必须在classpath下的mailTemplate文件夹中 */
	private String templateName;
	/** 默认发件人 */
	private String from = "系统管理员";
	/** 收件人 */
	private String[] to;
	/** 邮件主题 */
	private String subject;
	/** 邮件内容 */
	private String content;
	/** 邮件附件 */
	private File[] attachment;

	private boolean isDeleteFile = false;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Map<String, Object> getTemplateData() {
		return templateData;
	}

	public void addTemplateData(String name, Object value) {
		if (templateData == null) {
			templateData = new HashMap<String, Object>();
		}
		templateData.put(name, value);
	}

	public void setTemplateData(Map<String, Object> templateData) {
		this.templateData = templateData;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	/** 邮件地址以','为分割 */
	public void setTo(String to) {
		this.to = to.split(",");
	}

	public void setTo(List<String> to) {
		if (to != null && to.size() > 0) {
			this.to = to.toArray(new String[to.size()]);
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public File[] getAttachment() {
		return attachment;
	}

	public void setAttachment(File[] attachment) {
		this.attachment = attachment;
	}

	public void send() {
		if (MailProperties.isSendMail) {
			EmailUtils.sendMail(this);
		}
	}

	public boolean isDeleteFile() {
		return isDeleteFile;
	}

	public void setDeleteFile(boolean isDeleteFile) {
		this.isDeleteFile = isDeleteFile;
	}

}
