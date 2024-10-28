package com.tests.config;


import java.util.HashMap;
import java.util.Map;

public class RestAPIData {
    private Map<String, String> headerMap = new HashMap<>();
    private Map<String, String> queryParamMap = new HashMap<>();
    private String pathParam;
    private String baseURI;
    private String jsonBody;
    private String restOperation;
    private String proxyUserName;
    private String proxyPassword;
    private String proxyHost;
    private int proxyPort;
    private boolean proxySwitch;

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public boolean isProxySwitch() {
        return proxySwitch;
    }

    public void setProxySwitch(boolean proxySwitch) {
        this.proxySwitch = proxySwitch;
    }

    public String getProxyUserName() {
        return proxyUserName;
    }

    public void setProxyUserName(String proxyUserName) {
        this.proxyUserName = proxyUserName;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }


    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    public Map<String, String> getQueryParamMap() {
        return queryParamMap;
    }

    public void setQueryParamMap(Map<String, String> queryParamMap) {
        this.queryParamMap = queryParamMap;
    }

    public String getPathParam() {
        return pathParam;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    public String getRestOperation() {
        return restOperation;
    }

    public void setRestOperation(String restOperation) {
        this.restOperation = restOperation;
    }
}
