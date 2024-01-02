package com.example.domain.services

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkService(context: Context) {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun isNetworkAvailable(): Boolean {
        val result: Boolean
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetWork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            else -> false
        }
        return result
    }

    fun networkMonitoring(): Flow<Boolean> = callbackFlow {
        val networkCallback = object : NetworkCallback() {
            override fun onAvailable(network: Network) {
                val activeNetwork = connectivityManager.getNetworkCapabilities(network)
                val result = when {
                    activeNetwork?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ?: false ||
                            activeNetwork?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ?: false -> true

                    else -> false
                }
                trySend(result)
            }

            override fun onLost(network: Network) {
                trySend(false)
            }
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
        awaitClose { connectivityManager.unregisterNetworkCallback(networkCallback) }
    }

}