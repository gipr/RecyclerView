package com.acmadgilangpratama.jenissayuranyangadadiindonesia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.acmadgilangpratama.jenissayuranyangadadiindonesia.databinding.ListItemSayuranBinding
import com.acmadgilangpratama.jenissayuranyangadadiindonesia.model.Sayuran

class AdapterSayuran (private val context: Context,
                      private var data : List<Sayuran>?,
                      private val itemclick : OnClickListener)
    : RecyclerView.Adapter<AdapterSayuran.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemSayuranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }
    override fun getItemCount(): Int = data?.size ?:0

    inner class ViewHolder( val binding: ListItemSayuranBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }
    interface OnClickListener {
        fun detailData(item : Sayuran?)
    }
}
