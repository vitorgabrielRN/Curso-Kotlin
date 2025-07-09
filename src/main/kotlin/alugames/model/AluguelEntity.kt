package alugames.model

import alugames.Service.Periodo
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "aluguel")
class AluguelEntity(

    @ManyToOne
    val gamer:GamerEntity = GamerEntity(),

    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),

    @Embedded
    val periodo: Periodo
) {
    var valorDoAluguel = 0.0
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}