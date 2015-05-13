package com.bm.pap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bm.pap.entity.Usuario;
import com.bm.pap.service.UsuarioWS;

public class InicialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	    setContentView(R.layout.activity_inicial);
	    
	    
	  
	
	}
	
	
	

	public void btnEntrar(View view) {

		EditText email = (EditText) findViewById(R.id.email);
		EditText senha = (EditText) findViewById(R.id.senha);
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email.getText().toString());
		usuario.setSenha(senha.getText().toString());
		
		UsuarioWS ws = new UsuarioWS(usuario, this);
		ws.realizarLogin();
	}

	public void btnCadastro(View view) {
		Intent it2 = new Intent(InicialActivity.this, CadastroActivity.class);
		startActivity(it2);

	}

	// btnRecuerarSenha

	public void btnRecuperarSenha(View view) {
		Intent itent_rec_Senha = new Intent(InicialActivity.this,
				RecuperarSenha.class);
		startActivity(itent_rec_Senha);
	}
}
