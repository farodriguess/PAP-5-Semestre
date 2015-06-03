package com.bm.pap.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Usuario;

public class RankingActivity extends Activity {
private Usuario usuario;
private Campeonato campeonato;
private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
//		Intent intencao = getIntent();
//		Bundle info = intencao.getExtras();
//		usuario = (Usuario) info.getSerializable("usuario");
//		campeonato = (Campeonato) info.getSerializable("editarCampeonato");
		
		TextView campeonato=(TextView)findViewById(R.id.campeonato);
		campeonato.setText("COPA DAS CONFEDERAÇÕES 2013");
		
		List<String> ranking = new ArrayList<String>();
		ranking.add("1º Francisco 80pts");
		
		ListView lista = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, ranking);
		lista.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
