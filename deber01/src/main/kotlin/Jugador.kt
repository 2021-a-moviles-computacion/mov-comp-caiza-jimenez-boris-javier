import java.util.*

class Jugador(
    private var id: Int? = null,
    private var id_Euipo: Int? = null,
    private var nombre: String? = null,
    private var fecha_nacimiento:Date? = null,
    private var sueldo: Double? = null,
    private var ciudad: String? = null,
) {
    init { //Bloque de inicio del constructor Primario.

    }

    fun getFecha(): Date? {
        return fecha_nacimiento
    }

    // Setter
    fun setFecha(c: Date) {
        this.fecha_nacimiento = c
    }




    fun getCiudad(): String? {
        return ciudad
    }

    // Setter
    fun setCiudad(c: String) {
        this.ciudad = c
    }

    fun getSueldo(): Double? {
        return sueldo
    }

    // Setter
    fun setSueldo(c: Double) {
        this.sueldo = c
    }



    fun getIdEquipo(): Int? {
        return id_Euipo
    }

    // Setter
    fun setIdEquipo(c: Int) {
        this.id_Euipo = c
    }



    fun getnombre(): String? {
        return nombre
    }

    // Setter
    fun setNombre(nombre: String) {
        this.nombre = nombre
    }



    fun getId(): Int? {
        return id
    }

    // Setter
    fun setId(c: Int) {
        this.id = c
    }

    override fun toString(): String {
        return "[$id,$id_Euipo,$nombre,$sueldo,$ciudad]"
    }


}

