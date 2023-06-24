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
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030306, getResources().getString(R.string.alumno1_nombre), getResources().getString(R.string.alumno1_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030313, getResources().getString(R.string.alumno2_nombre), getResources().getString(R.string.alumno2_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030315, getResources().getString(R.string.alumno3_nombre), getResources().getString(R.string.alumno3_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030322, getResources().getString(R.string.alumno4_nombre), getResources().getString(R.string.alumno4_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030325, getResources().getString(R.string.alumno5_nombre), getResources().getString(R.string.alumno5_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030327, getResources().getString(R.string.alumno6_nombre), getResources().getString(R.string.alumno6_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030329, getResources().getString(R.string.alumno7_nombre), getResources().getString(R.string.alumno7_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030332, getResources().getString(R.string.alumno8_nombre), getResources().getString(R.string.alumno8_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030333, getResources().getString(R.string.alumno9_nombre), getResources().getString(R.string.alumno9_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030389, getResources().getString(R.string.alumno10_nombre), getResources().getString(R.string.alumno10_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030766, getResources().getString(R.string.alumno11_nombre), getResources().getString(R.string.alumno11_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030771, getResources().getString(R.string.alumno12_nombre), getResources().getString(R.string.alumno12_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030777, getResources().getString(R.string.alumno13_nombre), getResources().getString(R.string.alumno13_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030799, getResources().getString(R.string.alumno14_nombre), getResources().getString(R.string.alumno14_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030808, getResources().getString(R.string.alumno15_nombre), getResources().getString(R.string.alumno15_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030819, getResources().getString(R.string.alumno16_nombre), getResources().getString(R.string.alumno16_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030865, getResources().getString(R.string.alumno17_nombre), getResources().getString(R.string.alumno17_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2019030344, getResources().getString(R.string.alumno18_nombre), getResources().getString(R.string.alumno18_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030174, getResources().getString(R.string.alumno19_nombre), getResources().getString(R.string.alumno19_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030176, getResources().getString(R.string.alumno20_nombre), getResources().getString(R.string.alumno20_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030181, getResources().getString(R.string.alumno21_nombre), getResources().getString(R.string.alumno21_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030184, getResources().getString(R.string.alumno22_nombre), getResources().getString(R.string.alumno22_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030189, getResources().getString(R.string.alumno23_nombre), getResources().getString(R.string.alumno23_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030199, getResources().getString(R.string.alumno24_nombre), getResources().getString(R.string.alumno24_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030212, getResources().getString(R.string.alumno25_nombre), getResources().getString(R.string.alumno25_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030241, getResources().getString(R.string.alumno26_nombre), getResources().getString(R.string.alumno26_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030243, getResources().getString(R.string.alumno27_nombre), getResources().getString(R.string.alumno27_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030249, getResources().getString(R.string.alumno28_nombre), getResources().getString(R.string.alumno28_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030264, getResources().getString(R.string.alumno29_nombre), getResources().getString(R.string.alumno29_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030268, getResources().getString(R.string.alumno30_nombre), getResources().getString(R.string.alumno30_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030292, getResources().getString(R.string.alumno31_nombre), getResources().getString(R.string.alumno31_matricula)));
        alumnoItems.add(new AlumnoItem(R.drawable.a2020030304, getResources().getString(R.string.alumno32_nombre), getResources().getString(R.string.alumno32_matricula)));
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
