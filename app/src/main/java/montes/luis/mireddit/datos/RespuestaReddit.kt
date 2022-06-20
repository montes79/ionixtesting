package montes.luis.mireddit.datos

import com.google.gson.annotations.SerializedName

data class RespuestaReddit(
    @SerializedName("kind")
     val tipo:String,
    @SerializedName("data")
    val datos: Datos

)


data class Datos(
    @SerializedName("children")
    val hijos:ArrayList<DatosFiltroChildren> = ArrayList()
)

data class DatosFiltroChildren(
    @SerializedName("link_flair_text") //==>Shitposting
    val categoria1:String="",
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
