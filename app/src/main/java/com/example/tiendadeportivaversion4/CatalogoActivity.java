package com.example.tiendadeportivaversion4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tiendadeportivaversion4.DB.DBFirebase;
import com.example.tiendadeportivaversion4.adaptadores.ProductoAdapter;
import com.example.tiendadeportivaversion4.entidades.Producto;

import java.util.ArrayList;

public class CatalogoActivity extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();

        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();productoAdapter.vaciarLista();
        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), FormularioActivity.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}