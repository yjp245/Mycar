package cn.mycar.pojo;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


public class Log4 {
   private Logger logger;
    public Log4(Class classObject) {
        logger= Logger.getLogger(classObject);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void info(String s){
        logger.info(s);
    }
    public void info(int s){
        logger.info(s);
    }
    public void info(float s){
        logger.info(s);
    }
}
