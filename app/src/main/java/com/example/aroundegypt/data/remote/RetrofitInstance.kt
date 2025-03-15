package com.example.aroundegypt.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val baseUrl = "https://aroundegypt.34ml.com/"

    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val recentExperiencesAPI : RecentExperiencesAPI = getInstance().create(RecentExperiencesAPI::class.java)
    val recommendedExperiencesAPI : RecommendedExperiencesAPI = getInstance().create(RecommendedExperiencesAPI::class.java)
    val searchExperiencesAPI : SearchExperiencesAPI = getInstance().create(SearchExperiencesAPI::class.java)
    val experiencesDetailsAPI : ExperiencesDetailsAPI = getInstance().create(ExperiencesDetailsAPI::class.java)
    val getLikesAPI : PostLikesAPI = getInstance().create(PostLikesAPI::class.java)
}