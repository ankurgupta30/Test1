package com.imesomeone.test3;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import static java.net.URLDecoder.decode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class Test3Application {

	public static void main(String[] args) {
		SpringApplication.run(Test3Application.class, args);
		
//		System.out.println("----------------------------------------------");
//		String url = "https://gorest.co.in/public/v1/posts/1362 ";
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<String> httpEntity = new HttpEntity<String>("", new HttpHeaders());
//		try {
//		ResponseEntity<String> response = restTemplate.exchange(url,HttpMethod.GET,httpEntity, String.class);
//		System.out.println("Response:  " + response.getBody());
//		}catch(Exception e) {
//			System.out.println("TEST......................................");
//			e.printStackTrace();
//		}
//		
		RestTemplate rest = new RestTemplate();
		        //new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Content-Type", "application/json");
		    headers.add("Accept", "application/json");
		    HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		    UriComponentsBuilder builder = null;
		    String url = "param1=abc+13%3D";
		    try {
		    	String queryString = "param="+ decode("avc%2Bsdsd%3D", "UTF-8");
		    String encoded = "https://gorest.co.in/public/v1/posts/27&"+ queryString;
		    System.out.println("encoded : " + encoded);
		    //builder = UriComponentsBuilder.fromHttpUrl(encoded);
		    builder = UriComponentsBuilder.fromUriString(encoded);
		          //.queryParam("param1", URLEncoder.encode("abc+123%3D", "UTF-8"));
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    }

		    URI uri = builder.build(true).toUri();
		    System.out.println("URI : " + uri.toString());
		    ResponseEntity<String> responseEntity = rest.exchange(uri.toString(), HttpMethod.GET, requestEntity, String.class);
		    System.out.println("Response Entity:  " + responseEntity.getBody());
		  }
		
	

}
