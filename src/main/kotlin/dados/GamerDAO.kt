package dados

import alugames.model.Gamer
import alugames.model.GamerEntity
import alugames.util.toEntity
import alugames.util.toModel
import javax.persistence.EntityManager


class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plano = entity.plano.toModel() }
    }
}