package com.bm.pap.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.text.DateFormat;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;

public class RegrasActivity extends Activity {
	private Campeonato campeonato;
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	private Spinner spinner5;
	private Spinner spinner6;
	private Spinner spinner7;
	private Spinner spinner8;
	private ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regras2);
		Intent intencao = getIntent();
		Bundle info = intencao.getExtras();
		campeonato = (Campeonato) info.getSerializable("campeonato");

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		adapter = ArrayAdapter.createFromResource(this, R.array.Pontos,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra1()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra1()));
			spinner1.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra2()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra2()));
			spinner2.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra3()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra3()));
			spinner3.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner4.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra4()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra4()));
			spinner4.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner5.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra5()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra5()));
			spinner5.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner6 = (Spinner) findViewById(R.id.spinner6);
		spinner6.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra6()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra6()));
			spinner6.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner7 = (Spinner) findViewById(R.id.spinner7);
		spinner7.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra7()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra7()));
			spinner7.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		spinner8 = (Spinner) findViewById(R.id.spinner8);
		spinner8.setAdapter(adapter);
		// setar spinner com valor pré determinado
		if (!Integer.toString(campeonato.getRegra8()).equals(null)) {
			int spinnerPostion = adapter.getPosition(Integer
					.toString(campeonato.getRegra8()));
			spinner8.setSelection(spinnerPostion);
			spinnerPostion = 0;
		}
		;

		Intent intent = new Intent();
		intent.putExtra("campeonato", campeonato);
		setResult(RESULT_OK, intent);

	}

	public void btnSalvar(View v) {
		campeonato.setRegra1(Integer.parseInt(spinner1.getSelectedItem()
				.toString()));
		campeonato.setRegra2(Integer.parseInt(spinner2.getSelectedItem()
				.toString()));
		campeonato.setRegra3(Integer.parseInt(spinner3.getSelectedItem()
				.toString()));
		campeonato.setRegra4(Integer.parseInt(spinner4.getSelectedItem()
				.toString()));
		campeonato.setRegra5(Integer.parseInt(spinner5.getSelectedItem()
				.toString()));
		campeonato.setRegra6(Integer.parseInt(spinner6.getSelectedItem()
				.toString()));
		campeonato.setRegra7(Integer.parseInt(spinner7.getSelectedItem()
				.toString()));
		campeonato.setRegra8(Integer.parseInt(spinner8.getSelectedItem()
				.toString()));
		Intent intent = new Intent();
		intent.putExtra("campeonato", campeonato);
		setResult(RESULT_OK, intent);
		this.finish();
	}
}
