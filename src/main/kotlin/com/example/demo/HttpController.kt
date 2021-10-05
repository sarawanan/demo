package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class HttpController @Autowired constructor(val productRepo: ProductRepo) {
    @GetMapping("/")
    fun getAllProducts() = productRepo.findAll()
}