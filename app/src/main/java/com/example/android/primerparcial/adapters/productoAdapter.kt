package com.example.android.primerparcial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.primerparcial.databinding.ProductoRowBinding
import com.example.android.primerparcial.model.producto

class productoAdapter : RecyclerView.Adapter<productoAdapter.ProductoViewHolder>() {
    private var ProductoList = emptyList<producto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ProductoRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(ProductoList[position])
    }

    override fun getItemCount(): Int {
        return ProductoList.size
    }

    fun submitList(list: List<producto>)
    {
        ProductoList = list
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(private val binding: ProductoRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: producto) {
            binding.productoIdTextView.text = item.ProductoId.toString()
            binding.descripcionTextView.text = item.Descripcion
            binding.existenciaTextView.text = item.Existencia.toString()
            binding.costoTextView.text = item.Costo.toString()
            binding.valorInventarioTextView.text = item.ValorInventario.toString()
        }
    }
}