package montes.luis.mireddit.modelo.repositorio

import montes.luis.mireddit.modelo.proveedor.MemesProveedor
import montes.luis.mireddit.modelo.RespuestaReddit
import retrofit2.Response
import montes.luis.mireddit.servicios.MemeServicio
import javax.inject.Inject

class MemesRepositorio @Inject constructor(
    private val api: MemeServicio,
    private val proveedor: MemesProveedor
){

    suspend fun getListado100(numeroFiltro:Int): Response<RespuestaReddit> {
        val respuesta=api.getListadoMemesFiltro100(numeroFiltro)
        val lista1=respuesta.body()?.datos?.datosHijos
        proveedor.listaMemes= lista1?: mutableListOf()
        return respuesta
    }

    suspend fun getListadoBusqueda(cadenaBusqueda:String, numeroFiltro:Int): Response<RespuestaReddit> {
        val respuesta=api.getListadoMemesBusqueda(cadenaBusqueda,numeroFiltro)
        val lista1=respuesta.body()?.datos?.datosHijos
        proveedor.listaMemes= lista1?: mutableListOf()
        return respuesta
    }



}
