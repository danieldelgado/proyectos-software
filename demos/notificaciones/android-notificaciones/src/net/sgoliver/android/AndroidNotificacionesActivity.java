package net.sgoliver.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidNotificacionesActivity extends Activity {

	private Button btnNotificacion; 
	
	private static final int NOTIF_ALERTA_ID = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnNotificacion = (Button)findViewById(R.id.BtnNotif);
        
        btnNotificacion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Obtenemos una referencia al servicio de notificaciones
				String ns = Context.NOTIFICATION_SERVICE;
				NotificationManager notManager = 
					(NotificationManager) getSystemService(ns);
				
				//Configuramos la notificaci�n
				int icono = android.R.drawable.stat_sys_warning;
				CharSequence textoEstado = "Alerta!";
				long hora = System.currentTimeMillis();

				Notification notif = 
					new Notification(icono, textoEstado, hora);
				
				//Configuramos el Intent
				Context contexto = getApplicationContext();
				CharSequence titulo = "Mensaje de Alerta";
				CharSequence descripcion = "Ejemplo de notificaci�n.";
				
				Intent notIntent = new Intent(contexto, 
						AndroidNotificacionesActivity.class);
				
				PendingIntent contIntent = PendingIntent.getActivity(
						contexto, 0, notIntent, 0);

				notif.setLatestEventInfo(
						contexto, titulo, descripcion, contIntent);
				
				//AutoCancel: cuando se pulsa la notificai�n �sta desaparece
				notif.flags |= Notification.FLAG_AUTO_CANCEL;
				
				//A�adir sonido, vibraci�n y luces
				//notif.defaults |= Notification.DEFAULT_SOUND;
				//notif.defaults |= Notification.DEFAULT_VIBRATE;
				//notif.defaults |= Notification.DEFAULT_LIGHTS;
				
				//Enviar notificaci�n
				notManager.notify(NOTIF_ALERTA_ID, notif);
			}
		});
    }
}