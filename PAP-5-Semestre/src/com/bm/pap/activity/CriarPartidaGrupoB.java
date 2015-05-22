package com.bm.pap.activity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bm.pap.R;
import com.bm.pap.entity.Campeonato;
import com.bm.pap.entity.Equipe;
import com.bm.pap.entity.Partida;
import com.bm.pap.entity.Resultado;

public class CriarPartidaGrupoB extends PrincipalActivity {
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
	private DateFormat formatData;
	// info partida 1
	private Calendar data1;
	private TextView labelData1;
	private EditText local1;
	// info partida 2
	private Calendar data2;
	private TextView labelData2;
	private EditText local2;
	// info partida 3
	private Calendar data3;
	private TextView labelData3;
	private EditText local3;
	// info partida 4
	private Calendar data4;
	private TextView labelData4;
	private EditText local4;
	// info partida 5
	private Calendar data5;
	private TextView labelData5;
	private EditText local5;
	// info partida 1
	private Calendar data6;
	private TextView labelData6;
	private EditText local6;

	// liberarCheck usado para bloquear os metodos do listener das spinners ao
	// carregar
	private boolean liberarCheck;
	private ArrayAdapter<String> adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_criar_partida_grupo_b);

		Bundle extra = getIntent().getBundleExtra("bundleEquipesSelecionadas");
		equipesSelecionadas = (ArrayList<Equipe>) extra
				.getSerializable("equipesSelecionadas");
		extra = getIntent().getExtras();
		campeonato = (Campeonato) extra.getSerializable("campeonato");
		formatData = DateFormat.getDateInstance();
		// iniciar info partida 1
		data1 = Calendar.getInstance();
		labelData1 = (TextView) findViewById(R.id.dataPartida1);
		labelData1.setText(formatData.format(data1.getTime()));
		local1 = (EditText) findViewById(R.id.localPartida1);

		// iniciar info partida 2
		data2 = Calendar.getInstance();
		labelData2 = (TextView) findViewById(R.id.dataPartida2);
		labelData2.setText(formatData.format(data2.getTime()));
		local2 = (EditText) findViewById(R.id.localPartida2);

		// iniciar info partida 3
		data3 = Calendar.getInstance();
		labelData3 = (TextView) findViewById(R.id.dataPartida3);
		labelData3.setText(formatData.format(data3.getTime()));
		local3 = (EditText) findViewById(R.id.localPartida3);

		// iniciar info partida 4
		data4 = Calendar.getInstance();
		labelData4 = (TextView) findViewById(R.id.dataPartida4);
		labelData4.setText(formatData.format(data4.getTime()));
		local4 = (EditText) findViewById(R.id.localPartida4);

		// iniciar info partida 5
		data5 = Calendar.getInstance();
		labelData5 = (TextView) findViewById(R.id.dataPartida5);
		labelData5.setText(formatData.format(data5.getTime()));
		local5 = (EditText) findViewById(R.id.localPartida5);

		// iniciar info partida 6
		data6 = Calendar.getInstance();
		labelData6 = (TextView) findViewById(R.id.dataPartida6);
		labelData6.setText(formatData.format(data6.getTime()));
		local6 = (EditText) findViewById(R.id.localPartida6);

		liberarCheck = false;// bloqueando métodos de listener das spinners
		List<String> nomeEquipe = new ArrayList<String>();

		for (Equipe e : equipesSelecionadas) {
			nomeEquipe.add(e.getNome());
		}

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nomeEquipe);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);
		// criar uma listener ao selecionar um item no spinner
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// após carregar as spinners será liberado os métodos
				if (liberarCheck == true) {
					// comparar se os times das partidas são iguais
					compararSpinners(spinner1, spinner2);
				}
				// alterar spinners automaticamente
				setarSpinners(spinner1, spinner5, spinner10);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setAdapter(adapter);
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner2, spinner1);
				}
				setarSpinners(spinner2, spinner8, spinner11);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setAdapter(adapter);
		spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner3, spinner4);
				}
				setarSpinners(spinner3, spinner6, spinner12);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner4.setAdapter(adapter);
		spinner4.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner4, spinner3);
				}
				setarSpinners(spinner4, spinner7, spinner9);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner5.setAdapter(adapter);
		spinner5.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner5, spinner6);
				}
				setarSpinners(spinner5, spinner1, spinner10);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner6 = (Spinner) findViewById(R.id.spinner6);
		spinner6.setAdapter(adapter);
		spinner6.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner6, spinner5);
				}
				setarSpinners(spinner6, spinner3, spinner12);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner7 = (Spinner) findViewById(R.id.spinner7);
		spinner7.setAdapter(adapter);
		spinner7.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner7, spinner8);
				}
				setarSpinners(spinner7, spinner4, spinner9);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner8 = (Spinner) findViewById(R.id.spinner8);
		spinner8.setAdapter(adapter);
		spinner8.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner8, spinner7);
				}
				setarSpinners(spinner8, spinner2, spinner11);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner9 = (Spinner) findViewById(R.id.spinner9);
		spinner9.setAdapter(adapter);
		spinner9.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner9, spinner10);
				}
				setarSpinners(spinner9, spinner4, spinner7);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner10 = (Spinner) findViewById(R.id.spinner10);
		spinner10.setAdapter(adapter);
		spinner10.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner10, spinner9);
				}
				setarSpinners(spinner10, spinner1, spinner5);

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner11 = (Spinner) findViewById(R.id.spinner11);
		spinner11.setAdapter(adapter);
		spinner11.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner11, spinner12);
				}
				setarSpinners(spinner11, spinner2, spinner8);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		spinner12 = (Spinner) findViewById(R.id.spinner12);
		spinner12.setAdapter(adapter);
		spinner12.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (liberarCheck == true) {
					compararSpinners(spinner12, spinner11);
				}
				setarSpinners(spinner12, spinner3, spinner6);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		// carrega as spinners com valores pré-determinados
		carregarSpinners();
		// libera os metódos de listener das spinners
		if (campeonato.getQtdEquipe() == 8) {
			liberarCheck = false;
			Button b = new Button(this);
			b = (Button) findViewById(R.id.avancar);
			b.setText("Finalizar");
		} else {
			liberarCheck = true;
		}
		;
	}

	public void carregarSpinners() {

		// setar spinner com valor pré determinado
		if (!equipesSelecionadas.get(0).getNome().toString().equals(null)) {
			int spinnerPosition = adapter.getPosition(equipesSelecionadas
					.get(0).getNome().toString());
			spinner1.setSelection(spinnerPosition);
			spinnerPosition = 0;
		}
		;

		if (!equipesSelecionadas.get(1).getNome().toString().equals(null)) {
			int spinnerPosition = adapter.getPosition(equipesSelecionadas
					.get(1).getNome().toString());
			spinner2.setSelection(spinnerPosition);
			spinnerPosition = 0;
		}
		;

		if (!equipesSelecionadas.get(2).getNome().toString().equals(null)) {
			int spinnerPosition = adapter.getPosition(equipesSelecionadas
					.get(2).getNome().toString());
			spinner3.setSelection(spinnerPosition);
			spinnerPosition = 0;
		}
		;

		if (!equipesSelecionadas.get(3).getNome().toString().equals(null)) {
			int spinnerPosition = adapter.getPosition(equipesSelecionadas
					.get(3).getNome().toString());
			spinner4.setSelection(spinnerPosition);
			spinnerPosition = 0;
		}
		;

		spinner5.setSelection(adapter.getPosition(spinner1.getSelectedItem()
				.toString()));
		spinner6.setSelection(adapter.getPosition(spinner3.getSelectedItem()
				.toString()));
		spinner7.setSelection(adapter.getPosition(spinner4.getSelectedItem()
				.toString()));
		spinner8.setSelection(adapter.getPosition(spinner2.getSelectedItem()
				.toString()));
		spinner9.setSelection(adapter.getPosition(spinner4.getSelectedItem()
				.toString()));
		spinner10.setSelection(adapter.getPosition(spinner1.getSelectedItem()
				.toString()));
		spinner11.setSelection(adapter.getPosition(spinner2.getSelectedItem()
				.toString()));
		spinner12.setSelection(adapter.getPosition(spinner3.getSelectedItem()
				.toString()));

	}

	public Partida criarPartida(int numeroPartida, Date dataPartida,
			String localPartida, String equipe1, String equipe2) {
		Resultado incluirEquipe1 = new Resultado();
		Resultado incluirEquipe2 = new Resultado();
		for (Equipe e : equipesSelecionadas) {
			if (e.getNome().equals(equipe1)) {
				incluirEquipe1.setEquipe(e);
			}
			if (e.getNome().equals(equipe2)) {
				incluirEquipe2.setEquipe(e);
			}
		}
		Partida p = new Partida();
		p.setCampeonato(campeonato);
		p.setNumeroPartida(numeroPartida);
		p.setFase("Fase 1");
		p.setStatus("Aguardando Iniciar");
		p.setTipo("Grupo A");
		p.setDataPartida(dataPartida);
		p.setLocalPartida(localPartida);
		incluirEquipe1.setPartida(p);
		incluirEquipe2.setPartida(p);
		List<Resultado> equipes = new ArrayList<Resultado>();
		equipes.add(incluirEquipe1);
		equipes.add(incluirEquipe2);
		p.setResultadoList(equipes);
		return p;
	}

	public void btnAvancar(View v) {
		// Criando lista de partidas
		List<Partida> partidas = new ArrayList<Partida>();
		// adicionando partida1
		partidas.add(criarPartida(1, data1.getTime(), local1.getText()
				.toString(), spinner1.getSelectedItem().toString(), spinner2
				.getSelectedItem().toString()));
		// adicionando partida2
		partidas.add(criarPartida(2, data2.getTime(), local2.getText()
				.toString(), spinner3.getSelectedItem().toString(), spinner4
				.getSelectedItem().toString()));
		// adicionando partida3
		partidas.add(criarPartida(3, data3.getTime(), local3.getText()
				.toString(), spinner5.getSelectedItem().toString(), spinner6
				.getSelectedItem().toString()));
		// adicionando partida4
		partidas.add(criarPartida(4, data4.getTime(), local4.getText()
				.toString(), spinner7.getSelectedItem().toString(), spinner8
				.getSelectedItem().toString()));
		// adicionando partida5
		partidas.add(criarPartida(5, data5.getTime(), local5.getText()
				.toString(), spinner9.getSelectedItem().toString(), spinner10
				.getSelectedItem().toString()));
		// adicionando partida6
		partidas.add(criarPartida(6, data6.getTime(), local6.getText()
				.toString(), spinner11.getSelectedItem().toString(), spinner12
				.getSelectedItem().toString()));
		campeonato.setPartidaList(partidas);
		if (campeonato.getQtdEquipe() == 16) {
			// removendo equipes desnecessarias para próximo grupo
			for (int i = 0; i < equipesSelecionadas.size(); i++) {
				if (equipesSelecionadas.get(i).getNome()
						.equals(spinner1.getSelectedItem().toString())) {
					Equipe e = equipesSelecionadas.get(i);
					equipesSelecionadas.remove(e);
				}
				if (equipesSelecionadas.get(i).getNome()
						.equals(spinner2.getSelectedItem().toString())) {
					Equipe e = equipesSelecionadas.get(i);
					equipesSelecionadas.remove(e);
				}
				if (equipesSelecionadas.get(i).getNome()
						.equals(spinner3.getSelectedItem().toString())) {
					Equipe e = equipesSelecionadas.get(i);
					equipesSelecionadas.remove(e);
				}
				if (equipesSelecionadas.get(i).getNome()
						.equals(spinner4.getSelectedItem().toString())) {
					Equipe e = equipesSelecionadas.get(i);
					equipesSelecionadas.remove(e);
				}
			}

			Bundle extra = new Bundle();
			extra.putSerializable("equipesSelecionadas", equipesSelecionadas);
			Intent intent = new Intent(getBaseContext(),
					CriarPartidaGrupoC.class);
			intent.putExtra("bundleEquipesSelecionadas", extra);
			intent.putExtra("campeonato", campeonato);
			startActivity(intent);
		}

		if (campeonato.getQtdEquipe() == 8) {
			List<Spinner> spinners = new ArrayList<Spinner>();
			spinners.add(spinner1);
			spinners.add(spinner2);
			spinners.add(spinner3);
			spinners.add(spinner4);
			boolean finalizar = true;
			for (int i = 1; i < spinners.size(); i++) {
				if (spinners.get(0).getSelectedItem().toString()
						.equals(spinners.get(i).getSelectedItem().toString())) {
					carregarSpinners();
					finalizar = false;
				}
			}

			if (finalizar == false) {
				Toast.makeText(
						this,
						"Observe a 1º e 2º partida, as equipes devem ser diferentes.\n"
								+ "O sistema reorganizou as partidas com valores pré determinados!",
						Toast.LENGTH_SHORT).show();
			}

			if (finalizar == true) {
				Intent intent = new Intent(getBaseContext(),
						MeusCampeonatosActivity.class);
				intent.putExtra("usuario", campeonato.getUsuario());
				startActivity(intent);
				// fazer lógica para não voltar para essa tela
				// fazer lógica de salvar no banco de dados
			}

		}

	}

	public void compararSpinners(Spinner s1, Spinner s2) {
		int pos = adapter.getPosition(s1.getSelectedItem().toString());
		boolean mensagem = false;
		if (s1.getSelectedItem().toString()
				.equals(s2.getSelectedItem().toString())) {
			if (pos == adapter.getCount() - 1) {
				pos = 0;
			} else {
				pos += 1;
			}
			s1.setSelection(pos);
			mensagem = true;
		}
		int verificar = 0;
		verificar += verificarSpinner(s1);

		if (verificar > 1) {
			if (pos == adapter.getCount() - 1) {
				pos = 0;
			} else {
				pos += 1;
			}
			s1.setSelection(pos);
			compararSpinners(s1, s2);
			mensagem = true;
		}
		if (mensagem == true) {
			Toast.makeText(
					this,
					"Não é possível selecionar equipes iguais na mesma partida!\n"
							+ "Observe a 1º e 2º partida, as equipes devem ser diferentes.\n"
							+ "O sistema reorganizou as partidas selecionando a próxima equipe!",
					Toast.LENGTH_SHORT).show();
		}
	}

	public int verificarSpinner(Spinner s1) {
		int total = 0;
		if (s1.getSelectedItem().toString()
				.equals(spinner1.getSelectedItem().toString())) {
			total += 1;
		}
		if (s1.getSelectedItem().toString()
				.equals(spinner2.getSelectedItem().toString())) {
			total += 1;
		}
		if (s1.getSelectedItem().toString()
				.equals(spinner3.getSelectedItem().toString())) {
			total += 1;
		}
		if (s1.getSelectedItem().toString()
				.equals(spinner4.getSelectedItem().toString())) {
			total += 1;
		}
		return total;
	}

	public void setarSpinners(Spinner sp, Spinner s1, Spinner s2) {
		s1.setSelection(adapter.getPosition(sp.getSelectedItem().toString()));
		s2.setSelection(adapter.getPosition(sp.getSelectedItem().toString()));
	}

	// botões da data
	// botão da data1
	public void setData1(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener1,
				data1.get(Calendar.YEAR), data1.get(Calendar.MONTH),
				data1.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener1 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data1.set(Calendar.YEAR, year);
			data1.set(Calendar.MONTH, monthOfYear);
			data1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData1.setText(formatData.format(data1.getTime()));
		}
	};

	// botão da data2
	public void setData2(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener2,
				data2.get(Calendar.YEAR), data2.get(Calendar.MONTH),
				data2.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener2 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data2.set(Calendar.YEAR, year);
			data2.set(Calendar.MONTH, monthOfYear);
			data2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData2.setText(formatData.format(data2.getTime()));
		}
	};

	// botão da data3
	public void setData3(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener3,
				data3.get(Calendar.YEAR), data3.get(Calendar.MONTH),
				data3.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener3 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data3.set(Calendar.YEAR, year);
			data3.set(Calendar.MONTH, monthOfYear);
			data3.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData3.setText(formatData.format(data3.getTime()));
		}
	};

	// botão da data4
	public void setData4(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener4,
				data4.get(Calendar.YEAR), data4.get(Calendar.MONTH),
				data4.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener4 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data4.set(Calendar.YEAR, year);
			data4.set(Calendar.MONTH, monthOfYear);
			data4.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData4.setText(formatData.format(data4.getTime()));
		}
	};

	// botão da data5
	public void setData5(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener5,
				data5.get(Calendar.YEAR), data5.get(Calendar.MONTH),
				data5.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener5 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data5.set(Calendar.YEAR, year);
			data5.set(Calendar.MONTH, monthOfYear);
			data5.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData5.setText(formatData.format(data5.getTime()));
		}
	};

	// botão da data6
	public void setData6(View view) {
		new DatePickerDialog(CriarPartidaGrupoB.this, dataListener6,
				data6.get(Calendar.YEAR), data6.get(Calendar.MONTH),
				data6.get(Calendar.DAY_OF_MONTH)).show();
	}

	private DatePickerDialog.OnDateSetListener dataListener6 = new DatePickerDialog.OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub

			data6.set(Calendar.YEAR, year);
			data6.set(Calendar.MONTH, monthOfYear);
			data6.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			labelData6.setText(formatData.format(data6.getTime()));
		}
	};
}
