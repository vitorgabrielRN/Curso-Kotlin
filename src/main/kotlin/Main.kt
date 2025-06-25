package br.com.prodiga

import com.google.gson.Gson

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner
import kotlin.NullPointerException


fun main() {
    val leitura = Scanner(System.`in`)
    println("digite um codigo de jogo pra buscar")
    val busca = leitura.nextLine()
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"
    val client: HttpClient = HttpClient.newHttpClient()

    val  request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())
    val Json = response.body()
        println(Json)

    val gson = Gson()
    val meuInfojogo = gson.fromJson(Json, InfoJogo::class.java)

    val resultado = runCatching {
        val meuJogo = Jogo(
            meuInfojogo.info.title,
            meuInfojogo.info.thumb)
        println(meuJogo)
    }
   resultado.onFailure {
       println("Erro, não encontrado")
   }
}
