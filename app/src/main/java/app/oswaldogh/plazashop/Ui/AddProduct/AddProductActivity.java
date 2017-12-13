package app.oswaldogh.plazashop.Ui.AddProduct;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.oswaldogh89.picker.ImagePicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.oswaldogh.plazashop.R;

import static app.oswaldogh.plazashop.Tools.UtilsKt.log;

public class AddProductActivity extends AppCompatActivity {
    ImagePicker picker;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        picker = findViewById(R.id.picker);
        picker.setMainactivity(AddProductActivity.this);
        picker.SetBorderImageColor("#075e55");
        picker.enableDelateAll(true);


        //Si vas a cargar imagenes en el control desde una URL
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/01/19/15/earth-from-space.jpg");
        urls.add("http://www.slate.com/content/dam/slate/blogs/bad_astronomy/2016/03/09/shutterstock_earthfromhubble.jpg.CROP.original-original.jpg");
        picker.addImagesFromUrl(urls);

        Button btnUpload = findViewById(R.id.UploadImages);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Integer, String> images = picker.GetPathImages();
                for (Map.Entry entry : images.entrySet()) {
                    log("TAMAÑO : " + entry.getValue());
                }
            }
        });


        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.CAMERA
        };

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case ImagePicker.REQUEST_CAMERA:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
            case ImagePicker.REQUEST_GALLERY:
                if (resultCode == RESULT_OK) {
                    picker.AddNewImage(imageReturnedIntent);
                }
                break;
        }
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
