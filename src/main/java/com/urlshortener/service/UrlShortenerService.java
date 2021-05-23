package com.urlshortener.service;

import com.urlshortener.model.UrlShortenerModel;
import com.urlshortener.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UrlShortenerService {
    private static final char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final String baseUrl = "https://my-base-url.com/";
    private final UrlShortenerRepository repository;
    private final Map<String, Integer> urlMap = new HashMap<>();
    private final AtomicInteger shortUrlId = new AtomicInteger(0);

    @Autowired
    public UrlShortenerService(UrlShortenerRepository repository) {
        this.repository = repository;
    }

    private String convertToShortUrl(int n) {

        StringBuffer shortUrl = new StringBuffer();
        while (n > 0) {
            shortUrl.append(map[n % 62]);
            n = n / 62;
        }
        return shortUrl.reverse().toString();
    }

    public String encodeUrl(String url) {
        int id = shortUrlId.incrementAndGet();
        String encodedUrl = convertToShortUrl(id);
        urlMap.put(encodedUrl, id);

        final UrlShortenerModel model = new UrlShortenerModel();
        model.setShortUrlId(id);
        model.setShortUrl(encodedUrl);
        model.setLongUrl(url);
        model.setCreated_at(System.currentTimeMillis());
        repository.save(model);

        return baseUrl + encodedUrl;
    }

    public String decodeUrl(String encodedUrl) {
        String lookupUrl = encodedUrl.split("/")[3];
        UrlShortenerModel model = repository.getById(urlMap.get(lookupUrl));
        return model.getLongUrl();
    }
}
