package com.example.aroundegypt.domain.entity

data class Experience(
    val address: String = "",
    val audio_url: String = "",
    val city: String = "",
    val cover_photo: String = "",
    val description: String = "",
    val detailed_description: String = "",
    val era: String = "",
    val experience_tips: List<Any>? = null,
    val famous_figure: String = "",
    val founded: String = "",
    val gmap_location: String = "",
    val has_audio: Boolean = false,
    val has_video: Int = 0,
    val id: String,
    val is_liked: Boolean,
    val likes_no: Int,
    val opening_hours: String = "",
    val period: String = "",
    val rating: Int = 0,
    val recommended: Int = 0,
    val reviews: List<Review>? = null,
    val reviews_no: Int = 0,
    val starting_price: Int = 0,
    val tags: List<Tag>? = null,
    val ticket_prices: List<TicketPrice>? = null,
    val title: String,
    val tour_html: String = "",
    val translated_opening_hours: String  = "",
    val views_no: Int
)

//data class Experience(
//    val id: String,
//    val title: String,
//    val description: String,
//    val is_liked: Boolean,
//    val imageUrl: String,
//    val likes_no: Int,
//)

//data class ApiResponse(
//    val data: List<Experience>
//)