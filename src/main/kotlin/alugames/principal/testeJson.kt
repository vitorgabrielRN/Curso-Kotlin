package alugames.principal

import alugames.Service.ConsumoApi
import alugames.Service.Periodo
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
}