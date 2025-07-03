package alugames.model

data class Jogo( val titulo:String, val capa:String): JogosRecomendados {

    var descricao:String? = null
    var preco = 0.0
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    override fun recomendavel(nota: Int) {
        if(nota > 1 || nota > 10){
            println("Nota invalida: tem que ser entre 1 e 10")
        } else {
        listaNotas.add(nota)
    }
    }

    constructor(titulo: String,capa: String,preco: Double, descricao: String)
            :this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao=$descricao, preco=$preco)"
    }
}