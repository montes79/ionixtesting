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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializarRecyclerView()
    }


    private fun inicializarRecyclerView(){
       binding.rvMemesReddit.layoutManager= LinearLayoutManager(this)

        val listaResultados:MutableList<DatosFiltroChildren> = mutableListOf()

        binding.rvMemesReddit.adapter=MemeAdaptador(listaResultados) {
            onSeleccionarElemento( it )
        }

    }


    private fun onSeleccionarElemento(elemento: DatosFiltroChildren){
        Toast.makeText(this, elemento.titulo, Toast.LENGTH_SHORT).show()

    }



}