package dados

import alugames.model.Gamer
import alugames.model.GamerEntity
import javax.persistence.EntityManager

class GamerDAO ( manager: EntityManager): DAO<Gamer>(manager){
   override fun getLista(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { entity -> Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento,
            entity.usuario,
            entity.id) }
    }

    override  fun adicionar(gamer: Gamer) {

    }
}