package com.example.aroundegypt.data.remote

import com.example.aroundegypt.domain.entity.Experience
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExperiencesDetailsAPI {

    // جلب تجربة واحدة بالتفاصيل
    @GET("api/v2/experiences/{id}")
    suspend fun getSingleExperience(@Path("id") id: Int): Response<Experience>
}