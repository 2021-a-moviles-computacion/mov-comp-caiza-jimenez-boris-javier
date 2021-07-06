import java.io.*
import java.text.SimpleDateFormat
import java.util.*


fun main() {
    val jugador = "C:/Users/Boris/Desktop/Septimo Semestre/Aplicaciones Moviles/Primer Bimestre/mov-comp-caiza-jimenez-boris-javier/deber01/src/main/kotlin/jugador.txt"
    val club = "C:/Users/Boris/Desktop/Septimo Semestre/Aplicaciones Moviles/Primer Bimestre/mov-comp-caiza-jimenez-boris-javier/deber01/src/main/kotlin/equipo.txt"
    val scanner = Scanner(System.`in`)
    val lista_jugadores = ReadPlayer(jugador)
    val lista_clubes = ReadClub(club)
    println("Seleccion el archivo:\n" +
            "1. Jugador\n" +
            "2. Equipo\n" +
            "Opción")
    val opcion = scanner.nextLine()

    when (opcion) {
        ("1") -> {
            print("Que desea hacer con el archivo jugador:\n" +
                    "1. Leer\n" +
                    "2. Buscar \n" +
                    "3. Crear un jugador\n" +
                    "4. Eliminar un jugador\n" +
                    "5. Actualizar un jugador\n" +
                    "Opción:  ")

            val opcion2 = scanner.nextLine()

            when (opcion2) {

                ("1") -> {
                    printPlayer(lista_jugadores)
                }

                ("2") -> {
                    print("Por qué parámetro desea hacer la busqueda: \n" +
                            "1. Id de Equipo\n" +
                            "2. Nombre\n" +
                            "3. Fecha de Nacimiento\n" +
                            "4. Sueldo\n" +
                            "5.Ciudad\n" +
                            "Opcion:\n")
                    val opcion3 = scanner.nextLine()
                    println("Ingrese el parametro de búsqueda: \n")
                    val nuevo = scanner.nextLine()
                    printPlayer(findPlayer(opcion3.toInt(), nuevo, lista_jugadores))
                }

                ("3") -> {
                    print("++++++++++++++++++++++++++++++++++++++++++++++++\n")
                    print("Estos son los clubes disponibles: \n")
                    printClub(lista_clubes)
                    createPlayer(jugador)
                }

                ("4") -> {
                    println("1. Busqueda para eliminar \n" +
                            "2. Eliminar directamente desde el id \n" +
                            "Opción: ")
                    val opcion4 = scanner.nextLine()
                    when (opcion4) {
                        ("1") -> {

                            println("Por qué parametro desea buscar:\n" +
                                    "1.Id_Equipo\n" +
                                    "2.Nombre\n" +
                                    "3.Fecha de nacimeindo\n" +
                                    "4.Sueldo\n" +
                                    "5.Ciudad\n" +
                                    "Opción:")
                            val opcion4 = scanner.nextLine()
                            println("Ingrese el parametro de busqueda: ")
                            val str = scanner.nextLine()
                            printPlayer(findPlayer(opcion4.toInt(), str, lista_jugadores))


                            deletePlayer(jugador, lista_jugadores)
                        }

                        ("2") -> {
                            deletePlayer(jugador, lista_jugadores)

                        }
                    }

                }
                ("5") -> {
                    updatePlayer(lista_jugadores, jugador)
                    print("Jugador actualizado con exito.")
                }
            }
        }

        ("2") -> {
            print("Que desea hacer con el archivo jugador:\n" +
                    "1. Leer\n" +
                    "2. Buscar \n" +
                    "3. Crear un club\n" +
                    "4. Eliminar un club\n" +
                    "5. Actualizar un club\n" +
                    "Opción:  ")

            val opcion2 = scanner.nextLine()

            when (opcion2) {

                ("1") -> {
                    printClub(lista_clubes)
                }

                ("2") -> {
                    print("Por qué parámetro desea hacer la busqueda: \n" +
                            "0. Id de Equipo\n" +
                            "1. Nombre\n" +
                            "2. Categoría\n" +
                            "3. Provincia\n" +
                            "4. Ciudad\n" +
                            "5. Activo\n"+
                            "Si ha seleccionado activo escriba false o true\n"+
                            "Opcion:\n")
                    val opcion3 = scanner.nextLine()
                    println("Ingrese el parametro de búsqueda: \n")
                    val nuevo = scanner.nextLine()
                    printClub(findClub(opcion3.toInt(), nuevo, lista_clubes))
                }

                ("3") -> {
                    print("++++++++++++++++++++++++++++++++++++++++++++++++\n")
                    print("Estos son los clubes disponibles: \n")
                    printClub(lista_clubes)
                    createClub(club)
                }

                ("4") -> {
                    println("1. Busqueda para eliminar \n" +
                            "2. Eliminar directamente desde el id \n" +
                            "Opción: ")
                    val opcion4 = scanner.nextLine()
                    when (opcion4) {
                        ("1") -> {

                            print("Por qué parámetro desea hacer la busqueda: \n" +
                                    "0. Id de Equipo\n" +
                                    "1. Nombre\n" +
                                    "2. Categoría\n" +
                                    "3. Provincia\n" +
                                    "4. Ciudad\n" +
                                    "5. Activo"+
                                    "Si ha seleccionado activo escriba false o true\n"+
                                    "Opcion:\n")
                            val opcion3 = scanner.nextLine()
                            println("Ingrese el parametro de búsqueda: \n")
                            val nuevo = scanner.nextLine()
                            printClub(findClub(opcion3.toInt(), nuevo, lista_clubes))


                            deleteTeam(club, lista_clubes)
                        }

                        ("2") -> {
                            deleteTeam(club, lista_clubes)

                        }
                    }

                }
                ("5") -> {
                    updateTeam(lista_clubes, club)
                    print("Club actualizado con exito.")
                }
            }

        }
    }
}



