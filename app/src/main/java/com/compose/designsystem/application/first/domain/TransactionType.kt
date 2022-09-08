package com.compose.designsystem.application.first.domain

sealed interface TransactionType {
    object Fund : TransactionType
    object Sale : TransactionType
}