package util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanContextFactory {

	private static 	ApplicationContext context = new ClassPathXmlApplicationContext(
	        new String[] {"SpringBeanContext.xml"});
	
	static private BeanFactory loadXmlBeanResources(){
		BeanFactory factory = context;
		return factory;
	}
	
}
