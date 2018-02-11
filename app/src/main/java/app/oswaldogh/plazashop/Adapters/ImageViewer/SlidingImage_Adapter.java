package app.oswaldogh.plazashop.Adapters.ImageViewer;

/**
 * Created by oswaldogh89 on 10/02/18.
 */

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.oswaldogh.plazashop.BuildConfig;
import app.oswaldogh.plazashop.Entities.Image;
import app.oswaldogh.plazashop.R;


public class SlidingImage_Adapter extends PagerAdapter {


    private List<Image> images;
    private LayoutInflater inflater;
    private Context context;


    public SlidingImage_Adapter(Context context, List<Image> images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = imageLayout.findViewById(R.id.image);

        Glide.with(context).load(BuildConfig.STORAGE + images.get(position).getFilename()).into(imageView);
        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
