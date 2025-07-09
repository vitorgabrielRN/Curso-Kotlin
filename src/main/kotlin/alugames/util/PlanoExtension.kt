package alugames.util

import alugames.model.Plano
import alugames.model.PlanoAssinatura
import alugames.model.PlanoAssinaturaEntity
import alugames.model.PlanoAvulso
import alugames.model.PlanoAvulsoEntity
import alugames.model.PlanoEntity

fun Plano.toEntity(): PlanoEntity{
    return  if(this is PlanoAssinatura){
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.perccentualDesconto, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}
fun PlanoEntity.toModel():Plano{
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(
            this.tipo,
            this.mensalidade,
            this.jogosIncluidos,
            this.perccentualDesconto,
            this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}