fun deleteTeam(archivo:String , archivo1: ArrayList<Club>){
    val scanner = Scanner(System.`in`)
    var id:String?
    var equipo:String?
    var categoria:String?
    var provincia:String?
    var ciudad:String?
    var activo:String?
    println("Ingrese el Id del equipo a eliminar")
    val opcion =   scanner.nextLine()
    val borrar = findClub(0, opcion, archivo1)
    borrar.forEach {
        id = it.getId().toString()
        equipo = it.getnombre().toString()
        categoria = it.getCategoria().toString()
        provincia = it.getProvincia().toString()
        ciudad = it.getCiudad().toString()
        activo = it.getActivo().toString()
        deleteLine(archivo,"${id},${equipo},${categoria},${provincia},${ciudad},${activo},")
        deleteLine(archivo, "")
        println("Club eliminar con exito")

    }
}

fun deletePlayer(archivo:String , archivo1: ArrayList<Jugador>){
    val scanner = Scanner(System.`in`)
    var id:String?
    var id_equipo:String?
    var nombre:String?
    var fecha:String?
    var sueldo:String?
    var ciudad:String?
    println("Ingrese el Id del jugador a eliminar")
    val opcion =   scanner.nextLine()
    val borrar = findPlayer(0, opcion, archivo1)
    borrar.forEach {
        id = it.getId().toString()
        id_equipo = it.getIdEquipo().toString()
        nombre = it.getnombre().toString()
        fecha = it.getFecha().toString()
        sueldo = it.getSueldo().toString()
        ciudad = it.getCiudad().toString()
       // println("${id},${id_equipo},${nombre},${fecha},${sueldo},${ciudad},")
        deleteLine(archivo,"${id},${id_equipo},${nombre},${fecha},${sueldo},${ciudad},")
        println("Jugador eliminar con exito")
    }
}

fun createPlayer( ruta: String ){
    val scanner = Scanner(System.`in`)

    println("Ingrese el id:")
    val id = scanner.nextLine()
    println("Ingrese el id del equipo:")
    val id_equipo = scanner.nextLine()
    println("Ingrese el nombre del jugador:")
    val nombre = scanner.nextLine()
    println("Ingrese la fecha de nacimeinto:")
    val fecha = scanner.nextLine()
    println("Ingrese el sueldo:")
    val sueldo = scanner.nextLine()
    println("Ingrese la ciudad de origen:")
    val ciudad = scanner.nextLine()


    /*val nuevo:ArrayList<String>  = arrayListOf(id,id_equipo,categoria,provincia,ciudad)
    archivo.add(nuevo)
    archivo.forEach {
        fWriter.write("${it},")
    }
    fWriter.close()*/

    try {
        FileWriter(ruta, true).use { fw ->
            BufferedWriter(fw).use { bw ->
                PrintWriter(bw).use { out ->
                    out.print("\n"+"${id},${id_equipo},${nombre},${fecha},${sueldo},${ciudad},")
                }
            }
        }
    } catch (e: IOException) {
        //exception handling left as an exercise for the reader
    }
    deleteLine(ruta,"")

    println("Jugador creado con exito")


}


