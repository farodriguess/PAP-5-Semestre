package com.bm.pap.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bm.pap.R;

public class ResultadoGrupoA extends Activity {
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	private Spinner spinner5;
	private Spinner spinner6;
	private Spinner spinner7;
	private Spinner spinner8;
	private Spinner spinner9;
	private Spinner spinner10;	
	private Spinner spinner11;
	private Spinner spinner12;
	ArrayAdapter<CharSequence> adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado_grupo_a);

		// brasil vs japão
		adapter = ArrayAdapter.createFromResource(this, R.array.Gols,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// resultado brasil
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setAdapter(adapter);
		spinner1.setSelection(adapter.getPosition("3"));

		// resultado japão
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setAdapter(adapter);
		;
		spinner2.setSelection(adapter.getPosition("0"));

		// méxico vs italia
		// resultado méxico
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setAdapter(adapter);
		spinner3.setSelection(adapter.getPosition("1"));

		// resultado itália
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner4.setAdapter(adapter);
		spinner4.setSelection(adapter.getPosition("2"));

		// brasil vs mexico

		// resultado brasil
		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner5.setAdapter(adapter);
		spinner5.setSelection(adapter.getPosition("2"));

		// resultado mexico
		spinner6 = (Spinner) findViewById(R.id.spinner6);
		spinner6.setAdapter(adapter);
		spinner6.setSelection(adapter.getPosition("0"));

		// italia vs japão
		// resultado itália
		spinner7 = (Spinner) findViewById(R.id.spinner7);
		spinner7.setAdapter(adapter);
		spinner7.setSelection(adapter.getPosition("4"));

		// resultado japão
		spinner8 = (Spinner) findViewById(R.id.spinner8);
		spinner8.setAdapter(adapter);
		spinner8.setSelection(adapter.getPosition("3"));

		// italia vs brasil
		// resultado itália
		spinner9 = (Spinner) findViewById(R.id.spinner9);
		spinner9.setAdapter(adapter);
		spinner9.setSelection(adapter.getPosition("2"));

		// resultado brasil
		spinner10 = (Spinner) findViewById(R.id.spinner10);
		spinner10.setAdapter(adapter);
		spinner10.setSelection(adapter.getPosition("4"));

		// japão vs méxico
		// resultado japão
		spinner11 = (Spinner) findViewById(R.id.spinner11);
		spinner11.setAdapter(adapter);
		spinner11.setSelection(adapter.getPosition("1"));

		// resultado méxico
		spinner12 = (Spinner) findViewById(R.id.spinner12);
		spinner12.setAdapter(adapter);
		spinner12.setSelection(adapter.getPosition("2"));
	}
}
