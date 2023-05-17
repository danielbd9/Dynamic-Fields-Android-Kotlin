package com.example.androiddynamicfields.model

data class FieldModel (
    val id: Int,
    val name: String,
    val options: List<OptionModel>?
)