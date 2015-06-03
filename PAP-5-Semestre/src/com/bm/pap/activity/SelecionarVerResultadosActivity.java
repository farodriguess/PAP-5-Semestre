package com.bm.pap.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

public class SelecionarVerResultadosActivity extends Activity {
	private Usuario usuario;
	private Campeonato campeonato;
	private ArrayAdapter<CharSequence> adapter;
	private Spinner spinner1;
	private Spinner spinner2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selecionar_resultados);
		Intent intencao = getIntent();
		// Bundle info = intencao.getExtras();
		// usuario = (Usuario) info.getSerializable("usuario");
		// campeonato = (Campeonato) info.getSerializable("editarCampeonato");

		List<String> fase1 = new ArrayList();
		fase1.add("Grupo A");
		fase1.add("Grupo B");

		List<String> fase2 = new ArrayList();
		fase2.add("Semi Finais");
		fase2.add("Terceiro Lugar");
		fase2.add("Final");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, fase1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, fase2);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);

		// Button b =(Button)findViewById(R.id.btnIrFase2);
		// b.setEnabled(false);
		// spinner2.setEnabled(false);

	}

	public void irFase1(View v) {
		if (spinner1.getSelectedItem().toString().equals("Grupo A")) {
			Intent i = new Intent(this, VerResultadoGrupoA.class);
			startActivity(i);
		}
		if (spinner1.getSelectedItem().toString().equals("Grupo B")) {
			Intent i = new Intent(this, VerResultadoGrupoB.class);
			startActivity(i);
		}
	}

	public void irFase2(View v) {
		if (spinner2.getSelectedItem().toString().equals("Semi Finais")) {
//			Intent i = new Intent(this, ApostaSemifinal.class);
//			startActivity(i);
		}
		if (spinner2.getSelectedItem().toString().equals("Finais")) {
//			Intent i = new Intent(this, ApostaFinal.class);
//			startActivity(i);
		}
		if (spinner2.getSelectedItem().toString().equals("Terceiro Lugar")) {
//			Intent i = new Intent(this, ApostaTerceiroLugar.class);
//			startActivity(i);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
