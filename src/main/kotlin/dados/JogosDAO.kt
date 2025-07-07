package dados

import alugames.model.Jogo
import alugames.model.JogoEntity
import javax.persistence.EntityManager


class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>( manager, JogoEntity::class.java){


    override  fun getLista(): List<Jogo> {

    }

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(
            objeto.titulo,
            objeto.capa,
            objeto.preco,
            objeto.descricao,
            objeto.id)
    }

    override fun toModel(entity: JogoEntity): JogoEntity {
        return JogoEntity(
            objeto.titulo,
            objeto.capa,
            objeto.preco,
            objeto.descricao,
            objeto.id)
    }
    }


}