fun createClub( ruta: String ){
    val scanner = Scanner(System.`in`)

    println("Ingrese el id:")
    val id = scanner.nextLine()
    println("Ingrese el Nombre:")
    val nombre = scanner.nextLine()
    println("Ingrese la categoría:")
    val categoria = scanner.nextLine()
    println("Ingrese la Provincia:")
    val provincia = scanner.nextLine()
    println("Ingrese la ciudad:")
    val ciudad = scanner.nextLine()
    println("Ingrese si se encuentra activo: responda si o no:")
    val activo = scanner.nextLine()
    var activo1: String = "a"
    if(activo == "si"){
        activo1 = "true"
    }else{
        activo1 = "false"
    }


    /*val nuevo:ArrayList<String>  = arrayListOf(id,id_equipo,categoria,provincia,ciudad)
    archivo.add(nuevo)
    archivo.forEach {
        fWriter.write("${it},")
    }
    fWriter.close()*/

    try {
        FileWriter(ruta, true).use { fw ->
            BufferedWriter(fw).use { bw ->
                PrintWriter(bw).use { out ->
                    out.print("\n"+"${id},${nombre},${categoria},${provincia},${ciudad},${activo1},")
                }
            }
        }
    } catch (e: IOException) {
        //exception handling left as an exercise for the reader
    }

    deleteLine(ruta,"")
    println("Club creado con exito")

}

fun findPlayer( columna: Int, str:String, archivo: ArrayList<Jugador> ): ArrayList<Jugador> {

    if(columna == 0){
        return (archivo.filter {
            return@filter (it.getId() == str.toInt())
        } as ArrayList<Jugador>)
    }

    if(columna == 1){
        return (archivo.filter {
            return@filter (it.getIdEquipo() == str.toInt())
        } as ArrayList<Jugador>)
    }

    if(columna ==2 ){
        return (archivo.filter {
            return@filter (it.getnombre() == str.toString())
        } as ArrayList<Jugador>)

    }
    if(columna ==3 ){
        val date1 = SimpleDateFormat("dd/MM/yyyy").parse(str)
        return (archivo.filter {
            return@filter (it.getFecha() == date1)
        } as ArrayList<Jugador>)

    }

    if(columna ==4 ){
        return (archivo.filter {
            return@filter (it.getSueldo() == str.toDouble())
        } as ArrayList<Jugador>)

    }

    return (archivo.filter {
        return@filter (it.getCiudad() == str.toString())
    } as ArrayList<Jugador>)

}


fun findClub( columna: Int, str:String, archivo: ArrayList<Club> ): ArrayList<Club> {

    if(columna == 0){
        return (archivo.filter {
            return@filter (it.getId() == str.toInt())
        } as ArrayList<Club>)
    }

    if(columna == 1){
        return (archivo.filter {
            return@filter (it.getnombre() == str.toString())
        } as ArrayList<Club>)
    }

    if(columna ==2 ){
        return (archivo.filter {
            return@filter (it.getCategoria() == str.toString())
        } as ArrayList<Club>)

    }
    if(columna ==3 ){
        return (archivo.filter {
            return@filter (it.getProvincia() == str.toString())
        } as ArrayList<Club>)

    }

    if(columna ==4 ){
        return (archivo.filter {
            return@filter (it.getCiudad() == str.toString())
        } as ArrayList<Club>)

    }

    return (archivo.filter {
        return@filter (it.getActivo() == str.toBoolean())
    } as ArrayList<Club>)

}



fun printPlayer(jugadores: ArrayList<Jugador> ){


    System.out.format("%-12s%-12s%-12s%-20s%-12s%-12s\n", "Id","id_Equipo","Nombre","Fecha_Nacimiento","Sueldo", "Ciudad")
    jugadores.forEach {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        var date2: String? = formatter.format(it.getFecha())
        System.out.format("%-12s%-12s%-12s%-20s%-12s%-12s\n", it.getId(),
            it.getIdEquipo(),it.getnombre(), date2,it.getSueldo(), it.getCiudad())
    }
}


fun printClub(clubes: ArrayList<Club> ){
    System.out.format("%-12s%-12s%-12s%-20s%-12s%-12s\n", "Id","Nombre","Categoría","Provincia","Ciudad", "Activo")
    clubes.forEach {
        System.out.format("%-12s%-12s%-12s%-20s%-12s%-12s\n", it.getId(),it.getnombre(),it.getCategoria(),it.getProvincia(),it.getCiudad(), it.getActivo())
    }
}


