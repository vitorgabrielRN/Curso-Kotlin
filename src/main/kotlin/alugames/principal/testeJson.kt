package alugames.principal

import alugames.Service.ConsumoApi
import alugames.Service.Periodo
import alugames.model.PlanoAssinatura
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate
import kotlin.time.Duration.Companion.days

fun main() {
    val consumo = ConsumoApi()

    val listaJogosJson = consumo.buscaJogoJson()
    val listaGamer = consumo.buscaGamer()


    val gamerCaroline = listaGamer.get(3)

//    println(gamerCaroline)
//    println(jogoResidentVillage)
    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider = listaJogosJson.get(13)
    val jogoTheLastOfUs = listaJogosJson.get(2)
    val jogoDandara = listaJogosJson.get(5)
    val jogoAssassins = listaJogosJson.get(4)
    val jogoCyber = listaJogosJson.get(6)
    val jogoGod = listaJogosJson.get(7)
    val jogoSkyrim = listaJogosJson.get(18)


    val jogoTLOU = listaJogosJson.get(2)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))


    gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTLOU, periodo3)
//    println(gamerCaroline.jogosAluguel)

    val gamerCamila = listaGamer.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 39.9, 3, 0.15)
    gamerCamila.alugaJogo(jogoSpider,periodo)
    gamerCamila.alugaJogo(jogoTLOU,periodo3)
    gamerCamila.alugaJogo(jogoResidentVillage,periodo2)
//    println(gamerCamila.jogosAluguel)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
//    println(gamerCamila)

    gamerCamila.alugaJogo(jogoTLOU, periodo)
//    println(gamerCamila.jogosAluguel)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)


    gamerCaroline.recomendarJogo(jogoResidentVillage,2)
    gamerCaroline.recomendarJogo(jogoTLOU,10)
    gamerCamila.recomendarJogo(jogoSpider,1)
//    println(gamerCamila.jogosRecomendados)
//    println(gamerCaroline.jogosRecomendados)

    val gson = GsonBuilder()
                      .excludeFieldsWithoutExposeAnnotation()
                      .create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)
    val arquivo = File("jogosrecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)





}