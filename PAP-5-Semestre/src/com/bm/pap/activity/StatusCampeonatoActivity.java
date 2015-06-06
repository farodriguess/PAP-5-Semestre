package com.bm.pap.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

public class StatusCampeonatoActivity extends Activity {
	private Usuario usuario;
	private Campeonato campeonato;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status_campeonato);
		Intent intencao = getIntent();
		Bundle info = intencao.getExtras();
		usuario = (Usuario) info.getSerializable("usuario");
		campeonato = (Campeonato) info.getSerializable("editarCampeonato");

		RadioButton aguardar = (RadioButton) findViewById(R.id.radioButton1);
		RadioButton fase1 = (RadioButton) findViewById(R.id.radioButton2);
		RadioButton fase2 = (RadioButton) findViewById(R.id.radioButton3);
		RadioButton finalizado = (RadioButton) findViewById(R.id.radioButton4);

//		if (campeonato.getQtdEquipe() == 8) {
//			radioOito.setChecked(true);
//			radioDezesseis.setChecked(false);
//		} else {
//			if (campeonato.getQtdEquipe() == 16) {
//				radioDezesseis.setChecked(true);
//				radioOito.setChecked(false);
//			}
//		}
	}
	
	public void btnAtualizarStatus(View v){
		Toast.makeText(this, "Status Atualizado", Toast.LENGTH_SHORT).show();
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
