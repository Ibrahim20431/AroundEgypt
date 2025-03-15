package com.example.aroundegypt.data.remote

import com.example.aroundegypt.domain.entity.Data
import com.example.aroundegypt.domain.entity.Experience
import com.example.aroundegypt.domain.entity.ExperienceModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RecommendedExperiencesAPI {

    @GET("api/v2/experiences")
    suspend fun getRecommendedExperiences(@QueryMap filters: Map<String, Int>): Response<List<Data>>

}