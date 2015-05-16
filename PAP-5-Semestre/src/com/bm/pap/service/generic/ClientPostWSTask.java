package com.bm.pap.service.generic;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class ClientPostWSTask extends AsyncTask<Object, Object, String> {

	private static final String URI = "http://franciscoanderson.com:8080/BolaoWebService/webresources/";
	private static final String TAG = "ClientPosTWSTask.java";

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

	public ClientPostWSTask(Context context, String caminho,
			ObjectLoadedListener objectLoadedListener, String req,
			int solicitante) {
		this.req = req;
		this.caminho = caminho;
		this.context = context;
		this.objectLoadedListener = objectLoadedListener;
		this.solicitante=solicitante;
		cliente = new DefaultHttpClient();
	}

	@Override
	protected String doInBackground(Object... params) {
		try {

			// Cria uma instancia de httpget passando a url
			HttpPost requisicaoPost = new HttpPost(URI + caminho);

			StringEntity reqEntity = new StringEntity(req);

			reqEntity.setContentType("application/json");

			requisicaoPost.setEntity(reqEntity);

			HttpResponse response = cliente.execute(requisicaoPost);

			HttpEntity resEntity = response.getEntity();

			obj = EntityUtils.toString(resEntity);
			Log.v("Conteudo String", obj);

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
