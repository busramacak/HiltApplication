package com.bmprj.hiltapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private val kripto : List<Kripto>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(index: Kripto){
            Glide.with(itemView.context)
                .load(index.img).dontAnimate()
                .into(itemView.findViewById(R.id.image))
            itemView.findViewById<TextView>(R.id.kripto).text =  index.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bind(kripto[position])
    }

    override fun getItemCount() = kripto.size
}