package com.bm.pap;

import com.bm.pap.R;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;



public class PrincipalActivity extends InicialActivity implements View.OnClickListener{//<<

	DateFormat formete = DateFormat.getDateInstance();//<<
	Calendar calendar=Calendar.getInstance();//<<
	TextView label;//<<
	Button btn;//<<
	

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_principal);

			label=(TextView)findViewById(R.id.textView2);//<<
			btn=(Button)findViewById(R.id.button19);//<<
			btn.setOnClickListener(this);//<<
			updatedate();
		}
		
		public void updatedate()//<<<<<
		{
			
			
			label.setText(formete.format(calendar.getTime()));//<<
		}
		
		public void setDate(){//<<
			new DatePickerDialog(PrincipalActivity.this, d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();//<<
		}
		DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {//<<
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,//<<
					int dayOfMonth) {
				// TODO Auto-generated method stub//<<
				
			calendar.set(Calendar.YEAR,year);//<<
			calendar.set(Calendar.MONTH,monthOfYear);//<<
			calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);//<<
			updatedate();//<<
			//<<//<<
			}//<<
		};//<<
			
			
		
		// testar data allan 14-05 acho q nao estou usando esse onclick
		
		public void btnData (View view){
			Intent itent_data = new Intent(PrincipalActivity.this, Calendario.class);
			startActivity(itent_data);
			
			//<<
			
		}
		

		
		
		public void btnPartiparDeCampeonatos (View view){
			Intent itent_participar_de_camp = new Intent(PrincipalActivity.this, ParticiparDeCampeonatos.class);
			startActivity(itent_participar_de_camp);
			
			
			
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

				@Override  //<<
				public void onClick(View v) {//<<
					// TODO Auto-generated method stub//<<
					setDate();//<<//<<
					
				}
}
