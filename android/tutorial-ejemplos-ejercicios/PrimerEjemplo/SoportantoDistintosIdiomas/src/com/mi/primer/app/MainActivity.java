package com.mi.primer.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.mi.primer.app.MESSAGE";
	
	TextView mTextView; // Variable miembro para la vista de texto en el diseño


    static final String STATE_SCORE = "playerScore";
    static final String STATE_LEVEL = "playerLevel";
    
    
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTextView = (TextView) findViewById(R.id.text_message);
        
        // Si estamos en Honeycomb o superior podemos usar las APIs de ActionBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Para la actividad principal, nos aseguramos de que el icono de la
            // aplicación de la barra de acciones no se comporte como un botón
            ActionBar actionBar = getActionBar();
            actionBar.setHomeButtonEnabled(false);
        }
        
        
        // Comprobamos si estamos recreando una instancia destruida previamente
        if (savedInstanceState != null) {
            // Restauramos el valor de los miembros del estado guardado
            int mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
            int mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);

            System.out.println(" mCurrentScore : "+mCurrentScore);
            System.out.println(" mCurrentLevel : "+mCurrentLevel);
            
            
        } else {
            // Aquí probablemente inicializaríamos los miembros con valores por defecto
            // para una nueva instancia
        }
        
    }
    
   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();  // Llama siempre a la super clase      
        System.out.println(" android onDestroy "  );
        // Detiene la traza de métodos que iniciamos en onCreate()
        android.os.Debug.stopMethodTracing();
    }    
    
    public void sendMessage(View view) {
        System.out.println(" sendMessage ");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        System.out.println("message capturado clave :  " + EXTRA_MESSAGE);
        System.out.println("message capturado :  de la primera actividad " + message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Guardamos el estado actual del juego
        savedInstanceState.putInt(STATE_SCORE, 1);
        savedInstanceState.putInt(STATE_LEVEL, 2);
        
        // Llamamos siempre a la superclase para que pueda guardar el estado
        // de la jerarquía de vistas
        super.onSaveInstanceState(savedInstanceState);
    }
    
    
    
	@Override
	protected void onStop() {
	    super.onStop();  // Siempre llamamos primero al método de la super clase
	    System.out.println("  on stop ");
	    // Guardamos el borrador actual de la nota, porque la actividad se está parando
	    // y queremos asegurarnos de que el progreso en la nota actual no se pierda.
//	    ContentValues values = new ContentValues();
//	    values.put(NotePad.Notes.COLUMN_NAME_NOTE, getCurrentNoteText());
//	    values.put(NotePad.Notes.COLUMN_NAME_TITLE, getCurrentNoteTitle());

//	    getContentResolver().update(
//	            mUri,    // La URI de la nota a actualizar.
//	            values,  // Correspondencia de nombres de columnas y valores a aplicar.
//	            null,    // No utilizamos ningún criterio SELECT.
//	            null     // No se utiliza ninguna columna de WHERE.
//	            );
	}
    
	@Override
	protected void onStart() {
	    super.onStart();  // Siempre llamamos primero al método de la super clase
	    System.out.println(" on start ");
	    // La actividad está siendo reiniciada o iniciada por primera vez por lo
	    // que aquí es donde deberíamos asegurarnos de que el GPS está habilitado
//	    LocationManager locationManager = 
//	            (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//	    boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	    
//	    if (!gpsEnabled) {
	        // Aquí crearíamos un diálogo pidiendo al usuario activar el GPS y usaríamos una
	        // intención con la acción android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS
	        // para llevar al usuario a la pantalla de Configuración para activar el GPS
//	    }
	}

	@Override
	protected void onRestart() {
	    super.onRestart();  // Siempre llamamos primero al método de la super clase
	    System.out.println("on restart");
	    // La actividad está siendo reiniciada desde el estado de parada   
	}
	
}
