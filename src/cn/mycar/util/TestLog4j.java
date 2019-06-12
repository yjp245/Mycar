package cn.mycar.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {

	static Logger logger;

    public TestLog4j() {
        logger= Logger.getLogger(TestLog4j.class);
        PropertyConfigurator.configure("D:\\IdeaProjects\\Mycar\\src\\log4j.properties");
    }

    public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("D:\\IdeaProjects\\Mycar\\src\\log4j.properties");
	/*	for (int i = 0; i < 1; i++) {
			logger.trace("跟踪信息");
			logger.debug("调试信息");
			logger.info("输出信息");
			logger.warn("警告信息");
			logger.error("错误信息");
			logger.fatal("致命信息");
		}
*/
	add(123);
	}
    public static void add(int a){
	    logger.info(a);
    }
}
