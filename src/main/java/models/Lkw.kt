package models


class Lkw (id: Int, marke: String, modell: String, baujahr: Int, grundpreis: Double): Fahrzeug(id, marke, modell, baujahr, grundpreis) {

    override fun getRabatt(): Double {
        var rabatt = (getAlter() *  (grundpreis * 5 / 100))
        if(rabatt > grundpreis * 20 / 100)
            rabatt = grundpreis * 20 / 100
        return rabatt
    }

    override fun toString(): String {
        return super.toString() + "\nPreis: ${getPreis()} \n"
    }

}