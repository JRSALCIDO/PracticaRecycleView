package com.example.listviewalumnos;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> implements View.OnClickListener {
    protected ArrayList<Alumno> listaAlumnos;
    protected ArrayList<Alumno> listaAlumnosOriginal;
    private View.OnClickListener listener;
    private Context context;
    private LayoutInflater inflater;

    public MiAdaptador(ArrayList<Alumno> listaAlumnos, Context  context){
        this.listaAlumnos = listaAlumnos;
        this.listaAlumnosOriginal = new ArrayList<>(listaAlumnos);
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void filter(String texto) {
        listaAlumnos.clear();
        if (texto.isEmpty()) {
            listaAlumnos.addAll(listaAlumnosOriginal);
        } else {
            texto = texto.toLowerCase();
            for (Alumno item : listaAlumnosOriginal) {
                if (item.getNombre().toLowerCase().contains(texto) || item.getMatricula().toLowerCase().contains(texto)) {
                    listaAlumnos.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alumnos_items,null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Alumno alumno = listaAlumnos.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.idImagen.setImageURI(Uri.parse(alumno.getImg()));
        holder.txtCarrera.setText(alumno.getGrado());
    }


    @Override
    public int getItemCount(){
        return listaAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null) listener.onClick(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNombre;
        private TextView txtMatricula;
        private TextView txtCarrera;
        private ImageView idImagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txtAlumnoNombre);
            txtMatricula = (TextView) itemView.findViewById(R.id.txtMatricula);
            txtCarrera = (TextView) itemView.findViewById(R.id.txtCarrera);
            idImagen = (ImageView) itemView.findViewById((R.id.foto));
        }
    }
}

