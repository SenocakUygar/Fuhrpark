package management


import dao.FahrzeugDAO
import dao.SerializedFahrzeugDAO
import models.Fahrzeug
import models.Lkw
import models.Pkw
import java.util.*

class FahrzeugManagement {
    private val fahrzuegDAO: FahrzeugDAO = SerializedFahrzeugDAO("fahrzeug.ser")

    init {
        fahrzuegDAO.einlesen()
    }

    fun allDatenOfFahrzeug(): List<Fahrzeug> = fahrzuegDAO.getFahrzuegList()

    fun allDatenOfOneFahrzeug(id: Int) = fahrzuegDAO.getFahrzeugById(id)

    fun addFahrzeug(fahrzeug: Fahrzeug) = fahrzuegDAO.speichereFahrzeug(fahrzeug)

    fun removeFahrzeug(id: Int) = fahrzuegDAO.loescheFahrzeug(id)

    fun gesamtZahlOfAllFahrzeug() = fahrzuegDAO.getFahrzuegList().size

    fun gesamtZahlOfAllPkw() = fahrzuegDAO.getFahrzuegList().filter { f -> f is Pkw }.size

    fun gesamtZahlOfAllLkw() = fahrzuegDAO.getFahrzuegList().filter { f -> f is Lkw }.size

    fun durchschnittPreisAllFahrzeug() : Double{
        var count = 0.0
        fahrzuegDAO.getFahrzuegList().forEach { f -> count += f.getPreis() }
        return count / fahrzuegDAO.getFahrzuegList().size
    }
    
    fun idsDesAltestenFahrzuege(): List<Fahrzeug>{
        val oldest: Int = Collections.max(fahrzuegDAO.getFahrzuegList(), Comparator.comparingInt {f-> f.getAlter() }).getAlter()
        return fahrzuegDAO.getFahrzuegList().filter { f -> f.getAlter() == oldest }
    }
}