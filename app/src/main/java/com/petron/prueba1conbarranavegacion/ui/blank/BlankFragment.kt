package com.petron.prueba1conbarranavegacion.ui.blank

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.petron.prueba1conbarranavegacion.R
import com.petron.prueba1conbarranavegacion.databinding.BlankFragmentBinding

class BlankFragment: Fragment() {

    private lateinit var blackViewModel: BlankViewModel
    private var _binding: BlankFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        blackViewModel =
            ViewModelProvider(this).get(BlankViewModel::class.java)

        _binding = BlankFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBlank
        blackViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        binding.botonCalculo.setOnClickListener { calculo(it) }
        return root

    }
    private fun calculo(view: View){

            if (binding.et1Black.text.isEmpty()||binding.et2Black.text.isEmpty()){
                //en los fragment cambiamos el this del content por el actity
                Toast.makeText(activity, (R.string.fallo), Toast.LENGTH_SHORT).show()
            }else {
                var valorUno: Int = (binding.et1Black.text.toString()).toInt()
                var valorDos: Int = (binding.et2Black.text.toString()).toInt()
                var calculo: String = (valorUno + valorDos).toString()
                binding.textCalculo.text = (calculo)
                // quedamos los campos vacios
                binding.et1Black.text = null
                binding.et2Black.text = null
                //devolvemos el foco al primer edit text
                binding.et1Black.requestFocus()
                //Escondemos el teclado al dar al boton, sol ofragment (creo)
                val imn = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imn.hideSoftInputFromWindow(requireView().getWindowToken(),0)
                //Otro metodo que tambien funciona tambien sol opara fragment (creo)
               /* val imm = ContextCompat.getSystemService(view.context, InputMethodManager::class.java)
                imm?.hideSoftInputFromWindow(view.windowToken, 0)*/
            }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}