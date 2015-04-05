package com.bm.pap;

import com.bm.pap.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EditarCampeonatoActivity extends MeusCampeonatosActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_campeonato);
	}
	
	public void botaoAjustarRegras(View view){
		Intent intent = new Intent(this,RegrasActivity.class);
		startActivity(intent);
	}
	
	


}
