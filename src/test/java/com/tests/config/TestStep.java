package com.tests.config;

public class TestStep {
    public String stepId;
    public String stepDesc;
    public String restCall;
    public String header;
    public String queryParam;
    public String pathParam;
    public String requestPayloadFileName;
    public String requestPayloadId;
    public String responsePayloadFileName;
    public String responseId;
    public String statusCode;
    public String response;
    public String addParam1;
    public String addParam2;
    public String addParam3;
    public String addParam4;
    public String addParam5;

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getRestCall() {
        return restCall;
    }

    public void setRestCall(String restCall) {
        this.restCall = restCall;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getPathParam() {
        return pathParam;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getRequestPayloadFileName() {
        return requestPayloadFileName;
    }

    public void setRequestPayloadFileName(String requestPayloadFileName) {
        this.requestPayloadFileName = requestPayloadFileName;
    }

    public String getRequestPayloadId() {
        return requestPayloadId;
    }

    public void setRequestPayloadId(String requestPayloadId) {
        this.requestPayloadId = requestPayloadId;
    }

    public String getResponsePayloadFileName() {
        return responsePayloadFileName;
    }

    public void setResponsePayloadFileName(String responsePayloadFileName) {
        this.responsePayloadFileName = responsePayloadFileName;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAddParam1() {
        return addParam1;
    }

    public void setAddParam1(String addParam1) {
        this.addParam1 = addParam1;
    }

    public String getAddParam2() {
        return addParam2;
    }

    public void setAddParam2(String addParam2) {
        this.addParam2 = addParam2;
    }

    public String getAddParam3() {
        return addParam3;
    }

    public void setAddParam3(String addParam3) {
        this.addParam3 = addParam3;
    }

    public String getAddParam4() {
        return addParam4;
    }

    public void setAddParam4(String addParam4) {
        this.addParam4 = addParam4;
    }

    public String getAddParam5() {
        return addParam5;
    }

    public void setAddParam5(String addParam5) {
        this.addParam5 = addParam5;
    }

    @Override
    public String toString() {
        return "TestStep{" +
                "stepId='" + stepId + '\'' +
                ", stepDesc='" + stepDesc + '\'' +
                ", restCall='" + restCall + '\'' +
                ", header='" + header + '\'' +
                ", queryParam='" + queryParam + '\'' +
                ", pathParam='" + pathParam + '\'' +
                ", requestPayloadFileName='" + requestPayloadFileName + '\'' +
                ", requestPayloadId='" + requestPayloadId + '\'' +
                ", responsePayloadFileName='" + responsePayloadFileName + '\'' +
                ", responseId='" + responseId + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", response='" + response + '\'' +
                ", addParam1='" + addParam1 + '\'' +
                ", addParam2='" + addParam2 + '\'' +
                ", addParam3='" + addParam3 + '\'' +
                ", addParam4='" + addParam4 + '\'' +
                ", addParam5='" + addParam5 + '\'' +
                '}';
    }
}
