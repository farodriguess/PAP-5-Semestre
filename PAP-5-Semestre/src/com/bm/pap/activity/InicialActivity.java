package com.bm.pap.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;

public class InicialActivity extends Activity implements ObjectLoadedListener {

	private static final int LOGIN = 1;
	private static final String CAMINHOLOGIN = "/usuario/login";
	private Usuario usuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_inicial);

	}

	public void btnEntrar(View view) {

		EditText email = (EditText) findViewById(R.id.email);
		EditText senha = (EditText) findViewById(R.id.senha);

		usuario = new Usuario();
		usuario.setEmail(email.getText().toString());
		usuario.setSenha(senha.getText().toString());

		ClientPostWSTask login = new ClientPostWSTask(this, CAMINHOLOGIN, this,
				new Gson().toJson(usuario), LOGIN);
		login.execute();
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

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		switch (solicitante) {
		case LOGIN: {
			usuario = new Gson().fromJson(obj, Usuario.class);
			realizarLongin();

		}

			break;

		default:
			break;
		}

	}

	private void realizarLongin() {
		if (usuario != null) {
			Intent i = new Intent(this, PrincipalActivity.class);
			startActivity(i);
		} else {
			Toast.makeText(this, "Usuario ou senha Invalidos",
					Toast.LENGTH_LONG).show();
		}
	}
}
