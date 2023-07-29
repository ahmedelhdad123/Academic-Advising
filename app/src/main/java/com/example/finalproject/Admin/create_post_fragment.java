package com.example.finalproject.Admin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.finalproject.AAU.Objectives;
import com.example.finalproject.Admin_Home;
import com.example.finalproject.R;
import com.example.finalproject.TimeLine.Model.Data;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;
public class create_post_fragment extends Fragment {
    ImageView iv_back , iv_post;
    EditText write_post;
    Button btn_add_photo , btn_post;

    Uri imageUri ;
    DatabaseReference databaseReference  =   FirebaseDatabase.getInstance().getReference("posts");
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_post_fragment, container, false);

        iv_post = view.findViewById(R.id.iv_post_tl);
        btn_post = view.findViewById(R.id.post);
        write_post = view.findViewById(R.id.write_post);
        iv_back = view.findViewById(R.id.arrow_back);
        btn_add_photo = view.findViewById(R.id.add_photo);


        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            imageUri = data.getData();
                            iv_post.setImageURI(imageUri);
                        } else {
                            Toast.makeText(getContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btn_add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri != null){
                    uploadToFirebase(imageUri);
                } else  {
                    Toast.makeText(getContext(),"Please select image", Toast.LENGTH_SHORT).show();
                }
            }
        });

         // to back
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Admin_Home.class);
                startActivity(intent);
            }
        });


        return view;
    }
    private void uploadToFirebase(Uri uri){
        String caption = write_post.getText().toString();
        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Data dataClass = new Data(uri.toString(), caption);
                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(dataClass);
                        Toast.makeText(getContext() , "Uploaded", Toast.LENGTH_SHORT).show();
                        write_post.setText("");
                        iv_post.setImageResource(0);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private String getFileExtension(Uri fileUri){
        ContentResolver contentResolver = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(fileUri));
    }
}