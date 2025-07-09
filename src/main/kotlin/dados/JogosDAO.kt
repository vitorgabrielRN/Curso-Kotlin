package dados

import alugames.model.Jogo
import alugames.model.JogoEntity
import alugames.util.toEntity
import alugames.util.toModel
import javax.persistence.EntityManager


class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>( manager, JogoEntity::class.java){


    override fun getLista(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity -> Jogo(
            entity.titulo,
            entity.capa,
            entity.preco,
            entity.descricao,
            entity.id) }
    }

    override fun toEntity(objeto: Jogo): JogoEntity {
       return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
     return entity.toModel()
    }



}