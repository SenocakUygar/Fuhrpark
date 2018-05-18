
import management.FahrzeugManagement
import models.Fahrzeug
import models.Lkw
import models.Pkw


class Main {
    private val fahrzeugManagement: FahrzeugManagement = FahrzeugManagement()
    fun show() = fahrzeugManagement.allDatenOfFahrzeug()
    fun showById(id: Int) = fahrzeugManagement.allDatenOfOneFahrzeug(id)
    fun addPKW(id: Int, marke: String, modell: String, baujahr: Int, grundpreis: Double, letzteServiceJahr: Int)
            = fahrzeugManagement.addFahrzeug(Pkw(id, marke, modell, baujahr, grundpreis, letzteServiceJahr))
    fun addLKW(id: Int, marke: String, modell: String, baujahr: Int, grundpreis: Double)
            = fahrzeugManagement.addFahrzeug(Lkw(id, marke, modell, baujahr, grundpreis))
    fun loscheFahrzeug(id: Int) = fahrzeugManagement.removeFahrzeug(id)
    fun count() = fahrzeugManagement.gesamtZahlOfAllFahrzeug()
    fun countLKW() = fahrzeugManagement.gesamtZahlOfAllLkw()
    fun countPKW() = fahrzeugManagement.gesamtZahlOfAllPkw()
    fun meanprice() = fahrzeugManagement.durchschnittPreisAllFahrzeug()
    fun oldest() = fahrzeugManagement.idsDesAltestenFahrzuege()

}
fun main(args: Array<String>){
    val main = Main()
    if (!args.isEmpty()) {
        when {
            args[0].equals("show") && args.size == 1 -> main.show().forEach(::println)
            args[0].equals("show") && args.size == 2 -> println(main.showById(args[1].toInt()))
            args[0].equals("add") && args[1].equals("lkw") -> main.addLKW(args[2].toInt(), args[3], args[4], args[5].toInt(), args[6].toDouble())
            args[0].equals("add") && args[1].equals("pkw") -> main.addPKW(args[2].toInt(), args[3], args[4], args[5].toInt(), args[6].toDouble(), args[7].toInt())
            args[0].equals("del") -> main.loscheFahrzeug(args[1].toInt())
            args[0].equals("count") && args.size == 1 -> println(main.count())
            args[0].equals("count") && args.size == 2 && args[1].equals("lkw") -> println(main.countLKW())
            args[0].equals("count") && args.size == 2 && args[1].equals("pkw") -> println(main.countPKW())
            args[0].equals("meanprice") -> println(main.meanprice())
            args[0].equals("oldest") -> main.oldest().forEach { f -> println(f.id) }
            else -> println("argument")

        }
    }else{
        println("You have to give parameters!")
    }
}
