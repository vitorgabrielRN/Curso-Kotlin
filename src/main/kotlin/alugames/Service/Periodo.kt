package alugames.Service

import java.time.LocalDate
import java.time.Period

data class Periodo(val dataInicial: LocalDate,
                   val dataFinal: LocalDate){

    val emDias =  Period.between(dataInicial, dataFinal).days
}
