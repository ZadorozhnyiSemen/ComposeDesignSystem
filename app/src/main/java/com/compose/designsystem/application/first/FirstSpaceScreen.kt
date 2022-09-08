package com.compose.designsystem.application.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.designsystem.application.first.data.TransactionRepository
import com.compose.designsystem.application.first.domain.Transaction
import com.compose.designsystem.application.first.domain.TransactionType
import com.compose.designsystem.space.atoms.Divider
import com.compose.designsystem.space.atoms.NavTab
import com.compose.designsystem.space.atoms.Tab
import com.compose.designsystem.space.atoms.Text
import com.compose.designsystem.space.molecules.NavBar
import com.compose.designsystem.space.molecules.Tabs
import com.compose.designsystem.space.theme.*

data class NavTabItem(
    val id: Int,
    val icon: @Composable () -> Unit,
    val text: String,
)

private val navItems = listOf<NavTabItem>(
    NavTabItem(
        1,
        { SpaceIcons.IcHome(contentDescription = null) },
        "Home"
    ),
    NavTabItem(
        2,
        { SpaceIcons.IcCardTravel(contentDescription = null) },
        "Shop"
    ),
    NavTabItem(
        3,
        { SpaceIcons.IcLibraryBooks(contentDescription = null) },
        "History"
    ),
    NavTabItem(
        4,
        { SpaceIcons.IcPerson(contentDescription = null) },
        "Account"
    ),
)

@Composable
fun FirstSpaceScreen() {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    val transaction by derivedStateOf {
        when (selectedTab) {
            0 -> { TransactionRepository.getAllTransactions() }
            1 -> { TransactionRepository.getSales() }
            else -> { TransactionRepository.getFunds() }
        }
    }

    var selectedNavTab by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.background(SpaceTheme.colors.shadesWhite)) {
        Box(modifier = Modifier.weight(1f)) {
            ScreenContent(
                transactions = transaction,
                selectedTab = selectedTab,
                onTabChanged = { newTabIndex -> selectedTab = newTabIndex }
            )
        }
        Box {
            NavBar(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                NavTab(
                    text = navItems[0].text,
                    icon = navItems[0].icon,
                    onClick = { selectedNavTab = 0 },
                    selected = selectedNavTab == 0,
                )
                NavTab(
                    text = navItems[1].text,
                    icon = navItems[1].icon,
                    onClick = { selectedNavTab = 1 },
                    selected = selectedNavTab == 1,
                )
                NavTab(
                    text = navItems[2].text,
                    icon = navItems[2].icon,
                    onClick = { selectedNavTab = 2 },
                    selected = selectedNavTab == 2,
                )
                NavTab(
                    text = navItems[3].text,
                    icon = navItems[3].icon,
                    onClick = { selectedNavTab = 3 },
                    selected = selectedNavTab == 3,
                )
            }
        }
    }
}

@Composable
fun ScreenContent(
    transactions: List<Transaction>,
    onTabChanged: (Int) -> Unit,
    selectedTab: Int
) {

    Column {
        Text(
            text = "History",
            modifier = Modifier.padding(
                top = 32.dp,
                start = 16.dp,
                end = 16.dp,
            ),
            style = SpaceTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Tabs(modifier = Modifier.padding(horizontal = 16.dp)) {
            Tab(text = "All", selected = selectedTab == 0, onClick = { onTabChanged(0) })
            Tab(text = "Purchases", selected = selectedTab == 1, onClick = { onTabChanged(1)})
            Tab(text = "Funding", selected = selectedTab == 2, onClick = { onTabChanged(2)})
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            itemsIndexed(transactions) { index, item ->
                TransactionItem(
                    transaction = item,
                    isGrayBackground = index % 2 != 0
                )
            }
        }
    }
}

@Composable
private fun TransactionItem(
    transaction: Transaction,
    isGrayBackground: Boolean
) {
    val icon: @Composable () -> Unit = when (transaction.transactionType) {
        TransactionType.Fund -> {
            { SpaceIcons.IcPerson(contentDescription = null) }
        }
        TransactionType.Sale -> {
            { SpaceIcons.IcCreditCard(contentDescription = null) }
        }
    }

    val text = when (transaction.transactionType) {
        TransactionType.Fund -> "Fund"
        TransactionType.Sale -> "Sale"
    }

    Column {
        Row(
            modifier = Modifier
                .background(
                    if (isGrayBackground) SpaceTheme.colors.neutral_1 else SpaceTheme.colors.shadesWhite
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon()
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                style = SpaceTheme.typography.h4.copy(
                    fontWeight = FontWeight.Normal,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "\$${transaction.amount}",
                style = SpaceTheme.typography.h4.copy(
                    fontWeight = FontWeight.Normal,
                )
            )
        }
        Divider(
            color = SpaceTheme.colors.neutral_3,
            thickness = 1.dp,
        )
    }

}