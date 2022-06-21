package montes.luis.mireddit.servicios

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import montes.luis.mireddit.modelo.RespuestaReddit
import javax.inject.Inject
import retrofit2.Response

class MemeServicio @Inject constructor(private val api:ApiReddit) {


    suspend fun getListadoMemesFiltro100(cantidad:Int):Response<RespuestaReddit>{
        return withContext(Dispatchers.IO) {
            val respuesta = api.getListado100Resultados(cantidad)
            respuesta
        }

    }


    suspend fun getListadoMemesBusqueda(busqueda:String, cantidad:Int):Response<RespuestaReddit>{
        return withContext(Dispatchers.IO) {
            val respuesta = api.getListadoBusqueda(busqueda,cantidad)
            respuesta
        }

    }



}

