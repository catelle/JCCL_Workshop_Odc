package com.example.jccl_network_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jccl_network_project.detail_pages.DetailPublication_doc;
import com.example.jccl_network_project.utils.UtilFunctions;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewer extends AppCompatActivity {

    private String pdfName;
    private PDFView pdfViewer;
    private ImageButton close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
try{

        pdfViewer = findViewById(R.id.pdfView_full_doc);
        close = findViewById(R.id.btn_close);
        pdfName = getIntent().getStringExtra(DetailPublication_doc.EXTRA_PDF_NAME);

        UtilFunctions.pdfReader(pdfViewer , pdfName , 2);
        close.setOnClickListener( v-> { this.onBackPressed();});
}catch (Exception e){
    Toast.makeText(PdfViewer.this, e.toString(), Toast.LENGTH_SHORT).show();
}

    }
}