package com.example.urlshortener.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.entity.URLEntity;
import com.example.urlshortener.repository.URLRepo;

@Service
public class URLService {
@Autowired
private URLRepo urlRepo;

public String createShortURL(String longURL) {
	URLEntity url=new URLEntity();
	url.setLongURLString(longURL);
	url=urlRepo.save(url);
	String shortcodeString=encode(url.getId());
	url.setShortCodeString(shortcodeString);
	urlRepo.save(url);
	return shortcodeString;
	
}

private String encode(Long id) {
	// TODO Auto-generated method stub
	String charString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	StringBuilder sBuilder=new StringBuilder();
	while(id>0) {
		sBuilder.append(charString.charAt((int)(id%62)));
		id=id/62;
	}
	return sBuilder.reverse().toString();
}
public String getLongURL(String code) {
	 return urlRepo.findByShortCodeString(code).map(URLEntity::getLongURLString).orElseThrow(()->new RuntimeException("Long url not found"));
	
}
}
