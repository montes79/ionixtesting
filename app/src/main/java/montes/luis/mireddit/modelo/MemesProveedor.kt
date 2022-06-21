package montes.luis.mireddit.modelo

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemesProveedor @Inject constructor()  {

    var listaMemes:MutableList<DatosFiltroChildren> = mutableListOf()

}

