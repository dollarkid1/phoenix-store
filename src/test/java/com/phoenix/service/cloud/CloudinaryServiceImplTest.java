package com.phoenix.service.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CloudinaryServiceImplTest {

    @Autowired
    @Qualifier("cloudinary-service")
    CloudService cloudService;

    @Autowired
    Cloudinary cloudinary;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Cloudinary object instantiated test")
    void cloudinaryObjectInstanceTest(){
        assertThat(cloudinary).isNotNull();
    }

    @Test
    void uploadToCloudinaryTest() throws IOException {
        File file  = new File("src/test/resources/Screenshot (321).png");
        assertThat(file).isNotNull();
        Map<?,?> uploadResult = cloudService.upload(file,ObjectUtils.emptyMap());
        log.info("Upload result to cloud --> {}", uploadResult);
        assertThat(uploadResult.get("url")).isNotNull();

    }




}