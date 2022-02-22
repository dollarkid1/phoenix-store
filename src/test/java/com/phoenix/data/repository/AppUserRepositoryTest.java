package com.phoenix.data.repository;

import com.phoenix.data.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "/db/insert.sql")
@Slf4j
class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Create a new User with a cart test")
    void whenNewUserIsCreated_ThenCreateACartTest(){
        //creating a user object
        AppUser appUser = new AppUser();
        appUser.setFirstname("John");
        appUser.setLastname("Lee");
        appUser.setAddress("123 peace road");
        appUser.setEmail("john@email.com");

        //save user
        appUserRepository.save(appUser);
        assertThat(appUser.getId()).isNotNull();
        assertThat(appUser.getMyCart()).isNotNull();

        log.info("App user created :: {}", appUser);
    }
}