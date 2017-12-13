package app.oswaldogh.plazashop.Ui.ProductDetail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import app.oswaldogh.plazashop.R;
import static app.oswaldogh.plazashop.Tools.UtilsKt.*;

public class ProductDetailActivity extends AppCompatActivity implements Interface.View {
    private FloatingActionButton btnLike, btnDislike;
    private ImageView imWhatsapp,imSms,imMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String url_image = extras.getString("url_image");

        ImageView backdrop = findViewById(R.id.backdrop);
        Glide.with(this).load(url_image).into(backdrop);


        btnLike = findViewById(R.id.btnLike);
        btnDislike = findViewById(R.id.btnDislike);

        imWhatsapp = findViewById(R.id.imWhatsapp);
        imSms = findViewById(R.id.imSms);
        imMsg = findViewById(R.id.imMsg);
    }

    public void clickLike(View v){
        Toast.makeText(this, "Me Gusta", Toast.LENGTH_SHORT).show();
        log("Me Gusta");
    }

    public void clickDisLike(View v){
        Toast.makeText(this, "No me Gusta", Toast.LENGTH_SHORT).show();
        log("No me Gusta");
    }

    public void clickWhatsapp(View v){
        Toast.makeText(this, "Compartir en whatsapp", Toast.LENGTH_SHORT).show();
        log("whatsapp");
    }

    public void clickSms(View v){
        Toast.makeText(this, "Compartir por SMS", Toast.LENGTH_SHORT).show();
        log("sms");
    }

    public void clickMsg(View v){
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
