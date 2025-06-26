import alugames.model.Gamer

fun main(){
    val gamer1 = Gamer(
        "Vitor",
        "vitor@gmail.com")
    println(gamer1)

    val gamer2 = Gamer(
        "vitor2",
        "vitor@Gmail.com",
        "10/10/2010",
        "malaquito")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "20/04/2024"
        it.usuario = "vitorMalaquito"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "jack"
    println(gamer1)


}