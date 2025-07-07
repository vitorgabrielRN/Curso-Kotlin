package alugames.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "jogos")
class JogoEntity(val titulo:String = "titulo do jogo",
                 val capa:String = "capa do jogo",
                 val preco: Double = 0.0,


                 val descricao:String? = null,
                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id:Int = 0) {
}