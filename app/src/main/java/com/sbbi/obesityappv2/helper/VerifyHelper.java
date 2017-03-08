package com.sbbi.obesityappv2.helper;

import android.widget.EditText;

/**
 * Created by bsilva on 3/8/17.
 */

public class VerifyHelper {

    public static boolean isValidEditText(EditText editText){
        boolean answer = true;

        if(editText.getText().toString().trim().equals("")){
            answer = false;
        }

        return answer;
    }

}
