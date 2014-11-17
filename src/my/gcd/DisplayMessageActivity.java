package my.gcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB);
			getActionBar().setDisplayHomeAsUpEnabled(true);
		setupActionBar();
		
		Intent intent=getIntent();
		
		
		TextView tv=new TextView(this);
		tv.setTextSize(20);
	    tv.setText(getResources().getString(R.string.gcd_string)+intent.getStringExtra(GCD.EXTRA_MESSAGE));
	    
	    setContentView(tv);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
	        case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        case R.id.exit:
	        	 super.finish();
	        	    
	        	return true;
	      default:  
	        return super.onOptionsItemSelected(item);
		 }
	    }
	protected void onDestroy(){
		super.onDestroy();
	}

}
