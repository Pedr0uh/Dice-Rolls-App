package com.example.pratica

//todos os imports necessarios para esta aplicacao
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pratica.ui.theme.PraticaTheme

// classe main importante em qualquer projeto
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraticaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    // Funcao para carregar a imagem e o botao
    DadoComImagemBotao()
}

@Composable
fun DadoComImagemBotao(modifier: Modifier = Modifier.fillMaxSize()
    //Modificador que ocupa o maximo de espaço disponivel
    ){

    // variavel para escolha da imagem do dado, com o remember sempre sera lembrado o ultimo numero
    var result by remember { mutableStateOf(1) }

    // escolha para as imagens do dado
    val imagemDoDado = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> {
            R.drawable.dice_6
        }
    }

    // escolha para o texto acima do dado
    val textoDoDado = when (result) {
        1 -> "Numero 1"
        2 -> "Numero 2"
        3 -> "Numero 3"
        4 -> "Numero 4"
        5 -> "Numero 5"
        6 -> "Numero 6"
        else -> {
            "Numero 6"
        }
    }

    // Funcao com Conteudo Principal
    Column(
        //Chama o modifier
        modifier = modifier,

        //alinha os filhos horizontalmente
        horizontalAlignment = Alignment.CenterHorizontally,

        //arranja os filhos nos espaço do pai No centro
        verticalArrangement = Arrangement.Center

    ) {

        //Imagem do dado
        Text(textoDoDado)
        Image(
            painter = painterResource(imagemDoDado),
            contentDescription = "Face do dado numero 1"
        )

        //Botao para Rolar o Dado com o conteudo controlado
        Button (
            onClick = {
                result = (1..6).random()
            },
            modifier = Modifier.padding(16.dp)
            ) {
            Text(stringResource(R.string.lançar))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppPreview() {
    App()
}
