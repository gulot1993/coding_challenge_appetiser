package com.example.itunes_clone.common.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.itunes_clone.features.main.MainActivity
import com.example.itunes_clone.utils.schedulers.BaseScheduler
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.disposables.CompositeDisposable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<B: ViewDataBinding>: AppCompatActivity(), HasAndroidInjector {
    lateinit var binding: B

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var scheduler: BaseScheduler

    val disposables = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            getLayoutId())
        binding.lifecycleOwner = this
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun <T> Context.navigateToActivity(destActivity: Class<T>) {
        startActivity(Intent(this, destActivity))
    }
}