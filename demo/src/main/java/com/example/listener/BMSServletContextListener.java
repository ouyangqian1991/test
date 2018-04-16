package com.example.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;

/**
 * 服务器监听器
 * @author ouyq
 *
 * @date 2017年8月8日 下午2:01:04
 */
@WebListener
public class BMSServletContextListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(BMSServletContextListener.class);
	@Autowired
	private UserService userService;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("服务器启动中");
		User findById = userService.findById("1");
		System.out.println("findById:"+findById);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	

}
