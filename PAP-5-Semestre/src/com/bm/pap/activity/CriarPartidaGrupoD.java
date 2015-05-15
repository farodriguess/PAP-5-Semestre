package com.bm.pap.activity;

import com.bm.pap.R;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CriarPartidaGrupoD extends PrincipalActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_criar_partida_grupo_d);
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_D, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    
	    Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_D, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter2);
	    
	    //tente 
	    Spinner spinnertest= (Spinner) findViewById(R.id.spinnertest);
	    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_D, android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnertest.setAdapter(adapter3);
	    
	    Spinner spinnertest2 = (Spinner) findViewById(R.id.spinnertest2);
	    ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
	    this, R.array.Grupo_D, android.R.layout.simple_spinner_item);
	    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnertest2.setAdapter(adapter4);
	    

		
		
		
	}
}