package montes.luis.mireddit.servicios

import montes.luis.mireddit.modelo.RespuestaReddit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface servicioReddit {
// https://www.reddit.com/r/chile/new/.json?limit=1000


    @GET(".json?")
    suspend fun getListado100Resultados(@Query("limit") limite:Int): Response<RespuestaReddit> //suspend para que  pueda llamar Corutinas

    // - https://www.reddit.com/r/chile/search.json?q=(búsqueda)&limit=1000

    suspend fun getListadoBusqueda(@Query("limit") limite:Int): Response<RespuestaReddit> //suspend para que

}