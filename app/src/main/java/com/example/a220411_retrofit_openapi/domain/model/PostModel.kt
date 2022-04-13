package com.example.a220411_retrofit_openapi.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostModel(
    @Expose
    @SerializedName("id")
    var id: String? = null,
    @Expose
    @SerializedName("pwd")
    var pwd: String? = null,
    @Expose
    @SerializedName("nick")
    var nick: String? = null,
)