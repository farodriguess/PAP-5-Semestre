package com.bm.pap;

import android.app.Fragment.SavedState;
import android.os.Bundle;
import android.widget.NumberPicker;

public class ApostaFinal extends PrincipalActivity {
	
	
	NumberPicker np;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_aposta_final);
		np = (NumberPicker) findViewById(R.id.numberPicker1);
		np.setMinValue(0);
        np.setMaxValue(10);
                
		np = (NumberPicker) findViewById(R.id.numberPicker2);
		np.setMinValue(0);
        np.setMaxValue(10);
        
        np = (NumberPicker) findViewById(R.id.numberPicker3);
		np.setMinValue(0);
        np.setMaxValue(10);
        
        np = (NumberPicker) findViewById(R.id.numberPicker4);
		np.setMinValue(0);
        np.setMaxValue(10);
 
}
}