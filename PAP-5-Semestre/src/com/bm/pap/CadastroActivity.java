
package com.bm.pap;

import com.bm.pap.entity.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CadastroActivity  extends InicialActivity{
	
	private Usuario user;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_cadastro);
		


}
	
	public void btnCadastrar(View view) {

		EditText nome = (EditText) findViewById(R.id.cadastroNome);
		EditText email = (EditText) findViewById(R.id.cadastroEmail);
		EditText senha = (EditText) findViewById(R.id.cadastroSenha);
		EditText confirmaSenha = (EditText) findViewById(R.id.cadastroConfirmaSenha);

		if(nome.getText().toString().length()<=20){
		
		if (senha.getText().toString().equals(confirmaSenha.getText().toString())) {
			user.setNome(nome.getText().toString());
			user.setEmail(email.getText().toString());
			user.setSenha(senha.getText().toString());
			
			//fazer lógica para verificar se existe no banco
			//if(usuario existe){
			//salvar usuario no banco
			
			Toast.makeText(this, "Usuário Cadastrado com sucesso!",Toast.LENGTH_SHORT).show();

			Intent it = new Intent(CadastroActivity.this,PrincipalActivity.class);
			startActivity(it);
			//}
			//else{Toast.makeText(this, "Usuário já existe!",Toast.LENGTH_SHORT).show();};
			
		} else {
			Toast.makeText(this, "A senha esta incorreta!", Toast.LENGTH_SHORT)
					.show();
		}}else{
			Toast.makeText(this, "O nome deve conter no máixmo 20 caracteres!", Toast.LENGTH_SHORT)
			.show();
}
	}
}
	
