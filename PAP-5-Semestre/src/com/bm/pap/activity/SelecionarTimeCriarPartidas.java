package com.bm.pap.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Equipe;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SelecionarTimeCriarPartidas extends Activity implements
		ObjectLoadedListener {
	private static final int EQUIPES = 1;
	private static final String CAMINHOEQUIPES = "equipe/usuario";

	private Campeonato campeonato;
	private List<Equipe> equipes;
	private ArrayList<Equipe> equipesSelecionadas;
	private List<String> nomeEquipeSelecionada;
	private ArrayAdapter<String> adapter;
	private AlertDialog dialog;
	private String equipe;
	private ListView lista;
	private Usuario usuario;
	private Spinner spinner1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_selecionar_times);

		Intent intencao = getIntent();
		Bundle info = intencao.getExtras();
		campeonato = (Campeonato) info.getSerializable("campeonato");
		usuario = campeonato.getUsuario();
		equipesSelecionadas = new ArrayList<Equipe>();
		nomeEquipeSelecionada = new ArrayList<String>();
		lista = (ListView) findViewById(R.id.list);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int arg2, long arg3) {
				equipe = ((TextView) view).getText().toString();
				dialog = confirmarExclusao();
				dialog.show();
			}
		});

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomeEquipeSelecionada);
		lista.setAdapter(adapter);

		if (usuario != null) {
			carregarEquipes();
		}
	}

	public void btnAdicionarTime(View v) {
		if (equipes != null) {
			if (equipesSelecionadas.size() < campeonato.getQtdEquipe()) {
				for (Equipe c : equipes) {
					if (c.getNome().equals(
							spinner1.getSelectedItem().toString())) {
						if (!equipesSelecionadas.contains(c)) {
							equipesSelecionadas.add(c);
							nomeEquipeSelecionada.add(c.getNome());
							adapter.notifyDataSetChanged();
						} else {
							Toast.makeText(this,
									"Você ja selecionou essa Equipe!",
									Toast.LENGTH_LONG).show();
						}
					}
				}

			} else {
				Toast.makeText(
						this,
						"Você ja selecionou as "
								+ campeonato.getQtdEquipe().toString()
								+ " equipes!", Toast.LENGTH_LONG).show();
			}
		} else {
			Toast.makeText(this, "Você não possui equipes cadastradas!",
					Toast.LENGTH_LONG).show();
		}

	}

	public AlertDialog confirmarExclusao() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("REMOVER EQUIPE");
		builder.setMessage("Deseja remover equipe?");
		builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				for (int i = 0; i < equipesSelecionadas.size(); i++) {
					if (equipesSelecionadas.get(i).getNome().equals(equipe)) {
						Equipe e = equipesSelecionadas.get(i);
						equipesSelecionadas.remove(e);
						nomeEquipeSelecionada.remove(equipe);
						adapter.notifyDataSetChanged();

					}
				}
			}
		});

		builder.setNegativeButton("não", null);
		return builder.create();
	}

	public void btnAvancar(View v) {
		if (equipesSelecionadas.size() == campeonato.getQtdEquipe()) {
			Bundle extra = new Bundle();
			extra.putSerializable("equipesSelecionadas", equipesSelecionadas);
			Intent intent = new Intent(getBaseContext(),
					CriarPartidaGrupoA.class);
			intent.putExtra("bundleEquipesSelecionadas", extra);
			intent.putExtra("campeonato", campeonato);
			intent.putExtra("usuario", usuario);
			startActivity(intent);
		} else {
			Toast.makeText(
					this,
					"Você selecionou "
							+ Integer.toString(equipesSelecionadas.size())
							+ " equipes, restam "
							+ Integer.toString(campeonato.getQtdEquipe()
									- equipesSelecionadas.size()),
					Toast.LENGTH_LONG).show();
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

		default:
			break;
		}
	}

	private void carregarGrid() {
		List<String> nomeEquipe = new ArrayList();
		for (Equipe e : equipes) {
			nomeEquipe.add(e.getNome());
		}
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nomeEquipe);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
	}

	private void carregarEquipes() {
		ClientPostWSTask task = new ClientPostWSTask(this, CAMINHOEQUIPES,
				this, new Gson().toJson(usuario), EQUIPES);
		task.execute();
	}

}