package com.bm.pap;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class CriarPartidaGrupoA extends PrincipalActivity {
		
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.activity_criar_partida_grupo_a);
			
			//String[] items;
			 //items = getResources().getStringArray(R.array.Times);
			 
			 
			Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		    this, R.array.Times, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner1.setAdapter(adapter);
		    
		    Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
		    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
		    this, R.array.Times, android.R.layout.simple_spinner_item);
		    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3.setAdapter(adapter2);
		    
		    
}
		
}