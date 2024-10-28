package com.tests.config;

import java.util.List;

public class TestData {
    String testCaseID;
    List<TestStep> stepList ;
    RestAPIData restAPIData ;

    public String getTestCaseID() {
        return testCaseID;
    }

    public void setTestCaseID(String testCaseID) {
        this.testCaseID = testCaseID;
    }

    public List<TestStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<TestStep> stepList) {
        this.stepList = stepList;
    }

    public RestAPIData getRestAPIData() {
        return restAPIData;
    }

    public void setRestAPIData(RestAPIData restAPIData) {
        this.restAPIData = restAPIData;
    }
}
