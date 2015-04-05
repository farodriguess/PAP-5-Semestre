package com.bm.pap;

import com.bm.pap.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMeusCampeonatos extends ActivityPrincipal{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_meus_campeonatos);

}
	public void botaoNovo(View view){
		Intent intent = new Intent(this, ActivityEditarCampeonato.class);
		startActivity(intent);
	}

}
