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
		
		// INICIO ALLAN teste criar APOSTA grupos A B C D
		
		public void btnTelaAposta_G_A(View view){
			Intent itAposta_G_A = new Intent(PrincipalActivity.this, ApostaGrupo_A.class);
			startActivity(itAposta_G_A );
					
		}
		public void btnTelaAposta_G_B(View view){
			Intent itAposta_G_B = new Intent(PrincipalActivity.this, ApostaGrupo_B.class);
			startActivity(itAposta_G_B );
					
		}
		public void btnTelaAposta_G_C(View view){
			Intent itAposta_G_C = new Intent(PrincipalActivity.this, ApostaGrupo_C.class);
			startActivity(itAposta_G_C );
					
		}
		public void btnTelaAposta_G_D(View view){
			Intent itAposta_G_D = new Intent(PrincipalActivity.this, ApostaGrupo_D.class);
			startActivity(itAposta_G_D);
					
		}
		// FIM ALLAN teste criar APOSTA grupos A B C D
		
		
		//
		
		
		// INICIO ALLAN teste criar partida grupos A B C D
		public void btnCriarPartidaGrupoA (View view){
			Intent itCriarPartidaGrupoA = new Intent(PrincipalActivity.this, CriarPartidaGrupoA.class);
			startActivity(itCriarPartidaGrupoA);
		}
		
		public void btnCriarPartidaGrupoB (View view){
			Intent itCriarPartidaGrupoB = new Intent(PrincipalActivity.this, CriarPartidaGrupoB.class);
			startActivity(itCriarPartidaGrupoB);
		}
				
		
		public void btnCriarPartidaGrupoC (View view){
			Intent itCriarPartidaGrupoC = new Intent(PrincipalActivity.this, CriarPartidaGrupoC.class);
			startActivity(itCriarPartidaGrupoC);
		}
		
		public void btnCriarPartidaGrupoD (View view){
			Intent itCriarPartidaGrupoD = new Intent(PrincipalActivity.this, CriarPartidaGrupoD.class);
			startActivity(itCriarPartidaGrupoD);
		}
		
		// FIM ALLAN teste criar partida grupos A B C D
		
		public void botaoMeusTimes (View view){
			Intent intent = new Intent(this,MeusTimesActivity.class);
			startActivity(intent);
		}
}
