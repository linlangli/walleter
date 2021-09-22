package com.linlangli.walleter.net

import androidx.lifecycle.MutableLiveData
import com.linlangli.walleter.model.Bill
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val SERVER_URL = "https://wanandroid.com/"
    }

}