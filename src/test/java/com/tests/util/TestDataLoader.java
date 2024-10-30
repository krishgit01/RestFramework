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
import java.util.stream.Collectors;

public class TestDataLoader {
    private static final Logger logger = LoggerFactory.getLogger("TestDataLoader");

    public static List<TestData> loadTestData(String filePath) {
        InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream(filePath);
        List<TestData> testDataList = new ArrayList<>();

        boolean header = true;
        boolean newCase = false;
        List<String> headerList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String previousTestCaseID = "";
            String currentTestCaseId = "";
            TestData testData = null;

            while ((line = br.readLine()) != null) {
                if (header) {
                    headerList = Arrays.stream(line.split("\\|")).skip(1).map(m1 -> m1.trim()) // Skip the first empty element
                            .collect(Collectors.toList());
                    logger.info("headerList value is : " + headerList);
                    header = false;
                    continue;
                }
                if (line.length() == 0) continue;
                String[] data = Arrays.stream(line.split("\\|")).skip(1).toArray(String[]::new);
                if (data[0].trim().length() > 0) {
                    currentTestCaseId = data[0].trim();
                    newCase = true;
                }
                if (newCase) {
                    if (!previousTestCaseID.isEmpty() && testData != null) {
                        testDataList.add(testData);
                    }
                    testData = new TestData();
                    testData.setTestCaseID(currentTestCaseId);
                    testData.setStepList(new ArrayList<>());
                    previousTestCaseID = currentTestCaseId;
                    newCase = false;
                }


                TestStep testStep = createStepData(headerList, data);
                if (testData != null) {
                    testData.getStepList().add(testStep);
                }
            }
            testDataList.add(testData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (TestData testData : testDataList) {
            logger.info(testData.getTestCaseID());
            for (TestStep s1 : testData.getStepList()) {
                logger.info(s1.toString());
            }
        }
        return testDataList;
    }

    public static TestStep createStepData(List<String> headers, String[] values) {
        TestStep tmpTestStep = new TestStep();
        headers.remove("testCaseId");
        for (String tmpHeader : headers) {
            switch (tmpHeader) {
                case "testStep":
                    tmpTestStep.setStepId(values[1]);
                    break;
                case "testCaseDesc":
                    tmpTestStep.setStepDesc(values[2]);
                    break;
                case "restCall":
                    tmpTestStep.setRestCall(values[3]);
                    break;
                case "header":
                    tmpTestStep.setHeader(values[4]);
                    break;
                case "queryParam":
                    tmpTestStep.setQueryParam(values[5]);
                    break;
                case "pathParam":
                    tmpTestStep.setPathParam(values[6]);
                    break;
                case "reqPayloadFile":
                    tmpTestStep.setRequestPayloadFileName(values[7]);
                    break;
                case "reqPayloadId":
                    tmpTestStep.setRequestPayloadId(values[8]);
                    break;
                case "responsePayload":
                    tmpTestStep.setResponsePayloadFileName(values[9]);
                    break;
                case "responseId":
                    tmpTestStep.setResponseId(values[10]);
                    break;
                case "statusCode":
                    tmpTestStep.setStatusCode(values[11]);
                    break;
                case "expectedResponse":
                    tmpTestStep.setExpectedResponse(values[12]);
                    break;
                case "addParam1":
                    tmpTestStep.setAddParam1(values[13]);
                    break;
                case "addParam2":
                    tmpTestStep.setAddParam2(values[14]);
                    break;
                case "addParam3":
                    tmpTestStep.setAddParam3(values[15]);
                    break;

                default:
                    logger.info("No such Header is present : " + tmpHeader);
                    throw new CustomException("No such header : " + tmpHeader);
            }
        }

        return tmpTestStep;
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

        List<TestData> testDataList = loadTestData(sFilePath);
        String finalSTestcaseId = sTestcaseId;
        List<Object[]> filteredTestData = testDataList.stream().filter(d1 -> d1.getTestCaseID().equalsIgnoreCase(finalSTestcaseId))
                        .map(obj -> new Object[]{obj}).toList();
//        List<Object[]> testCaseList = new ArrayList<>();
//        for (TestData tmpTestData:filteredTestData){
//            testCaseList.add(new Object[]{tmpTestData});
//        }

        return filteredTestData.toArray(new Object[0][]);
    }
}
