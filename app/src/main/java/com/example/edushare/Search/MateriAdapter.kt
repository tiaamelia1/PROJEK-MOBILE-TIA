package com.example.edushare.Search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.edushare.databinding.ItemMateriBinding

class MateriAdapter(
    private val context: Context,
    private val data: List<MateriModel>
) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        val binding = ItemMateriBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        val materi = data[position]

        binding.txtJudul.text = materi.judul

        binding.txtInfo.text =
            "${materi.mataKuliah} • ${materi.semester}"

        binding.txtRating.text =
            "★ ${materi.rating}"

        binding.txtIcon.text =
            materi.tipe.take(2).uppercase()

        return binding.root
    }
}