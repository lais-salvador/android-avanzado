package com.example.android_avanzado

data class Model(val name: String, val photoUrl: String) {
    companion object{
        fun dummy(): Model{
            return Model("Ejemplo modelo", "https://us.123rf.com/450wm/outchill/outchill1712/outchill171204062/91291455-texto-del-ejemplo-escrito-en-el-sello-vintage-de-goma-del-c%C3%ADrculo-simple-verde.jpg")
        }
    }
}