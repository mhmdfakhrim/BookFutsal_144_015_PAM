package com.example.bookfutsal.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
fun HalamanLihatPemesanan(
    dataPemesananViewModel: DataPemesananViewModel

) {

    var pemesananID: String by remember { mutableStateOf("") }
    var nama: String by remember { mutableStateOf("") }
    var alamat: String by remember { mutableStateOf("") }
    var telpon: String by remember { mutableStateOf("") }
    var telponInt: Int by remember { mutableStateOf(0) }
    var jam: String by remember { mutableStateOf("") }
    var jamInt: Int by remember { mutableStateOf(0) }
    var lapangan: String by remember { mutableStateOf("") }
    var lapanganInt: Int by remember { mutableStateOf(0) }

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

                HeadingTextComponent(value = stringResource(id = R.string.pemesanan))

                Spacer(modifier = Modifier.height(10.dp))

                MyTextIdPemesananFieldComponent(
                    labelValue = stringResource(id = R.string.id_pemesanan),
                    painterResource(id = R.drawable.baseline_person_2_24 ),
                    onTextChanged = {}
                )
                Button(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(100.dp),
                    onClick = {
                        dataPemesananViewModel.retrieveData(
                            pemesananID = pemesananID,
                            context = context
                        ) { data ->
                            nama = data.nama
                            alamat = data.alamat
                            telpon = data.telpon.toString()
                            telponInt = telpon.toInt()
                            lapangan = lapangan.toString()
                            lapanganInt = lapangan.toInt()
                            jam = jam.toString()
                            jamInt = jam.toInt()
                        }
                    }
                ){
                    Text(text = "Get Data")

                }

                Spacer(modifier = Modifier.height(10.dp))

                MyTextNameFieldComponent(
                    labelValue = stringResource(id = R.string.nama),
                    painterResource(id = R.drawable.baseline_person_2_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextAlamatFieldComponent(
                    labelValue = stringResource(id = R.string.alamat),
                    painterResource(id = R.drawable.baseline_place_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextTelponFieldComponent(
                    labelValue = stringResource(id = R.string.telpon),
                    painterResource(id = R.drawable.baseline_call_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextLapanganFieldComponent(
                    labelValue = stringResource(id = R.string.pilih_lapangan),
                    painterResource(id = R.drawable.baseline_access_time_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(10.dp))

                MyTextJamFieldComponent(
                    labelValue = stringResource(id = R.string.jumlah_jam),
                    painterResource(id = R.drawable.baseline_access_time_24 ),
                    onTextChanged = {}
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    onClick = {
                        val dataPemesanan = DataPemesanan(
                            pemesananID = pemesananID,
                            nama = nama,
                            alamat = alamat,
                            telpon = telponInt,
                            lapangan = lapanganInt,
                            jam = jamInt
                        )

                        dataPemesananViewModel.saveData(dataPemesanan = dataPemesanan, context = context)
                    }
                ){
                    Text(text = "Save")
                }

                Button(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    onClick = {

                        dataPemesananViewModel.deleteData(pemesananID = pemesananID, context = context)
                    }
                ){
                    Text(text = "Hapus")
                }




            }

        }

    }
    SystemBackButtonHandler {
        BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanHome)
    }
}