package com.mi.primer.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.mi.primer.app.MESSAGE";
	
	TextView mTextView; // Variable miembro para la vista de texto en el diseño

	
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
    
}
