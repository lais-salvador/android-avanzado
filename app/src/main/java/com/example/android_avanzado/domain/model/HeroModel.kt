package com.example.android_avanzado.domain.model

data class HeroModel(
    val name: String,
    val photoUrl: String
    ) {
    companion object{
        fun dummy(): HeroModel {
            return HeroModel("Ejemplo modelo", "https://us.123rf.com/450wm/outchill/outchill1712/outchill171204062/91291455-texto-del-ejemplo-escrito-en-el-sello-vintage-de-goma-del-c%C3%ADrculo-simple-verde.jpg")
        }
    }
}