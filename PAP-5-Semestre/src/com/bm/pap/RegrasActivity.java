package com.bm.pap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegrasActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regras2);
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    
	    Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter2);
	    
	    Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter3);
	}
}
