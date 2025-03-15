package com.example.aroundegypt.data.remote

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface PostLikesAPI {

    // الإعجاب بتجربة
    @POST("api/v2/experiences/{id}/like")
    suspend fun likeExperience(@Path("id") id: Int): Response<Unit>
}