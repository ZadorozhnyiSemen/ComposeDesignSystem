package com.compose.designsystem.application.first.data

import com.compose.designsystem.application.first.domain.Transaction
import com.compose.designsystem.application.first.domain.TransactionType

private val transactionList: List<Transaction> = listOf(
    Transaction(TransactionType.Sale, 1.99),
    Transaction(TransactionType.Sale, 5.48),
    Transaction(TransactionType.Fund, 10.00),
    Transaction(TransactionType.Sale, 2.99),
    Transaction(TransactionType.Sale, 6.48),
    Transaction(TransactionType.Sale, 0.49),
    Transaction(TransactionType.Sale, 1.99),
    Transaction(TransactionType.Fund, 20.00),
)

object TransactionRepository {

    fun getAllTransactions(): List<Transaction> = transactionList

    fun getSales(): List<Transaction> =
        transactionList.filter { it.transactionType is TransactionType.Sale }

    fun getFunds(): List<Transaction> =
        transactionList.filter { it.transactionType is TransactionType.Fund }
}