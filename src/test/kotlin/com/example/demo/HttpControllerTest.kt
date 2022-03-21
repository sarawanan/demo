package com.example.demo

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
internal class HttpControllerTest @Autowired constructor(val mockMvc: MockMvc) {

    @MockBean
    private lateinit var productRepo: ProductRepo

    @Test
    fun `test all products`() {
        val product1 = Product(name = "Rice", price = 10.00, quantity = 100f)
        val product2 = Product(name = "Milk", price = 5.00, quantity = 100f)
        Mockito.`when`(productRepo.findAll()).thenReturn(listOf(product1, product2))
        mockMvc.perform(get("/api/product/").accept(MediaType.APPLICATION_JSON))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.[0].name").value("Rice"))
            .andReturn()
    }

}