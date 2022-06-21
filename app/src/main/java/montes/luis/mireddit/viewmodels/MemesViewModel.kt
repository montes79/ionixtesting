package montes.luis.mireddit.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import montes.luis.mireddit.dominio.CasoUsoFiltro100
import montes.luis.mireddit.dominio.CasoUsoFiltroBusqueda
import montes.luis.mireddit.modelo.DatosFiltroChildren
import javax.inject.Inject

@HiltViewModel
class MemesViewModel @Inject constructor(
    private val getCasoFiltro: CasoUsoFiltro100,
    private val getCasoBusqueda:CasoUsoFiltroBusqueda
) : ViewModel() {

    val listaMemes = MutableLiveData<ArrayList<DatosFiltroChildren>>()
    val isLoading = MutableLiveData<Boolean>()

    fun OnInicializar(cantidad:Int) {

        viewModelScope.launch {
            isLoading.postValue(true)
            val resultado = getCasoFiltro(cantidad)
            if(!resultado.isSuccessful){
                listaMemes.postValue(resultado.body()?.datos?.hijos ?: arrayListOf())
                isLoading.postValue(false)
            }
        }

    }


}
