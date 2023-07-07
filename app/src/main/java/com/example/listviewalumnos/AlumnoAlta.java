package com.example.listviewalumnos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlumnoAlta extends AppCompatActivity {

    private Button btnGuardar, btnRegresar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private TextView lblImagen;
    private String carrera = "Ing. Tec. Informacion";
    private int posicion;


    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);

        setContentView(R.layout.activity_alumno_alta);
        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtGrado = (EditText) findViewById(R.id.txtGrado);
        imgAlumno = (ImageView) findViewById(R.id.imgAlumno);

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if(posicion >= 0){
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getGrado());
            imgAlumno.setImageResource(alumno.getImg());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alumno == null){
                    alumno = new Alumno();
                    alumno.setGrado(carrera);
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImg(R.drawable.us01);

                    if(validar()) {
                        Aplicacion.alumnos.add(alumno);
                        setResult(Activity.RESULT_OK);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Falto capturar datos", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();

                    }
                }

                if (posicion >= 0){
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setGrado(txtGrado.getText().toString());

                    Aplicacion.alumnos.get(posicion).setMatricula(alumno.getMatricula());
                    Aplicacion.alumnos.get(posicion).setNombre(alumno.getNombre());
                    Aplicacion.alumnos.get(posicion).setGrado(alumno.getGrado());


                    Toast.makeText(getApplicationContext(), " Se modifico con exito ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private boolean validar(){
        boolean exito = true;
        Log.d("nombre", "validar: "  + txtNombre.getText());
        if (txtNombre.getText().toString().equals("")) exito = false;
        if (txtMatricula.getText().toString().equals("")) exito = false;
        if (txtGrado.getText().toString().equals("")) exito = false;

        return exito;
    }

}
