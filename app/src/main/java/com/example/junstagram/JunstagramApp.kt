package com.example.junstagram

import android.app.Application
import androidx.compose.runtime.frames.modelListOf
import com.example.junstagram.di.dataSourceModule
import com.example.junstagram.di.repositoryModule
import com.example.junstagram.di.serviceModule
import com.example.junstagram.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//Application() 클래스는 애플리케이션 컴포넌트들 사이에서 공통으로 멤버들을 사용할 수 있게 해주는 편리한 공유 클래스를 제공.
class JunstagramApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JunstagramApp)
            modules(dataSourceModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(serviceModule)
        }
    }
}