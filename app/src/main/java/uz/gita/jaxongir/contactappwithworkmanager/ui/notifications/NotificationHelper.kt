package uz.gita.jaxongir.contactappwithworkmanager.ui.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import uz.gita.jaxongir.contactappwithworkmanager.R

class NotificationHelper(val context: Context) {

    private val notificationBuilder: NotificationCompat.Builder by lazy {
        NotificationCompat.Builder(context, "Notification")
            .setSmallIcon(R.drawable.contact)
            .setContentTitle("Contact app")
            .setContentText("Your contacts was added to api")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    }

    val notificationManagerCompat: NotificationManagerCompat by lazy { NotificationManagerCompat.from(context) }


    fun getNotification(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel.
            val name = "First"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel("Notification", name, importance)
            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            notificationManagerCompat.createNotificationChannel(mChannel)
        }

        return notificationBuilder.build()
    }

}