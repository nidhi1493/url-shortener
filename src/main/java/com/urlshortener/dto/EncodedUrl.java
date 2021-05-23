package com.urlshortener.dto;

public class EncodedUrl {
    private String encodedUrl;
    private String requestUrl;

    public String getEncodedUrl() {
        return encodedUrl;
    }

    public void setEncodedUrl(String encodedUrl) {
        this.encodedUrl = encodedUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString() {
        return "EncodedUrl{" +
                "encodedUrl='" + encodedUrl + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}
