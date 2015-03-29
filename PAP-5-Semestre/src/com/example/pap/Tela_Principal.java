package com.example.pap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Tela_Principal extends Tela_Inicial{
	

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tela_principal);

			
			
		}
		
		
		public void btnCriarPartida (View view){
			Intent it3 = new Intent(Tela_Principal.this, Tela_Criar_Partida.class);
			startActivity(it3);
			
			
			
		}
		
		public void btnPerfil (View view){
			Intent it4 = new Intent(Tela_Principal.this, Tela_Perfil.class);
			startActivity(it4);
			
			
			
		}
}
