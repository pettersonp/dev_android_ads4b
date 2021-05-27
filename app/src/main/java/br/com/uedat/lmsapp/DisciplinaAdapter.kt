package br.com.uedat.lmsapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DisciplinaAdapter(val disciplinas: List<Disciplina>, val onClick: (Disciplina) -> Unit ):RecyclerView.Adapter<DisciplinaAdapter.DisciplinasViewHolder>() {
    class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView
        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_disciplinas)
        }

    }

    override fun getItemCount() = this.disciplinas.size

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): DisciplinasViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_disciplina, parent, false)

        val holder = DisciplinasViewHolder(view)
        return holder

    }

    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val disciplina = disciplinas[position]


        holder.cardNome.text = disciplina.nome
        holder.cardProgress.visibility = View.VISIBLE
        val context = holder.itemView.context
        Picasso.with(context).load(disciplina.foto).fit().into(holder.cardImage, object: com.squareup.picasso.Callback{
            override fun onSuccess() {
                holder.cardProgress.visibility = View.GONE
            }

            override fun onError() {
                holder.cardImage.setImageResource(R.drawable.test)
                holder.cardProgress.visibility = View.GONE

            }
        })


    }





}
