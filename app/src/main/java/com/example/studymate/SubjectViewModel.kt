package com.example.studymate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectspageViewModel : ViewModel() {


    private var _subjects = MutableStateFlow<List<Subjects>>(emptyList())
    val subjects: StateFlow<List<Subjects>> = _subjects

    init {
        fetchSubjects()
    }

    private fun fetchSubjects(){
        viewModelScope.launch {
            val repo = subjectRepository()
            val response = repo.getSubjects()
            _subjects.value = response
        }
    }
}