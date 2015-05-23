package com.bm.pap.activity;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

public class NovoCampeonatoActivity extends Activity {

	private Campeonato campeonato;
	private EditText nome;
	private RadioGroup rg;
	private DateFormat formete2;
	private Calendar calendarDataInicio;
	private Calendar calendarDatafim;
	private TextView campoDataInicio; 
	private TextView campoDataFim;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_campeonato);
		campoDataInicio = (TextView) findViewById(R.id.datainicio);
		campoDataFim = (TextView) findViewById(R.id.datafim);
		calendarDataInicio = Calendar.getInstance();
		calendarDatafim = Calendar.getInstance();
		formete2 = DateFormat.getDateInstance();
		nome = (EditText) findViewById(R.id.campoNomeCampeonato);
		// iniciar campeonato e setar regras
		Intent intencao = getIntent();
		Bundle info = intencao.getExtras();
		if (info.getSerializable("campeonato") != null) {
			campeonato = (Campeonato) info.getSerializable("campeonato");
			nome.setText(campeonato.getNome());
			RadioButton radioOito = (RadioButton) findViewById(R.id.radioButton1);
			RadioButton radioDezesseis = (RadioButton) findViewById(R.id.radioButton2);
			calendarDataInicio.setTime(campeonato.getDataInicio());
			calendarDatafim.setTime(campeonato.getDataFinal());
			campoDataInicio.setText(formete2.format(calendarDataInicio
					.getTime()));
			campoDataFim.setText(formete2.format(calendarDatafim.getTime()));
			if (campeonato.getQtdEquipe() == 8) {
				radioOito.setChecked(true);
				radioDezesseis.setChecked(false);
			} else {
				if (campeonato.getQtdEquipe() == 16) {
					radioDezesseis.setChecked(true);
					radioOito.setChecked(false);
				}				
			}
		} else {
			campeonato = new Campeonato();
			campeonato.setUsuario((Usuario) info.getSerializable("usuario"));
			campeonato.setRegra1(10);
			campeonato.setRegra2(5);
			campeonato.setRegra3(10);
			campeonato.setRegra4(5);
			campeonato.setRegra5(20);
			campeonato.setRegra6(10);
			campeonato.setRegra7(5);
			campeonato.setRegra8(2);
			campeonato.setStatus("Aguardando Iniciar");
			campoDataInicio.setText(formete2.format(calendarDataInicio
					.getTime()));
			campoDataFim.setText(formete2.format(calendarDatafim.getTime()));
		}		
	}

	public void setDataInicio(View view) {
		new DatePickerDialog(NovoCampeonatoActivity.this, dataInicioListener,
				calendarDataInicio.get(Calendar.YEAR),
				calendarDataInicio.get(Calendar.MONTH),
				calendarDataInicio.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataInicioListener = new DatePickerDialog.OnDateSetListener() { 

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			calendarDataInicio.set(Calendar.YEAR, year);
			calendarDataInicio.set(Calendar.MONTH, monthOfYear);
			calendarDataInicio.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			campoDataInicio.setText(formete2.format(calendarDataInicio
					.getTime()));
			
		}
	};

	public void setDataFim(View view) {
		new DatePickerDialog(NovoCampeonatoActivity.this, dataFimListener,
				calendarDatafim.get(Calendar.YEAR),
				calendarDataInicio.get(Calendar.MONTH),
				calendarDatafim.get(Calendar.DAY_OF_MONTH)).show(); 
	}

	private DatePickerDialog.OnDateSetListener dataFimListener = new DatePickerDialog.OnDateSetListener() { 

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, 
				int dayOfMonth) { 
			
			calendarDatafim.set(Calendar.YEAR, year);
			calendarDatafim.set(Calendar.MONTH, monthOfYear); 
			calendarDatafim.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			campoDataFim.setText(formete2.format(calendarDatafim.getTime()));
			
		}
	};

	public void btnAjustarRegras(View view) {
		rg = (RadioGroup) findViewById(R.id.qtdEquipes);
		int op = rg.getCheckedRadioButtonId();
		if (op == R.id.radioButton1) {
			campeonato.setQtdEquipe(8);
		} else {
			if (op == R.id.radioButton2) {
				campeonato.setQtdEquipe(16);
			}
		}
		;
		campeonato.setDataInicio(calendarDataInicio.getTime());
		campeonato.setDataFinal(calendarDatafim.getTime());
		campeonato.setNome(nome.getText().toString());
		Intent intent_ajustar_regras = new Intent(this, RegrasActivity.class);
		intent_ajustar_regras.putExtra("campeonato", campeonato);
		startActivityForResult(intent_ajustar_regras, 1);
	}

	// testar data allan 14-05

	// Alterado as lógicas do botão Criar Partidas (Jeferson)
	public void btnCriarPartidas(View view) {

		if (nome.getText().toString().trim().length() > 0) {
			if (nome.getText().toString().length() <= 30) {
				campeonato.setNome(nome.getText().toString());
				campeonato.setDataInicio(calendarDataInicio.getTime());
				campeonato.setDataFinal(calendarDatafim.getTime());
				rg = (RadioGroup) findViewById(R.id.qtdEquipes);
				int op = rg.getCheckedRadioButtonId();

				if (op == R.id.radioButton1) {
					campeonato.setQtdEquipe(8);
				} else {
					if (op == R.id.radioButton2) {
						campeonato.setQtdEquipe(16);
					}
				}
				;

				if (calendarDataInicio.equals(Calendar.getInstance())
						|| calendarDataInicio.after(Calendar.getInstance())) {
					if (calendarDatafim.equals(calendarDataInicio)
							|| calendarDatafim.after(calendarDataInicio)) {
						Intent intent = new Intent(this,
								SelecionarTimeCriarPartidas.class);
						intent.putExtra("campeonato", campeonato);
						startActivity(intent);
					} else {
						Toast.makeText(this,
								"Data final inferior a data inicial!",
								Toast.LENGTH_LONG).show();
						calendarDatafim = calendarDataInicio;
						campoDataFim.setText(formete2.format(calendarDatafim
								.getTime()));
					}

				} else {
					Toast.makeText(this, "Data inicial inferior a data atual!",
							Toast.LENGTH_LONG).show();
					calendarDataInicio = Calendar.getInstance();
					campoDataInicio.setText(formete2.format(calendarDataInicio
							.getTime()));
				}

			} else {
				Toast.makeText(this,
						"A equipe deve ter no máximo 30 caracteres!",
						Toast.LENGTH_SHORT).show();
			}

		} else {
			Toast.makeText(this, "Campo nome em branco!", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		this.campeonato = (Campeonato) data.getSerializableExtra("campeonato");

	}

}
