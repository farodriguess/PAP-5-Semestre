package com.bm.pap.activity;

import com.bm.pap.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class RegrasActivity extends Activity {
	private int regra1;
	private int regra2;
	private int regra3;
	private int regra4;
	private int regra5;
	private int regra6;
	private int regra7;
	private int regra8;
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
		regra1 = info.getInt("regra1");
		regra2 = info.getInt("regra2");
		regra3 = info.getInt("regra3");
		regra4 = info.getInt("regra4");
		regra5 = info.getInt("regra5");
		regra6 = info.getInt("regra6");
		regra7 = info.getInt("regra7");
		regra8 = info.getInt("regra8");
		
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner1.setAdapter(adapter);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra1).equals(null)) {
	        int spinnerPostion = adapter.getPosition(Integer.toString(regra1));
	        spinner1.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner2 = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner2.setAdapter(adapter2);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra2).equals(null)) {
	        int spinnerPostion = adapter2.getPosition(Integer.toString(regra2));
	        spinner2.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    spinner3 = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner3.setAdapter(adapter3);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra3).equals(null)) {
	        int spinnerPostion = adapter3.getPosition(Integer.toString(regra3));
	        spinner3.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	  
		spinner4 = (Spinner) findViewById(R.id.spinner4);
	    ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner4.setAdapter(adapter4);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra4).equals(null)) {
	        int spinnerPostion = adapter4.getPosition(Integer.toString(regra4));
	        spinner4.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner5 = (Spinner) findViewById(R.id.spinner5);
	    ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner5.setAdapter(adapter5);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra5).equals(null)) {
	        int spinnerPostion = adapter5.getPosition(Integer.toString(regra5));
	        spinner5.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner6 = (Spinner) findViewById(R.id.spinner6);
	    ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner6.setAdapter(adapter6);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra6).equals(null)) {
	        int spinnerPostion = adapter6.getPosition(Integer.toString(regra6));
	        spinner6.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    
	    spinner7 = (Spinner) findViewById(R.id.spinner7);
	    ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner7.setAdapter(adapter7);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra7).equals(null)) {
	        int spinnerPostion = adapter7.getPosition(Integer.toString(regra7));
	        spinner7.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };
	    
	    spinner8 = (Spinner) findViewById(R.id.spinner8);
	    ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
	    this, R.array.Pontos, android.R.layout.simple_spinner_item);
	    adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner8.setAdapter(adapter8);
	    //setar spinner com valor pré determinado
	    if (!Integer.toString(regra8).equals(null)) {
	        int spinnerPostion = adapter8.getPosition(Integer.toString(regra8));
	        spinner8.setSelection(spinnerPostion);
	        spinnerPostion = 0;
	    };    	    
	}
	
	public void btnSalvar(View v){
		
		regra1 = Integer.parseInt(spinner1.getSelectedItem().toString());
		regra2 = Integer.parseInt(spinner2.getSelectedItem().toString());
		regra3 = Integer.parseInt(spinner3.getSelectedItem().toString());
		regra4 = Integer.parseInt(spinner4.getSelectedItem().toString());
		regra5 = Integer.parseInt(spinner5.getSelectedItem().toString());
		regra6 = Integer.parseInt(spinner6.getSelectedItem().toString());
		regra7 = Integer.parseInt(spinner7.getSelectedItem().toString());
		regra8 = Integer.parseInt(spinner8.getSelectedItem().toString());
		
		Intent intent_ajustar_regras = new Intent(this, NovoCampeonatoActivity.class);
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
}
