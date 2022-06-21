package montes.luis.mireddit.modelo.proveedor

import montes.luis.mireddit.modelo.DatosChildren
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemesProveedor @Inject constructor()  {

    var listaMemes:MutableList<DatosChildren> = mutableListOf()

}

