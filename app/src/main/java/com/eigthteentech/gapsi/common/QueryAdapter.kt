package com.eigthteentech.gapsi.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eigthteentech.gapsi.databinding.QueryItemBinding
import com.eigthteentech.gapsi.entities.QueryEntity

class QueryAdapter(private val list:List<QueryEntity>, private val listener:QueryListener ) :
RecyclerView.Adapter<QueryAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(QueryItemBinding.inflate( LayoutInflater.from(parent.context), parent, false), listener)

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position].name!!)
    }

    override fun getItemCount() = list.size

    inner class VH(private val binding: QueryItemBinding, private val listener:QueryListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(query: String){
            binding.textView3.text = query
            binding.textView3.setOnClickListener {
                listener.onClicked(query)
            }
        }
    }

    interface QueryListener{
        fun onClicked(name:String)
    }
}