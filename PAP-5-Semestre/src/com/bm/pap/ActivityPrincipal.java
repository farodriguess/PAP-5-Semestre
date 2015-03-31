package com.bm.pap;

import com.bm.pap.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityPrincipal extends ActivityInicial{
	

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.tela_principal);

			
			
		}
		
		
		public void btnCriarPartida (View view){
			Intent it3 = new Intent(ActivityPrincipal.this, ActivityCriarPartida.class);
			startActivity(it3);
			
			
			
		}
		
		public void btnPerfil (View view){
			Intent it4 = new Intent(ActivityPrincipal.this, ActivityPerfil.class);
			startActivity(it4);
			
			
			
		}
		
		public void btnMeusCampeonatos (View view){
			Intent it5 = new Intent(ActivityPrincipal.this, ActivityMeusCampeonatos.class);
			startActivity(it5);
			
			
			
		}
}
