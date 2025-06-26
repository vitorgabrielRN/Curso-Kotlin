package Service

import alugames.model.Gamer
import alugames.model.InfoGamer
import alugames.model.InfoJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String):InfoJogo {

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()


        val gson = Gson()
        val meuInfojogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfojogo
    }

    fun buscaGamer(): List<InfoGamer> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()


        val gson = Gson()
        val meuGamerTipo  = object : TypeToken<List<InfoGamer>>(){}.type
        val listaGamer: List<InfoGamer> = gson.fromJson(json, meuGamerTipo)


        listaGamer.map { infoGamer -> Gamer(
            infoGamer.nome,
            infoGamer.email,
            infoGamer.dataNascimento,
            infoGamer.usuario)
        }
        return listaGamer


    }

}