package com.hardeylim.movlancer.usecase.internet

import io.reactivex.Completable

interface InternetChecker {
    fun checkInternet(): Completable
}