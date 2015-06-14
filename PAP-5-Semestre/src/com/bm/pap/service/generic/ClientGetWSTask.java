package com.bm.pap.service.generic;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class ClientGetWSTask extends AsyncTask<Object, Object, String> {

	private static final String URI = "http://franciscoanderson.com/BolaoWebService/webresources";

	private static final String TAG = "ClientGetWSTask.java";

	private String obj;

	private String caminho;
	private Context context;
	private ObjectLoadedListener objectLoadedListener;
	// identificação do metodo solicitante
	private int solicitante;

	private ProgressDialog dialog;

	// Cria uma instancia de http client
	private HttpClient cliente;

	public ClientGetWSTask(Context context, String caminho,
			ObjectLoadedListener objectLoadedListener, int solicitante) {
		this.caminho = caminho;
		this.objectLoadedListener = objectLoadedListener;
		this.context = context;
		this.solicitante=solicitante;
		cliente = new DefaultHttpClient();
	}

	@Override
	protected String doInBackground(Object... params) {
		try {

			// Cria uma instancia de httpget passando a url
			HttpGet requisicaoGet = new HttpGet(URI + caminho);

			// Cria uma instancia de httpHandler
			ResponseHandler<String> h = new BasicResponseHandler();

			obj = cliente.execute(requisicaoGet, h);

		} catch (Exception ex) {
			Log.v(TAG, ex.toString());
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
