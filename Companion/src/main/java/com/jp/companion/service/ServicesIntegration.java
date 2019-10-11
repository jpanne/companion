package com.jp.companion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jp.companion.model.Ad;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ServicesIntegration {
	
    @Autowired
	RestTemplate restTemplate;


	
    @HystrixCommand(fallbackMethod = "defaultAds")
    public List<Ad> getAdds() {
    	

        String url = "http://adservice/ads";
        
        ResponseEntity<List<Ad>> response = restTemplate.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Ad>>(){});
       
        List<Ad> adds = response.getBody();
        
       return adds;
    }

    @HystrixCommand(fallbackMethod = "defaultComments",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public void getComments(List<Ad> ads) {
		 String baseUrl = "http://commentService/";
		 
		for(Ad ad:ads) {
	        
			
	        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl+ad.getId(),HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>(){});
	       
	        List<String> comments = response.getBody();
	        ad.setComments(comments);
		}
	}
    
    public List<Ad> defaultAds() {
    	 return new ArrayList<Ad>();
    }
    
    public void defaultComments(List<Ad> ads) {
    	for(Ad ad:ads) {
	        ad.setComments(new ArrayList<String>());
		}
    }
}
