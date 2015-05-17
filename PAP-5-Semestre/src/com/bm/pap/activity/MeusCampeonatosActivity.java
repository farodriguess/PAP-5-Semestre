package com.bm.pap.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MeusCampeonatosActivity extends Activity implements
		ObjectLoadedListener {

	private static final int CAMPEONATOS = 1;
	private static final String CAMINHOCAMPEONATOS = "campeonato/usuario";

	private List<Campeonato> campeonatos;
	private ArrayAdapter<String> adapter;
	private Usuario usuario;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meus_campeonatos);

		Intent intencao = getIntent();
		Bundle bundle = intencao.getExtras();
		Bundle b = bundle.getBundle("bundle");
		usuario = (Usuario) b.getSerializable("usuario");
		
		if(usuario!=null){

		// fazer lógica para carregar lista de campeonato e colocar na list
		// List<Campeonato>e= new ArrayList<Equipe>();
		ClientPostWSTask task = new ClientPostWSTask(this, CAMINHOCAMPEONATOS,
				this, new Gson().toJson(usuario), CAMPEONATOS);
		task.execute();
		}

	}

	public void botaoNovo(View view) {
		Intent intent = new Intent(this, NovoCampeonatoActivity.class);
		startActivity(intent);

	}

	public void botaoEditar(View view) {
		Intent intent = new Intent(this, EditarCampeonatoActivity.class);
		startActivity(intent);
	}

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		// TODO Auto-generated method stub

		switch (solicitante) {
		case CAMPEONATOS: {
			Type collectionType = new TypeToken<List<Campeonato>>() {
			}.getType();			
			campeonatos = new Gson().fromJson(obj, collectionType);
			carregarGrid();
		}

			break;

		default:
			break;
		}

		

	

	}
	
	private void carregarGrid(){
		// a list campeonatos terá os nomes e status da lista de meusCampeonatos

		/*
		 * for(campeonatos a : e){ campeonatos.add(a.getNome()+" "+
		 * a.getStatus()); }
		 */
		List<String> nomeCampeonato = new ArrayList();
		for(Campeonato c:campeonatos){
			nomeCampeonato.add(c.getNome());
		}
		ListView lista = (ListView) findViewById(R.id.listaMeusCampeonatos);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nomeCampeonato);
		lista.setAdapter(adapter);
	}

}
