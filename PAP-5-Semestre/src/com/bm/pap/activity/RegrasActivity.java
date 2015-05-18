package com.bm.pap.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regras2);
		Intent intencao =getIntent();
		Bundle info = intencao.getExtras();
		campeonato=(Campeonato) info.getSerializable("campeonato");
		
		
		AlertDialog.Builder mensagem = new
				AlertDialog.Builder(RegrasActivity.this);
				mensagem.setTitle("Info");
				mensagem.setMessage("Nome campeonato: "+ campeonato.getNome() + "\n Quantidade Equipes: "+ campeonato.getQtdEquipe()+ "\n Data inicio: " + DateFormat.getDateInstance().format(campeonato.getDataInicio()));
				mensagem.setNeutralButton("OK", null);
				mensagem.show();
		
		
		
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra1()).equals(null)) {
	        int spinnerPostion = adapter.getPosition(Integer.toString(campeonato.getRegra1()));
	        spinner1.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner2 = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter2);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra2()).equals(null)) {
	        int spinnerPostion = adapter2.getPosition(Integer.toString(campeonato.getRegra2()));
	        spinner2.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter3);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra3()).equals(null)) {
	        int spinnerPostion = adapter3.getPosition(Integer.toString(campeonato.getRegra3()));
	        spinner3.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	  
		spinner4 = (Spinner) findViewById(R.id.spinner4);
	    ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner4.setAdapter(adapter4);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra4()).equals(null)) {
	        int spinnerPostion = adapter4.getPosition(Integer.toString(campeonato.getRegra4()));
	        spinner4.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner5 = (Spinner) findViewById(R.id.spinner5);
	    ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner5.setAdapter(adapter5);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra5()).equals(null)) {
	        int spinnerPostion = adapter5.getPosition(Integer.toString(campeonato.getRegra5()));
	        spinner5.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner6 = (Spinner) findViewById(R.id.spinner6);
	    ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner6.setAdapter(adapter6);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra6()).equals(null)) {
	        int spinnerPostion = adapter6.getPosition(Integer.toString(campeonato.getRegra6()));
	        spinner6.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    
	    spinner7 = (Spinner) findViewById(R.id.spinner7);
	    ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner7.setAdapter(adapter7);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra8()).equals(null)) {
	        int spinnerPostion = adapter7.getPosition(Integer.toString(campeonato.getRegra8()));
	        spinner7.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner8 = (Spinner) findViewById(R.id.spinner8);
	    ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner8.setAdapter(adapter8);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(campeonato.getRegra8()).equals(null)) {
	        int spinnerPostion = adapter8.getPosition(Integer.toString(campeonato.getRegra8()));
	        spinner8.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };    	    
	}
	
	public void btnSalvar(View v){	
		campeonato.setRegra1(Integer.parseInt(spinner1.getSelectedItem().toString())); 
		campeonato.setRegra2(Integer.parseInt(spinner2.getSelectedItem().toString())); 
		campeonato.setRegra3(Integer.parseInt(spinner3.getSelectedItem().toString())); 
		campeonato.setRegra4(Integer.parseInt(spinner4.getSelectedItem().toString())); 
		campeonato.setRegra5(Integer.parseInt(spinner5.getSelectedItem().toString())); 
		campeonato.setRegra6(Integer.parseInt(spinner6.getSelectedItem().toString())); 
		campeonato.setRegra7(Integer.parseInt(spinner7.getSelectedItem().toString())); 
		campeonato.setRegra8(Integer.parseInt(spinner8.getSelectedItem().toString())); 		
		Intent intent_ajustar_regras = new Intent(this, NovoCampeonatoActivity.class);
		intent_ajustar_regras.putExtra("campeonato", campeonato);
		startActivity(intent_ajustar_regras);			
	}
}
