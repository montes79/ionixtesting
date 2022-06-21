package montes.luis.mireddit.ui.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import montes.luis.mireddit.databinding.ItemMemeRedditBinding
import montes.luis.mireddit.datos.DatosFiltroChildren

class MemeHolder(private val vista: View) : RecyclerView.ViewHolder(vista) {

    val binding = ItemMemeRedditBinding.bind(vista)


    fun dibujar(heroe: DatosFiltroChildren, onClickFuncion: (DatosFiltroChildren) -> Unit) {
      //  binding.tvSuperhero.text = heroe.nombre
      //  binding.tvRealName.text = heroe.nombreReal
      //  binding.tvPublisher.text = heroe.editorial

      //  Glide.with(binding.tvSuperhero.context).load(heroe.urlFoto).into(binding.ivAvatar)

        itemView.setOnClickListener {
            onClickFuncion(heroe)
        }

    }



}