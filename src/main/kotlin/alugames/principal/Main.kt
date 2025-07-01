package br.com.prodiga.alugames.principal

import alugames.Service.ConsumoApi
import alugames.model.Gamer
import alugames.model.Jogo
import transformarEmIdade
import java.util.*


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido com sucesso")
    println(gamer)
    println("Idade do gamer:  " +
            gamer.dataNascimento?.transformarEmIdade())

    do {

        println("digite um codigo de jogo pra buscar")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb)
        }

        resultado.onFailure {
            println("Erro, não encontrado")
        }

        resultado.onSuccess {
            println("deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if(opcao.equals("s", true)){
                println("insira a descrição para o jogo: ")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }
        println("quer buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()


    } while (resposta.equals("s", true))


    println("jogos buscado")
    println(gamer.jogosBuscados)
    println("\n jogos por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    gamer.jogosBuscados.forEach{
        println("TITULOS: " + it?.titulo)
    }

    val jogoFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?:false
    }

    println("\n jogosfiltrados")
    println(jogoFiltrados)

    println("deseja apagar algum jogo da lista origina? S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s", true)){
        println(gamer.jogosBuscados)
        println("qual é o numero que o jogo está na lista")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)

    }
    println("\n Lista atualizada: ")
    println(gamer.jogosBuscados)

    println("busca finalizada com sucesso")



}
