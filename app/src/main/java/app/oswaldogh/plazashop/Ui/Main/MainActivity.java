package app.oswaldogh.plazashop.Ui.Main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Ui.AboutMe.AboutFragment;
import app.oswaldogh.plazashop.Ui.ProductAdd.ProductAddActivity;
import app.oswaldogh.plazashop.Ui.Products.ProductsFragment;
import app.oswaldogh.plazashop.Ui.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Interface.View {
    FloatingActionButton fab;
    Dialog dialog;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setChecked(true);
        setFragment(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_product) {
            setFragment(0);
        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_about) {
            setFragment(2);

        } else if (id == R.id.nav_enter) {
            presenter.openLoginDialog();


            /*
            // set the custom dialog components - text, image and button
            TextView text = (TextView) dialog.findViewById(R.id.text);
            text.setText("Android custom dialog example!");
            ImageView image = (ImageView) dialog.findViewById(R.id.image);
            image.setImageResource(R.drawable.ic_launcher);

            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            */
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                ProductsFragment inboxFragment = new ProductsFragment();
                fragmentTransaction.replace(R.id.fragment, inboxFragment);
                fab.setVisibility(View.VISIBLE);
                break;
            case 1:
                fab.setVisibility(View.GONE);
                break;
            case 2:
                AboutFragment aboutFragment = new AboutFragment();
                fragmentTransaction.replace(R.id.fragment, aboutFragment);
                fab.setVisibility(View.GONE);
                break;
        }
        fragmentTransaction.commit();
    }

    public void onNewProduct(View v) {
        Intent i = new Intent(MainActivity.this, ProductAddActivity.class);
        startActivity(i);
    }

    public void onRegister(View v) {
        presenter.closeLoginDialog();
        Intent i = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void showLoginDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public void hideLoginDialog() {
        dialog.hide();
        dialog = null;
    }
}
