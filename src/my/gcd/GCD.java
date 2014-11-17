package my.gcd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class GCD extends Activity {
	public final static String EXTRA_MESSAGE = "my.gcd.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gcd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gcd, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.exit:
			onDestroy();
			return true;
		case R.id.credits:
			startActivity(new Intent(this,Credits.class));
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	public void displayResult(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText)findViewById(R.id.editText1);
		try{
		int a=Integer.parseInt(editText.getText().toString());
		
		int b=(int)Integer.parseInt(((EditText)findViewById(R.id.editText2)).getText().toString()); /*Come sopra ma in un unica istruzione*/
		
		int mcd=gcd(a,b);
		intent.putExtra(EXTRA_MESSAGE, Integer.toString(mcd));
		}catch(NullPointerException npe){
			npe.printStackTrace();
		intent.putExtra(EXTRA_MESSAGE, "Vettore Nullo");	
		}
		startActivity(intent);
		
	}
	
	public static int gcd(int a, int b){
		if (b==0) return a;
		else
			return gcd(b,a%b);
	}
	public static int lcm(int a, int b){
		return (b/gcd(a,b))*a;
	}
	
	public void onDestroy(){
		super.onDestroy();
		super.finish();
	}
	
}
