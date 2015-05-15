package com.bm.pap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.bm.pap.entity.Campeonato;

public class SelecionarTimeCriarPartidas extends Activity {
	private Campeonato campeonato;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_selecionar_times);
		Intent intencao = getIntent();

		Bundle info = intencao.getExtras();
		campeonato=(Campeonato) info.getSerializable("campeonato");
		
		
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.TodosOsTimes, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);

}
 
}