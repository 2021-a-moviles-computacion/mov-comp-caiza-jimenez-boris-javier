import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val entrada = Scanner(System.`in`)
    val prueba = FileRead("C:/Users/Boris/Desktop/Septimo Semestre/Aplicaciones Moviles/Primer Bimestre/mov-comp-caiza-jimenez-boris-javier/deber1/src/main/kotlin/jugador.txt")
    print(prueba)

}





fun printTable(archivo: ArrayList<ArrayList<String>>, nombre:String){

    print("+++++++++++++++++++++++++++++++++++++++++++ ${nombre}++++++++++++++++++++++++++++++++++++++++++\n")
    archivo.forEach{
        println(it.forEach { print("\t\t"+it+"\t\t") }
        )
    }

}


fun buscarPor(
    indice: Int,
    str:String,
    archivo: ArrayList<ArrayList<String>>

): ArrayList<ArrayList<String>> {
    return(archivo.filter {
        return@filter (it[indice] == str)
    } as ArrayList<ArrayList<String>>)
}



fun FileRead(name:String): ArrayList<ArrayList<String>> {
    val uno = ArrayList<String>()
    val varios = arrayListOf(ArrayList<String>())
    try {
        val myObj = File(name)
        val myReader = Scanner(myObj)

        while (myReader.hasNextLine()) {
            val data: String = myReader.nextLine()
            val st = StringTokenizer(data, ",")
            while (st.hasMoreTokens()) {
                uno.add(st.nextToken())
            }
            varios.add(varios.clone() as ArrayList<String>)
            uno.clear()

        }
        myReader.close()
    } catch (e: FileNotFoundException) {
        println("An error occurred.")
        e.printStackTrace()
    }


    return varios
}