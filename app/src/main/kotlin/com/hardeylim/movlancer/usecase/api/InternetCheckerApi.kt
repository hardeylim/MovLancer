package com.hardeylim.movlancer.usecase.api

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Url

interface InternetCheckerApi {
    @GET("")
    fun checkGoogle(@Url url: String = ""): Completable
}

