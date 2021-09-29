package com.example.android.primerparcial.ui.productoList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.primerparcial.R
import com.example.android.primerparcial.adapters.productoAdapter
import com.example.android.primerparcial.databinding.ProductoListFragmentBinding

class productoListFragment : Fragment() {

    companion object {
        fun newInstance() = productoListFragment()
    }
    private var _binding: ProductoListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: productoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProductoListFragmentBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, productoListViewModel.Factory(requireActivity().application))
                .get(productoListViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listaRecyclerView.adapter = productoAdapter()
        val adapter = binding.listaRecyclerView.adapter as productoAdapter

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}