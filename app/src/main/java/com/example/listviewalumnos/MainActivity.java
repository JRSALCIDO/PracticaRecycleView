package com.example.listviewalumnos;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private Aplicacion app;

    private Alumno alumno;
    int posicion = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aplicacion app = (Aplicacion) getApplication();
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        recyclerView.setAdapter(app.getAdaptador());

        fbtnAgregar = (FloatingActionButton) findViewById(R.id.agregarAlumno);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fbtnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                alumno =null;
                Intent intent = new Intent(MainActivity.this, AlumnoAlta.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno", alumno);
                bundle.putInt("posicion", posicion);
                intent.putExtras(bundle);

                startActivityForResult(intent, 0);

            }
        });


        app.getAdaptador().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    posicion = recyclerView.getChildAdapterPosition(v);
                    alumno = app.getAlumnos().get(posicion);

                    Intent intent = new Intent(MainActivity.this, AlumnoAlta.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("alumno", alumno);
                    intent.putExtra("posicion", posicion);


                startActivityForResult(intent, 1);
                }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        recyclerView.getAdapter().notifyDataSetChanged();
        posicion = -1;
    }

}