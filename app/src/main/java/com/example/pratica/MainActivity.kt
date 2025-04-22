package com.example.pratica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pratica.ui.theme.PraticaTheme

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
        Text("Imagem")

        //Botao para Rolar o Dado com o conteudo controlado
        Button (onClick = { /*A Fazer*/ }) {
            Text(stringResource(R.string.lançar))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}

@Preview()
@Composable
fun AppPreview2() {
    App()
}