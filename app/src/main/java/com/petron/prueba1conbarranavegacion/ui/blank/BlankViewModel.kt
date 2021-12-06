package com.petron.prueba1conbarranavegacion.ui.blank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _text = MutableLiveData<String>().apply {
        value = "This is Black Fragment"
    }
    val text: LiveData<String> = _text
}