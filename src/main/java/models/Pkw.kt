package models

import java.time.LocalDate

class Pkw(id: Int, marke: String, modell: String, baujahr: Int, grundpreis: Double, var letzteServiceJahr: Int): Fahrzeug(id, marke, modell, baujahr, grundpreis) {

    init {
        require(letzteServiceJahr < LocalDate.now().year && letzteServiceJahr >= baujahr)
                    {"LetzteServiceJahr '$letzteServiceJahr' may not bigger than today's year or less than baujahr!"}
    }

    override fun getRabatt(): Double {
        val serviceJahr = LocalDate.now().year - letzteServiceJahr
        var rabatt = (getAlter() * (grundpreis * 5 / 100)) + (serviceJahr * (grundpreis * 2 / 100))
        if (rabatt > grundpreis * 15 / 100)
            rabatt = grundpreis * 15 / 100
        return rabatt
    }

    override fun toString(): String {
        return super.toString() + "\nLetzteServiceJahr: $letzteServiceJahr \nPreis: ${getPreis()} \n"
    }

}
