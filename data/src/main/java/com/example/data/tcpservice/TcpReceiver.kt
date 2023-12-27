package com.example.data.tcpservice

import com.example.data.LocationDataBase
import com.example.data.dbmodel.LocationDbModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket

class TcpReceiver(private val port: Int, tcpReceiverService: TcpReceiverService) : Runnable {
    private val database = LocationDataBase.getLocationDatabase(tcpReceiverService)
    private val locationDao = database.getDao()
    override fun run() {
        val serverSocket = ServerSocket(port)
        while (true) {

            val clientSocket: Socket = serverSocket.accept()
            val inputStream = clientSocket.getInputStream()
            val reader = InputStreamReader(inputStream)

            val bufferSize = 1024
            val buffer = CharArray(bufferSize)
            val receivedData = StringBuilder()
            var bytesRead: Int = reader.read(buffer, 0, bufferSize)

            while (bytesRead != -1) {
                receivedData.append(buffer, 0, bytesRead)
                bytesRead = reader.read(buffer, 0, bufferSize)
            }

            // Обработать полученные данные (JSON)
            val jsonData = receivedData.toString()
            processReceivedData(jsonData)

            clientSocket.close()
        }
    }

    private fun processReceivedData(jsonData: String) {
        val point = LocationDbModel(
            0,
            JSONObject(jsonData).getJSONObject("point").getDouble("lat"),
            JSONObject(jsonData).getJSONObject("point").getDouble("long")
        )
        CoroutineScope(Dispatchers.Default).launch {
            locationDao.insertLocation(point)
        }

    }
}