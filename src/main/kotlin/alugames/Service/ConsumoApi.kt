package alugames.Service

import alugames.model.Gamer
import alugames.model.InfoGamerJson
import alugames.model.InfoJogosJson

import alugames.model.InfoJogo
import alugames.model.Jogo

import alugames.util.criaGamer
import alugames.util.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse



class ConsumoApi {

  private  fun consomeDados(endereco:String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()
        return  response.body()
    }

    fun buscaJogo(id:String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo

    }

    fun buscaJogoJson(): List<Jogo> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuJogoTipo: Type = object: TypeToken<List<InfoJogosJson>>(){}.type
        val listaJogos:List<InfoJogosJson> = gson.fromJson(json, meuJogoTipo)
        val listaJogosConvertida = listaJogos.map { infoGamerJson -> infoGamerJson.criaJogo() }


        return  listaJogosConvertida
    }

    fun buscaGamer(): List<Gamer> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consomeDados(endereco)

        val gson = Gson()
        val meuGamerTipo  = object : TypeToken<List<InfoGamerJson>>(){}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)


        val listaGamerConvertida =  listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer()}

        return listaGamerConvertida
    }

}