package com.urlshortener.repository;

import com.urlshortener.model.UrlShortenerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<UrlShortenerModel, Integer> {

}
