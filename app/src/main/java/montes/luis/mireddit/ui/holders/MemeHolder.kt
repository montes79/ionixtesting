package montes.luis.mireddit.ui.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import montes.luis.mireddit.R
import montes.luis.mireddit.databinding.ItemMemeRedditBinding
import montes.luis.mireddit.datos.DatosFiltroChildren

class MemeHolder(private val vista: View) : RecyclerView.ViewHolder(vista) {

    private val binding = ItemMemeRedditBinding.bind(vista)

    fun dibujar(ElMeme: DatosFiltroChildren, onClickFuncion: (DatosFiltroChildren) -> Unit) {
        binding.tvTitulo.text=ElMeme.titulo
        binding.tvPuntaje.text=itemView.context.getString(R.string.valor_votacion,ElMeme.puntaje.toString())
        binding.tvComentarios.text=itemView.context.getString(R.string.valor_comentarios,ElMeme.numeroComentarios.toString())
       Glide.with(binding.imagenMeme.context).load(ElMeme.urlImagen).into(binding.imagenMeme)

        itemView.setOnClickListener {
            onClickFuncion(ElMeme)
        }

    }



}