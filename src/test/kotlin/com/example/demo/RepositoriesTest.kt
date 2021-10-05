package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class RepositoriesTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val productRepo: ProductRepo
) {

    @Test
    fun `test all products`() {
        entityManager.persist(Product(name = "Rice", price = 10.0, quantity = 10.00f))
        entityManager.flush()
        val products = productRepo.findAll();
        assertThat(products).hasSize(1)
        products.forEach { println("${it.id} - ${it.name} - ${it.price} - ${it.quantity} - ${it.createdDate}") }
    }
}