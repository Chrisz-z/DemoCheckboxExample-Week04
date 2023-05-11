package sg.edu.rp.c346.id22035357.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox  cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbEnabled = findViewById(R.id.Cb1);
        btnCheck = findViewById(R.id.Btn1);
        tvShow = findViewById(R.id.Tv1);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                String discount = "";
                Context context = getApplicationContext();
                String text = "Button Clicked";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                if(cbEnabled.isChecked()){
                    double pay = calcPay(100, 20);
                    discount = "The discount is given. You need to pay " + pay;
                }else{
                    double pay = calcPay(100, 0);
                    discount = "The discount is not given. You need to pay " + pay;
                }

                tvShow.setText(discount);
            }
        });

    }
    private double calcPay(double price, double discount){
        double pay = price * (1-discount/100);
        return pay;
    }
}