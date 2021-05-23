package com.urlshortener.controller;

import com.urlshortener.dto.EncodedUrl;
import com.urlshortener.dto.UrlRequest;
import com.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url/v1")
public class UrlShortenerController {

    private final UrlShortenerService shortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping("/encode")
    public ResponseEntity<EncodedUrl> encodeUrl(@RequestBody UrlRequest urlRequest) {
        String encodedUrl = shortenerService.encodeUrl(urlRequest.getUrl());

        EncodedUrl response = new EncodedUrl();
        response.setEncodedUrl(encodedUrl);
        response.setRequestUrl(urlRequest.getUrl());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/decode")
    public ResponseEntity<UrlRequest> decodeUrl(@RequestParam(name = "url") String encodedUrl) {
        String decodedUrl = shortenerService.decodeUrl(encodedUrl);
        UrlRequest urlRequest = new UrlRequest();
        urlRequest.setUrl(decodedUrl);
        return ResponseEntity.ok().body(urlRequest);
    }
}
