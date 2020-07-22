package com.patronusstudio.sisecevirmece.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkConnection
    (val mContext: Context) {

    fun isConnected(): Boolean {
        val cm: ConnectivityManager =
            mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo: NetworkInfo = cm.activeNetworkInfo
        if (netInfo != null && netInfo.isConnectedOrConnecting) {
            return true
        }
        return false
    }

}