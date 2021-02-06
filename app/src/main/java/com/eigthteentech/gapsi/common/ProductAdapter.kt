package com.eigthteentech.gapsi.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eigthteentech.gapsi.databinding.ProductItemBinding
import com.eigthteentech.gapsi.entities.ProductEntity

class ProductAdapter(private val list:List<ProductEntity> ):
    RecyclerView.Adapter<ProductAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(ProductItemBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class VH(private val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(productEntity: ProductEntity){
            binding.textView.text = productEntity.title
            binding.textView2.text = "$${productEntity.price}"
            Glide.with(binding.imageView).load(productEntity.image).into(binding.imageView)
        }
    }
}