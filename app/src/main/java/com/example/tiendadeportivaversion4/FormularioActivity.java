package com.example.tiendadeportivaversion4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tiendadeportivaversion4.DB.DBFirebase;
import com.example.tiendadeportivaversion4.entidades.Producto;

public class FormularioActivity extends AppCompatActivity {

    private DBFirebase dbFirebase;
    private Button btnForm;
    private EditText editNameForm, editDescriptionForm, editPriceForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        btnForm = (Button) findViewById(R.id.btnForm);
        editNameForm = (EditText) findViewById(R.id.editName);
        editDescriptionForm = (EditText) findViewById(R.id.editDescription);
        editPriceForm = (EditText) findViewById(R.id.editPrice);
        dbFirebase = new DBFirebase();

        Intent intentIN = getIntent();
        if(intentIN.getBooleanExtra("edit",false)){
            editNameForm.setText(intentIN.getStringExtra("name"));
            editDescriptionForm.setText(intentIN.getStringExtra("description"));
            editPriceForm.setText(intentIN.getStringExtra("price"));
        }

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editNameForm.getText().toString().matches("")
                        || editDescriptionForm.getText().toString().matches("")
                        || editPriceForm.getText().toString().matches("")){
                    Toast.makeText(FormularioActivity.this, getString(R.string.texto_todos_los_campos_son_obligatorios), Toast.LENGTH_SHORT).show();
                }else{
                    Producto producto = new Producto(
                            editNameForm.getText().toString(),
                            editDescriptionForm.getText().toString(),
                            Long.parseLong(editPriceForm.getText().toString()),
                            "",
                            "",
                            ""
                    );
                    if(intentIN.getBooleanExtra("edit",false)){
                        producto.setId(intentIN.getStringExtra("id"));
                        dbFirebase.updateData(producto);
                    }else{
                        dbFirebase.insertData(producto);
                    }
                    finish();
                }
            }
        });
    }
}