package com.bm.pap;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MeusCampeonatosActivity extends PrincipalActivity{
	private List<String> campeonatos;
	private ArrayAdapter<String> adapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_meus_campeonatos);

		
		setContentView(R.layout.activity_meus_campeonatos);
		//fazer lógica para carregar lista de campeonato e colocar na list
				//List<Campeonato>e= new ArrayList<Equipe>();
				
		campeonatos = new ArrayList<String>();
				
		//a list campeonatos terá os nomes e status da lista de meusCampeonatos
				
			/*	for(campeonatos a : e){
					campeonatos.add(a.getNome()+" "+ a.getStatus());			
				}	*/	
						
				ListView lista = (ListView) findViewById(R.id.listaMeusCampeonatos);
				adapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, campeonatos);
				lista.setAdapter(adapter);
}
	public void botaoNovo(View view){
		Intent intent = new Intent(this, NovoCampeonatoActivity.class);
		startActivity(intent);
		
	}
	
	public void botaoEditar(View view){
		Intent intent = new Intent(this, EditarCampeonatoActivity.class);
		startActivity(intent);
	}

}
