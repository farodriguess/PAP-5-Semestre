package com.bm.pap.activity;

import java.util.ArrayList;
import java.util.List;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Equipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class CriarPartidaGrupoA extends PrincipalActivity {
	private Campeonato campeonato;
	private ArrayList<Equipe> equipesSelecionadas;
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.activity_criar_partida_grupo_a);
			
			
			
			
			Bundle extra = getIntent().getBundleExtra("bundleEquipesSelecionadas");
			equipesSelecionadas = (ArrayList<Equipe>) extra.getSerializable("equipesSelecionadas");
			campeonato =  (Campeonato) extra.getSerializable("campeonato");
			
			
			//String[] items;
			 //items = getResources().getStringArray(R.array.Times);
			
			List<String> nomeEquipe = new ArrayList();
		
		for (Equipe e : equipesSelecionadas) {
				nomeEquipe.add(e.getNome());
		}
			 
			 
			Spinner spinner1CGrupoA = (Spinner) findViewById(R.id.spinner1CGrupoA);
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, nomeEquipe);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner1CGrupoA.setAdapter(adapter);
		    
		    Spinner spinner2CGrupoA = (Spinner) findViewById(R.id.spinner2CGrupoA);
		    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, nomeEquipe);
		    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner2CGrupoA.setAdapter(adapter2);
		    
		    
		    Spinner spinner3CGrupoA = (Spinner) findViewById(R.id.spinner3CGrupoA);
		    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, nomeEquipe);
		    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner3CGrupoA.setAdapter(adapter3);
		    
		    Spinner spinner4CGrupoA = (Spinner) findViewById(R.id.spinner4CGrupoA);
		    ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, nomeEquipe);
		    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner4CGrupoA.setAdapter(adapter4);
		    
		    
}
		
		
		
}