package app.oswaldogh.plazashop.Adapters.Product;

/**
 * Created by oswaldogomez on 05/12/17.
 */

import android.annotation.SuppressLint;
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
    private ProductItemView view;

    public AdapterProductList(Context context, ArrayList<Product> products, ProductItemView view) {
        this.products = products;
        this.context = context;
        this.view = view;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final Product res = products.get(position);
        Glide.with(context).load(res.getUrl()).into(holder.image);
        holder.description.setText(res.getDescripcion());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onClickProductItem(res, position);
            }
        });
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