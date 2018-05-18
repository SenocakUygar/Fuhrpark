package dao

import models.Fahrzeug
import java.io.*


class SerializedFahrzeugDAO(private val path: String) : FahrzeugDAO {

    private var fahrzeugList = ArrayList<Fahrzeug>()

    override fun einlesen() {
        try {
            val file = File(path)
            if (file.exists()) {
                fahrzeugList.clear()
                ObjectInputStream(FileInputStream(path)).use { it -> fahrzeugList.addAll(it.readObject() as ArrayList<Fahrzeug>) }
                println("Fahrzeug will be read")
            }
        }catch (e: Exception){
            throw IllegalStateException("Fehler bei Serialisierung! ${e.message}")
        }
    }

    override fun speichern() {
        try {
            val file = File(path)
            if (file.exists())
                file.delete()
            ObjectOutputStream(FileOutputStream(path, true)).use { it -> it.writeObject(fahrzeugList) }
            println("Fahrzueg will be safed!!")
        }catch (e: Exception) {
            throw IllegalStateException("Fehler bei Deserialisierung!")
        }

    }

    override fun getFahrzuegList(): List<Fahrzeug> = fahrzeugList

    override fun getFahrzeugById(id : Int): Fahrzeug = fahrzeugList.single { f -> f.id == id }

    override fun speichereFahrzeug(fahrzeug: Fahrzeug): Boolean{
        fahrzeugList.add(fahrzeug)
        speichern()
        return true
    }

    override fun loescheFahrzeug(id: Int): Boolean = fahrzeugList.removeIf {f -> f.id == id }
}