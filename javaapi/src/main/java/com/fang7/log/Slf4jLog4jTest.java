package com.fang7.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLog4jTest {
    private static Logger logger = LoggerFactory.getLogger(Slf4jLog4jTest.class);
    public static void main(String[] args) {
        logger.debug("123");
        logger.info("321");
        logger.warn("wwww");
        logger.error("error ");
    }
}
