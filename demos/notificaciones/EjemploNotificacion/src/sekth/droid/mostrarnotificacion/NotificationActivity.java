package sekth.droid.mostrarnotificacion;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.NotificationCompat;

public class NotificationActivity extends Activity {
	int notificationID = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_example);
	}
	
	public void onClick(View v){
		displayNotification();
	}
	
	protected void displayNotification(){
		System.out.println("DISPLAY");
		Intent i = new Intent(this, NotificationView.class);
		i.putExtra("notificationID", notificationID);
		System.out.println("DISPLAY 1 ");
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
		NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		System.out.println("DISPLAY 2 ");
		CharSequence ticker ="Nueva entrada en SekthDroid";
		CharSequence contentTitle = "SekthDroid";
		CharSequence contentText = "Visita ahora SekthDroid!";
		System.out.println("DISPLAY 3 ");
		Notification noti = new NotificationCompat.Builder(this)
								.setContentIntent(pendingIntent)
								.setTicker(ticker)
								.setContentTitle(contentTitle)
								.setContentText(contentText)
								.setSmallIcon(R.drawable.ic_launcher)
								.addAction(R.drawable.ic_launcher, ticker, pendingIntent)
								.setVibrate(new long[] {100, 250, 100, 500})
								.build();
		nm.notify(notificationID, noti);
		System.out.println("DISPLAY 4 ");
	}

}
