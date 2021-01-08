package com.example.first_application.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.first_application.DataManager.MainActivityManager;
import com.example.first_application.Exceptions.DivideByZeroException;
import com.example.first_application.Exceptions.IntExtendedFormatException;
import com.example.first_application.Exceptions.IntOverflowException;
import com.example.first_application.R;

import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MainActivityManager mainActivityManager = new MainActivityManager();

    private Button btn_plus;
    private Button btn_minus;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_equal;
    private Button btn_zero;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;

    private TextView txt_result;

    private void ConnectObjectToVisualElement(){
        btn_plus = (Button)findViewById(R.id.plus);
        btn_minus = (Button)findViewById(R.id.minus);
        btn_multiply = (Button)findViewById(R.id.multiply);
        btn_divide = (Button)findViewById(R.id.divide);
        btn_equal = (Button)findViewById(R.id.equal);
        btn_zero = (Button)findViewById(R.id.zero);
        btn_one = (Button)findViewById(R.id.one);
        btn_two = (Button)findViewById(R.id.two);
        btn_three = (Button)findViewById(R.id.three);
        btn_four = (Button)findViewById(R.id.four);
        btn_five = (Button)findViewById(R.id.five);
        btn_six = (Button)findViewById(R.id.six);
        btn_seven = (Button)findViewById(R.id.seven);
        btn_eight = (Button)findViewById(R.id.eight);
        btn_nine = (Button)findViewById(R.id.nine);

        txt_result = (TextView)findViewById(R.id.result);
    }


    private void Make_clickable(){
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
    }


    private void Add_char(char to_add){
        txt_result.setText(mainActivityManager.RecieveCharAndTextReturnText(to_add, txt_result.getText().toString()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectObjectToVisualElement();
        Make_clickable();
    }

    @Override
    public void onClick(View view) {

        Button b = (Button)view;
        char buttonText = b.getText().toString().charAt(0);
        if(Character.isDigit(buttonText))
            Add_char(buttonText);
        else if (buttonText == '=')
            try{
                txt_result.setText(mainActivityManager.Equal());
            }
            catch (NumberFormatException e){
                txt_result.setText(e.getMessage());
            }
            catch (ArithmeticException e){
                txt_result.setText(e.getMessage());
            }
        else{
            try{
                txt_result.setText(mainActivityManager.Calculate(buttonText));
            } catch (NumberFormatException e){
                txt_result.setText(e.getMessage());
            }
        }
    }
}