fun ReadPlayer(jugador_archivo:String): ArrayList<Jugador> {
    val jugadores = ArrayList<Jugador>()
    val jugador_lista = ReadFile(jugador_archivo)
    var str:String?
    jugador_lista.forEach {
        val date1 = SimpleDateFormat("dd/MM/yyyy").parse(it[3])
        jugadores.add(Jugador(it[0].toInt(), it[1].toInt(), it[2].toString(), date1, it[4].toDouble(), it[5].toString()))
    }
    return jugadores
}

fun ReadClub(club_archivo:String): ArrayList<Club> {
    val clubes = ArrayList<Club>()
    val clubes_lista = ReadFile(club_archivo)
    clubes_lista.forEach {
        clubes.add(Club(it[0].toInt(), it[1].toString(), it[2].toString(), it[3].toString(), it[4].toString(), it[5].toBoolean()))
    }
    return clubes
}

fun ReadFile(nombreArchivo: String):ArrayList<ArrayList<String>> {
    val uno = ArrayList<String>()
    val varios = arrayListOf(ArrayList<String>())
    //val matrix5 = arrayListOf(Array)

    try {
        val myObj = File(nombreArchivo)
        val myReader = Scanner(myObj)
        //myReader.nextLine()
        while (myReader.hasNextLine()) {
            val data: String = myReader.nextLine()
            val st = StringTokenizer(data, ",")
            while (st.hasMoreTokens()) {
                uno.add(st.nextToken())
            }

            varios.add(uno.clone() as ArrayList<String>)
            uno.clear()
        }
        myReader.close()
    } catch (e: FileNotFoundException) {
        println("An error occurred.")
        e.printStackTrace()
    }
    varios.removeAt(0)
    return varios
}


fun deleteLine(file: String?, lineToRemove: String) {
    try {
        val inFile = File(file)
        if (!inFile.isFile) {
            println("Parameter is not an existing file")
            return
        }

        //Construct the new file that will later be renamed to the original filename.
        val tempFile = File(inFile.absolutePath + ".tmp")
        val br = BufferedReader(FileReader(file))
        val pw = PrintWriter(FileWriter(tempFile))
        var line: String? = null

        //Read from the original file and write to the new
        //unless content matches data to be removed.
        while (br.readLine().also { line = it } != null) {
            if (line!!.trim { it <= ' ' } != lineToRemove) {
                pw.println(line)
                pw.flush()
            }
        }
        pw.close()
        br.close()

        //Delete the original file
        if (!inFile.delete()) {
            println("Could not delete file")
            return
        }

        //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(inFile)) println("Could not rename file")
    } catch (ex: FileNotFoundException) {
        ex.printStackTrace()
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
}


fun updateTeam(lista_clubes: ArrayList<Club>, club_archivo: String){
    val scanner = Scanner(System.`in`)
    var id:String?
    var equipo1:String?
    var categoria:String?
    var provincia:String?
    var ciudad:String?
    var activo:String?
    print("Estos son los siguinetes clubes: \n")
    printClub(lista_clubes)
    print("Ingrese el id del club a actualizar: \n")
    val prueba = scanner.nextLine()
    print("Seleccione el parametro a actualizar: \n" +
            "1. Nombre\n" +
            "2. Categoría\n" +
            "3. Provincia\n" +
            "4. Ciudad\n" +
            "5. Activo\n"+
            "En caso de ser activo escriba false o true:\n"+
            "Opción: ")
    val cambio = scanner.nextLine().toInt()
    print("Ingrese la actualización:\n ")
    val nuevo = scanner.nextLine()
    var antiguo:String ="a"
    if(cambio.toString() == "1") {
        lista_clubes.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getnombre().toString()
            it.setNombre(nuevo.toString())

        }
    }

    if(cambio.toString() == "2") {
        lista_clubes.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getCategoria().toString()
            it.setCategoria(nuevo.toString())

        }
    }

    if(cambio.toString() == "3") {
        lista_clubes.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getProvincia().toString()
            it.setProvincia(nuevo.toString())

        }
    }

    if(cambio.toString() == "4") {
        lista_clubes.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getCiudad().toString()
            it.setCiudad(nuevo.toString())

        }
    }

    if(cambio.toString() == "5") {
        lista_clubes.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getActivo().toString()
            it.setActivo(nuevo.toBoolean())

        }
    }


    printClub(lista_clubes)

    val borrar = findClub(0, prueba, lista_clubes)
    borrar.forEach {
        id = it.getId().toString()
        equipo1 = it.getnombre().toString()
        categoria = it.getCategoria()
        provincia = it.getProvincia()
        ciudad = it.getCiudad()
        activo = it.getActivo().toString()

        when(cambio.toString()) {
            "1" -> {
                deleteLine(club_archivo, "${id},${antiguo},${categoria},${provincia},${ciudad},${activo},")
            }
            "2" -> {
                deleteLine(club_archivo, "${id},${equipo1},${antiguo},${provincia},${ciudad},${activo},")
            }

            "3" -> {
                deleteLine(club_archivo, "${id},${equipo1},${categoria},${antiguo},${ciudad},${activo},")
            }

            "4" -> {
                deleteLine(club_archivo, "${id},${equipo1},${categoria},${provincia},${antiguo},${activo},")
            }

            "5" -> {
                deleteLine(club_archivo, "${id},${equipo1},${categoria},${provincia},${ciudad},${antiguo},")
            }
        }
        try {


            FileWriter(club_archivo, true).use { fw ->
                BufferedWriter(fw).use { bw ->
                    PrintWriter(bw).use { out ->
                        out.print("\n"+"${id},${equipo1},${categoria},${provincia},${ciudad},${activo},")
                    }
                }
            }
        } catch (e: IOException) {
            //exception handling left as an exercise for the reader
        }
    }

    deleteLine(club_archivo,"")
}



