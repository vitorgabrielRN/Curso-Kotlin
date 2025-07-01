package alugames.util

import alugames.model.Gamer
import alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {

 return Gamer(this.nome,
     this.email,
     this.dataNascimento,
     this.usuario)
}