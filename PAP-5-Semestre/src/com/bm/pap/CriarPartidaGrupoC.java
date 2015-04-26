package com.bm.pap;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CriarPartidaGrupoC extends PrincipalActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_criar_partida_grupo_c);
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_C, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    
	    Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_C, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter2);
	    
	    Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_C, android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter3);
	    
	    Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
	    ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_C, android.R.layout.simple_spinner_item);
	    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner4.setAdapter(adapter5);
	    

		
		
		
	}
}