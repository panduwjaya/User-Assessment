package com.example.userassessment.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.userassessment.ui.util.MenuCard
import com.example.userassessment.ui.util.MenuItem
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.userassessment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier,
    onMenuClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1EB6FF)
                )
            )
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.End
            ) {
                FloatingActionButton(
                    onClick = onLogoutClick,
                    containerColor = Color.White,
                    contentColor = Color(0xFF1EB6FF)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_exit),
                        contentDescription = "Add Order"
                    )
                }
            }
        }
    ) { scaffoldPadding ->

        val menus = listOf(
            MenuItem("Admin", Icons.Default.Person),
            MenuItem("Finder", Icons.Default.Search),
            MenuItem("Record", Icons.Default.Refresh),
            MenuItem("Lab", Icons.Default.Place),
            MenuItem("Settings", Icons.Default.Settings)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxSize()
                .padding(scaffoldPadding) // ✅ WAJIB
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(menus) { menu ->
                MenuCard(
                    title = menu.title,
                    icon = menu.icon,
                    onClick = { onMenuClick(menu.title) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContentPreview() {
    HomeScreenContent(
        onLogoutClick = {},
        onMenuClick = {}
    )
}