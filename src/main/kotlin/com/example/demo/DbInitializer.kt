package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DbInitializer @Autowired constructor(val productRepo: ProductRepo) {

    @Bean
    fun initialize() = ApplicationRunner {
        productRepo.save(Product(name = "Rice", price = 10.00, quantity = 100f))
        productRepo.save(Product(name = "Milk", price = 5.00, quantity = 100f))
    }
}