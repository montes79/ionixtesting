package montes.luis.mireddit.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import montes.luis.mireddit.componente.ComponenteApp
import montes.luis.mireddit.componente.DaggerComponenteApp

@HiltAndroidApp
class Aplicacion : Application(){
    val appComponent: ComponenteApp = DaggerComponenteApp.create()
}

