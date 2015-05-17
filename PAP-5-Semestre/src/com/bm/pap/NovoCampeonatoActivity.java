package com.bm.pap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bm.pap.entity.Campeonato;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovoCampeonatoActivity extends PrincipalActivity {
	private Campeonato campeonato;

	private Integer regra1;
	private Integer regra2;
	private Integer regra3;
	private Integer regra4;
	private Integer regra5;
	private Integer regra6;
	private Integer regra7;
	private Integer regra8;
	private String nome;
	// / --- allan pacheco alteracao para poupup
	private Date datainicio;// <<
	private Date datafim;// <<

	private int qtdEquipe;

	DateFormat formete2;
	Calendar calendarDataInicio;
	Calendar calendarDatafim;
	TextView campoDataInicio;// <<
	TextView campoDataFim;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_campeonato);

		campoDataInicio = (TextView) findViewById(R.id.datainicio);// <<
		campoDataFim = (TextView) findViewById(R.id.datafim);

		formete2 = DateFormat.getDateInstance();// /<<
		calendarDataInicio = Calendar.getInstance();// <<
		calendarDatafim = Calendar.getInstance();
		// botaoDataInicio.setOnClickListener(this);//<<
		// updatedate2();

		Intent intencao = getIntent();

		Bundle info = intencao.getExtras();

		if (info != null) {
			regra1 = info.getInt("regra1");
			regra2 = info.getInt("regra2");
			regra3 = info.getInt("regra3");
			regra4 = info.getInt("regra4");
			regra5 = info.getInt("regra5");
			regra6 = info.getInt("regra6");
			regra7 = info.getInt("regra7");
			regra8 = info.getInt("regra8");
		}
		;

		if (regra1 == null) {
			regra1 = 10;
		}
		;
		if (regra2 == null) {
			regra2 = 5;
		}
		;
		if (regra3 == null) {
			regra3 = 10;
		}
		;
		if (regra4 == null) {
			regra4 = 5;
		}
		;
		if (regra5 == null) {
			regra5 = 20;
		}
		;
		if (regra6 == null) {
			regra6 = 10;
		}
		;
		if (regra7 == null) {
			regra7 = 5;
		}
		;
		if (regra8 == null) {
			regra8 = 2;
		}
		;
	}// ///

	public void setDataInicio(View view) {// <<
		new DatePickerDialog(NovoCampeonatoActivity.this, dataInicioListener,
				calendarDataInicio.get(Calendar.YEAR),
				calendarDataInicio.get(Calendar.MONTH),
				calendarDataInicio.get(Calendar.DAY_OF_MONTH)).show();// <<
	}

	private DatePickerDialog.OnDateSetListener dataInicioListener = new DatePickerDialog.OnDateSetListener() {// <<

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,// <<
				int dayOfMonth) {// <<
			// TODO Auto-generated method stub

			calendarDataInicio.set(Calendar.YEAR, year);// <<
			calendarDataInicio.set(Calendar.MONTH, monthOfYear);// <<
			calendarDataInicio.set(Calendar.DAY_OF_MONTH, dayOfMonth);// <<
			campoDataInicio.setText(formete2.format(calendarDataInicio
					.getTime()));

			// <<
		}// <<
	};// <<

	public void setDataFim(View view) {
		new DatePickerDialog(NovoCampeonatoActivity.this, dataFimListener,
				calendarDatafim.get(Calendar.YEAR),
				calendarDataInicio.get(Calendar.MONTH),
				calendarDatafim.get(Calendar.DAY_OF_MONTH)).show();// <<
	}

	private DatePickerDialog.OnDateSetListener dataFimListener = new DatePickerDialog.OnDateSetListener() {// <<

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,// <<
				int dayOfMonth) {// <<
			// TODO Auto-generated method stub

			calendarDatafim.set(Calendar.YEAR, year);// <<
			calendarDatafim.set(Calendar.MONTH, monthOfYear);// <<
			calendarDatafim.set(Calendar.DAY_OF_MONTH, dayOfMonth);// <<
			campoDataFim.setText(formete2.format(calendarDatafim.getTime()));
			// <<
		}// <<
	};// <<

	public void btnAjustarRegras(View view) {
		Intent intent_ajustar_regras = new Intent(this, RegrasActivity.class);
		Bundle info = new Bundle();
		info.putInt("regra1", regra1);
		info.putInt("regra2", regra2);
		info.putInt("regra3", regra3);
		info.putInt("regra4", regra4);
		info.putInt("regra5", regra5);
		info.putInt("regra6", regra6);
		info.putInt("regra7", regra7);
		info.putInt("regra8", regra8);
		intent_ajustar_regras.putExtras(info);
		startActivity(intent_ajustar_regras);

	}

	// testar data allan 14-05

	public void btnCriarPartidas(View view) {

		EditText nome = (EditText) findViewById(R.id.campoNomeCampeonato);
		EditText dataInicio = (EditText) findViewById(R.id.datainicio);
		EditText dataFinal = (EditText) findViewById(R.id.datafim);

		if (nome.getText().toString().trim().length() > 0) {
			if (nome.getText().toString().length() <= 30) {
				if (qtdEquipe == 8 || qtdEquipe == 16) {
					campeonato.setNome(nome.getText().toString());
					try {
						campeonato.setDataInicio(new SimpleDateFormat(
								"dd/MM/yyyy").parse(dataInicio.getText()
								.toString()));

						campeonato.setDataFinal(new SimpleDateFormat(
								"dd/MM/yyyy").parse(dataFinal.getText()
								.toString()));
					} catch (ParseException e) {
						e.printStackTrace();
					}

					campeonato.setQtdEquipe(qtdEquipe);
					campeonato.setStatus("Aguardando Iniciar");

					campeonato.setRegra1(regra1);
					campeonato.setRegra2(regra2);
					campeonato.setRegra3(regra3);
					campeonato.setRegra4(regra4);
					campeonato.setRegra5(regra5);
					campeonato.setRegra6(regra6);
					campeonato.setRegra7(regra7);
					campeonato.setRegra8(regra8);

					Intent intent = new Intent(this, RegrasActivity.class);
					startActivity(intent);

				} else {
					Toast.makeText(this, "Escolha quantidade de equipes!",
							Toast.LENGTH_SHORT).show();
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

	public void btnOitoEquipes(View view) {
		qtdEquipe = 8;

	}

	public void btnDezesseisEquipes(View view) {
		qtdEquipe = 16;

	}

}
