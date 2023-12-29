package com.example.bookfutsal.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bookfutsal.R
import com.example.bookfutsal.data.biodata.DataPemesanan
import com.example.bookfutsal.data.biodata.DataPemesananViewModel
import com.example.bookfutsal.komponen.HeadingTextComponent
import com.example.bookfutsal.komponen.MyTextAlamatFieldComponent
import com.example.bookfutsal.komponen.MyTextIdPemesananFieldComponent
import com.example.bookfutsal.komponen.MyTextJamFieldComponent
import com.example.bookfutsal.komponen.MyTextLapanganFieldComponent
import com.example.bookfutsal.komponen.MyTextNameFieldComponent
import com.example.bookfutsal.komponen.MyTextTelponFieldComponent
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman
import com.example.bookfutsal.navigation.SystemBackButtonHandler

@Composable
fun HalamanPemesanan(
    dataPemesananViewModel: DataPemesananViewModel

) {
    var pemesananID: String by remember { mutableStateOf("") }
    var nama: String by remember { mutableStateOf("") }
    var alamat: String by remember { mutableStateOf("") }
    var telpon: Int by remember { mutableIntStateOf(0) }
    var jam: Int by remember { mutableIntStateOf(0) }
    var lapangan: Int by remember { mutableIntStateOf(0) }

    val context = LocalContext.current



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                HeadingTextComponent(value = stringResource(id = R.string.isi_biodata))

                Spacer(modifier = Modifier.height(20.dp))

                MyTextIdPemesananFieldComponent(
                    labelValue = stringResource(id = R.string.id_pemesanan),
                    painterResource(id = R.drawable.baseline_person_2_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextNameFieldComponent(
                    labelValue = stringResource(id = R.string.nama),
                    painterResource(id = R.drawable.baseline_person_2_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextAlamatFieldComponent(
                    labelValue = stringResource(id = R.string.alamat),
                    painterResource(id = R.drawable.baseline_place_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextTelponFieldComponent(
                    labelValue = stringResource(id = R.string.telpon),
                    painterResource(id = R.drawable.baseline_call_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextLapanganFieldComponent(
                    labelValue = stringResource(id = R.string.pilih_lapangan),
                    painterResource(id = R.drawable.baseline_access_time_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextJamFieldComponent(
                    labelValue = stringResource(id = R.string.jumlah_jam),
                    painterResource(id = R.drawable.baseline_access_time_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .fillMaxWidth(),
                    onClick = {
                        val dataPemesanan = DataPemesanan(
                            pemesananID = pemesananID,
                            nama = nama,
                            alamat = alamat,
                            telpon = telpon,
                            lapangan = lapangan,
                            jam = jam
                        )

                        dataPemesananViewModel.saveData(dataPemesanan = dataPemesanan, context = context)
                    }
                ){
                    Text(text = "Konfirmasi")
                }

                Spacer(modifier = Modifier.height(20.dp))


            }

        }

    }
    SystemBackButtonHandler {
        BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanHome)
    }
}



