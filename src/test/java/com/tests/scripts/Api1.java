package com.tests.scripts;

import com.tests.config.TestCaseId;
import com.tests.config.TestData;
import com.tests.config.TestDataFileName;
import com.tests.util.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Api1 extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Api1.class);

    @TestCaseId("TC001")
    @TestDataFileName( "src/test/resources/testdata/testdata.txt")
    @Test(dataProvider = "TestData" ,dataProviderClass = com.tests.util.TestDataLoader.class)
    public void TestApi1(TestData testData){
        logger.info("i am in TestApi1 class");

    }
}
