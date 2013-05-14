package org.frogtek.ndksample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
	
	static {
		System.loadLibrary("ndksample");
	}
	
	public native String getStringFromNDK();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ((Button) findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("getStringFromNDK():"+getStringFromNDK());
				Toast.makeText(Main.this, getStringFromNDK(), Toast.LENGTH_LONG).show();
			}
		});
    }
}