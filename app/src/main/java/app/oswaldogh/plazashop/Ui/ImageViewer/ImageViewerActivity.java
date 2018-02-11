package app.oswaldogh.plazashop.Ui.ImageViewer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.google.gson.Gson;

import app.oswaldogh.plazashop.Adapters.ImageViewer.SlidingImage_Adapter;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import me.relex.circleindicator.CircleIndicator;

public class ImageViewerActivity extends Activity {
    private ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        Bundle extras = getIntent().getExtras();
        Gson gson = new Gson();
        final Product product = gson.fromJson(extras.getString("productImages"), Product.class);

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(ImageViewerActivity.this, product.getPhotos()));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
    }
}
