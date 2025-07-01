package alugames.model

import alugames.Service.Periodo
import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valorAluguel: Double = gamer.plano.obterValor(this)



    override fun toString(): String {
        return "Aluguel(gamer=$gamer, jogo=$jogo, periodo=$periodo, valorAluguel=$valorAluguel)"
    }
}



