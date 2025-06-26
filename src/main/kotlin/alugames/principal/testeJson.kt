package alugames.principal

import Service.ConsumoApi

fun main(){
    val consumo = ConsumoApi()

    val listaGamer = consumo.buscaGamer()

    println(listaGamer)
}