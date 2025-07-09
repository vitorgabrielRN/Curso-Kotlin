package alugames.util

import dados.AlguelDAO
import dados.Banco
import dados.GamerDAO
import dados.JogosDAO

fun main(){
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamerDAO(manager)
    val AlguelDAO = AlguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = JogosDAO.recuperarPeloId(3)

    manager.close()
}