fun updatePlayer(lista_jugadores: ArrayList<Jugador>, jugador_archivo: String){
    val scanner = Scanner(System.`in`)
    var id:String?
    var id_equipo:String?
    var nombre:String?
    var fecha:String?
    var sueldo:String?
    var ciudad:String?
    print("Estos son los juagadores registrados: \n")
    printPlayer(lista_jugadores)
    print("Ingrese el id del jugador a actualizar: \n")
    val prueba = scanner.nextLine()
    print("Seleccione el parametro a actualizar: \n" +
            "1. id_Equipo\n" +
            "2. Nombre\n" +
            "3. Sueldo\n" +
            "Opción: ")
    val cambio = scanner.nextLine().toInt()
    println("Ingrese la actualización:\n ")
    val nuevo = scanner.nextLine()
    var antiguo:String ="a"
    if(cambio.toString() == "1") {
        lista_jugadores.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getIdEquipo().toString()
            it.setIdEquipo(nuevo.toInt())

        }
    }

    if(cambio.toString() == "2") {
        lista_jugadores.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getnombre().toString()
            it.setNombre(nuevo.toString())

        }
    }

    if(cambio.toString() == "3") {
        lista_jugadores.filter { it.getId() == prueba.toInt() }.forEach {
            antiguo = it.getSueldo().toString()
            it.setSueldo(nuevo.toDouble())
        }


    }

    printPlayer(lista_jugadores)

    val borrar = findPlayer(0, prueba, lista_jugadores)
    borrar.forEach {
        id = it.getId().toString()
        id_equipo = it.getIdEquipo().toString()
        nombre = it.getnombre()
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        var date2: String? = formatter.format(it.getFecha())
        fecha = date2.toString()
        sueldo = it.getSueldo().toString()
        ciudad = it.getCiudad().toString()

        when(cambio.toString()) {
            "1" -> {
                deleteLine(jugador_archivo, "${id},${antiguo},${nombre},${fecha},${sueldo},${ciudad},")
            }
            "2" -> {
                println("${id},${id_equipo},${nombre},${fecha},${antiguo},${ciudad},")
                deleteLine(jugador_archivo, "${id},${id_equipo},${antiguo},${fecha},${sueldo},${ciudad},")
            }

            "3" -> {
                println("${id},${id_equipo},${nombre},${fecha},${antiguo},${ciudad},")
                deleteLine(jugador_archivo, "${id},${id_equipo},${nombre},${fecha},${antiguo},${ciudad},")
            }


        }
        try {


            FileWriter(jugador_archivo, true).use { fw ->
                BufferedWriter(fw).use { bw ->
                    PrintWriter(bw).use { out ->
                        out.print("\n"+"${id},${id_equipo},${nombre},${fecha},${sueldo},${ciudad},")
                    }
                }
            }
        } catch (e: IOException) {
            //exception handling left as an exercise for the reader
        }
    }

    deleteLine(jugador_archivo,"")
}
