package com.example.domain.usecase

import com.example.domain.repository.TcpServiceRepository

class StopTcpServiceUseCase(private val tcpRepo: TcpServiceRepository) {

    fun stopTcpService() {
        tcpRepo.stopTcpService()
    }
}