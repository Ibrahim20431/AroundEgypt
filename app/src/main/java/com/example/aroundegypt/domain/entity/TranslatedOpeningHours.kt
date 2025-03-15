package com.example.aroundegypt.domain.entity

data class TranslatedOpeningHours(
    val friday: Friday,
    val monday: Monday,
    val saturday: Saturday,
    val sunday: Sunday,
    val thursday: Thursday,
    val tuesday: Tuesday,
    val wednesday: Wednesday
)