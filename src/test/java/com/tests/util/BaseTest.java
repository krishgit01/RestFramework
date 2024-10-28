package com.tests.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {
        logger.info("I am in setup method");
    }


    @AfterClass
    public void tearDown() {
        logger.info("I am in teardown method");
    }

}
