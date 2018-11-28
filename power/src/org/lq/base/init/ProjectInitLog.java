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
    	log.info("��Ŀ����ʱ��:"+(stopTime-startTime)/1000+" ��.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	startTime = System.currentTimeMillis();//��¼��������ʱ��
    	//ServletRegistration ->һ��servelt������ϸ(������,����ĵ�ַ,��ʼ������.....)
    	//��ȡ��ǰ��Ŀ����Servlet�������ַ
    	Map<String,ServletRegistration> servletMapping =(Map<String, ServletRegistration>) sce.getServletContext().getServletRegistrations();
    	//Class ���ģ��(����)
    	Collection<ServletRegistration> regs = servletMapping.values();
    	Iterator<ServletRegistration> iter= regs.iterator();
    	log.debug("��Ŀ��������������Դ��Ϣ:");
    	while(iter.hasNext()) {
    		ServletRegistration reg = iter.next();
    		log.debug("����:"+reg.getName()+"   �����ַ:"+reg.getMappings().iterator().next());
    	}
    	//���г�ʼ���������ڼ������е���
    	sce.getServletContext().setAttribute("project_name", PropertiesUtil.getValue("projectName"));
    	
    	
    }
	
}
