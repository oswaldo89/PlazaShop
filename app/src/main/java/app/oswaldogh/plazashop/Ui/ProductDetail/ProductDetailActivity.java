package app.oswaldogh.plazashop.Ui.ProductDetail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import app.oswaldogh.plazashop.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ImageView backdrop = findViewById(R.id.backdrop);
        Glide.with(this).load("https://tecnoandroid.net/wp-content/uploads/2017/04/cristal-templado-para-galaxy-s8-y-s8-plus-smrt.jpg").into(backdrop);

    }

}
