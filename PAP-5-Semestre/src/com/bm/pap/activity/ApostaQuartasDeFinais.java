package com.bm.pap.activity;

import com.bm.pap.R;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ApostaQuartasDeFinais extends PrincipalActivity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aposta_quartas);
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Gols, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    
	    Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Gols, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter2);
	
	

}
	
}
