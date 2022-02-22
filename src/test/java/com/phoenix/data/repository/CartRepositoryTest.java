package com.phoenix.data.repository;

import com.phoenix.data.models.Cart;
import com.phoenix.data.models.Item;
import com.phoenix.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("Add an item to cart test")
    void addProductToCart(){

        Product product = productRepository.findByName("Macbook Air").orElse(null);
        assertThat(product).isNotNull();

        Item item = new Item(product, 2);

//        assertThat()
        Cart cart = new Cart();
        cart.addItem(item);

        cartRepository.save(cart);
        assertThat(cart.getId()).isNotNull();
        assertThat(cart.getItemList().isEmpty()).isFalse();
        assertThat(cart.getItemList().get(0).getProduct()).isNotNull();
        log.info("cart object saved --> {}", cart);

//        Cart cart = Cart.builder().build();


    }


}