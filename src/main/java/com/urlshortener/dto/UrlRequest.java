package com.urlshortener.dto;

public class UrlRequest {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UrlRequest{" +
                "url='" + url + '\'' +
                '}';
    }
}
