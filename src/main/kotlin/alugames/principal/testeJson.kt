package alugames.principal

import alugames.Service.ConsumoApi
import alugames.Service.Periodo
import alugames.model.PlanoAssinatura
import java.time.LocalDate
import kotlin.time.Duration.Companion.days

fun main() {
    val consumo = ConsumoApi()

    val listaJogosJson = consumo.buscaJogoJson()
    val listaGamer = consumo.buscaGamer()


    val gamerCaroline = listaGamer.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)
//    println(gamerCaroline)
//    println(jogoResidentVillage)


    val jogoSpider = listaJogosJson.get(13)
    val jogoTLOU = listaJogosJson.get(2)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))


    gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTLOU, periodo3)
   println(gamerCaroline.jogosAluguel)

    val gamerCamila = listaGamer.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 39.9, 3, 0.15)
    gamerCamila.alugaJogo(jogoSpider,periodo)
    gamerCamila.alugaJogo(jogoTLOU,periodo3)
    gamerCamila.alugaJogo(jogoResidentVillage,periodo2)
    println(gamerCamila.jogosAluguel)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoTLOU, periodo)
    println(gamerCamila.jogosAluguel)

}