package com.compose.designsystem.application.first.domain

data class Transaction(
    val transactionType: TransactionType,
    val amount: Double,
)
