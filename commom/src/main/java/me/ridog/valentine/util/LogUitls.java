package me.ridog.valentine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tate on 2016/7/15.
 */
public class LogUitls {

    private static final Logger logger = LoggerFactory.getLogger(LogUitls.class);


    public static void info(Object info){
        if (info instanceof String){
            logger.info("【"+info+"】");
        }else if (info instanceof Integer){
            logger.info("【"+String.valueOf(info)+"】");
        }else if (info instanceof Long){
            logger.info("【"+String.valueOf(info)+"】");
        }else if (info instanceof Date){
            logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(info));
        }

    }

    public static void info(String format, Object... arguments){
        logger.info(format, arguments);
    }



    public static void error(String err){
        logger.error("【"+err+"】");
    }
}
