package com.example.lessonfirst_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnTurnScreenClick(View view) {

        EditText editText = findViewById(R.id.editTxtAngle);

        if (Integer.parseInt(editText.getText().toString())%90 != 0) {
            Toast.makeText(getApplicationContext(), "Please input a angle multiple of 90!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if (Integer.parseInt(editText.getText().toString())%180 != 0) {
                int rotateAngle = getWindowManager().getDefaultDisplay().getRotation();
                if (rotateAngle == Surface.ROTATION_90 || rotateAngle == Surface.ROTATION_270) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        }
    }
}
