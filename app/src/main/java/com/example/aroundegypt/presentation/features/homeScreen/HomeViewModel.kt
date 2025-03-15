package com.example.aroundegypt.presentation.features.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aroundegypt.data.remote.RetrofitInstance
import com.example.aroundegypt.domain.entity.Data
import com.example.aroundegypt.domain.entity.Experience
import com.example.aroundegypt.domain.entity.ExperienceModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

//    private val searchExperiencesAPI = RetrofitInstance.searchExperiencesAPI
    private val recommendedExperiencesAPI = RetrofitInstance.recommendedExperiencesAPI
    private val recentExperiencesAPI = RetrofitInstance.recentExperiencesAPI
//    private val experiencesDetailsAPI = RetrofitInstance.experiencesDetailsAPI

    private val _recommendedExperiences = MutableStateFlow<List<Data>>(emptyList())
    val recommendedExperiences: StateFlow<List<Data>> = _recommendedExperiences

    private val _recentExperiences = MutableStateFlow<List<Data>>(emptyList())
    val recentExperiences: StateFlow<List<Data>> = _recentExperiences

//    private val _experiencesDetails = MutableStateFlow<Experience?>(null)
//    val experiencesDetails: StateFlow<Experience?> = _experiencesDetails


    fun getRecomendedExperiences(){
        viewModelScope.launch {
            val filters = mapOf("filter[recommended]" to 1)
//            val response = recommendedExperiencesAPI.getRecommendedExperiences(filters)
//            if (response.isSuccessful) {
//                _recommendedExperiences.value = (response.body() ?: emptyList())
//            } else {
//                println("Error: ${response.errorBody()?.string()}")
//            }
            try {
                val data = recommendedExperiencesAPI.getRecommendedExperiences(filters)
                _recommendedExperiences.value = (data.body() ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getRecentExperiences(){
        viewModelScope.launch {
            val response = recentExperiencesAPI.getRecentExperiences()
            if (response.isSuccessful) {
                _recentExperiences.value = (response.body() ?: emptyList())
            } else {
                println("Error: ${response.errorBody()?.string()}")
            }
        }
    }

//    fun searchExperiences(searchText : String){
//        viewModelScope.launch {
//            val filters = mapOf("filter[title]" to searchText)
//            val response = searchExperiencesAPI.searchExperiences(filters)
//
//            if (response.isSuccessful) {
//                val experiences = response.body()
//                println("✅ Search Results: $experiences")
//            } else {
//                println("Error: ${response.errorBody()?.string()}")
//            }
//        }
//    }
}