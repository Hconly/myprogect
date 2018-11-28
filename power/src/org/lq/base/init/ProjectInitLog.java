package org.lq.base.init;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import org.lq.base.util.PropertiesUtil;

import lombok.extern.log4j.Log4j;

/**
 * Application Lifecycle Listener implementation class ProjectInitLog
 *
 */
@WebListener
@Log4j
public class ProjectInitLog implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ProjectInitLog() {
    }
    private long startTime = 0;
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	long stopTime = System.currentTimeMillis();
    	log.info("项目运行时间:"+(stopTime-startTime)/1000+" 秒.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	startTime = System.currentTimeMillis();//记录服务启动时间
    	//ServletRegistration ->一个servelt的相信细(类名称,请求的地址,初始化参数.....)
    	//获取当前项目所用Servlet的请求地址
    	Map<String,ServletRegistration> servletMapping =(Map<String, ServletRegistration>) sce.getServletContext().getServletRegistrations();
    	//Class 类的模板(反射)
    	Collection<ServletRegistration> regs = servletMapping.values();
    	Iterator<ServletRegistration> iter= regs.iterator();
    	log.debug("项目加载所有请求资源信息:");
    	while(iter.hasNext()) {
    		ServletRegistration reg = iter.next();
    		log.debug("名称:"+reg.getName()+"   请求地址:"+reg.getMappings().iterator().next());
    	}
    	//所有初始化的内容在监听器中调用
    	sce.getServletContext().setAttribute("project_name", PropertiesUtil.getValue("projectName"));
    	
    	
    }
	
}
