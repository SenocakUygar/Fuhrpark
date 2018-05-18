package dao

import models.Fahrzeug

interface FahrzeugDAO {
    fun einlesen()
    fun speichern()
    fun getFahrzuegList(): List<Fahrzeug>
    fun getFahrzeugById(id: Int): Fahrzeug
    fun speichereFahrzeug(fahrzeug: Fahrzeug): Boolean
    fun loescheFahrzeug(id: Int): Boolean
}