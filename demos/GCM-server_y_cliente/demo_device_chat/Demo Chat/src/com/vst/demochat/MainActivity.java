package com.vst.demochat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	MainActivity mainActivity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		  case R.id.itemRun:
			  new Thread(new Runnable() {
				    public void run() {
				    	for (int i = 0; i < 5; i++) {
					    	final int count = i;
				    		runOnUiThread(new Runnable() {
					    	    public void run() {				    	    	
					    	    	System.out.println("run");
					    	    	LinearLayout  linearLayout = (LinearLayout) mainActivity.findViewById(R.id.principal);    	    	
					    	    	System.out.println(linearLayout);
					    	    	TextView valueTV = new TextView(mainActivity);
					    	    	    valueTV.setText("Test " + count);			  	    	
						    	    	System.out.println(valueTV);	    	    	   
					    	    	    linearLayout.addView(valueTV);				    	    	
					    	    }
					    	});				    		
				    		try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
				    	
				    }
				}).start();			  
              return true; 
		}
		return false;
	}

}
