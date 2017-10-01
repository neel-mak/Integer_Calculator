package cmpe277.com.integer_calculator;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toUnsignedLong;

public class MainActivity extends AppCompatActivity {


    private TextView total;
    String result;
    String display="0";
    int current_result = 0 ;
    int current_value = 0;
    int count = 0;
    String current_op = "";
    int afterop = 0;
    int hascounter = 0;
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
        total.setText(display);
    }
    void settext(int num){
        if(afterop == 1){
            afterop=0;
            hascounter=0;
            allclear();
        }

        if(total.getText().length() >= 7){
            showToast("OVERFLOW!");
        }
        else{
            if(display == "0"){
                //Toast.makeText(this,display+"len"+display.length(),Toast.LENGTH_LONG).show();
                display =Integer.toString(num);

            }
            else{
                display +=  Integer.toString(num);
                display = Integer.valueOf(display).toString();
            }
            total.setText(display);
        }


    }
    void clickoperator(View view){

        Button b = (Button)view;
        String op =( b.getText().toString());

        if(hascounter == 0){
            if(op.equals("=")){

                operation(current_op);
                current_op = "";

            }
            else{
                hascounter=1;
                if(count==0){
                    current_result = (parseInt(display));
                    count++;

                }
                else{

                    if (current_op.length() > 0){
                        operation(current_op);
                        current_op = op;
                    }

                }
                afterop =1;
                current_op = op;
            }
        }
        else{
            current_op = op;
        }



    }
    public void operation(String op){
        current_value = (parseInt(display));
        switch(op){
            case "+":
                current_result +=current_value;
                break;
            case "-":
                current_result -=current_value;
                break;
            case "*":
                current_result *=current_value;
                break;
            case "/":
                if(current_value == 0){
                    showToast("0 is not valid");
                }
                else{
                    double num = (double)current_result/(double)current_value ;
                    int inum= current_result/current_value;

                    double diff = num - inum;

                    if(diff < 0.5){
                        current_result = inum;
                    }else{
                        current_result = inum+1;
                    }

                }

                break;
        }
        allclear();
        display = Integer.toString(current_result);
        total.setText(display);
    }
    public void clear(View view){
        allclear();
        current_result = 0;
        current_value = 0;
        count = 0;
        current_op = "";
        afterop = 0;
    }
    public void allclear(){
        display = "0";

        total.setText(display);
    }
}
