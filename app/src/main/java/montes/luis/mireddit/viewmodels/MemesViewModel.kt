package montes.luis.mireddit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import montes.luis.mireddit.dominio.CasoUsoFiltro100
import montes.luis.mireddit.dominio.CasoUsoFiltroBusqueda
import montes.luis.mireddit.modelo.DatosFiltroChildren
import montes.luis.mireddit.modelo.RespuestaReddit
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MemesViewModel @Inject constructor(
    private val getCasoFiltro: CasoUsoFiltro100,
    private val getCasoBusqueda: CasoUsoFiltroBusqueda
) : ViewModel() {

    val listaMemes = MutableLiveData<Response<RespuestaReddit>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onInicializar(cantidad:Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val resultado = getCasoFiltro(cantidad)
            if(!resultado.isSuccessful){
                listaMemes.postValue(resultado)
                isLoading.postValue(false)
            }
        }
    }



      fun busquedaCampo(cadenaBusqueda:String,cantidad:Int) {
          viewModelScope.launch {
              isLoading.postValue(true)
              val resultado = getCasoBusqueda(cadenaBusqueda, cantidad)
              if(!resultado.isSuccessful) {
                  listaMemes.postValue(resultado)
                  isLoading.postValue(false)
              }
          }
      }

}
