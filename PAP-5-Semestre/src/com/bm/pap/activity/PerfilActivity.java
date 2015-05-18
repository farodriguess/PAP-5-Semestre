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

public class PerfilActivity extends Activity implements ObjectLoadedListener {

	private static final int USUARIO = 1;
	private static final String CAMINHOUSUARIO = "usuario/editarUsuario";

	private Usuario usuario;
	private EditText campoNome;
	private EditText campoEmail;
	private EditText campoSenha;
	private EditText campoConfSenha;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_perfil);

		Intent intencao = getIntent();
		Bundle bundle = intencao.getExtras();
		usuario = (Usuario) bundle.getSerializable("usuario");

		carregarCampos();

		campoNome.setText(usuario.getNome());
		campoEmail.setText(usuario.getEmail());
		campoSenha.setText(usuario.getSenha());
		campoConfSenha.setText(usuario.getSenha());

		Intent intent = new Intent();
		intent.putExtra("usuario", usuario);
		setResult(RESULT_OK, intent);

	}

	public void salvar(View view) {
		// carregarCampos();
		if (campoSenha.getText().toString()
				.equals(campoConfSenha.getText().toString())) {

			usuario.setNome(campoNome.getText().toString());
			usuario.setEmail(campoEmail.getText().toString());
			usuario.setSenha(campoSenha.getText().toString());

			ClientPostWSTask task = new ClientPostWSTask(this, CAMINHOUSUARIO,
					this, new Gson().toJson(usuario), USUARIO);
			task.execute();

		} else {
			Toast.makeText(this, "Campo Senha não Confere", Toast.LENGTH_LONG)
					.show();
		}

	}

	private void carregarCampos() {
		campoNome = (EditText) findViewById(R.id.campoNome);
		campoEmail = (EditText) findViewById(R.id.campoEmail);
		campoSenha = (EditText) findViewById(R.id.campoSenha);
		campoConfSenha = (EditText) findViewById(R.id.campoSenha2);
	}

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		// TODO Auto-generated method stub
		switch (solicitante) {
		case USUARIO: {
			if (obj.equals("OK")) {
				Toast.makeText(this, "Usuario alterado com Sucesso",
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent();
				intent.putExtra("usuario", usuario);
				setResult(RESULT_OK, intent);
				this.finish();
			} else {
				Toast.makeText(this, obj, Toast.LENGTH_LONG).show();
			}
		}

			break;

		default:
			break;
		}

	}

}
