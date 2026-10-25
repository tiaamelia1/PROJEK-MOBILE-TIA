package com.example.edushare.Bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.edushare.Search.MateriAdapter
import com.example.edushare.Search.MateriModel
import com.example.edushare.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private val dataBookmark = listOf(

        MateriModel(
            "Rangkuman Pemrograman Web",
            "Teknik Informatika",
            "Semester 3",
            "4.8",
            "WEB"
        ),

        MateriModel(
            "Catatan Basis Data",
            "Teknik Informatika",
            "Semester 4",
            "4.6",
            "DB"
        ),

        MateriModel(
            "Latihan Soal Struktur Data",
            "Teknik Informatika",
            "Semester 3",
            "4.7",
            "SD"
        ),

        MateriModel(
            "Materi Jaringan Komputer",
            "Teknik Informatika",
            "Semester 4",
            "4.5",
            "JK"
        ),

        MateriModel(
            "Rangkuman Algoritma & Pemrograman",
            "Teknik Informatika",
            "Semester 4",
            "4.4",
            "AL"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBookmarkBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MateriAdapter(
            requireContext(),
            dataBookmark
        )

        binding.listBookmark.adapter = adapter

        binding.txtJumlah.text =
            "${dataBookmark.size} materi"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}