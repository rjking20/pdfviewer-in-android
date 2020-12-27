package com.rjfication.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import com.github.barteksc.pdfviewer.PDFView;

public class pdf extends AppCompatActivity {


    private Uri url=null;
    private PDFView pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdf = findViewById(R.id.pdfView);


        Intent ind=getIntent();
        url=Uri.parse(ind.getStringExtra("name"));
        pdf.fromUri(url)
                .enableSwipe(true)
                .defaultPage(0)
                .spacing(0)
                .load();


    }

    @Override
    public void onBackPressed() {
        Intent ind=new Intent(pdf.this,MainActivity.class);
        finish();
        startActivity(ind);



    }




}
