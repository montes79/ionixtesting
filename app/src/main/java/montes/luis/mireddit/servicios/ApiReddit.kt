package montes.luis.mireddit.servicios

import montes.luis.mireddit.modelo.RespuestaReddit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiReddit {

    // https://www.reddit.com/r/chile/new/.json?limit=100
    @GET(".json?")  //DatosFiltroChildren RespuestaReddit
    suspend fun getListado100Resultados(@Query("limit") limite:Int): Response<RespuestaReddit>


    // - https://www.reddit.com/r/chile/search.json?q=(búsqueda)&limit=1000
    @GET("search.json?")  //DatosFiltroChildren RespuestaReddit
    suspend fun getListadoBusqueda(@Query("q") busqueda:String , @Query("limit") limite:Int): Response<RespuestaReddit>

}