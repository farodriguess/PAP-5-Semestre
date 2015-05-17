package com.bm.pap.activity;

import com.bm.pap.R;
import com.bm.pap.entity.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends InicialActivity{
	
	private Bundle info;
	

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_principal);
			Intent intencao = getIntent();
			info = intencao.getExtras();
				
			
		}
		
		// testar data allan 14-05
		
		public void btnData (View view){
			Intent itent_data = new Intent(PrincipalActivity.this, Calendario.class);
			itent_data.putExtra("usuario", info);
			startActivity(itent_data);
			
			
			
		}
		

		
		
		public void btnPartiparDeCampeonatos (View view){
			Intent itent_participar_de_camp = new Intent(PrincipalActivity.this, ParticiparDeCampeonatos.class);
			itent_participar_de_camp.putExtra("usuario", info);
			startActivity(itent_participar_de_camp);
			
			
			
		}
		
		public void btnPerfil (View view){
			Intent it4 = new Intent(PrincipalActivity.this, PerfilActivity.class);
			it4.putExtra("usuario", info);
			startActivity(it4);
			
			
			
		}
		
		public void btnMeusCampeonatos (View view){
			Intent it5 = new Intent(PrincipalActivity.this, MeusCampeonatosActivity.class);
			it5.putExtra("bundle", info);
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
		
		// INICIO ALLAN teste criar aposta final
		public void btnApostaFinal (View view){
			Intent itApostaFinal= new Intent(PrincipalActivity.this, ApostaFinal.class);
			startActivity(itApostaFinal);
		}
		// FIM ALLAN
		
		// INICIO ALLAN teste criar aposta terceiro lugar
				public void btnApostaTerceiroLugar (View view){
					Intent itApostaTerceiroLugar= new Intent(PrincipalActivity.this, ApostaTerceiroLugar.class);
					startActivity(itApostaTerceiroLugar);
				}
				// FIM ALLAN 
				
				// INICIO ALLAN teste criar aposta semifinal
				public void btnApostaSemifinal (View view){
					Intent itApostaSemifinal= new Intent(PrincipalActivity.this, ApostaSemifinal.class);
					startActivity(itApostaSemifinal);
				}
				// FIM ALLAN  btnApostaQuartas
				
				// INICIO ALLAN teste criar aposta quartas
				public void btnApostaQuartas (View view){
					Intent itApostaQuartas= new Intent(PrincipalActivity.this, ApostaQuartasDeFinais.class);
					startActivity(itApostaQuartas);
				}
				// FIM ALLAN 
				
				// INICIO ALLAN teste criar aposta oitavas
				public void btnApostaOitavas (View view){
					Intent itApostaOitavas= new Intent(PrincipalActivity.this, ApostaOitavaDeFinais.class);
					startActivity(itApostaOitavas);
				}
				// FIM ALLAN 
				
				
				
				// INICIO ALLAN teste ver resultado oitavas
				public void btnResult8 (View view){
					Intent itResultOitavas= new Intent(PrincipalActivity.this, ResultadoOitavas.class);
					startActivity(itResultOitavas);
				}
				// FIM ALLAN 

		
		public void botaoMeusTimes (View view){
			Intent intent = new Intent(this,MeusTimesActivity.class);
			startActivity(intent);
		}
}
