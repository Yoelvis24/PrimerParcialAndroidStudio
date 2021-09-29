package com.example.android.primerparcial.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.primerparcial.R
import com.example.android.primerparcial.databinding.ProductoEditViewFragmentBinding
import java.lang.reflect.Array.get
import com.example.android.primerparcial.*
import com.example.android.primerparcial.model.producto
import com.example.android.primerparcial.utils.*
import com.google.android.material.snackbar.Snackbar

class productoEditViewFragment : Fragment() {

    companion object {
        fun newInstance() = productoEditViewFragment()
    }

    private lateinit var viewModel: productoEditViewModel
    private lateinit var binding: ProductoEditViewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductoEditViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, productoEditViewModel.Factory(requireActivity().application))
        .get(productoEditViewModel::class.java)

        binding.guardarButton.setOnClickListener{
            if(!Validar()){
                it.showMessage("Verifique los errores para continuar")
            }else{
                if(binding.productoIdTextInputEditText.text?.isNotEmpty() == true)
                {
                    if(viewModel.Find(AtraparId()) != null)
                    {
                        viewModel.Update(LlenaActualizar())
                        it.showMessage("El producto se ha actualizado")
                    }
                }
                else
                {
                    viewModel.Insert(LlenaClase())
                    it.showMessage("Producto guardado")
                }
                Limpiar()
            }
        }

        binding.nuevoButton.setOnClickListener{
            Limpiar()
        }

        binding.eliminarButton.setOnClickListener{
            viewModel.Delete(AtraparId())
            it.showMessage("El producto se ha eliminado")
            Limpiar();
        }
    }

    fun Limpiar(){
        return findNavController().navigate(R.id.productoEditViewFragment)
    }

    fun Validar() : Boolean{
        var esValido = true;

        //binding.productoIdTextInputEditText.
        binding.descripcionTextInputEditText.let {
            if (it.text.isNullOrEmpty()) {
                it.error = "Debe introducir una descripción válida"
                esValido = false
            }else
                it.error = null
        }

        binding.existenciaTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir la cantidad del producto"
                esValido = false
            } else
            it.error = null
        }

        binding.costosTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir un costo válido"
                esValido = false
            } else
                it.error = null
        }

        binding.valorInventarioTextInputEditText.let {
            if (it.text.getFloat() <= 0) {
                it.error = "Debe introducir un valor válido"
                esValido = false
            } else
                it.error = null
        }

        return esValido
    }

    fun LlenaClase(): producto {
        return producto(
            0,
            binding.descripcionTextInputEditText.text.toString(),
            binding.existenciaTextInputEditText.text.getFloat(),
            binding.costosTextInputEditText.text.getFloat(),
            binding.valorInventarioTextInputEditText.text.getFloat()
        )
    }

    fun AtraparId(): producto{
        return producto(
        binding.productoIdTextInputEditText.text.toString().toLong(),
        "",
        0f,
        0f,
        0f
        )
    }

    fun LlenaActualizar(): producto{
        return producto(
            binding.productoIdTextInputEditText.text.toString().toLong(),
            binding.descripcionTextInputEditText.text.toString(),
            binding.existenciaTextInputEditText.text.getFloat(),
            binding.costosTextInputEditText.text.getFloat(),
            binding.valorInventarioTextInputEditText.text.getFloat()
        )
    }
}