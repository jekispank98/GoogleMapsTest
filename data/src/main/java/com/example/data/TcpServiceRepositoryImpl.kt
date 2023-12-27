package com.example.data

import android.content.Context
import android.content.Intent
import com.example.data.tcpservice.TcpReceiverService
import com.example.domain.repository.TcpServiceRepository

class TcpServiceRepositoryImpl(private val context: Context): TcpServiceRepository {

    override fun startTcpService() {
        val tcpService = Intent(context, TcpReceiverService::class.java)
        context.startService(tcpService)
    }

    override fun stopTcpService() {
        val tcpService = Intent(context, TcpReceiverService::class.java)
        context.stopService(tcpService)
    }
}