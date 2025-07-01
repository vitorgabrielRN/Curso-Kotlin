package alugames.util

import alugames.model.InfoJogosJson

import alugames.model.Jogo


fun InfoJogosJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}