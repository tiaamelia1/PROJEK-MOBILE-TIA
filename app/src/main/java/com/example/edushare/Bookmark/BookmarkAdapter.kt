
package com.example.edushare.Bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edushare.Search.MateriModel
import com.example.edushare.databinding.ItemBookmarkBinding

class BookmarkAdapter(
    private val dataBookmark: List<MateriModel>,
    private val onItemClick: (MateriModel) -> Unit
) : RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    inner class BookmarkViewHolder(
        val binding: ItemBookmarkBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {

        val binding = ItemBookmarkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return BookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BookmarkViewHolder,
        position: Int
    ) {

        val materi = dataBookmark[position]

        with(holder.binding) {
            txtJudul.text = materi.judul
            txtMataKuliah.text = materi.mataKuliah
            txtSemester.text = materi.semester
            txtRating.text = "★ ${materi.rating}"
            txtTipe.text = materi.tipe

            root.setOnClickListener {
                onItemClick(materi)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataBookmark.size
    }
}
