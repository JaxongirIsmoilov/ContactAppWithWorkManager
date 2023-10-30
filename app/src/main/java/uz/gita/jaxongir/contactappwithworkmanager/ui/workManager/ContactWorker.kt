package uz.gita.jaxongir.contactappwithworkmanager.ui.workManager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ContactWorker(
    private val context : Context ,
    private val workerParameters: WorkerParameters
) : Worker(context , workerParameters){
    override fun doWork(): Result {


        return Result.success()
    }
}