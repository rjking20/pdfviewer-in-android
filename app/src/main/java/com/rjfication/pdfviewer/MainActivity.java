package com.rjfication.pdfviewer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private Button but1 , but2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.bt1);
        but2 = findViewById(R.id.bt2);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                but1.setBackgroundResource(R.drawable.button_background_change);
                Intent choose =new Intent(Intent.ACTION_GET_CONTENT);
                choose.setType("application/pdf");
                startActivityForResult(choose,10);

            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                but2.setBackgroundResource(R.drawable.button_background_change);
                Intent ind=new Intent(MainActivity.this, ytPlayer.class);
                finish();
                startActivity(ind);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 10:

                if (resultCode == RESULT_OK) {
                    try {


                        Intent ind=new Intent(MainActivity.this,pdf.class);
                        ind.putExtra("name",String.valueOf(data.getData()));
                        startActivity(ind);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }


                }

                break;

            default:
                System.out.println("Your case is not matching!!");

        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}