package com.tests.util;

import com.tests.config.TestCaseId;
import com.tests.config.TestData;
import com.tests.config.TestDataFileName;
import com.tests.config.TestStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataLoader {
    private static final Logger logger = LoggerFactory.getLogger("TestDataLoader");

    public static List<TestData> loadTestData(String filePath) {
        InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream(filePath);
        List<TestData> testDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = null;
            boolean isHeader = true;
            TestData currentTestData = null;
            List<TestStep> testStepList = null;

            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                if (values.length == 0) continue;

                // If new test case ID, create a new TestData object
                String testCaseId = values[0].trim();
                if (!testCaseId.isEmpty()) {
                    currentTestData = new TestData();
                    testStepList = new ArrayList<>();
                    currentTestData.setTestCaseID(testCaseId);
                    testDataList.add(currentTestData);
                }

                if (currentTestData != null) {
                    TestStep testStep = createStepData(values, headers);
                    testStepList.add(testStep);
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new TestData());
    }

    public static TestStep createStepData(String[] values, String[] headers) {
        return new TestStep();
    }

    @DataProvider(name = "TestData")
    public Object[][] testData(Method method) {
        String sTestcaseId = null;
        String sFilePath = null;
        Annotation[] annotations = method.getDeclaredAnnotations();
        Annotation testDataFileName = Arrays.stream(annotations).filter(a1 -> (a1 instanceof TestDataFileName)).findFirst().orElse(null);
        Annotation testCaseId = Arrays.stream(annotations).filter(a1 -> (a1 instanceof TestCaseId)).findFirst().orElse(null);
        if (testDataFileName != null) {
            sFilePath = ((TestDataFileName) testDataFileName).value();
            logger.info("sFilePath value is :" + sFilePath);
        }
        if (testCaseId != null) {
            sTestcaseId = ((TestCaseId) testCaseId).value();
            logger.info("testCaseId value is :" + sTestcaseId);
        } else {
            //default value to provided
        }
        loadTestData(sFilePath);
        return new Object[][]{
                {new TestData()},
                {new TestData()}
        };
    }
}
