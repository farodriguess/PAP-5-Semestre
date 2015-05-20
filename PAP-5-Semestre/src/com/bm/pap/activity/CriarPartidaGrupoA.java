package com.bm.pap.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Equipe;
import com.bm.pap.entity.Partida;
import com.bm.pap.entity.Resultado;

public class CriarPartidaGrupoA extends PrincipalActivity {
	private Campeonato campeonato;
	private ArrayList<Equipe> equipesSelecionadas;
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinner4;
	private Spinner spinner5;
	private Spinner spinner6;
	private Spinner spinner7;
	private Spinner spinner8;
	private Spinner spinner9;
	private Spinner spinner10;
	private Spinner spinner11;
	private Spinner spinner12;
	
	private ArrayAdapter<String> adapter;
	
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			setContentView(R.layout.activity_criar_partida_grupo_a);
						
			Bundle extra = getIntent().getBundleExtra("bundleEquipesSelecionadas");
			equipesSelecionadas = (ArrayList<Equipe>) extra.getSerializable("equipesSelecionadas");
			campeonato =  (Campeonato) extra.getSerializable("campeonato");
						
			//String[] items;
			 //items = getResources().getStringArray(R.array.Times);
			
			List<String> nomeEquipe = new ArrayList();
		
		for (Equipe e : equipesSelecionadas) {
				nomeEquipe.add(e.getNome());
		}
			 			 
			spinner1 = (Spinner) findViewById(R.id.spinner1);
		   adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item, nomeEquipe);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner1.setAdapter(adapter);
		    
		    spinner2 = (Spinner) findViewById(R.id.spinner2);
		    spinner2.setAdapter(adapter);
		    		    		   		    		    		    
		    spinner3 = (Spinner) findViewById(R.id.spinner3);
		    spinner3.setAdapter(adapter);
		    
		    spinner4 = (Spinner) findViewById(R.id.spinner4);
		    spinner4.setAdapter(adapter);
		    	    
			spinner5 = (Spinner) findViewById(R.id.spinner5);
		    spinner5.setAdapter(adapter);
		    
		    spinner6 = (Spinner) findViewById(R.id.spinner6);
		    spinner6.setAdapter(adapter);
		    		    
		    spinner7 = (Spinner) findViewById(R.id.spinner7);
		    spinner7.setAdapter(adapter);
		    
		    spinner8 = (Spinner) findViewById(R.id.spinner8);
		    spinner8.setAdapter(adapter);
		    	    
			spinner9 = (Spinner) findViewById(R.id.spinner9);
		    spinner9.setAdapter(adapter);
		    
		    spinner10 = (Spinner) findViewById(R.id.spinner10);
		    spinner10.setAdapter(adapter);
		    		    
		    spinner11 = (Spinner) findViewById(R.id.spinner11);
		    spinner11.setAdapter(adapter);
		    
		    spinner12 = (Spinner) findViewById(R.id.spinner12);
		    spinner12.setAdapter(adapter);
		  
		    carregarSpinners();
		    
}
		public void carregarSpinners(){
			
			  //setar spinner com valor pré determinado
		    if (!equipesSelecionadas.get(0).getNome().toString().equals(null)) {
		        int spinnerPosition = adapter.getPosition(equipesSelecionadas.get(0).getNome().toString());
		        spinner1.setSelection(spinnerPosition);
		        spinnerPosition = 0;
		    };
		    
		    if (!equipesSelecionadas.get(1).getNome().toString().equals(null)) {
		        int spinnerPosition = adapter.getPosition(equipesSelecionadas.get(1).getNome().toString());
		        spinner2.setSelection(spinnerPosition);
		        spinnerPosition = 0;
		    };
		    
		    if (!equipesSelecionadas.get(2).getNome().toString().equals(null)) {
		        int spinnerPosition = adapter.getPosition(equipesSelecionadas.get(2).getNome().toString());
		        spinner3.setSelection(spinnerPosition);
		        spinnerPosition = 0;
		    };
		    
		    if (!equipesSelecionadas.get(3).getNome().toString().equals(null)) {
		        int spinnerPosition = adapter.getPosition(equipesSelecionadas.get(3).getNome().toString());
		        spinner4.setSelection(spinnerPosition);
		        spinnerPosition = 0;
		    };
			
		    spinner5.setSelection(adapter.getPosition(spinner1.getSelectedItem().toString()));
		    spinner6.setSelection(adapter.getPosition(spinner3.getSelectedItem().toString()));
		    spinner7.setSelection(adapter.getPosition(spinner4.getSelectedItem().toString()));
		    spinner8.setSelection(adapter.getPosition(spinner2.getSelectedItem().toString()));
		    spinner9.setSelection(adapter.getPosition(spinner4.getSelectedItem().toString()));
		    spinner10.setSelection(adapter.getPosition(spinner1.getSelectedItem().toString()));
		    spinner11.setSelection(adapter.getPosition(spinner2.getSelectedItem().toString()));
		    spinner12.setSelection(adapter.getPosition(spinner3.getSelectedItem().toString()));

		}
		
		public Partida criarPartida(int numeroPartida, Date dataPartida, String localPartida,Equipe e1, Equipe e2){
			Resultado equipe1 = new Resultado();
			equipe1.setEquipe(e1);
			Resultado equipe2 = new Resultado();
			equipe2.setEquipe(e2);
			if(equipe1.getEquipe()==equipe2.getEquipe()){
				return null;
			}else{
			Partida p = new Partida();
			p.setCampeonato(campeonato);
			p.setNumeroPartida(numeroPartida);
			p.setFase("Fase 1");
			p.setStatus("Aguardando Iniciar");
			p.setTipo("Grupo A");
			p.setDataPartida(dataPartida);
			p.setLocalPartida(localPartida);
			equipe1.setPartida(p);
			equipe2.setPartida(p);
			List<Resultado> equipes = new ArrayList();
			equipes.add(equipe1);
			equipes.add(equipe2);
			p.setResultadoList(equipes);
			return p;
			}
		}
		
		
		
}