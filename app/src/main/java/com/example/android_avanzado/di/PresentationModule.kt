package com.example.android_avanzado.di

import com.example.android_avanzado.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel{ ListViewModel(get()) }
    viewModelOf(::ListViewModel)
}