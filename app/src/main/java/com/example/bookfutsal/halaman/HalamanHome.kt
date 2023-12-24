package com.example.bookfutsal.halaman

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookfutsal.R
import com.example.bookfutsal.data.home.HomeViewModel
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookfutsal.komponen.AppToolbar
import com.example.bookfutsal.komponen.NavigationDrawerBody
import com.example.bookfutsal.komponen.NavigationDrawerHeader
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel = HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {


            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}