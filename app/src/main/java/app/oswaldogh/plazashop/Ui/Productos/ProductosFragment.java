package app.oswaldogh.plazashop.Ui.Productos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.oswaldogh.plazashop.Adapters.AdapterProductList;
import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;

public class ProductosFragment extends Fragment implements Interface.View{

    private ProductsPresenter presenter;
    private RecyclerView recycler_productos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_productos, container, false);

        presenter = new ProductsPresenter(this);


        initRecycler(v);

        return v;
    }

    private void initRecycler(View v) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recycler_productos = v.findViewById(R.id.table_agenda);
        recycler_productos.setHasFixedSize(true);
        recycler_productos.setLayoutManager(llm);
        presenter.getDataProducts();
    }


    @Override
    public void showProducts(ArrayList<Product> products) {
        AdapterProductList adapter = new AdapterProductList(getActivity(),products);
        recycler_productos.setAdapter(adapter);
    }
}
