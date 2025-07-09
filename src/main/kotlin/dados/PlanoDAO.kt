package dados

import alugames.model.Plano
import alugames.model.PlanoEntity
import alugames.util.toEntity
import alugames.util.toModel
import javax.persistence.EntityManager

class PlanoDAO(manager: EntityManager):DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano): PlanoEntity {
     return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
    return entity.toModel()
    }


}