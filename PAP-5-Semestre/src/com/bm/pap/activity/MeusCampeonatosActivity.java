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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

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
	private AlertDialog alerta;
	private AlertDialog alerta2;
	private ListView lista;
	private List<String> nomeCampeonato;
	private String campeonato;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meus_campeonatos);

		Intent intencao = getIntent();
		Bundle bundle = intencao.getExtras();
		usuario = (Usuario) bundle.getSerializable("usuario");

		if (usuario != null) {
			ClientPostWSTask task = new ClientPostWSTask(this,
					CAMINHOCAMPEONATOS, this, new Gson().toJson(usuario),
					CAMPEONATOS);
			task.execute();
		}

		lista = (ListView) findViewById(R.id.listaMeusCampeonatos);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int arg2, long arg3) {
				campeonato = ((TextView) view).getText().toString();
				opcoes();
			}
		});

	}

	public void botaoNovo(View view) {
		Intent intent = new Intent(this, NovoCampeonatoActivity.class);
		intent.putExtra("usuario", usuario);
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

	private void carregarGrid() {

		nomeCampeonato = new ArrayList();
		for (Campeonato c : campeonatos) {
			nomeCampeonato.add(c.getNome() + "\nStatus: " + c.getStatus()+"\nUsuário: "+usuario.getNome());
		}

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomeCampeonato);
		lista.setAdapter(adapter);
	}

	private void opcoes() {
		// Lista de itens
		ArrayList<String> itens = new ArrayList<String>();
		itens.add("Opções");
		itens.add("Excluir");
		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				R.layout.item_alerta, itens);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Selecione uma opção:");

		builder.setSingleChoiceItems(arrayAdapter, 0,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0) {
							opcoesCampeonato();
						}
						if (arg1 == 1) {
							confirmarExclusao().show();
						}
						alerta.dismiss();
					}
				});
		alerta = builder.create();
		alerta.show();
	}

	public AlertDialog confirmarExclusao() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("REMOVER CAMPEONATO");
		builder.setMessage("Deseja remover o campeonato?");
		builder.setPositiveButton("sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// FAZER LÓGICA DE REMOVER CAMPEONATO DO BANCO
				nomeCampeonato.remove(campeonato);
				adapter.notifyDataSetChanged();
			}
		});

		builder.setNegativeButton("não", null);
		return builder.create();
	}

	private void opcoesCampeonato() {
		// Lista de itens
		ArrayList<String> itens = new ArrayList<String>();
		itens.add("Editar info. do Campeonato");
		itens.add("Editar Partidas");
		itens.add("Ver Participantes");
		itens.add("Ranking");
		itens.add("Resultado Partida");
		itens.add("Definir Status");
		itens.add("Regras");

		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				R.layout.item_alerta, itens);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Selecione uma opção:");

		builder.setSingleChoiceItems(arrayAdapter, 0,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0) {
							editarInfoCampeonato();
						}
						if (arg1 == 1) {
							editarPartida();
						}
						if (arg1 == 2) {
							verParticipantes();
						}
						if (arg1 == 3) {
							ranking();
						}
						if (arg1 == 4) {
							resultadoPartida();
						}

						if (arg1 == 5) {
							definirStatus();
						}
						if (arg1 == 6) {
							regras();
						}
						alerta2.dismiss();
					}
				});
		alerta2 = builder.create();
		alerta2.show();
	}

	public void editarInfoCampeonato() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				 Intent intent = new Intent(this,
				 EditarCampeonatoActivity.class);
				 intent.putExtra("usuario", usuario);
				intent.putExtra("editarCampeonato", campeonatos.get(i));
				startActivity(intent);
			}
		}
	}

	public void editarPartida() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				// Intent intent = new Intent(this,
				// EditarPartidaGAActivity.class);
				// campeonatos.get(i).setUsuario(usuario);
				// intent.putExtra("editarCampeonato", campeonatos.get(i));
				// startActivity(intent);
			}
		}
	}

	public void verParticipantes() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				 Intent intent = new Intent(this,
						 VerParticipantesActivity.class);
				 intent.putExtra("usuario", usuario);
				 intent.putExtra("editarCampeonato", campeonatos.get(i));
				 startActivity(intent);
			}
		}
	}

	public void ranking() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				Intent intent = new Intent(this, RankingActivity.class);
				intent.putExtra("usuario", usuario);
				intent.putExtra("editarCampeonato", campeonatos.get(i));
				startActivity(intent);
			}
		}
	}

	public void resultadoPartida() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				 Intent intent = new Intent(this,
				 SelecionarResultadoActivity.class);
				 intent.putExtra("usuario", usuario);
				 intent.putExtra("editarCampeonato", campeonatos.get(i));
				 startActivity(intent);
			}
		}
	}

	public void definirStatus() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				 Intent intent = new Intent(this,
				 StatusCampeonatoActivity.class);
				intent.putExtra("usuario", usuario);
				 intent.putExtra("editarCampeonato", campeonatos.get(i));
				 startActivity(intent);
			}
		}
	}

	public void regras() {
		for (int i = 0; i < campeonatos.size(); i++) {
			if (campeonatos
					.get(i)
					.getNome()
					.equals(campeonato.substring(0,
							campeonato.indexOf("Status") - 1))) {
				// Intent intent = new Intent(this, VerRegrasActivity.class);
				// campeonatos.get(i).setUsuario(usuario);
				// intent.putExtra("editarCampeonato", campeonatos.get(i));
				// startActivity(intent);
			}
		}
	}
}
