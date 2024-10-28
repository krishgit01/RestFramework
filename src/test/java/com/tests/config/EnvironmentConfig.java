package com.tests.config;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class EnvironmentConfig {
    private static String baseUrl;

    public static void loadEnvironment(String environment) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/main/resources/config/environments.xml");

            NodeList envList = document.getElementsByTagName("environment");
            for (int i = 0; i < envList.getLength(); i++) {
                Element envElement = (Element) envList.item(i);
                String name = envElement.getElementsByTagName("name").item(0).getTextContent();
                if (name.equalsIgnoreCase(environment)) {
                    baseUrl = envElement.getElementsByTagName("url").item(0).getTextContent();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            baseUrl = "http://qa.example.com/api"; // Default to QA
        }
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}

