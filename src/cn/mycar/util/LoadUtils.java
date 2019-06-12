package cn.mycar.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LoadUtils implements ApplicationContextAware  {

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		LoadUtils.context = arg0;
		System.out.println("load success!");
		//Tcp t= new Tcp();
	}
	  
    public static Object getSpringBean(String beanName) {  
        return context==null?null:context.getBean(beanName);  
    }  
  
    public static String[] getBeanDefinitionNames() {  
        return context.getBeanDefinitionNames();  
    }  
	
	

}
