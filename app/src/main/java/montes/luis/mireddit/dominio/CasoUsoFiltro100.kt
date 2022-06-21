package montes.luis.mireddit.dominio

import montes.luis.mireddit.modelo.RespuestaReddit
import montes.luis.mireddit.modelo.repositorio.MemesRepositorio
import retrofit2.Response
import javax.inject.Inject

class CasoUsoFiltro100 @Inject constructor(
    private val repositorio: MemesRepositorio
){

    suspend operator fun invoke(numeroFiltro:Int): Response<RespuestaReddit> = repositorio.getListado100(numeroFiltro )

}

