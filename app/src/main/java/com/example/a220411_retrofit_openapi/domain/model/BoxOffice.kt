package com.example.a220411_retrofit_openapi.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("boxOfficeResult")
    @Expose
    val boxOfficeResult: BoxOfficeResult,
)


data class BoxOfficeResult(
    @SerializedName("boxofficeType")
    @Expose
    val boxofficeType: String,
    @SerializedName("showRange")
    @Expose
    val showRange: String,
    @SerializedName("dailyBoxOfficeList")
    @Expose
    val List_dailyBoxOffice: ArrayList<Movie>,
)

data class Movie(
    @SerializedName("rnum")
    @Expose
    val rnum: String? = null,
    @SerializedName("movieNm")
    @Expose
    val movieNm: String? = null,
    @SerializedName("openDt")
    @Expose
    val openDt: String? = null,
)




