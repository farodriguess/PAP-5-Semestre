package com.bm.pap.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Equipe;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ClientPutWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MeusTimesActivity extends Activity implements ObjectLoadedListener {

	private static final int EQUIPES = 1;
	private static final int SALVAREQUIPE = 2;
	private static final String CAMINHOEQUIPES = "equipe/usuario";
	private static final String CAMINHOSALVAREQUIPE = "equipe";

	private List<Equipe> equipes;
	private ArrayAdapter<String> adapter;
	private Usuario usuario;

	private EditText nomeTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meus_times);

		Intent intencao = getIntent();
		Bundle bundle = intencao.getExtras();		
		usuario = (Usuario) bundle.getSerializable("usuario");

		if (usuario != null) {
			// fazer lógica para carregar lista de equipe e colocar na list
			// List<Equipe>e= new ArrayList<Equipe>();

			carregarEquipes();

		}

	}

	public void adicionarEquipe(View view) {
		nomeTime = (EditText) findViewById(R.id.nomeTime);
		if (nomeTime.getText().toString().trim().length() > 0) {
			if (equipes == null)
				equipes = new ArrayList();
			Equipe novo = new Equipe();
			novo.setNome(nomeTime.getText().toString());
			novo.setUsuario(usuario);
			equipes.add(novo);

			ClientPutWSTask task = new ClientPutWSTask(this,
					CAMINHOSALVAREQUIPE, this, new Gson().toJson(novo),
					SALVAREQUIPE);
			task.execute();

			// fazer lógica de salvar a equipe no banco
		} else {
			Toast.makeText(this, "Campo nome do time em branco!",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		// TODO Auto-generated method stub
		switch (solicitante) {
		case EQUIPES: {
			Type collectionType = new TypeToken<List<Equipe>>() {
			}.getType();
			equipes = new Gson().fromJson(obj, collectionType);
			carregarGrid();
		}
			break;

		case SALVAREQUIPE: {
			if(!obj.equals("erro")){
			Toast.makeText(this, obj, Toast.LENGTH_LONG).show();
			carregarEquipes();
			} else
				Toast.makeText(this, "Erro ao tentar Salvar Time", Toast.LENGTH_LONG).show();
			
		}
			break;

		default:
			break;
		}

	}


	private void carregarGrid() {
		List<String> nomeEquipe = new ArrayList();
		for (Equipe e : equipes) {
			nomeEquipe.add(e.getNome());
		}
		ListView lista = (ListView) findViewById(R.id.listEquipe);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomeEquipe);
		lista.setAdapter(adapter);
	}
	
	private void carregarEquipes(){
		ClientPostWSTask task = new ClientPostWSTask(this, CAMINHOEQUIPES,
				this, new Gson().toJson(usuario), EQUIPES);
		task.execute();
	}

}