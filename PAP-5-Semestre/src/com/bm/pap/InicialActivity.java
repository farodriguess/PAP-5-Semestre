package com.bm.pap;

import com.bm.pap.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InicialActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_inicial);
	    
	    
	  
	
	}
	
	
	
	public void btnEntrar(View view){
		
		

		
		EditText email = (EditText) findViewById(R.id.email);
		 EditText senha = (EditText) findViewById(R.id.senha);

	//	 if("ads2pap@outlook.com".equals(email.getText().toString()) &&
		//"123456db".equals(senha.getText().toString())) {
		Intent it = new Intent(InicialActivity.this, PrincipalActivity.class);
		startActivity(it);
	// 	}else{
		//	Toast.makeText(this, "E-mail ou senha errado!",Toast.LENGTH_SHORT).show();
//		}
		
	}
	
	
	public void btnCadastro(View view){
		Intent it2 = new Intent(InicialActivity.this, CadastroActivity.class);
		startActivity(it2);
		
		
		
	}

	//btnRecuerarSenha
	
	public void btnRecuperarSenha(View view){
		Intent itent_rec_Senha = new Intent(InicialActivity.this, RecuperarSenha.class);
		startActivity(itent_rec_Senha);
	}
}
