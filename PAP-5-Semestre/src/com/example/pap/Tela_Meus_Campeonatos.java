package com.example.pap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Meus_Campeonatos extends Tela_Principal{
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.tela_meus_campeonatos);

}
	public void botaoNovo(View view){
		Intent intent = new Intent(this, TelaEditarCampeonato.class);
		startActivity(intent);
	}

}
