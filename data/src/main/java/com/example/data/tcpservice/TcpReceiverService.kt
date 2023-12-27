package com.example.data.tcpservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TcpReceiverService: Service() {
    private val port = 1989
    private var tcpReceiver: TcpReceiver? = null
    private var thread: Thread? = null

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        tcpReceiver = TcpReceiver(port, this)
        thread = Thread(tcpReceiver)
        thread?.start()

        return START_STICKY
    }
}