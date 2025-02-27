package com.codesoom.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    @Test
    void creationWithBuilder() {
        Product product = Product.builder()
                .id(1L)
                .name("쥐돌이")
                .maker("냥이월드")
                .price(5000)
                .build();

        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getName()).isEqualTo("쥐돌이");
        assertThat(product.getMaker()).isEqualTo("냥이월드");
        assertThat(product.getPrice()).isEqualTo(5000);
        assertThat(product.getImageUrl()).isNull();
    }

    @Test
    void change() {
        Product product = Product.builder()
                .id(1L)
                .name("쥐돌이")
                .maker("냥이월드")
                .price(5000)
                .build();

        Product updateProduct = Product.builder()
                        .name("쥐순이")
                        .maker("코드숨")
                        .price(10000)
                        .imageUrl("http://localhost:8080/rat")
                        .build();

        product.change(updateProduct);
        assertThat(product.getName()).isEqualTo(updateProduct.getName());
        assertThat(product.getMaker()).isEqualTo(updateProduct.getMaker());
        assertThat(product.getPrice()).isEqualTo(updateProduct.getPrice());
        assertThat(product.getImageUrl()).isEqualTo(updateProduct.getImageUrl());
    }
}
