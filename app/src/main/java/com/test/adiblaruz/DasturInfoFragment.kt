package com.test.adiblaruz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.adiblaruz.databinding.FragmentDasturInfoBinding

class DasturInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    lateinit var binding: FragmentDasturInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDasturInfoBinding.inflate(layoutInflater)

        binding.phone.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode("+998993063234")))
            startActivity(intent)
        }

        binding.telegram.setOnClickListener{
            val url = "https://t.me/muhammadumar_developer"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.instagram.setOnClickListener{
            val url = "https://www.instagram.com/muhammadumar_0902/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.codial.setOnClickListener{
            val url = "https://t.me/codialuz"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        return binding.root
    }
}