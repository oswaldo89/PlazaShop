package app.oswaldogh.plazashop.Ui.ProductAdd;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oswaldogh89.picker.ImagePicker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.oswaldogh.plazashop.Entities.Product;
import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Tools.Image;
import app.oswaldogh.plazashop.Tools.Permissions;
import app.oswaldogh.plazashop.Tools.PreferencesHandler;

public class ProductAddActivity extends AppCompatActivity implements Interface.View {
    private ImagePicker picker;
    private EditText txtNameProduct, txtPrice, txtDescriptionProduct, txtLocalNumber;
    private Spinner spnCategories;
    private ProductAddPresenter presenter;
    private ProgressDialog progressNewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter = new ProductAddPresenter(this);

        String[] PERMISSIONS = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        Permissions.enablePermissions(this, PERMISSIONS);

        initViews();
    }

    private void initViews() {
        txtNameProduct = findViewById(R.id.txtNameProduct);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescriptionProduct = findViewById(R.id.txtDescriptionProduct);
        spnCategories = findViewById(R.id.spnCategories);
        txtLocalNumber = findViewById(R.id.txtLocal);

        picker = findViewById(R.id.picker);
        picker.setMainactivity(ProductAddActivity.this);
        picker.SetBorderImageColor("#075e55");
        picker.enableDelateAll(true);
    }

    public void saveProduct(View view) {
        Product product = new Product();

        String mName = txtNameProduct.getText().toString();
        float mPrice = txtPrice.getText().toString().equals("") ? 0.0f : Float.parseFloat(txtPrice.getText().toString());
        String mDescription = txtDescriptionProduct.getText().toString();
        int mCategory = spnCategories.getSelectedItemPosition();
        int mLocal = txtLocalNumber.getText().toString().equals("") ? 0 : Integer.parseInt(txtLocalNumber.getText().toString());

        product.setNombre(mName);
        product.setPrecio(mPrice);
        product.setDescripcion(mDescription);
        product.setCategoria(mCategory);
        product.setLocal(mLocal);

        List<File> imagesModel = new ArrayList<>();
        HashMap<Integer, String> images = picker.GetPathImages();
        for (Map.Entry entry : images.entrySet()) {
            String pathImg = "content://media/" + entry.getValue().toString();
            imagesModel.add(new File(Image.compressImage(pathImg, ProductAddActivity.this)));
        }
        product.setImage(imagesModel);
        presenter.saveProduct(product);
    }

    @Override
    public void productSaved(String info) {
        PreferencesHandler.setReloadList(true, this);
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void uploadError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressNewProduct = new ProgressDialog(this);
        progressNewProduct.setTitle("PlazaShop");
        progressNewProduct.setMessage("Estamos agregando el producto...");
        progressNewProduct.setCancelable(false);
        progressNewProduct.show();
    }

    @Override
    public void hideLoading() {
        progressNewProduct.hide();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case ImagePicker.REQUEST_CAMERA:
                if (resultCode == RESULT_OK)
                    picker.AddNewImage(imageReturnedIntent);
                break;
            case ImagePicker.REQUEST_GALLERY:
                if (resultCode == RESULT_OK)
                    picker.AddNewImage(imageReturnedIntent);
                break;
        }
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
    public String tokenApi(){
        return PreferencesHandler.getTokenApi(this);
    }
}
