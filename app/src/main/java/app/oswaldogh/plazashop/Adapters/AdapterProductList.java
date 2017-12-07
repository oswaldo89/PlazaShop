package app.oswaldogh.plazashop.Adapters;

/**
 * Created by oswaldogomez on 05/12/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;

public class AdapterProductList extends RecyclerView.Adapter<AdapterProductList.ListViewHolder> {

    private ArrayList<Product> products;
    private Context context;

    public AdapterProductList(Context context, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_recycler_item, parent, false);
        ListViewHolder lvh = new ListViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int i) {

        Product res = products.get(i);
        Glide.with(context).load(res.getUrl()).into(holder.image);
        holder.description.setText(res.getDescription());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        ImageView image;

        ListViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.product_thumb);
            description = itemView.findViewById(R.id.description);
        }
    }

}