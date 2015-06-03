package com.bm.pap.activity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

public class PesquisarActivity extends Activity {
private Usuario usuario;
private Campeonato campeonato;
private Spinner spinner1;
private ArrayAdapter<CharSequence> adapter;
private DateFormat formatar;
private Calendar calendarDataInicio;
private Calendar calendarDatafim;
private TextView campoDataInicio; 
private TextView campoDataFim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pesquisa);
		
		campoDataInicio = (TextView) findViewById(R.id.lblInicio);
		campoDataFim = (TextView) findViewById(R.id.lblFim);
		calendarDataInicio = Calendar.getInstance();
		calendarDatafim = Calendar.getInstance();
		formatar = DateFormat.getDateInstance();		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		adapter = ArrayAdapter.createFromResource(this, R.array.Status,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
	}
	
	public void setDataInicio(View view) {
		new DatePickerDialog(PesquisarActivity.this, dataInicioListener,
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
			campoDataInicio.setText(formatar.format(calendarDataInicio
					.getTime()));
			
		}
	};

	public void setDataFim(View view) {
		new DatePickerDialog(PesquisarActivity.this, dataFimListener,
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
			campoDataFim.setText(formatar.format(calendarDatafim.getTime()));
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
