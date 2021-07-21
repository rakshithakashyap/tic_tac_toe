package com.example.tic_tac_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Players extends AppCompatActivity {
EditText p1,p2;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        p1=(EditText)findViewById(R.id.p1);
        p2=(EditText)findViewById(R.id.p2);
        btn=(Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pname1 = p1.getText().toString();
                final String pname2 = p2.getText().toString();

                if (pname1.isEmpty() || pname2.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Players.this);
                    builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            p1.setText("");
                            p2.setText("");
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else{
                    Intent intent = new Intent(Players.this , MainActivity.class);
                    intent.putExtra("pname1" , pname1);
                    intent.putExtra("pname2",  pname2);
                    startActivity(intent);
                }
            }
        });
    }
}