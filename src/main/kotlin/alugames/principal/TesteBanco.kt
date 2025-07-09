package alugames.principal


import alugames.model.Gamer
import alugames.model.Jogo
import dados.Banco
import dados.GamerDAO
import dados.PlanoDAO

fun main(){

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")


    val manager = Banco.getEntityManager()
    val gamerDAO = GamerDAO(manager)
    val  planoDAO = PlanoDAO(manager)

    gamer.plano = planoDAO.recuperarPeloId(3)

    val listaGamerBanco = gamerDAO.getLista()
    println(listaGamerBanco)

    manager.close()
}