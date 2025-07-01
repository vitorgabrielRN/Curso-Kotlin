package alugames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
    ): Plano(tipo){}
