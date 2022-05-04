package com.test.adiblaruz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.test.adiblaruz.Adapters.RvAdibAdapter
import com.test.adiblaruz.Models.Adib
import com.test.adiblaruz.Utils.InternetData
import com.test.adiblaruz.databinding.FragmentSearchAdibBinding
import java.util.*
import kotlin.collections.ArrayList

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchAdibFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentSearchAdibBinding
    lateinit var rvAdibAdapter: RvAdibAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchAdibBinding.inflate(layoutInflater)

        binding.searchAdib.setQuery("",true);
        binding.searchAdib.setFocusable(true);
        binding.searchAdib.setIconified(false);
        binding.searchAdib.requestFocusFromTouch();

        rvAdibAdapter = RvAdibAdapter(context, InternetData.list, object : RvAdibAdapter.RvClick{
            override fun onCLick(adib: Adib) {
                findNavController().navigate(R.id.adibInfoFragment, bundleOf("keyAdib" to adib, "keyInt" to 1))
            }
        })
        binding.rvSearch.adapter = rvAdibAdapter

        binding.searchAdib.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                var list = ArrayList<Adib>()
                for (adib in InternetData.list) {
                    for (i in 0 until adib.nameAndLastName?.length!!){
                        if (adib.nameAndLastName?.subSequence(0, i).toString()
                                .lowercase(Locale.getDefault()) == p0?.toLowerCase()){
                            list.add(adib)
                        }
                    }
                }
                rvAdibAdapter = RvAdibAdapter(context, list, object : RvAdibAdapter.RvClick{
                    override fun onCLick(adib: Adib) {
                        findNavController().navigate(R.id.adibInfoFragment, bundleOf("keyAdib" to adib, "keyInt" to 1))
                    }
                })
                binding.rvSearch.adapter= rvAdibAdapter
                return true
            }
        })

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchAdibFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}