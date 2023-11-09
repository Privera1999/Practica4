package com.example.practica4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica4.ui.theme.Practica4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica4Theme {
                // A surface container using the 'background' color from the theme
                    DinamicaVertical()
                }
            }
        }
    }


@Composable
fun DinamicaVertical(){
    LazyColumn{
        item{
                 BarraBusqueda()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraBusqueda(
    modifier: Modifier = Modifier
) {
    Row(modifier= Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(6.dp))
        Surface(color= Color.White,
            border = BorderStroke(2.dp, color = Color.Black),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(2.dp)
                .clip(RoundedCornerShape(30.dp))
        ) {
            Row {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .heightIn(50.dp)
                        .size(40.dp)

                )
                Spacer(modifier = Modifier.width(6.dp))
                TextField(
                    value = "¿Qué estás buscando?",
                    onValueChange = {},
                    trailingIcon = {
                        Surface(modifier=Modifier.clip(CircleShape)) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Introduce",
                                    modifier = Modifier.size(35.dp)
                                )
                        }
                    },
                    modifier = Modifier
                        .heightIn(30.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(4.dp))
        Icon(imageVector = Icons.Default.Notifications,
            contentDescription = null,
            modifier = Modifier
                .heightIn(50.dp)
                .size(52.dp))
    }
}

@Composable
fun TextoAlineado(
    @StringRes text2: Int,
    modifier:Modifier=Modifier){
        Surface(modifier= Modifier
            .width(100.dp)
            .height(40.dp)) {
            Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(text2),
                    textAlign = TextAlign.Center,
                    fontSize=23.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .heightIn(90.dp)
                )
        }
}

@Composable
fun TextoAlineadoRow(
    modifier: Modifier = Modifier
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
       items(Texto1){
               item ->  TextoAlineado(text2)
       }
        items(Texto1){

        }
        //TextoAlineado(text2 = R.string.Plaza)
    }
}

@Composable
fun TextoFijo1(msg: String){
    Row(modifier= Modifier
        .fillMaxWidth()
        .height(35.dp)) {
    Surface() {
        Row() {
            Column() {
            Text(text = "Devolución gratis ")
                Text(text = "En millones de articulos")
                 }
            Spacer(modifier = Modifier.width(85.dp))
            Column() {
                Text(text = "Entrega mejorada gratis")
                Text(text = "En pedidos + 10euros")
                }
            }
         }
    }
}

private val Texto1 = listOf(
    R.string.Plaza,
    R.string.Feed,
    R.string.Trendy,
    R.string.Moda,
    R.string.Bisuteria,
    R.string.Casa,
    R.string.Alimentacion,
    R.string.Herramientas
).map { TextoReutilizar(it) }

private val Imagenesytexto1 = listOf(
    R.drawable.cintametrica to R.string.CintaMétrica,
    R.drawable.destornillador to R.string.Destornillador,
    R.drawable.llavesinglesas to R.string.LLavesInglesas,
    R.drawable.sierra to R.string.Sierra,
    R.drawable.soldador to R.string.Soldador,
    R.drawable.taladro to R.string.Taladro,
    ).map { ImagenesTextoReutilizar(it.first, it.second) }


private val Imagenesytexto2 = listOf(
    R.drawable.brooklin to R.string.Brooklin,
    R.drawable.cleveland to R.string.Cleveland,
    R.drawable.golden to R.string.Golden,
    R.drawable.grizliise to R.string.Grizzlies,
    R.drawable.hornets to R.string.Hornets,
    R.drawable.miami to R.string.Miami,
    ).map { ImagenesTextoReutilizar(it.first, it.second) }

//Clase donde vamos a llamar a las imagenes para no tener que meter una por una
private data class ImagenesTextoReutilizar(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private data class TextoReutilizar(
    @StringRes val text2: Int)

data class Mensaje( val texto: String)

@Preview(showBackground = false)
@Composable
fun PreviewDinamicaVertical(){
    Practica4Theme {
        DinamicaVertical()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
     BarraBusqueda()
}
@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TextoAlineadoPreview() { Practica4Theme {
        TextoAlineado(
            text2 =R.string.Trendy
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Textofijo1Preview() {
    TextoFijo1("HOLA"
    )
}