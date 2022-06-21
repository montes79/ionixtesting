package montes.luis.mireddit.componente

import dagger.Component
import montes.luis.mireddit.modulos.ModuloRed
import montes.luis.mireddit.ui.actividades.PrincipalActivity
import montes.luis.mireddit.viewmodels.MemesViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuloRed::class])
interface ComponenteApp {

    fun inject(actividadPrincipal: PrincipalActivity)
    fun inject(miviewModel: MemesViewModel)

}

