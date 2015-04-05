package com.bm.pap;

import com.bm.pap.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends InicialActivity{
	

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_principal);

			
			
		}
		
		
		public void btnCriarPartida (View view){
			Intent it3 = new Intent(PrincipalActivity.this, CriarPartidaActivity.class);
			startActivity(it3);
			
			
			
		}
		
		public void btnPerfil (View view){
			Intent it4 = new Intent(PrincipalActivity.this, PerfilActivity.class);
			startActivity(it4);
			
			
			
		}
		
		public void btnMeusCampeonatos (View view){
			Intent it5 = new Intent(PrincipalActivity.this, MeusCampeonatosActivity.class);
			startActivity(it5);
			
			
			
		}
		public void botaoMeusTimes (View view){
			Intent intent = new Intent(this,MeusTimesActivity.class);
			startActivity(intent);
		}
}
