package com.example.exam5

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.databinding.ChooserLayoutBinding
import com.example.exam5.databinding.FieldsLayoutBinding
import com.example.exam5.databinding.InputLayoutBinding

class FieldsAdapter(private var fields: MutableList<Field>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var INPUT_TYPE = 1
    private val CHOOSER_TYPE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            INPUT_TYPE -> {
                InputViewHolder(
                    InputLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> { ChooserViewHolder(
                ChooserLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )}
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InputViewHolder -> holder.bind()
            is ChooserViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = fields.size

    override fun getItemViewType(position: Int): Int {
        return if (fields[position].fieldType == "input") INPUT_TYPE else CHOOSER_TYPE
    }

    inner class InputViewHolder(private var binding: InputLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.etInput.setHint(fields[adapterPosition].hint)
        }
    }

    inner class ChooserViewHolder(private var binding: ChooserLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.etChooser.setHint(fields[adapterPosition].hint)
        }
    }
}