package com.example.itunes_clone.common.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.itunes_clone.common.di.ViewModelFactory
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseViewModelActivity<VM: BaseViewModel, B: ViewDataBinding>: BaseActivity<B>() {

    @Inject
    lateinit var factory: ViewModelFactory<VM>

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelClass = (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[1] as Class<VM>

        viewModel = ViewModelProvider(this, factory)[viewModelClass]
    }
}