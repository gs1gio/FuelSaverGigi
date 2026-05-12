package br.ulbra.fuelsavergigi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText edtnome, edtplaca, edtdistancia, edtconsumo, edtpreco;
    TextView txRes;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Inicialização
        edtnome = findViewById(R.id.edtNome);
        edtplaca = findViewById(R.id.edtPlaca);
        edtdistancia = findViewById(R.id.edtDistancia);
        edtconsumo = findViewById(R.id.edtConsumo);
        edtpreco = findViewById(R.id.edtPreco);
        txRes = findViewById(R.id.txtRes);
        btCalcular = findViewById(R.id.btnCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Validação de possiveis campos vazios
                if (edtnome.getText().equals(null) || edtplaca.getText().equals(null) || edtdistancia.getText().equals(null)
                ) {
                    txRes.setText("Preencha todos os campos!");
                    return;
                }
                String nome = edtnome.getText().toString().trim();
                String placa = edtplaca.getText().toString().trim();
                double dist = Double.parseDouble(edtdistancia.getText().toString().trim());
                double consumo = Double.parseDouble(edtconsumo.getText().toString().trim());
                double preco = Double.parseDouble(edtpreco.getText().toString().trim());



                              // Validação numero maior que 0
                if (dist <= 0 || consumo <= 0 || preco <= 0) {
                    txRes.setText("Valores devem ser maiores que zero!");
                    return;
                }

                // Cálculos
                double litros = dist / consumo;
                double custo = litros * preco;

                // Formatação adequada
                String resultado = "Resultado:\n\n" +
                        "Veiculo: " + nome + "\n" +
                        "Placa: " + placa + "\n" +
                        "Distância: " + dist + " km\n" +
                        "Combustível necessário: " + String.format("%.2f", litros) + " L\n" +
                        "Custo da viagem: R$ " + String.format("%.2f", custo);

                txRes.setText(resultado);
            }
        });
    }
}