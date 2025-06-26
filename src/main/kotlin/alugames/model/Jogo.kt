package alugames.model

data class Jogo( val titulo:String,
            val capa:String) {
  // caso algo senha nulo! é obrigado a usar o ? e super necessario esse tipo de variavel
    var descricao:String? = null
  //boa pratica
    override fun toString(): String {
        return "Meu Jogo= '\n" + "Titulo: $titulo'\n, Capa='$capa'\n , Descricao='$descricao')"
    }
}