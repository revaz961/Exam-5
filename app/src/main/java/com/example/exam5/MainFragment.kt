package com.example.exam5

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.exam5.databinding.FragmentMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import org.json.JSONArray


class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private var adapter: FieldsGroupAdapter? = null
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(binding==null){
            binding = FragmentMainBinding.inflate(inflater,container,false)
            init()
        }
        return binding!!.root
    }

    private fun init(){
        adapter = FieldsGroupAdapter()
        binding!!.rvFieldsGroup.adapter = adapter

        mainViewModel.mainLiveData.observe(viewLifecycleOwner,{
            adapter!!.setData(it)
        })
    }



}