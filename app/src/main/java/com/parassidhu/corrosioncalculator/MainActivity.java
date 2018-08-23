package com.parassidhu.corrosioncalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    private MaterialEditText betaA, betaC, rP;
    private Button calculate;
    private TextView resultCorr, resultCR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        betaA = findViewById(R.id.beta_a);
        betaC = findViewById(R.id.beta_c);
        rP = findViewById(R.id.r_p);
        calculate = findViewById(R.id.calculate);
        resultCorr = findViewById(R.id.result_corr);
        resultCR = findViewById(R.id.result_cr);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        try {
            double numBetaA = Double.valueOf(betaA.getText().toString());
            double numBetaC = Double.valueOf(betaC.getText().toString());
            double numRP = Double.valueOf(rP.getText().toString());

            double result = (numBetaA * numBetaC) / (2.303d * (numBetaA + numBetaC) * numRP);
            resultCorr.setText(String.valueOf(result));

            double resCR = 0.45693d * result;
            resultCR.setText(String.valueOf(resCR));
        }catch (Exception e){
            Toast.makeText(this, "Something is wrong! Fill all the fields correctly",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
