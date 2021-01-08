package com.example.first_application.DataManager;

import android.text.TextUtils;

import com.example.first_application.Exceptions.DivideByZeroException;
import com.example.first_application.Exceptions.IntExtendedFormatException;
import com.example.first_application.Exceptions.IntOverflowException;
import com.example.first_application.Exceptions.NotNumberException;

public class MainActivityManager {
    private int int_buffer;
    private String str_result;
    private boolean is_cleaning_screen = false;

    private enum math_actions{
        plus,
        minus,
        multiply,
        divide
    }

    private math_actions math_action;

    public String RecieveCharAndTextReturnText(char to_add, String text){
        if (is_cleaning_screen){
            is_cleaning_screen = false;
            text="";
        }
        str_result = text;
        str_result += to_add;
        return str_result;
    }

    private Exception tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return null;
        } catch (NumberFormatException e) {
            if(!TextUtils.isDigitsOnly(value))
                throw new NotNumberException("ERROR - not number");
            else
                throw new IntExtendedFormatException("ERROR - number extended format");
        }
    }

    public String Calculate(char math_sign){
        if(str_result=="" || str_result == null) {
            is_cleaning_screen = true;
            return ("Error - no input");
        }

        is_cleaning_screen = true;

        try{
            tryParseInt(str_result);
            int_buffer = Integer.parseInt(str_result);
        } catch (NumberFormatException e){
            is_cleaning_screen = true;
            str_result = "";
            throw e;
        }
        switch (math_sign){
            case '+':
                math_action = math_actions.plus;
                break;
            case '-':
                math_action = math_actions.minus;
                break;
            case '*':
                math_action = math_actions.multiply;
                break;
            case '/':
                math_action = math_actions.divide;
                break;
        }
        return str_result;
    }

    public String Equal(){
        if(math_action == null){
            is_cleaning_screen = true;
            return ("Error - no input");
        }

        int buffer_two;

        try{
            tryParseInt(str_result);
            buffer_two = Integer.parseInt(str_result);
        } catch (NumberFormatException e){
            is_cleaning_screen = true;
            throw new IntExtendedFormatException("ERROR - int extended");
        }

        int res=0;
        switch (math_action){
            case plus:
                res = int_buffer + buffer_two;
                break;
            case minus:
                res = int_buffer - buffer_two;
                break;
            case multiply:
                res = int_buffer * buffer_two;
                break;
            case divide:
                try {
                    res = int_buffer / buffer_two;
                }catch (ArithmeticException e){
                    str_result = "";
                    if (buffer_two==0) {
                        is_cleaning_screen = true;
                        throw new DivideByZeroException("Error - division by ZERO");
                    }
                    else if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                        throw new IntOverflowException("Error - Integer overflow");
                    }
                }
                break;
        }

        str_result = "";
        int_buffer = 0;
        is_cleaning_screen = true;
        math_action = null;
        return (Integer.toString(res));
    }
}
