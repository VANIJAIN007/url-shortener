package com.example.urlshortener.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.service.URLService;
@RestController
public class URLController {
	@Autowired
	private URLService urlService;	
	@PostMapping("/shorten")
	public String findshortcode(@RequestBody String longurl) {
		String codeBuilder=urlService.createShortURL(longurl);
		return "http://localhost:8082/"+codeBuilder;
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<Void> redirect(@PathVariable String code){
		String longURLString=urlService.getLongURL(code);
		System.out.println("Redirects sections hit");
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURLString)).build();
	}
	
}
