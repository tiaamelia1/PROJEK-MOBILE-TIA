
package com.example.edushare.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.edushare.DetailActivity
import com.example.edushare.LoginActivity
import com.example.edushare.R
import com.example.edushare.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
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

        // HEADER EDUSHARE
        binding.txtLogo.text = "EduShare"
        binding.txtSubtitle.text = "Berbagi Ilmu, Tumbuh Bersama"

        // SHARED PREFERENCES
        val sharedPref = requireContext().getSharedPreferences(
            "user_pref",
            AppCompatActivity.MODE_PRIVATE
        )

        val user = sharedPref.getString("username", "")

        // TOMBOL DETAIL
        binding.btnDetail.setOnClickListener {
            val intent = Intent(
                requireContext(),
                DetailActivity::class.java
            )
            startActivity(intent)
        }

        // TOMBOL LOGOUT
        binding.btnLogOut.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Yakin mau keluar?")
                .setMessage("Udah hapal password kan?")
                .setPositiveButton("Iyaa") { _, _ ->

                    sharedPref.edit()
                        .clear()
                        .apply()

                    val intent = Intent(
                        requireContext(),
                        LoginActivity::class.java
                    )

                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }
                .setNegativeButton("Gk jadi dehh", null)
                .show()
        }
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(
        item: MenuItem
    ): Boolean {

        return when (item.itemId) {

            R.id.action_search -> {
                Toast.makeText(
                    requireContext(),
                    "Search Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(
                    requireContext(),
                    "Settings Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
