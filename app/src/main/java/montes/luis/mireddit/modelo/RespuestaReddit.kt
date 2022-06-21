package montes.luis.mireddit.modelo

import com.google.gson.annotations.SerializedName

data class RespuestaReddit(
    @SerializedName("kind")
     val tipo:String,
    @SerializedName("data")
    val datos: Datos

)


data class Datos(
    @SerializedName("children")
    val datosHijos:ArrayList<DatosChildren> = ArrayList()
)

data class DatosChildren(
    @SerializedName("data")
    val hijos:DatosFiltroChildren
)


data class DatosFiltroChildren(
    //	"link_flair_text": "Shitposting",
    @SerializedName("link_flair_text")
    val categoria1:String="",

    //"post_hint": "image",
    @SerializedName("post_hint") // ==> image
    val categoria2:String="",

    @SerializedName("title")
    val titulo:String="",
    @SerializedName("thumbnail")
    val urlImagen:String="",
    @SerializedName("score")
    val puntaje:Int=0,
    @SerializedName("num_comments")
    val numeroComentarios:Int=0
)
