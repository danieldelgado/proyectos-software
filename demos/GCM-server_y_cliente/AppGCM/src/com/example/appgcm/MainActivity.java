package com.example.appgcm;

import static com.example.appgcm.CommonUtilities.SENDER_ID;
import static com.example.appgcm.CommonUtilities.SERVER_URL;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		checkNotNull(SERVER_URL, "SERVER_URL");
        checkNotNull(SENDER_ID, "SENDER_ID");
        GCMRegistrar.checkDevice(this);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void checkNotNull(Object reference, String name) {
        if (reference == null) {
            throw new NullPointerException(
                    getString(R.string.error_config, name));
        }
    }
}
