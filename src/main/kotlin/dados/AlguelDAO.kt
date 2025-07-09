package dados

import alugames.model.Aluguel
import alugames.model.AluguelEntity
import alugames.util.toEntity
import alugames.util.toModel
import javax.persistence.EntityManager

class AlguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java){
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(
            objeto.gamer.toEntity(),
            objeto.jogo.toEntity(),
            objeto.periodo).apply { valorDoAluguel = objeto.valorAluguel
            id = objeto.id}
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(
            entity.gamer.toModel(),
            entity.jogo.toModel(),
            entity.periodo) .apply { valorAluguel = entity.valorDoAluguel
        }
        }
    }

