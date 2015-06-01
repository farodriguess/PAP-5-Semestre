package com.bm.pap.activity;

import java.util.ArrayList;
import java.util.List;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

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

public class CampeonatosQueParticipo extends Activity {

	private List<Campeonato> campeonatos;
	private ArrayAdapter<String> adapter;
	private Usuario usuario;
	private AlertDialog alerta;
	private ListView lista;
	private List<String> nomeCampeonato;
	private String campeonato;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campeonatos_que_participo);


		carregarGrid();
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int arg2, long arg3) {
				campeonato = ((TextView) view).getText().toString();
				opcoesCampeonato();
			}
		});
	}

	private void carregarGrid() {
		nomeCampeonato = new ArrayList();
//		for (Campeonato c : campeonatos) {
//			nomeCampeonato.add(c.getNome() + "\nStatus: " + c.getStatus());
//		}
		nomeCampeonato.add("COPA DAS CONFEDERAÇÕES 2013" + "\nStatus: 1º Fase\nUsuário: jk");
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, nomeCampeonato);
		lista = (ListView) findViewById(R.id.list);
		lista.setAdapter(adapter);
	}


	private void opcoesCampeonato() {
		// Lista de itens
		ArrayList<String> itens = new ArrayList<String>();
		itens.add("Ver info. do Campeonato");
		itens.add("Ver Partidas");
		itens.add("Ranking");
		itens.add("Regras");
		itens.add("Minhas Apostas");
		itens.add("Deixar de Participar");

		ArrayAdapter arrayAdapter = new ArrayAdapter(this,
				R.layout.item_alerta, itens);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Selecione uma opção:");

		builder.setSingleChoiceItems(arrayAdapter, 0,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						if (arg1 == 0) {
							verInfoCampeonato();
						}
						if (arg1 == 1) {
							verPartidas();
						}
						if (arg1 == 2) {					
							ranking();
						}
						if (arg1 == 3) {
							regras();
						}
						if (arg1 == 4) {
							apostar();
						}
						if (arg1 == 5) {
							confirmarExclusao();
						}
						alerta.dismiss();
					}
				});
		alerta = builder.create();
		alerta.show();
	}

	public void verInfoCampeonato() {
//		for (int i = 0; i < campeonatos.size(); i++) {
//			if (campeonatos
//					.get(i)
//					.getNome()
//					.equals(campeonato.substring(0,
//							campeonato.indexOf("Status") - 1))) {
				Intent intent = new Intent(this, EditarCampeonatoActivity.class);
//				intent.putExtra("usuario", usuario);
//				intent.putExtra("editarCampeonato", campeonatos.get(i));
				startActivity(intent);
//			}
//		}
	}

	public void verPartidas() {
//		for (int i = 0; i < campeonatos.size(); i++) {
//			if (campeonatos
//					.get(i)
//					.getNome()
//					.equals(campeonato.substring(0,
//							campeonato.indexOf("Status") - 1))) {
				 Intent intent = new Intent(this,
				 SelecionarVerResultadosActivity.class);
				// campeonatos.get(i).setUsuario(usuario);
				// intent.putExtra("editarCampeonato", campeonatos.get(i));
				 startActivity(intent);
//			}
//		}
	}

	public void apostar() {
//		for (int i = 0; i < campeonatos.size(); i++) {
//			if (campeonatos
//					.get(i)
//					.getNome()
//					.equals(campeonato.substring(0,
//							campeonato.indexOf("Status") - 1))) {
				Intent intent = new Intent(this, SelecionarApostaActivity.class);
//				intent.putExtra("usuario", usuario);
//				intent.putExtra("editarCampeonato", campeonatos.get(i));
				startActivity(intent);
//			}
//		}
	}

	public void ranking() {
//		for (int i = 0; i < campeonatos.size(); i++) {
//			if (campeonatos
//					.get(i)
//					.getNome()
//					.equals(campeonato.substring(0,
//							campeonato.indexOf("Status") - 1))) {
				Intent intent = new Intent(this, RankingActivity.class);
//				intent.putExtra("usuario", usuario);
//				intent.putExtra("editarCampeonato", campeonatos.get(i));
				startActivity(intent);
//			}
//		}
	}

	public void regras() {
//		for (int i = 0; i < campeonatos.size(); i++) {
//			if (campeonatos
//					.get(i)
//					.getNome()
//					.equals(campeonato.substring(0,
//							campeonato.indexOf("Status") - 1))) {
//				 Intent intent = new Intent(this, VerRegrasActivity.class);
				// campeonatos.get(i).setUsuario(usuario);
				// intent.putExtra("editarCampeonato", campeonatos.get(i));
//				 startActivity(intent);
//			}
//		}
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
}
