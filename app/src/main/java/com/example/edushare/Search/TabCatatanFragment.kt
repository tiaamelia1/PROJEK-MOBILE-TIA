
package com.example.edushare.Search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.edushare.databinding.FragmentTabCatatanBinding

class TabCatatanFragment : Fragment() {

    private var _binding: FragmentTabCatatanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabCatatanBinding.inflate(
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

        val dataMateri = listOf(
            MateriModel(
                "Catatan Basis Data",
                "Teknik Informatika",
                "Semester 4",
                "4.6",
                "DB"
            ),
            MateriModel(
                "Materi Jaringan Komputer",
                "Teknik Informatika",
                "Semester 4",
                "4.5",
                "JK"
            )
        )

        val adapter = MateriAdapter(
            requireContext(),
            dataMateri
        )

        binding.listMateri.adapter = adapter

        binding.listMateri.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(),
                dataMateri[position].judul,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
