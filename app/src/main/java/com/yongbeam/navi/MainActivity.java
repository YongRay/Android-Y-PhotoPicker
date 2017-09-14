package com.yongbeam.navi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yongbeam.y_photopicker.util.photopicker.PhotoPagerActivity;
import com.yongbeam.y_photopicker.util.photopicker.PhotoPickerActivity;
import com.yongbeam.y_photopicker.util.photopicker.utils.YPhotoPickerIntent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int REQUEST_CODE = 1;
    private Button button3;

    public static ArrayList<String> selectedPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YPhotoPickerIntent intent = new YPhotoPickerIntent(MainActivity.this);
                intent.setMaxSelectCount(20);
                intent.setShowCamera(true);
                intent.setShowGif(true);
                intent.setSelectCheckBox(false);
                intent.setMaxGrideItemCount(3);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<String> photos = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
            if (photos != null) {
                selectedPhotos.addAll(photos);
            }

            // start image viewr
            Intent startActivity = new Intent(this , PhotoPagerActivity.class);
            startActivity.putStringArrayListExtra("photos" , selectedPhotos);
            startActivity(startActivity);
        }
    }
}