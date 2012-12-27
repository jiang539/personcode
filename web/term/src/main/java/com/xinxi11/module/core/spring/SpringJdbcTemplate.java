package com.xinxi11.module.core.spring;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
* SpringJdbcTemplate静态调用类
*
* @author 李国江
* @date 2011-8-25
*/
public class SpringJdbcTemplate {

	private static JdbcTemplate jdbcTemplate = null;
	private static NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	public static JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			DataSource dataSource = SpringContextHolder.getBean("dataSource");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		if (namedParameterJdbcTemplate == null) {
			namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());
		}
		return namedParameterJdbcTemplate;
	}

}
