package com.jp.companion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.companion.model.Ad;

@RestController
@RefreshScope
public class CompanionService {
	
	private static final Logger log = LoggerFactory.getLogger(CompanionService.class);
	
	@Autowired
	ServicesIntegration integration;
	
    @Value("${sampleString}")
    String sampleString;
	
	@RequestMapping("/posts")
	public List<Ad> getAds() {
		log.info("in companion app get ads and sampleString="+sampleString);
		List<Ad> ads = getAdsFromAdService();
		getComments(ads);
		return ads;
	} 

	private void getComments(List<Ad> ads) {
		 integration.getComments(ads);
		
	}
	
	private List<Ad> getAdsFromAdService() {
		return integration.getAdds();

	}
	

}
