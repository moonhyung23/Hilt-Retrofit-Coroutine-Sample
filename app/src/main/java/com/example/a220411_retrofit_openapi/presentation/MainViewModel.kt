package com.example.a220411_retrofit_openapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a220411_retrofit_openapi.domain.model.Movie
import com.example.a220411_retrofit_openapi.domain.model.PostModel
import com.example.a220411_retrofit_openapi.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject internal constructor(private val repository: MainRepository) :
    ViewModel() {
    //LiveData
    var Live_BoxOffice = MutableLiveData<ArrayList<Movie>>()

    //ArrayList
    var List_DailyBoxOffice = ArrayList<Movie>()

    init {
        loadBoxOfficeData()
    }

    private fun loadBoxOfficeData() {
        //코루틴으로 Retrofit 통신을 진행
        viewModelScope.launch {
            //Retrofit으로 데이터 요청
            val result = repository.boxOfficeApi("20200319")
            List_DailyBoxOffice = result.data?.boxOfficeResult?.List_dailyBoxOffice!!
            Live_BoxOffice.value = List_DailyBoxOffice

            /* when (response.isSuccessful) {
                 //응답 성공
                 true -> {

                 }
                 //응답 실패
                 else -> {
                     Timber.e("TEST -> ${response.body()}")
                 }
             }*/
        }
    }


}