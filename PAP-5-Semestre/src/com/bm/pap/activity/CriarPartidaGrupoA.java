package com.bm.pap.activity;

import com.bm.pap.R;

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
			 
			 
			Spinner spinner1CGrupoA = (Spinner) findViewById(R.id.spinner1CGrupoA);
		    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		    this, R.array.Grupo_A, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner1CGrupoA.setAdapter(adapter);
		    
		    Spinner spinner2CGrupoA = (Spinner) findViewById(R.id.spinner2CGrupoA);
		    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
		    this, R.array.Grupo_A, android.R.layout.simple_spinner_item);
		    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2CGrupoA.setAdapter(adapter2);
		    
		    
		    Spinner spinner3CGrupoA = (Spinner) findViewById(R.id.spinner3CGrupoA);
		    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
		    this, R.array.Grupo_A, android.R.layout.simple_spinner_item);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3CGrupoA.setAdapter(adapter3);
		    
		    Spinner spinner4CGrupoA = (Spinner) findViewById(R.id.spinner4CGrupoA);
		    ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
		    this, R.array.Grupo_A, android.R.layout.simple_spinner_item);
		    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner4CGrupoA.setAdapter(adapter4);
		    
		    
}
		
}