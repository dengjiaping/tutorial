package com.tutorial.yaml;

import java.util.List;

public class WebServiceDescription {
    private String baseUri;
    private String serviceName;
    private List<String> queryParameter;
    private List<String> parameter;
    private String body;

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<String> getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(List<String> queryParameter) {
        this.queryParameter = queryParameter;
    }

    public List<String> getParameter() {
        return parameter;
    }

    public void setParameter(List<String> parameter) {
        this.parameter = parameter;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
