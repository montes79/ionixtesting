package montes.luis.mireddit.modelo.repositorio

import montes.luis.mireddit.modelo.MemesProveedor
import montes.luis.mireddit.modelo.RespuestaReddit
import montes.luis.mireddit.servicios.servicioReddit
import retrofit2.Response
import javax.inject.Inject

class MemesRepositorio @Inject constructor(
    private val api:servicioReddit,
    private val proveedor:MemesProveedor
){

    //DatosFiltroChildren RespuestaReddit
    suspend fun getListado100(numeroFiltro:Int): Response<RespuestaReddit> {
        val respuesta=api.getListado100Resultados(numeroFiltro)
        proveedor.listaMemes= respuesta.body()?.datos?.hijos?: mutableListOf()
        return respuesta
    }
}
