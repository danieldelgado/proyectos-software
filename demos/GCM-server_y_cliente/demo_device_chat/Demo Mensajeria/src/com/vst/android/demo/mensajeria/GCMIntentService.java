/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vst.android.demo.mensajeria;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import com.vst.android.service.SeguridadService;
import com.vst.android.service.impl.SeguridadServiceImpl;
import com.vst.android.util.Constantes;

/**
 * IntentService responsible for handling GCM messages.
 */
public class GCMIntentService extends GCMBaseIntentService {

//    private static final String TAG = "GCMIntentService";
	
	private SeguridadService seguridadService = SeguridadServiceImpl.newStaticInstance();//usar un apuntador del objeto ya creado e instanciado y se obtiene mediante esta linea.
	
    public GCMIntentService() {
        super(Constantes.gcm_id.SENDER_ID);
    }

    /**
     * Registra el regID(ID que google asigna al dispositivo movil)
     */
    @Override
    protected void onRegistered(Context context, String registrationId) {
    	Log.v(GCMIntentService.class.getName(), "onRegistered seguridadService.registrarEnServidor :"+registrationId);
    	Constantes.instance.regId = registrationId;
    	try {
			int r = seguridadService.registrarEnServidor(registrationId, null, null,Constantes.tipo_registro_mobile.DESDE_CLASE_GCMINTENT_SERVICE);
			Log.v(GCMIntentService.class.getName(), "onRegistered r :"+r);
			GCMRegistrar.setRegisteredOnServer(context, true);
			switch (r) {
			case Constantes.respuestas_servidor.DISPOSITIVO_REGISTRADO:
				System.out.println("DISPOSITIVO_REGISTRADO");
				break;
			case Constantes.respuestas_servidor.NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO:
				System.out.println("NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO");
				
				break;
			case Constantes.respuestas_servidor.NUEVO_DISPOSITIVO_POR_NUEVO_USUARIO_REGISTRADO:
				System.out.println("NUEVO_DISPOSITIVO_POR_NUEVO_USUARIO_REGISTRADO");
				
				break;
			case Constantes.respuestas_servidor.NUEVO_USUARIO_POR_DISPOSITIVO_REGISTRADO:
				System.out.println("NUEVO_USUARIO_POR_DISPOSITIVO_REGISTRADO");
				
				break;
			}
    	} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }

    @Override
    protected void onUnregistered(Context context, String registrationId) {
        Log.v(GCMIntentService.class.getName(), "onUnregistered unregistered");
//        displayMessage(context, getString(R.string.gcm_unregistered));
//        ServerUtilities.unregister(context, registrationId);
    }

    @Override
    protected void onMessage(Context context, Intent intent) {
        Log.v(GCMIntentService.class.getName(), "onMessage message");
//        String message1 = intent.getStringExtra("message");
//        System.out.println("  message1 :"+ message1);
//        String message = getString(R.string.gcm_message);
//        System.out.println("  message :"+ message);
//        displayMessage(context, message1);
//        // notifies user
//        generateNotification(context, message1);
    }

    @Override
    protected void onDeletedMessages(Context context, int total) {
        Log.v(GCMIntentService.class.getName(), "onDeletedMessages message");
//        Log.v(GCMIntentService.class.getName(), "Received deleted messages notification");
//        String message = getString(R.string.gcm_deleted, total);
//        displayMessage(context, message);
//        // notifies user
//        generateNotification(context, message);
    }

    @Override
    public void onError(Context context, String errorId) {
        Log.v(GCMIntentService.class.getName(), "Received error: " + errorId);
//        displayMessage(context, getString(R.string.gcm_error, errorId));
    }

    @Override
    protected boolean onRecoverableError(Context context, String errorId) {
        // log message
        Log.v(GCMIntentService.class.getName(), "onRecoverableError recoverable error: " + errorId);
//        displayMessage(context, getString(R.string.gcm_recoverable_error,
//                errorId));
        return super.onRecoverableError(context, errorId);
    }

    /**
     * Issues a notification to inform the user that server has sent a message.
     */
//    private static void generateNotification(Context context, String message) {
//        int icon = R.drawable.ic_stat_gcm;
//        long when = System.currentTimeMillis();
//        NotificationManager notificationManager = (NotificationManager)
//                context.getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification notification = new Notification(icon, message, when);
//        String title = context.getString(R.string.app_name);
//        Intent notificationIntent = new Intent(context, DemoActivity.class);
//        // set intent so it does not start a new activity
//        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        PendingIntent intent =
//                PendingIntent.getActivity(context, 0, notificationIntent, 0);
//        notification.setLatestEventInfo(context, title, message, intent);
//        notification.flags |= Notification.FLAG_AUTO_CANCEL;
//        notificationManager.notify(0, notification);
//    }

}
