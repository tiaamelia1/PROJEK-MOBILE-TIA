package com.example.edushare.Profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.edushare.LoginActivity
import com.example.edushare.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(
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

        // Toolbar
        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.apply {
                title = "Profil"
                subtitle = "Akun EduShare"
            }

        // Ambil data login
        val sharedPref = requireContext()
            .getSharedPreferences(
                "user_pref",
                AppCompatActivity.MODE_PRIVATE
            )

        val username = sharedPref
            .getString("username", "")

        // Tampilkan username
        binding.txtUsername.text = username

        // Tombol Logout
        binding.btnLogout.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Tombol Logout berhasil diklik",
                Toast.LENGTH_SHORT
            ).show()

            AlertDialog.Builder(requireContext())
                .setTitle("Yakin mau keluar?")
                .setMessage("Udah hapal password kan?")

                .setPositiveButton("Iyaa") { _, _ ->

                    // Hapus data login
                    sharedPref
                        .edit()
                        .clear()
                        .apply()

                    // Kembali ke Login
                    val intent = Intent(
                        requireContext(),
                        LoginActivity::class.java
                    )

                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }

                .setNegativeButton(
                    "Gk jadi dehh",
                    null
                )

                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}