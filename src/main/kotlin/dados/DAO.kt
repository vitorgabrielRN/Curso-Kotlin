package dados

import alugames.model.GamerEntity
import alugames.model.Jogo
import alugames.model.JogoEntity
import javax.persistence.EntityManager

abstract  class  DAO <TModel, TEntity>( protected val manager: EntityManager, protected val entityType: class<TEntity>){



    abstract  fun toEntity(objeto: TModel): TEntity

    abstract  fun toModel(entity: TEntity): TModel

    open fun  getLista(): List<TModel>{

        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity)
        }

    }

    open  fun adicionar(objeto: TModel){
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}