package alugames.model

sealed class Plano(val tipo:String, var id:Int = 0) {

    open fun obterValor( aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias

    }
}