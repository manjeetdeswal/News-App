package com.mddstudio.kotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Myadapter(val context:Context,val articles:List<Article>):RecyclerView.Adapter<Myadapter.Myviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return Myviewholder(view)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val articels=articles[position]
        holder.txtTitle.text=articels.title
        holder.txtBody.text=articels.description
        Glide.with(context).load(articels.urlToImage).into(holder.imageview)
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent=Intent(context,Details::class.java)
            intent.putExtra("url",articels.url)
            context.startActivity(intent)
        })


    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class Myviewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageview=itemView.findViewById<ImageView>(R.id.imgVIew);
        val txtTitle=itemView.findViewById<TextView>(R.id.title);
        val txtBody=itemView.findViewById<TextView>(R.id.body);

    }
}