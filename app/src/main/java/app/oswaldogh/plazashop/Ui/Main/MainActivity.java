package app.oswaldogh.plazashop.Ui.Main;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
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
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import app.oswaldogh.plazashop.R;
import app.oswaldogh.plazashop.Tools.PreferencesHandler;
import app.oswaldogh.plazashop.Ui.AboutMe.AboutFragment;
import app.oswaldogh.plazashop.Ui.ProductAdd.ProductAddActivity;
import app.oswaldogh.plazashop.Ui.Products.ProductsFragment;
import app.oswaldogh.plazashop.Ui.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Interface.View {
    private NavigationView navigationView;
    Menu nav_Menu;
    private FloatingActionButton fab;
    private Dialog dialog;
    private MainPresenter presenter;

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

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        nav_Menu = navigationView.getMenu();

        navigationView.getMenu().getItem(0).setChecked(true);
        setFragment(0);
    }

    //region Fragment Navigation
    //---------------------------------------------------------------------------------------
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_product:
                setFragment(0);
                break;
            case R.id.nav_about:
                setFragment(2);
                break;
            case R.id.nav_enter:
                presenter.openLoginDialog();
                break;
            case R.id.nav_exit:
                presenter.logoutApplication();
                break;
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //---------------------------------------------------------------------------------------
    //endregion

    //region Login Implementation
    //---------------------------------------------------------------------------------------
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
        final EditText txtUser = dialog.findViewById(R.id.txtUser);
        final EditText txtPassword = dialog.findViewById(R.id.txtPassword);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogin(txtUser.getText().toString(), txtPassword.getText().toString());
            }
        });
        dialog.show();
    }

    @Override
    public void hideLoginDialog() {
        dialog.hide();
        dialog = null;
    }

    @Override
    public void setTokenApi(String tokenApi) {
        PreferencesHandler.setTokenApi(tokenApi, this);
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()){
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // hide
        } else {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY); // show
        }
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucces() {
        dialog.hide();

        //Deshabilitamos el boton de "Entrar" en el navigationDrawer y Hablitamos "Salir"
        enableButtonLogout();
        Toast.makeText(this, "Ingreso correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void logout() {

        //Reset token
        PreferencesHandler.setTokenApi("", this);

        //Enable button to login.
        enableButtonLogin();
        Toast.makeText(this, "Salio correctamente", Toast.LENGTH_SHORT).show();
    }

    private void enableButtonLogout() {
        nav_Menu.findItem(R.id.nav_enter).setVisible(false);
        nav_Menu.findItem(R.id.nav_exit).setVisible(true);
    }

    private void enableButtonLogin() {
        nav_Menu.findItem(R.id.nav_enter).setVisible(true);
        nav_Menu.findItem(R.id.nav_exit).setVisible(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!PreferencesHandler.getTokenApi(this).equals(""))
            enableButtonLogout();
    }

    //---------------------------------------------------------------------------------------
    //endregion

    public void onNewProduct(View v) {

        if (!PreferencesHandler.getTokenApi(this).equals("")){
            Intent i = new Intent(MainActivity.this, ProductAddActivity.class);
            startActivity(i);
        }else{
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("PlazaShop");
            alertDialog.setMessage("Para poder agregar un producto necesita ser un usuario registrado. Desea registrarse ahora ?");
            alertDialog.setIcon(R.drawable.ic_iconapp);
            alertDialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(i);
                    finish();
                }
            });
            alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alertDialog.show();
        }





    }

}
