package com.example.urlshortener.dto;

import org.hibernate.annotations.processing.Pattern;
import org.springframework.stereotype.Service;

public class URLdto {
	@NotBlank(message="url cannot blank")
	@Pattern(regexp="^(http://|https://).+",
			message="url must start from http ot https"
	)
	public String urlString;

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	
}
