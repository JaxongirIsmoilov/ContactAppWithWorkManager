package uz.gita.jaxongir.contactappwithworkmanager.ui.workManager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import uz.gita.jaxongir.contactappwithworkmanager.domain.usecase.SaveAllDataUseCase

@HiltWorker
class ContactWorker @AssistedInject constructor(
    private val saveAllDataUseCase: SaveAllDataUseCase ,
    @Assisted context : Context ,
    @Assisted workerParameters: WorkerParameters
) : Worker(context , workerParameters){
    override fun doWork(): Result {
        saveAllDataUseCase()
        return Result.success()
    }
}