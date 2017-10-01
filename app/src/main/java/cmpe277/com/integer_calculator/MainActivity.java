package cmpe277.com.integer_calculator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {


    private TextView total;
    String result;
    String display;
    int current_result = 0 ;
    int current_value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();




    }
    public void click(View view){

        Button b = (Button)view;
        int num =parseInt( b.getText().toString());
        settext(num);
       // Toast.makeText(this,"num is"+num,Toast.LENGTH_LONG).show();
    }


    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    private void setup(){

        total = (TextView)findViewById(R.id.result);
    }
    void settext(int num){

        if(total.getText().length() >= 7){
            showToast("OVERFLOW!");
        }
        else{
            if(display==null){
                display=Integer.toString(num);
            }
            else{
                display +=  Integer.toString(num);
            }
            total.setText(display);
        }


    }
    void clickoperator(View view){
        Button b = (Button)view;
        String op =( b.getText().toString());

        if(op == "="){

            current_result +=current_value;
        }
        if(op == "+"){
            current_value = (parseInt(display));

        }
        if(op == "-"){

        }
        if(op == "*"){

        }
        if(op == "/"){

        }
    }
    public void clear(View view){
        display = null;
        total.setText(display);
    }
}
