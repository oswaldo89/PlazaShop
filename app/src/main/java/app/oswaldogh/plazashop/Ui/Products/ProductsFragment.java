package app.oswaldogh.plazashop.Ui.Products;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Adapters.Product.AdapterProductList;
import app.oswaldogh.plazashop.Adapters.Product.ProductItemView;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.ProductDetail.ProductDetailActivity;

public class ProductsFragment extends Fragment implements Interface.View, ProductItemView {

    private ProductsPresenter presenter;
    private SuperRecyclerView rv_productList;
    private AdapterProductList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_products, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Productos");
        presenter = new ProductsPresenter(this);
        initRecycler(v);
        return v;
    }

    private void initRecycler(View v) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv_productList = v.findViewById(R.id.product_list);
        rv_productList.setLayoutManager(llm);
        presenter.getDataProducts(0);
        rv_productList.setupMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
                presenter.getDataProducts(numberOfItems);
            }
        }, 10);
    }

    @Override
    public void showProducts(ArrayList<Product> products) {
        if (products.size() != 0) {
            if (adapter == null) { //only enter the first time, when adapter is null and empty.
                adapter = new AdapterProductList(getActivity(), products, this);
            } else { //it is called only when the adapter has products
                adapter.addItems(products);
            }
            rv_productList.setAdapter(adapter);
        }else if(products.size() == 0 && adapter == null){//if the adapter is null and dont exist any products, shows empty view layout.
            rv_productList.getEmptyView();
        }
        rv_productList.hideMoreProgress();
    }

    @Override
    public void onClickProductItem(Product item, int position) {
        Intent i = new Intent(getContext(), ProductDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putString("url_image", item.getUrl());
        i.putExtras(extras);
        startActivity(i);
    }
}
