package cne.compaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.vision.text.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        WebView webViewControl = (WebView) findViewById(R.id.webview);
        webViewControl.getSettings().setJavaScriptEnabled(true);
        webViewControl.setWebViewClient(new WebViewClient());
        webViewControl.loadUrl("http://www.compa.org.mx");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // En esta seccion se manejan los eventos de cuando el usuario
    // presiona
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // En esta sección se cargará la pagina de noticias
        if (id == R.id.nav_news) {
            WebView webViewControl = (WebView) findViewById(R.id.webview);
            webViewControl.loadUrl("http://www.compa.org.mx");

        }
        // En esta sección se carga el mapa con los grupos de estudio biblico
        else if (id == R.id.nav_studies) {
            //Toast.makeText(this, "Esta característica se habilitará proximamente", Toast.LENGTH_SHORT).show();
            Intent intentMap = new Intent(this, StudyGroupsActivity.class );
            startActivity(intentMap);

        }
        // En esta sección se cargará la página con los eventos
        else if (id == R.id.nav_events) {
            WebView webViewControl = (WebView) findViewById(R.id.webview);
            webViewControl.loadUrl("http://compa.org.mx/eventos/");

        }
        // En esta sección, cargar la página de donativos
        else if (id == R.id.nav_donate) {
            WebView webViewControl = (WebView) findViewById(R.id.webview);
            webViewControl.loadUrl("http://compa.org.mx/involucrate/");

        }
        // En esta sección se cargan los recursos
        else if (id == R.id.nav_resources) {
            WebView webViewControl = (WebView) findViewById(R.id.webview);
            webViewControl.loadUrl("http://wwww.facebook.com");

        }
        // En esta parte cargar la sección con la información sobre compa
        else if (id == R.id.nav_about) {
            WebView webViewControl = (WebView) findViewById(R.id.webview);
            webViewControl.loadUrl("http://compa.org.mx/about-us/");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
