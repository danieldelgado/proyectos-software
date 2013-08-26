package com.vst.demochat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DemoChatActivity extends Activity {

	DemoChatActivity mainActivity = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_demo_chat);
		new Thread(new CargaDatosInicio()).start();	
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
			  		  
              return true; 
		}
		return false;
	}
	
	@SuppressLint("ResourceAsColor")
	class CargaDatosInicio implements Runnable{		
		@Override
		public void run() {
					/*logica*/
					for (int i = 0; i < 5; i++) {
				    	final int count = i;
			    		runOnUiThread(new Runnable() {
				    	    public void run() {				    	    	
				    	    	System.out.println("run");
				    	    	LinearLayout  linearLayout = (LinearLayout) mainActivity.findViewById(R.id.principal);    	    	
				    	    	System.out.println(linearLayout);
				    	    	TextView valueTV = new TextView(mainActivity);
				    	    	    valueTV.setText("Test " + count);		
//				    	    	    valueTV.setTextColor(R.color.letras_blancas);
				    	    	    valueTV.setTextColor(Color.WHITE);
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
		
	}

}
