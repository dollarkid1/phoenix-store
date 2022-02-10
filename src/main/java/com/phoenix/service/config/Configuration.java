package com.phoenix.service.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;
    @Value("${cloudinary.api-key}")
    private String apiKey;
    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
   public Cloudinary cloudinary (){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "my_cloud_name",
                "api_key","my_api_key",
                "api_secret", "my_api_secret",
                "secure", true));
    }
}
