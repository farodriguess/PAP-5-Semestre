package com.bm.pap.service.generic;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class ClientPutWSTask extends AsyncTask<Object, Object, String> {

	private static final String URI = "http://franciscoanderson.com/BolaoWebService/webresources/";
	private static final String TAG = "ClientPutWSTask.java";

	private String obj;

	private String req;
	private ObjectLoadedListener objectLoadedListener;
	private Context context;
	private String caminho;
	// identificação do metodo solicitante
	private int solicitante;

	private ProgressDialog dialog;

	// Cria uma instancia de http client
	private HttpClient cliente;

	public ClientPutWSTask(Context context, String caminho,
			ObjectLoadedListener objectLoadedListener, String req,
			int solicitante) {
		this.req = req;
		this.caminho = caminho;
		this.context = context;
		this.objectLoadedListener = objectLoadedListener;
		this.solicitante = solicitante;
		cliente = new DefaultHttpClient();
	}

	@Override
	protected String doInBackground(Object... params) {
		// TODO Auto-generated method stub

		try {

			HttpPut requisicaoPut = new HttpPut(URI + caminho);

			StringEntity reqEntity = new StringEntity(req,"UTF-8");

			reqEntity.setContentType("application/json");			
			requisicaoPut.setEntity(reqEntity);
			cliente.execute(requisicaoPut);
			obj = "Time Cadastrado com Sucesso";

		} catch (Exception ex) {
			Log.v(TAG, ex.toString());
			obj = "erro";
		} finally {
			cliente.getConnectionManager().shutdown();
		}

		return null;
	}

	@Override
	protected void onPostExecute(String nameString) {
		dialog.dismiss();
		objectLoadedListener.onObjectLoaded(this.obj, solicitante);
	}

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(context);
		dialog.setTitle("Aguarde");
		dialog.setMessage("carregando informações");
		dialog.show();
	}

}
