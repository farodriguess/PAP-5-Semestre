package com.bm.pap.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;

public class CadastroActivity extends Activity implements ObjectLoadedListener{

	private static final int NOVOUSUARIO = 1;
	private static final String CAMINHONOVOUSUARIO = "usuario/novoUsuario";
	private Usuario user;

	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_cadastro);
		user = new Usuario();

	}

	public void btnCadastrar(View view) {

		EditText nome = (EditText) findViewById(R.id.cadastroNome);
		EditText email = (EditText) findViewById(R.id.cadastroEmail);
		EditText senha = (EditText) findViewById(R.id.cadastroSenha);
		EditText confirmaSenha = (EditText) findViewById(R.id.cadastroConfirmaSenha);

		if (nome.getText().toString().length() <= 20) {

			if (senha.getText().toString()
					.equals(confirmaSenha.getText().toString())) {
				user.setNome(nome.getText().toString());
				user.setEmail(email.getText().toString());
				user.setSenha(senha.getText().toString());
				
				ClientPostWSTask task = new ClientPostWSTask(this, CAMINHONOVOUSUARIO, this, new Gson().toJson(user), NOVOUSUARIO);
				task.execute();
				
			} else {
				Toast.makeText(this, "A senha esta incorreta!",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(this, "O nome deve conter no máixmo 20 caracteres!",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		switch (solicitante) {
		case NOVOUSUARIO:{
			cadastrarNovoUsuario(obj);
		}
			
			break;

		default:
			break;
		}
		
	}
	
	private void cadastrarNovoUsuario(String msg){
		if(msg.equals("OK")){
			Toast.makeText(this, "Usuario cadastrado com sucesso", Toast.LENGTH_LONG).show();
			finish();
		} else {
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		}
	}

}
