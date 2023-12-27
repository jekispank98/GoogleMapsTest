package com.example.domain.usecase

import com.example.domain.repository.TcpServiceRepository

class StartTcpServiceUseCase(private val tcpRepo: TcpServiceRepository) {
    fun startGettingJsonFromTcp() {
        tcpRepo.startTcpService()
    }
}