package com.example.demo

import org.springframework.data.repository.CrudRepository

interface ProductRepo : CrudRepository<Product, Long>