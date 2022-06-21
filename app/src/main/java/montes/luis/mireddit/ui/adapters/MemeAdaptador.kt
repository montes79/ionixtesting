package montes.luis.mireddit.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import montes.luis.mireddit.R
import montes.luis.mireddit.modelo.DatosFiltroChildren
import montes.luis.mireddit.ui.holders.MemeHolder

class MemeAdaptador(
    private val listaMemes: List<DatosFiltroChildren>,
    private val onClickFuncion: (DatosFiltroChildren) -> Unit  //Lambda function
) : RecyclerView.Adapter<MemeHolder>() {

    override fun onCreateViewHolder(padre: ViewGroup, viewType: Int): MemeHolder {
        val layoutInflater = LayoutInflater.from(padre.context)
        val vista =   layoutInflater.inflate(
            R.layout.item_meme_reddit,
            padre,
            false
        )
        return MemeHolder(vista)

    }


    override fun onBindViewHolder(vistaHolder: MemeHolder, posicion: Int) {
        val item = listaMemes[posicion]
        vistaHolder.dibujar(item,onClickFuncion)
    }



    override fun getItemCount(): Int = listaMemes.size

}