package com.example.android_avanzado.domain.model

class TestDataBuilder {
    var name = ""
    var numElements: Int = 1

    fun withName(name: String): TestDataBuilder {
        this.name = name

        return this
    }

    fun withNumElements(numElements: Int): TestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun build(): List<HeroModel>{
        val list = mutableListOf<HeroModel>()

        for(i in 0 .. numElements){
        list.add(HeroModel("", name, "", ""))
        }

        return list.toList()
    }
}