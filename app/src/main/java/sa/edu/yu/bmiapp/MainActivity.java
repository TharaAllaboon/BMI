package sa.edu.yu.bmiapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv1 = (TextView) findViewById(R.id.tv1);

        findViewById(R.id.buttonBMI).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }

                float Weight = Float.parseFloat(str1);
                float Height = Float.parseFloat(str2)/100;

                float bmiValue = calculateBMI(Weight, Height);

                String bmiInterpretation = interpretBMI(bmiValue);

                tv1.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    private float calculateBMI (float Weight, float Height) {
        return (float) (Weight / (Height * Height));
    }

    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
