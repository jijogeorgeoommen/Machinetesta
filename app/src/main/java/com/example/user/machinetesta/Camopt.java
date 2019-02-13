package com.example.user.machinetesta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Camopt extends AppCompatActivity {
    static int CAM_REQUEST = 1888;

    ImageView imagev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camopt);
        imagev = findViewById(R.id.camimage);
        findViewById(R.id.cam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent();
                c.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(c,CAM_REQUEST);
            }
        });

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharein=new Intent(Intent.ACTION_SEND);
                sharein.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharein.setType("image/*");
                startActivity(Intent.createChooser(sharein, " share image using"));
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAM_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imagev.setImageBitmap(photo);
            }

        }
    }
}
