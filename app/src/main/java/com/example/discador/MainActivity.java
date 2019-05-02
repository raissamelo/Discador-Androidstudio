package com.example.discador;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeview();
    }

    private void initializeview() {
        screen = (EditText) findViewById(R.id.screen);
        int idList [] = {R.id.buttonUm,R.id.buttonDois,R.id.buttonTres, R.id.buttonQuatro,
                R.id.buttonCinco,R.id.buttonSeis,R.id.buttonSete,R.id.buttonOito,R.id.buttonNove,
                R.id.buttonEstrela,R.id.buttonZero,R.id.buttonHash, R.id.buttonDiscar, R.id.buttonLimpar};

        for (int d:idList){
            View v= (View)findViewById(d);
            v.setOnClickListener(this);
        }
    }
    public void display (String val){
        screen.append(val);
    }

    private boolean checkCallPermission (){
        String permission = "android.permission.CALL_PHONE";
        int res= getApplicationContext().checkCallingOrSelfPermission(permission);
        return (res== PackageManager.PERMISSION_GRANTED);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonUm:
                display("1");
                break;
            case R.id.buttonDois:
                display ("2");
                break;
            case R.id.buttonTres:
                display ("3");
                break;
            case R.id.buttonQuatro:
                display ("4");
                break;
            case R.id.buttonCinco:
                display ("5");
                break;
            case R.id.buttonSeis:
                display ("6");
                break;
            case R.id.buttonSete:
                display ("7");
                break;
            case R.id.buttonOito:
                display ("8");
                break;
            case R.id.buttonNove:
                display ("9");
                break;
            case R.id.buttonEstrela:
                display ("*");
                break;
            case R.id.buttonZero:
                display ("0");
                break;
            case R.id.buttonHash:
                display ("#");
                break;
            case R.id.buttonLimpar:
                if (screen.getText().toString().length()>=1) {
                    String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1);
                    screen.setText(newScreen);
                }break;
            case R.id.buttonDiscar:
                if (screen.getText().toString().isEmpty())
                    Toast.makeText(this,"Digite um numero",Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+screen.getText().toString())));
                break;
        }
    }
}
