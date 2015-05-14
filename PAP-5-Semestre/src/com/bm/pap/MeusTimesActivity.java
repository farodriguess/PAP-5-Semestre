package com.bm.pap;

import java.util.ArrayList;
import java.util.List;

import com.bm.pap.entity.Equipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;



public class MeusTimesActivity extends Activity {

	private List<String> equipes;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meus_times);

		
//fazer lógica para carregar lista de equipe e colocar na list
		//List<Equipe>e= new ArrayList<Equipe>();
		
		equipes = new ArrayList<String>();
		
//a list equipes terá os nomes da lista de equipes
		
	/*	for(Equipe a : e){
			equipes.add(a.getNome());			
		}	*/	
				
		ListView lista = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, equipes);
		lista.setAdapter(adapter);
	}
	
	public void adicionarEquipe(View view){
		EditText nomeTime = (EditText) findViewById(R.id.nomeTime);
		if (nomeTime.getText().toString().trim().length() > 0) {
			equipes.add(nomeTime.getText().toString());
			adapter.notifyDataSetChanged();
			nomeTime.setText("");
			Equipe equipe = new Equipe();
			equipe.setNome(nomeTime.getText().toString());
			//fazer lógica de salvar a equipe no banco
		} else {
			Toast.makeText(this, "Campo nome do time em branco!",
					Toast.LENGTH_SHORT).show();
		}
	}
	
}