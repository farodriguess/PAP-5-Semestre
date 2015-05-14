package com.bm.pap.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.bm.pap.PrincipalActivity;
import com.bm.pap.entity.Usuario;
import com.bm.pap.service.generic.ClientPostWSTask;
import com.bm.pap.service.generic.ObjectLoadedListener;
import com.google.gson.Gson;

public class UsuarioWS implements ObjectLoadedListener {

	private static final int RealizarLogin = 1;
	private static final int CadastrarNovoUsuario = 2;

	private Usuario usuario;

	private ClientPostWSTask cp;

	private Context context;

	private Gson gson;

	public UsuarioWS(Usuario usuario, Context context) {
		this.context = context;
		this.usuario = usuario;
		gson = new Gson();

	}

	@Override
	public void onObjectLoaded(String obj, int solicitante) {
		// TODO Auto-generated method stub
		this.usuario = gson.fromJson(obj, Usuario.class);
		switch (solicitante) {
		case RealizarLogin: {
			
							
			if (usuario != null) {
				Intent intent = new Intent(context, PrincipalActivity.class);
				intent.putExtra("usuario", usuario);
				context.startActivity(intent);
			} else {
				if(context!=null)
				Log.v("É nulo?", context.toString());
				Toast t =Toast.makeText(context, "Usuário ou Senha Inválidos",Toast.LENGTH_LONG);
				t.show();
			}
		}

			break;
		case CadastrarNovoUsuario: {

		}
			break;

		default:
			break;
		}

	}

	public void realizarLogin() {
		String user = gson.toJson(usuario);		
		cp = new ClientPostWSTask(context, "/usuario/login", this, user,
				RealizarLogin);
		cp.execute();
	}

	public void cadastrarNovoUsuario() {
		String user = gson.toJson(usuario);
		cp = new ClientPostWSTask(context, "/usuario/novoUsuario", this, user,
				CadastrarNovoUsuario);
		cp.execute();
	}

}
