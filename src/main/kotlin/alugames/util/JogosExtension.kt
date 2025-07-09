package alugames.util

import alugames.model.InfoJogosJson

import alugames.model.Jogo
import alugames.model.JogoEntity


fun InfoJogosJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}
