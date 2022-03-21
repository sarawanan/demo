package com.example.demo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("online")
@ConstructorBinding
data class ConfigurationProperties(var title: String, var productTitle: String)