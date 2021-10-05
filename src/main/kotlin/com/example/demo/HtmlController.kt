package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

@Controller
class HtmlController @Autowired constructor(
    val productRepo: ProductRepo,
    val config: ConfigurationProperties
) {

    @GetMapping("/")
    fun getAllProducts(model: Model): String {
        model["title"] = config.title
        model["productTitle"] = config.productTitle
        model["products"] = productRepo.findAll().mapNotNull { it.render() }
        return "products"
    }
}

private fun Product.render() = RenderProduct(id, name, price, quantity, createdDate.format())

data class RenderProduct(
    val id: Long?,
    val name: String,
    val price: Double,
    val quantity: Float,
    val createdDate: String?
)

private fun LocalDateTime.format(): String? =
    this.format(DateTimeFormatterBuilder().appendPattern("dd-MMM-yyyy").toFormatter())

