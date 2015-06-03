package com.bm.pap.activity;

import com.bm.pap.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ApostaGrupo_B extends Activity{
	
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
		setContentView(R.layout.activity_aposta_grupo_b);

		// espanha vs uruguai
		adapter = ArrayAdapter.createFromResource(this, R.array.Gols,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// resultado espanha
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setAdapter(adapter);
		spinner1.setSelection(adapter.getPosition("2"));

		// resultado uruguai
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setAdapter(adapter);
		;
		spinner2.setSelection(adapter.getPosition("0"));

		// taiti vs nigéria
		// resultado taiti
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setAdapter(adapter);
		spinner3.setSelection(adapter.getPosition("0"));

		// resultado nigéria
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner4.setAdapter(adapter);
		spinner4.setSelection(adapter.getPosition("2"));

		// espanha vs taiti

		// resultado espanha
		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner5.setAdapter(adapter);
		spinner5.setSelection(adapter.getPosition("5"));

		// resultado taiti
		spinner6 = (Spinner) findViewById(R.id.spinner6);
		spinner6.setAdapter(adapter);
		spinner6.setSelection(adapter.getPosition("0"));

		// nigéria vs uruguai
		// resultado nigeria
		spinner7 = (Spinner) findViewById(R.id.spinner7);
		spinner7.setAdapter(adapter);
		spinner7.setSelection(adapter.getPosition("0"));

		// resultado uruguai
		spinner8 = (Spinner) findViewById(R.id.spinner8);
		spinner8.setAdapter(adapter);
		spinner8.setSelection(adapter.getPosition("2"));

		// nigéria vs espanha
		// resultado nigéria
		spinner9 = (Spinner) findViewById(R.id.spinner9);
		spinner9.setAdapter(adapter);
		spinner9.setSelection(adapter.getPosition("0"));

		// resultado espanha
		spinner10 = (Spinner) findViewById(R.id.spinner10);
		spinner10.setAdapter(adapter);
		spinner10.setSelection(adapter.getPosition("3"));

		// uruguai vs taiti
		// resultado uruguai
		spinner11 = (Spinner) findViewById(R.id.spinner11);
		spinner11.setAdapter(adapter);
		spinner11.setSelection(adapter.getPosition("4"));

		// resultado taiti
		spinner12 = (Spinner) findViewById(R.id.spinner12);
		spinner12.setAdapter(adapter);
		spinner12.setSelection(adapter.getPosition("0"));
		
		spinner1.setEnabled(false);
		spinner2.setEnabled(false);
		spinner3.setEnabled(false);
		spinner4.setEnabled(false);
		spinner5.setEnabled(false);
		spinner6.setEnabled(false);
		spinner7.setEnabled(false);
		spinner8.setEnabled(false);
		spinner9.setEnabled(false);
		spinner10.setEnabled(false);
		spinner11.setEnabled(false);
		spinner12.setEnabled(false);
	}

}
