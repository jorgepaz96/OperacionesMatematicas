package com.example.operacionesmatematicas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText campo1,campo2;
    TextView etiResultado;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = (EditText) findViewById(R.id.campo1);
        campo2 = (EditText) findViewById(R.id.campo2);
        etiResultado = (TextView) findViewById(R.id.etiResultado);

    }

    public void onClick(View view) {

        if (campo1.getText().toString().equals("")) campo1.setText("0");
        if (campo2.getText().toString().equals("")) campo2.setText("0");
        num1 = Integer.parseInt(campo1.getText().toString());
        num2 = Integer.parseInt(campo2.getText().toString());

        switch (view.getId()){
            case R.id.btnSuma: sumar();
                break;
            case R.id.btnResta: resta();
                break;
            case R.id.btnMultipli: multiplicar();
                break;
            case R.id.btnDiv: division();
                break;
            case R.id.btnRaiz: raiz();
                break;
            case R.id.btnFactorial: factorial();
                break;

        }
    }

    private void factorial() {

        long factorial = 1;
        if (campo1.getText().toString().equals("")) campo1.setText("0");
        Toast.makeText(getApplicationContext(),"El factorial es del primer campo",Toast.LENGTH_SHORT).show();
        int num = Integer.parseInt(campo1.getText().toString());
        for(int i = 1; i<=num; i++){
            factorial = i * factorial;
        }
        etiResultado.setText("El factorial  es: "+factorial);
    }

    private void raiz() {
        Toast.makeText(getApplicationContext(),"La raiz cudrada es del primer campo",Toast.LENGTH_SHORT).show();
        Double operan1, res;
        operan1= Double.parseDouble(campo1.getText().toString());
        res=Math.sqrt(operan1);
        etiResultado.setText("El resultado de la raiz es: "+res);
    }

    private void division() {
        if(num2>0){
            int div=num1/num2;
            etiResultado.setText("El resultado de la divicion es: "+div);
        }else {
            Toast.makeText(this,"Advertencia",Toast.LENGTH_SHORT).show();
            etiResultado.setText("El numero 2 debe ser mayor a 0 ");
        }


    }

    private void multiplicar() {
        int multi=num1*num2;
        etiResultado.setText("El resultado de la multiplicacion es: "+multi);
    }

    private void resta() {
        int resta=num1-num2;
        etiResultado.setText("El resultado de la resta es: "+resta);
    }

    private void sumar() {
        int suma=num1+num2;
        etiResultado.setText("El resultado de la suma es: "+suma);
    }
}
