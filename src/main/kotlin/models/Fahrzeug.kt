package models

import java.io.Serializable
import java.time.LocalDate

abstract class Fahrzeug (var id: Int, var marke: String, var modell: String, var baujahr: Int, var grundpreis: Double): Serializable{

    init {
        require(id > 0) {"Id '$id' may not less than 0!"}
        require(baujahr < LocalDate.now().year) {"Baujahr '$baujahr' may not bigger than today's year!"}
        require(grundpreis > 0) {"Grundpreis '$grundpreis' may not less than 0!"}
    }

    override fun toString(): String =  "Typ: ${this::class.simpleName} \nId: $id \nMarke: $marke \nModel: $modell \nBaujahr: $baujahr \nGrundpreis: $grundpreis"

    fun getAlter(): Int = LocalDate.now().year - baujahr

    fun getPreis(): Double = grundpreis - getRabatt()

    abstract fun getRabatt(): Double

}