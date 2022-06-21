package montes.luis.mireddit.ui.actividades

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint

import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer

import montes.luis.mireddit.databinding.ActivityMainBinding
import montes.luis.mireddit.modelo.DatosFiltroChildren
import montes.luis.mireddit.ui.adapters.MemeAdaptador
import montes.luis.mireddit.utilidades.Constantes
import montes.luis.mireddit.viewmodels.MemesViewModel

@AndroidEntryPoint
class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val memesViewModel: MemesViewModel by viewModels()
    private lateinit var adaptador: MemeAdaptador
    private var listaResultados:ArrayList<DatosFiltroChildren> = arrayListOf()
    private var listaFiltrada100:MutableList<DatosFiltroChildren> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarRecyclerView()
        llamadaRecuperar100Registros()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun actualizarRecyclerView100Elementos(){
        adaptador.listaMemes.clear()
        adaptador.listaMemes.addAll(listaFiltrada100)
        adaptador.notifyDataSetChanged()
    }


    private fun llamadaRecuperar100Registros(){

        memesViewModel.onInicializar(Constantes.limiteBusqueda)

        memesViewModel.listaMemes.observe(this, Observer {
            respuesta->
            val listaFiltrada=respuesta.body()?.datos?.hijos?.filter { it.categoria1==Constantes.filtro_link_flair_text && it.categoria2==Constantes.filtro_post_hint }

            listaFiltrada100= listaFiltrada?.toMutableList() ?: mutableListOf()
            actualizarRecyclerView100Elementos( )

        })

        memesViewModel.isLoading.observe(this, Observer {
            isVisible->
            binding.barraProgreso.isVisible=isVisible
        })



    }

    private fun inicializarRecyclerView(){
        crearListaDummy()

        adaptador= MemeAdaptador(listaResultados){
            onSeleccionarElemento( it )
        }

        binding.rvMemesReddit.adapter=adaptador
    }



    private fun onSeleccionarElemento(elemento: DatosFiltroChildren){
        Toast.makeText(this, elemento.titulo, Toast.LENGTH_SHORT).show()
    }


    private fun crearListaDummy(){
        val urlImagenDefault="https://b.thumbs.redditmedia.com/gskdoafF01sJavrTVRCgfwIY-dNBE_jfRayctFiASKQ.jpg"

        listaResultados.add(
            DatosFiltroChildren(categoria1 = "Shitposting", categoria2 = "image", titulo = "Primer titulo del meme 01", urlImagen = urlImagenDefault, puntaje = 5, numeroComentarios = 50)
        )

        listaResultados.add(
            DatosFiltroChildren(categoria1 = "Shitposting", categoria2 = "image", titulo = "Segundo titulo del meme 02", urlImagen = urlImagenDefault, puntaje = 10, numeroComentarios = 100)
        )

        listaResultados.add(
            DatosFiltroChildren(categoria1 = "Shitposting", categoria2 = "image", titulo = "Tercer titulo del meme 03", urlImagen = urlImagenDefault, puntaje = 25, numeroComentarios = 75)
        )


    }


}