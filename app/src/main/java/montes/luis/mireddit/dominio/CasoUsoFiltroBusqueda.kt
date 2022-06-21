package montes.luis.mireddit.dominio

import montes.luis.mireddit.modelo.RespuestaReddit
import montes.luis.mireddit.modelo.repositorio.MemesRepositorio
import retrofit2.Response
import javax.inject.Inject

class CasoUsoFiltroBusqueda @Inject constructor (private val repositorio: MemesRepositorio) {

    suspend operator fun invoke(cadenaBusqueda:String, numeroFiltro:Int): Response<RespuestaReddit> = repositorio.getListadoBusqueda(cadenaBusqueda,numeroFiltro )

}
