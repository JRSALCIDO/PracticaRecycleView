package com.example.listviewalumnos;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<AlumnoItem> alumnoItems;
    private ArrayList<AlumnoItem> allAlumnoItems; // Lista de todos los elementos sin filtrar
    private AdapterAlumno adapter;
    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        alumnoItems = new ArrayList<>();
        allAlumnoItems = new ArrayList<>(); // Inicializar lista de todos los elementos

        fillAlumnos();

        allAlumnoItems.addAll(alumnoItems); // Agregar todos los elementos a la lista sin filtrar

        adapter = new AdapterAlumno(this, alumnoItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            AlumnoItem alumnoItem = alumnoItems.get(position);
            Toast.makeText(MainActivity.this, "Seleccionado: " + alumnoItem.getNombre(), Toast.LENGTH_SHORT).show();
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAlumnos(newText);
                return true;
            }
        });
    }

    private void fillAlumnos() {
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
        alumnoItems.add(new AlumnoItem());
    }

    private void filterAlumnos(String query) {
        ArrayList<AlumnoItem> filteredList = new ArrayList<>();

        if (TextUtils.isEmpty(query)) {
            filteredList.addAll(allAlumnoItems); // Mostrar todos los elementos si el texto de búsqueda está vacío
        } else {
            String searchQuery = query.toLowerCase().trim();

            for (AlumnoItem alumno : allAlumnoItems) {
                if (alumno.getNombre().toLowerCase().contains(searchQuery)
                        || alumno.getMatricula().toLowerCase().contains(searchQuery)) {
                    filteredList.add(alumno);
                }
            }
        }

        alumnoItems.clear(); // Limpiar la lista actual
        alumnoItems.addAll(filteredList); // Agregar los elementos filtrados
        adapter.notifyDataSetChanged();
    }
}
