package com.example.aroundegypt.data.remote

import com.example.aroundegypt.domain.entity.Data
import com.example.aroundegypt.domain.entity.Experience
import com.example.aroundegypt.domain.entity.ExperienceModel
import retrofit2.Response
import retrofit2.http.GET

interface RecentExperiencesAPI {

    // جلب أحدث التجارب
    @GET("api/v2/experiences")
    suspend fun getRecentExperiences(): Response<List<Data>>
}