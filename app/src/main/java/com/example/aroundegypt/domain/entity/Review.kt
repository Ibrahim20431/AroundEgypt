package com.example.aroundegypt.domain.entity

data class Review(
    val comment: String,
    val created_at: String,
    val experience: String,
    val id: String,
    val name: String,
    val rating: Int
)