package uz.gita.jaxongir.contactappwithworkmanager.app

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import dagger.hilt.android.HiltAndroidApp
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.SaveAllDataUseCase
import uz.gita.jaxongir.contactappwithworkmanager.ui.workManager.ContactWorker
import javax.inject.Inject

@HiltAndroidApp
class App : Application() , Configuration.Provider{

    @Inject
    lateinit var myWorkerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setWorkerFactory(myWorkerFactory)
            .build()
}