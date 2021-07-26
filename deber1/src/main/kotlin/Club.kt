class Club(
    private var id: Int? = null,
    private var nombre: String? = null,
    private var categoria: String? = null,
    private var provincia:String? = null,
    private var ciudad: String? = null,
    private var activo: Boolean? = null,
) {
    init { //Bloque de inicio del constructor Primario.

    }

    fun getCategoria(): String? {
        return categoria
    }

    // Setter
    fun setCategoria(c: String) {
        this.categoria = c
    }


    fun getProvincia(): String? {
        return provincia
    }

    // Setter
    fun setProvincia(c: String) {
        this.provincia = c
    }





    fun getCiudad(): String? {
        return ciudad
    }

    // Setter
    fun setCiudad(c: String) {
        this.ciudad = c
    }

    fun getActivo(): Boolean? {
        return activo
    }

    fun setActivo(c:Boolean){
        this.activo = c
    }
    // Setter
    fun setSueldo(c: Boolean) {
        this.activo = activo
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

    /* override fun toString(): String {
         return "[$id,$id_Euipo,$nombre,$sueldo,$ciudad]"
     }*/


}
