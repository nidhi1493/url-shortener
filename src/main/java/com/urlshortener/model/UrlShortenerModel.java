package com.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class UrlShortenerModel {

    private String shortUrl;

    private String longUrl;

    private long created_at;

    @Id
    private int shortUrlId;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public int getShortUrlId() {
        return shortUrlId;
    }

    public void setShortUrlId(int shortUrlId) {
        this.shortUrlId = shortUrlId;
    }
}
