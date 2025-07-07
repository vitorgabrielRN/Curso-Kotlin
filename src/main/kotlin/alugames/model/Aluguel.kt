package alugames.model

import alugames.Service.Periodo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo,
   ) {
    val valorAluguel: Double = gamer.plano.obterValor(this)
   var id = 0
    override fun toString(): String {
        return "Aluguel(gamer=$gamer, jogo=$jogo, periodo=$periodo, valorAluguel=$valorAluguel, id=$id)"
    }


}



