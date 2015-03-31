package com.bm.pap;

import com.bm.pap.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInicial extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.tela_inicial);
	
	}
	
	
	
	public void btnEntrar(View view){
		
		EditText email = (EditText) findViewById(R.id.email);
		 EditText senha = (EditText) findViewById(R.id.senha);

	//	 if("ads2pap@outlook.com".equals(email.getText().toString()) &&
		//"123456db".equals(senha.getText().toString())) {
		Intent it = new Intent(ActivityInicial.this, ActivityPrincipal.class);
		startActivity(it);
	// 	}else{
		//	Toast.makeText(this, "E-mail ou senha errado!",Toast.LENGTH_SHORT).show();
//		}
		
	}
	
	
	public void btnCadastro(View view){
		Intent it2 = new Intent(ActivityInicial.this, ActivityCadastro.class);
		startActivity(it2);
		
		
		
	}

}
