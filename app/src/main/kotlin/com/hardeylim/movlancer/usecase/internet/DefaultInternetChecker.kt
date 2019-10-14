package com.hardeylim.movlancer.usecase.internet

import com.hardeylim.movlancer.usecase.api.InternetCheckerApi
import io.reactivex.Completable
import javax.inject.Inject

class DefaultInternetChecker
@Inject
internal constructor
    (private val internetCheckerApi: InternetCheckerApi) : InternetChecker {
    override fun checkInternet(): Completable {
        return internetCheckerApi.checkGoogle()
    }
}