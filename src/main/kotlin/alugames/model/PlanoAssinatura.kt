package alugames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val perccentualDesconto: Double,
    id: Int = 0
    ): Plano(tipo, id){

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.jogosDoMes(
                          aluguel.periodo.dataInicial.monthValue)
                           .size+1

        return if (totalJogosMes <= jogosIncluidos){
                 0.0
        } else {
             var valorOriginal =  super.obterValor(aluguel)
            if (aluguel.gamer.media > 8){
                valorOriginal -= valorOriginal * perccentualDesconto
            }
            valorOriginal
        }
    }

    override fun toString(): String {
        return "PlanoAssinatura(mensalidade=$mensalidade, jogosIncluidos=$jogosIncluidos, perccentualDesconto=$perccentualDesconto)"
    }
}
