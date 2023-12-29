package com.example.bookfutsal.data.biodata

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.bookfutsal.navigation.BookOnlineFutsalAppRouter
import com.example.bookfutsal.navigation.Halaman
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataPemesananViewModel : ViewModel() {

    fun saveData(
        dataPemesanan: DataPemesanan,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("pemesanan")
            .document(dataPemesanan.pemesananID)

        try {

            fireStoreRef.set(dataPemesanan)
                .addOnSuccessListener {
                    Toast.makeText(context, "Sucessfully saved data", Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun retrieveData(
        pemesananID: String,
        context: Context,
        data: (DataPemesanan) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("pemesanan")
            .document(pemesananID)

        try {

            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        val dataPemesanan = it.toObject<DataPemesanan>()!!
                    }
                    Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteData(
    pemesananID: String,
    context: Context,

    ) = CoroutineScope(Dispatchers.IO).launch {

        val fireStoreRef = Firebase.firestore
            .collection("pemesanan")
            .document(pemesananID)

        try {

            fireStoreRef.delete()
                .addOnSuccessListener {
                    Toast.makeText(context, "Sucessfully Deleted Data", Toast.LENGTH_SHORT).show()
                    BookOnlineFutsalAppRouter.navigateTo(Halaman.HalamanHome)
                    }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

}
