package com.example.currencyapp.domain.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
Created by Ahmed Reda on 27/8/23
*/
open class ApiResponse<T>() {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("timestamp")
    @Expose
    var timestamp: Long? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

    @SerializedName("date")
    @Expose
    var date: String? = null

    @SerializedName("rates")
    var data: T? = null

    @SerializedName("error")
    var error: ApiError? = null

    @Transient
    var request: Any? = null

    constructor(success: Boolean, timestamp: Long, base: String, date: String, data: T?, error: ApiError?) : this() {
        this.success = success
        this.timestamp = timestamp
        this.base = base
        this.date = date
        this.data = data
        this.error = error
    }

    data class ApiError(
        @SerializedName("date")
        @Expose
        var code: Int? = null,
        @SerializedName("info")
        @Expose
        var info: String? = null ,
        @SerializedName("type")
        @Expose
        var type: String? = null
    )
}
