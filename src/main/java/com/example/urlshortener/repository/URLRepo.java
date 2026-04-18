package com.example.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.urlshortener.entity.URLEntity;

public interface URLRepo extends JpaRepository<URLEntity, Long>{
	Optional<URLEntity> findByShortCodeString(String shortString);
}