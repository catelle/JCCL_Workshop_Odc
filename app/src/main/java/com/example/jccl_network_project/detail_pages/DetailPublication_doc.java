package com.example.jccl_network_project.detail_pages;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jccl_network_project.PdfViewer;
import com.example.jccl_network_project.R;
import com.example.jccl_network_project.adapters.CommentaireAdapter;
import com.example.jccl_network_project.models.Commentaire;
import com.example.jccl_network_project.models.Publication;
import com.example.jccl_network_project.utils.FirebaseUtils;
import com.example.jccl_network_project.utils.UtilFunctions;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class DetailPublication_doc extends AppCompatActivity {

    public static final String EXTRA_PDF_NAME = "docName";
    private List<Commentaire> listComments = new ArrayList<>();
    private RecyclerView commentRecycler;
    private CommentaireAdapter adapter;
    private PDFView mPdfView;
    private TextView mDownloadButton, mApercuButton, mPageCount;
    private EditText mLeaveComment;
    private ImageButton mSendComment;
    private String docName;
    private int pageCount;
    Publication publication;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_publication_doc);

        /**va charger toutes les donnes relative a une publication dans la
         * variable @param {publication}*/
        getPublication("DrxFvKTEbNWMjDuuOgQ7");

        commentRecycler = findViewById(R.id.recycler_comments);
        adapter = new CommentaireAdapter(this, listComments);
        mPdfView = findViewById(R.id.pdfView_book);
        mDownloadButton = findViewById(R.id.btn_download);
        mApercuButton = findViewById(R.id.btn_apercu);
        mPageCount = findViewById(R.id.text_page_count);
        mLeaveComment = findViewById(R.id.edit_comment);
        mSendComment = findViewById(R.id.btn_sent_comment);
        docName = "fretocam.pdf";

        //permet d'afficher l'image du pdf sur la page de detail du document
        pageCount = UtilFunctions.pdfReader(mPdfView, docName, 76);
        mPageCount.setText(pageCount + " pages");



        //permet de creer le recyclerview
        createRecycler();

        // TODO : gestion du telechargement lors du click sur le button sur le boutton de telechargement
        mDownloadButton.setOnClickListener(v -> onDownloadDoc());

        //TODO : gestion de click sur le boutton d'apercu
        mApercuButton.setOnClickListener(v -> onApercuDoc());

        //TODO : gestion de click sur le boutton d'envoie de message
        mSendComment.setOnClickListener(v -> onSendComment());
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void onSendComment() {


        String newComment = mLeaveComment.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Commentaire commentaire = new Commentaire(formatter.format(new Date()),"32434edefsadf3",newComment,"3.5","img_user_picture");
        publication.getCommentaires().add(commentaire);
        db.collection("publication")
                .document("DrxFvKTEbNWMjDuuOgQ7")
                .set(publication)
                .addOnSuccessListener( u -> {
                   Log.d("***insert" , publication+"");
                   Toast.makeText(DetailPublication_doc.this , "Ajout reussi" , Toast.LENGTH_LONG);
                });
    }

    private void onApercuDoc() {
        Intent intent = new Intent(this, PdfViewer.class);
        intent.putExtra(EXTRA_PDF_NAME, docName);
        startActivity(intent);
    }

    private void onDownloadDoc() {

    }

    public void createRecycler() {

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        commentRecycler.setLayoutManager(lm);
        commentRecycler.setAdapter(adapter);
    }

    /**
     * @param publication_id represente l'identifiant du document
     * dont on souhaite recuperer les donnees
     * TODO : juste passer l'identifier en parametre
     */
     public void getPublication(String publication_id) {
        db.collection("publication")
                .document(publication_id)
                .get()
                .addOnSuccessListener(task -> {
                    publication = task.toObject(Publication.class);
                    Log.d("***success", publication.getCommentaires() + "");
                    listComments = publication.getCommentaires();
                    Log.d("***success",  listComments.get(0) + "");
                })
                .addOnFailureListener(e -> {
                    Log.d("***echec", e + "");
                });
    }
}