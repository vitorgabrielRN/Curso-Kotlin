package dados

abstract  class  DAO <TModel>{

    abstract fun  getLista(): List<TModel>
    abstract  fun adicionar(objeto: TModel)
}