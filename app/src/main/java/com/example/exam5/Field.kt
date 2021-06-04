package com.example.exam5

data class Field(
    var fieldId: Int,
    var hint: String,
    val fieldType: String,
    var Required: Boolean,
    var isActive: Boolean,
    var icon:String,
    var keyboard:String? = null
)
