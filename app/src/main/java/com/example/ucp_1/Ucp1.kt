package com.example.ucp_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Ucp1(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderSection()
        InputData()
    }
}

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box{
                Image(
                    painter = painterResource(id = R.drawable.dwan),
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape).size(35.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.verif),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp).align(Alignment.BottomEnd)
                )
            }
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(text = "Halo", style = TextStyle(Color.White))
                Text(text = "Ridwan Hidayatullah", style = TextStyle(Color.White))

            }

        }
    }
}

@Composable
fun InputData(
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var notelp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val dataTahun = listOf("2020", "2021", "2022")
    var selectedTahun by remember { mutableStateOf(dataTahun[0]) }

    var confEmail by remember { mutableStateOf("") }
    var confNotelp by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confTahun by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Masukkan Biodata Kamu!",
            modifier = Modifier.padding(top = 5.dp)
        )
        Text(
            text = "Silahkan isi data dengan sebenar-benarnya",
            modifier = Modifier.padding(bottom = 5.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi Email Anda") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = notelp,
            onValueChange = { notelp = it },
            label = { Text(text = "No Telepone") },
            placeholder = { Text(text = "Isi No Telepon Anda") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text(text = "Alamat") },
            placeholder = { Text(text = "Isi Alamat Anda") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Text(text = "Tahun Masuk")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            dataTahun.forEach { tahunOption ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = (selectedTahun == tahunOption),
                        onClick = { selectedTahun = tahunOption }
                    )
                    Text(text = tahunOption, modifier = Modifier.padding(start = 4.dp))
                }
            }
        }

        Button(onClick = {
            confEmail = email
            confNotelp = notelp
            confAlamat = alamat
            confTahun = selectedTahun
        }) {
            Text(text = "Submit", modifier = Modifier.fillMaxWidth())
        }
        Text(text = "Data Kamu", modifier = Modifier.padding(5.dp))
        DataKamu(param = "Email", argu = confEmail)
        DataKamu(param = "Phone", argu = confNotelp)
        DataKamu(param = "Address", argu = confAlamat)
        DataKamu(param = "Year", argu = confTahun)
    }
}

@Composable
fun DataKamu(
    param: String, argu: String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = argu, modifier = Modifier.weight(2f))
        }
    }
}