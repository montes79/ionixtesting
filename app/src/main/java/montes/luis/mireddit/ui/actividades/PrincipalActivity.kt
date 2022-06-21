package montes.luis.mireddit.ui.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import montes.luis.mireddit.R
import montes.luis.mireddit.databinding.ActivityMainBinding
import montes.luis.mireddit.datos.DatosFiltroChildren
import montes.luis.mireddit.ui.adapters.MemeAdaptador
import java.util.ArrayList

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: MemeAdaptador
    private var listaResultados:MutableList<DatosFiltroChildren> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarRecyclerView()
    }


    private fun inicializarRecyclerView(){
       //binding.rvMemesReddit.layoutManager= LinearLayoutManager(this)
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

        adaptador= MemeAdaptador(listaResultados){
            onSeleccionarElemento( it )
        }

        binding.rvMemesReddit.adapter=adaptador

    }



    private fun onSeleccionarElemento(elemento: DatosFiltroChildren){
        Toast.makeText(this, elemento.titulo, Toast.LENGTH_SHORT).show()
    }



}