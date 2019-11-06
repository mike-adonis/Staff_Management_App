package com.example.disc;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

class GeneralUtility {
    static void displaySnackBar(String message, View view) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    static String getFormattedString(TextView view, Boolean capitalize) {
        String formattedString;
        if (capitalize) {
            formattedString = capitalise(view.getText().toString().trim());
            Log.d("General Utility", "getFormattedString: " + formattedString);
            return formattedString;
        } else {
            formattedString = view.getText().toString().trim();
            Log.d("General Utility", "getFormattedString: " + formattedString);
            return formattedString;
        }
    }

    static boolean validForm(TextView... views) {
        boolean valid = false;
        TextView holderTextView;
        for (TextView view : views) {
            holderTextView = view;
            String value = holderTextView.getText().toString();
            if (TextUtils.isEmpty(value)) {
                Log.d("GeneralUtility", "validForm: this stuff is empty");
                holderTextView.setError("Required.");
            } else {
                holderTextView.setError(null);
                valid = true;
            }
        }
        Log.d("Valid Form", "validForm: " + valid);
        return valid;
    }

    static void clearView(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeAllViews();
        }
    }

    static String capitalise(String word) {
        String upperString = word.substring(0, 1).toUpperCase() + word.substring(1);
        return upperString;
    }
}
