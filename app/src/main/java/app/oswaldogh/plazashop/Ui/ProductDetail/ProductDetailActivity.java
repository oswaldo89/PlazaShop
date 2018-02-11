package app.oswaldogh.plazashop.Ui.ProductDetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.ImageViewer.ImageViewerActivity;

import static app.oswaldogh.plazashop.Tools.UtilsKt.log;

public class ProductDetailActivity extends AppCompatActivity implements Interface.View {
    private FloatingActionButton btnLike, btnDislike;
    private ImageView imWhatsapp, imSms, imMsg;
    private TextView titleProduct, descriptionProduct, priceProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        Gson gson = new Gson();
        final Product product = gson.fromJson(extras.getString("ProductDetail"), Product.class);

        ImageView backdrop = findViewById(R.id.backdrop);
        backdrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                Intent i = new Intent(ProductDetailActivity.this, ImageViewerActivity.class);
                i.putExtra("productImages", gson.toJson(product));
                startActivity(i);
            }
        });

        if (product.getPhotos().size() > 0) {
            Glide.with(this).load(BuildConfig.STORAGE + product.getPhoto(0).getFilename()).into(backdrop);
        }


        initView();
        populateView(product);
    }

    @SuppressLint("SetTextI18n")
    private void populateView(Product product) {
        titleProduct.setText(product.getNombre());
        descriptionProduct.setText(product.getDescripcion());
        priceProduct.setText("$" + product.getPrecio() + " pesos");
    }

    private void initView() {
        titleProduct = findViewById(R.id.titleProduct);
        descriptionProduct = findViewById(R.id.descriptionProduct);
        priceProduct = findViewById(R.id.priceProduct);
        btnLike = findViewById(R.id.btnLike);
        btnDislike = findViewById(R.id.btnDislike);
        imWhatsapp = findViewById(R.id.imWhatsapp);
        imSms = findViewById(R.id.imSms);
        imMsg = findViewById(R.id.imMsg);
    }

    public void clickLike(View v) {
        Toast.makeText(this, "Me Gusta", Toast.LENGTH_SHORT).show();
        log("Me Gusta");
    }

    public void clickDisLike(View v) {
        Toast.makeText(this, "No me Gusta", Toast.LENGTH_SHORT).show();
        log("No me Gusta");
    }

    public void clickWhatsapp(View v) {
        Toast.makeText(this, "Compartir en whatsapp", Toast.LENGTH_SHORT).show();
        log("whatsapp");
    }

    public void clickSms(View v) {
        Toast.makeText(this, "Compartir por SMS", Toast.LENGTH_SHORT).show();
        log("sms");
    }

    public void clickMsg(View v) {
        Toast.makeText(this, "Compartir en Facebook messenger", Toast.LENGTH_SHORT).show();
        log("facebook");
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

    @Override
    public void setLike() {

    }
}
