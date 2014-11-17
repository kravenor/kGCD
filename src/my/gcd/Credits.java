package my.gcd;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Credits extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credits);
		getIntent();
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB);
			getActionBar().setDisplayHomeAsUpEnabled(true);
		setupActionBar();
		TextView tv=new TextView(this);
		tv.setTextSize(20);
		tv.setText(R.string.editText1);
		setContentView(tv);
		
	}

	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.credits, menu);
		return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
          return true;
        case R.id.back:
        	NavUtils.navigateUpFromSameTask(this);
        	return true;
        	
        
        default:
        return super.onOptionsItemSelected(item);
        }
    }
}
