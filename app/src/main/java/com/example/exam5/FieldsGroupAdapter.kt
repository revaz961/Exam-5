package com.example.exam5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.databinding.FieldsLayoutBinding

class FieldsGroupAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var fieldsGrop = mutableListOf<MutableList<Field>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            FieldsLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(items:MutableList<MutableList<Field>>){
        fieldsGrop = items
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = fieldsGrop.size

    inner class ViewHolder(private var binding: FieldsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.rvFields.adapter = FieldsAdapter(fieldsGrop[adapterPosition])
        }
    }
}