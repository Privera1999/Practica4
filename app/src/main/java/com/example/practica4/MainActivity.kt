package com.example.practica4

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                    DinamicaVertical()
                }
            }
        }
    }



@Composable
fun DinamicaVertical(){
    LazyColumn( verticalArrangement = Arrangement.spacedBy(5.dp),){
        item{
            BarraBusqueda()
        }
        item{
            TextoAlineadoRow()
        }
        item{
            TextoFijo1(msg = "")
        }
        item{
            CirculosTextoRow()
        }
        item{
            TextoFijo2(msg="")
        }
        item{
            TextoFijo3(msg ="")
        }
        item{
            Imagenytexto1Row()
        }
        item{
            Imagenytexto2Row()
        }
        item{
            Imagenytexto3Row()
        }
        item{
            Imagenytexto4Row()
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
            border = BorderStroke(1.dp, color = Color.Black),
            shape = MaterialTheme.shapes.small,
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
                    fontSize = 23.sp,
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
    LazyRow(horizontalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
                modifier=modifier.padding(1.dp)
    ){
       items(Texto1){
               item ->  TextoAlineado(item.text2)
       }
    }
}

@Composable
fun TextoFijo1(msg: String){
    Row() {
        Spacer(modifier = Modifier.width(20.dp))
    Surface(color = Color.Red,
        shape = MaterialTheme.shapes.small) {
        Row() {
            Column() {
            Text(text = "Devolución gratis ",fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(text = "En millones de articulos", fontSize = 12.sp)
                 }
            Spacer(modifier = Modifier.width(85.dp))
            Column() {
                Text(text = "Entrega mejorada gratis",fontWeight = FontWeight.Bold, fontSize = 12.sp)
                Text(text = "En pedidos + 10euros", fontSize = 12.sp)
                }
            Spacer(modifier = Modifier.width(10.dp))
            }
         }
    }
}

@Composable
fun CirculosTexto(
    @DrawableRes drawable:Int,
    @StringRes text:Int,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally
        ,modifier=modifier) {
        Image(painter = painterResource(drawable),
            contentDescription=null,
            contentScale = ContentScale.Fit,
            modifier= Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Text(text = stringResource(text),
            modifier=Modifier.paddingFromBaseline(top=24.dp, bottom = 8.dp),
            style=MaterialTheme.typography.bodyMedium
        )
    }

}

// Step: Align your body row - Arrangements
@Composable
fun CirculosTextoRow(
    modifier: Modifier = Modifier
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
        items(CirculosPequeños){
                item -> CirculosTexto(item.drawable, item.text)
        }
    }
}

@Composable
fun TextoFijo2(msg: String){
    Row(modifier= Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.width(3.dp))
        Surface(color = Color.Red,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(5.dp)) {
            Row(modifier= Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.width(4.dp))
                Column() {
                    Text(
                        text = "Faltan ",
                        fontSize = 12.sp,
                        )

                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "4 ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                        )
                    Text(
                        text = "dias",
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Próximamente: Promo del 11.11",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = "Las mayores ofertas del año", fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(30.dp))

                Column {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "->", fontSize = 18.sp,fontWeight = FontWeight.Bold)
                }
                 }
            }
        }
    }

@Composable
fun TextoFijo3(msg: String){
    Row(modifier= Modifier.fillMaxWidth()){

        Spacer(modifier = Modifier.height(4.dp))
        Surface(color=Color.Yellow,modifier= Modifier
            .width(400.dp)
            .height(50.dp)
            ) {
            Column() {
                Spacer(modifier = Modifier.height(4.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Check",
                        modifier = Modifier.size(28.dp)
                    )
                    Text(text = "Choice ", fontWeight = FontWeight.Bold, fontSize = 19.sp)
                }
                Text(
                    text = "Envío gratis | Entrega en 5 días | Devolución gratis",
                    fontSize = 12.sp
                )
            }
        }
            }
        }

@Composable
fun ImagenYtexto1(
    @DrawableRes drawable:Int,
    @StringRes text:Int,
    modifier: Modifier = Modifier
) {
        Column(
            modifier = Modifier.width(95.dp)){
            Image(
                painter=painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(85.dp)
            )
            Text(text = stringResource(text),
                style=MaterialTheme.typography.titleMedium,
                modifier=Modifier.padding(horizontal = 16.dp))
        }
    }

// Step: Align your body row - Arrangements
@Composable
fun Imagenytexto1Row(
    modifier: Modifier = Modifier
) {
    Surface(modifier= Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(color=Color.Yellow, modifier=Modifier.padding(2.dp)) {
                Text(text = "Choice",fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "3 por 5.99$ * Entrega en 5 días", fontSize = 18.sp,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(65.dp))
            Text(text = ">", fontSize = 18.sp,fontWeight = FontWeight.Bold)
            }
    }
    Spacer(modifier = Modifier.height(9.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
        items(Imagenesytexto1){
                item -> ImagenYtexto1(item.drawable, item.text)
        }
    }
}
//Este código sobra, podria reutilizar imagen y texto 1
@Composable
fun ImagenYtexto2(
    @DrawableRes drawable:Int,
    @StringRes text:Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.width(95.dp)){
        Image(
            painter=painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(85.dp)
        )
        Text(text = stringResource(text),
            style=MaterialTheme.typography.titleMedium,
            modifier=Modifier.padding(horizontal = 16.dp))
    }
}

@Composable
fun Imagenytexto2Row(
    modifier: Modifier = Modifier
) {
    Surface(modifier= Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(color=Color.Yellow, modifier=Modifier.padding(2.dp)) {
                Text(text = "Choice",fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "2 por 40$ * Entrega en 1-3 días", fontSize = 18.sp,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(63.dp))
            Text(text = ">", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(9.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
        items(Imagenesytexto2){
                item -> ImagenYtexto2(item.drawable, item.text)
        }
    }
}

@Composable
fun Imagenytexto3Row(
    modifier: Modifier = Modifier
) {
    Surface(modifier= Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(color=Color.Yellow, modifier=Modifier.padding(2.dp)) {
                Text(text = "Choice",fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Super Oferta todo a 1$", fontSize = 18.sp,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(127.dp))
            Text(text = ">", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(9.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
        items(Imagenesytexto3){
                item -> ImagenYtexto2(item.drawable, item.text)
        }
    }
}
@Composable
fun Imagenytexto4Row(
    modifier: Modifier = Modifier
) {
    Surface(modifier= Modifier
        .fillMaxWidth()
        .height(30.dp)) {
        Spacer(modifier = Modifier.width(4.dp))
        Row {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(color=Color.Yellow, modifier=Modifier.padding(2.dp)) {
                Text(text = "Choice",fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Fin de anime, todo a 20$", fontSize = 18.sp,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(112.dp))
            Text(text = ">", fontSize = 18.sp,fontWeight = FontWeight.Bold)
        }
    }
    Spacer(modifier = Modifier.height(9.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding= PaddingValues(horizontal = 16.dp),
        modifier=modifier.padding()
    ){
        items(Imagenesytexto4){
                item -> ImagenYtexto2(item.drawable, item.text)
        }
    }
}

@Composable
private fun BarraNavegacion(modifier: Modifier = Modifier) {
    NavigationBar(modifier=modifier)
    {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
        )
        NavigationBarItem(
            selected=false,
            onClick = {/*TODO*/},
            icon = { Icon(imageVector=Icons.Default.Search, contentDescription=null)},
        )
        NavigationBarItem(
            selected=false,
            onClick = {/*TODO*/},
            icon= { Image(painter=painterResource(R.drawable.choisebueno), contentDescription =null)},
        )
        NavigationBarItem(
            selected=false,
            onClick = {/*TODO*/},
            icon = { Icon(imageVector=Icons.Default.ShoppingCart, contentDescription=null)},
        )
        NavigationBarItem(
            selected=false,
            onClick = {/*TODO*/},
            icon = { Icon(imageVector=Icons.Default.Person, contentDescription=null)},
        )
    }
}

private val Texto1 = listOf(
    R.string.Explorar,
    R.string.Movil,
    R.string.Ropa,
    R.string.Juegos,
    R.string.Moda,
    R.string.Bisuteria,
    R.string.Casa,
    R.string.Jardín,
    R.string.Deporte
).map { TextoReutilizar(it) }

private val CirculosPequeños = listOf(
    R.drawable.carro to R.string.Carro,
    R.drawable.moneda to R.string.Moneda,
    R.drawable.ofertas to R.string.Ofertas,
    R.drawable.relampago2 to R.string.Relámpago,
    R.drawable.saldo to R.string.Saldo,
    R.drawable.tractor to R.string.Tractor,
).map { ImagenesTextoReutilizar(it.first, it.second) }

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

private val Imagenesytexto3 = listOf(
    R.drawable.kawai1 to R.string.Kawai1,
    R.drawable.kawai2 to R.string.Kawai2,
    R.drawable.kawai3 to R.string.Kawai3,
    R.drawable.kawai4 to R.string.Kawai4,
    R.drawable.kawai5 to R.string.Kawai5,
    R.drawable.kawai6 to R.string.Kawai6,
    R.drawable.kawai7 to R.string.Kawai7,
    ).map { ImagenesTextoReutilizar(it.first, it.second) }

private val Imagenesytexto4 = listOf(
    R.drawable.coraza to R.string.Acorazado,
    R.drawable.capitan to R.string.Capi,
    R.drawable.levi to R.string.Levi,
    R.drawable.levi2 to R.string.Levi2,
    R.drawable.mikasa to R.string.Mikasa,
    R.drawable.sosagero to R.string.Sosa,
    R.drawable.hanges to R.string.Gero,
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
            text2 =R.string.Ropa
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Textofijo1Preview() {
    TextoFijo1("HOLA"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CirculosTextoPreview() {
    CirculosTexto(
            modifier = Modifier.padding(8.dp),
            drawable =R.drawable.tractor,
            text =R.string.Tractor
        )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Textofijo2Preview() {
    TextoFijo2("HOLA"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Textofijo3Preview() {
    TextoFijo1("HOLA"
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ImagenYtextoPreview() {

        ImagenYtexto1(
            modifier = Modifier.padding(8.dp),
            drawable =R.drawable.grizliise,
            text =R.string.Sierra
        )

    }

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ImagenYtexto2Preview() {

    ImagenYtexto1(
        modifier = Modifier.padding(8.dp),
        drawable =R.drawable.grizliise,
        text =R.string.Sierra
    )

}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BarraNavegacionPreview() {
    BarraNavegacion() }
