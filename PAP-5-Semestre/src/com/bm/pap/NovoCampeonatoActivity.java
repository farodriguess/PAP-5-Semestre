package com.bm.pap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NovoCampeonatoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_campeonato);
	}
	
	public void btnAjustarRegras(View view){
		Intent intent_ajustar_regras = new Intent(this,RegrasActivity.class);
		startActivity(intent_ajustar_regras);
	}
	
	
	
	public void btnCriarPartida(View view){
		Intent intent_criarpartida = new Intent(this,SelecionarTimeCriarPartidas.class);
		startActivity(intent_criarpartida);
	}
}
