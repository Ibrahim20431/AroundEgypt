package com.example.aroundegypt.data.remote

import com.example.aroundegypt.domain.entity.Experience
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SearchExperiencesAPI {

    // البحث عن تجربة معينة
    @GET("api/v2/experiences")
    suspend fun searchExperiences(@QueryMap filters: Map<String, String>): Response<List<Experience>>
}