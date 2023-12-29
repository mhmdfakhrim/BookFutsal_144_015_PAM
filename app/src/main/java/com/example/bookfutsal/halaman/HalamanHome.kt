package com.example.bookfutsal.halaman

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookfutsal.R
import com.example.bookfutsal.data.home.HomeViewModel
import com.example.bookfutsal.komponen.AppToolbar
import com.example.bookfutsal.komponen.NavigationDrawerBody
import com.example.bookfutsal.komponen.NavigationDrawerHeader
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman
import kotlinx.coroutines.launch

@Composable
fun HalamanHome(
    homeViewModel: HomeViewModel = viewModel(),

     ) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(
                toolbarTitle = stringResource(id = R.string.home),
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
            NavigationDrawerBody(
                navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere", "inside_NavigationItemClicked")
                    Log.d("ComingHere", "${it.itemId} ${it.title}")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanPemesanan) }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Order")
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Gambar lapangan futsal
                Image(
                    painter = painterResource(id = R.drawable.lapangan_futsal),
                    contentDescription = "Futsal field image",
                    modifier = Modifier.size(400.dp)
                )
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanLihatPemesanan) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,
                        contentColor = Color.White
                    )
                )
                {
                    Text("Lihat Pesanan")

                }
            }
            }

    }
}


