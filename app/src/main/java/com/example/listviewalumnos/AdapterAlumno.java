package com.example.listviewalumnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterAlumno extends ArrayAdapter<AlumnoItem> {

    private Context mContext;
    private ArrayList<AlumnoItem> mAlumnoItems;

    public AdapterAlumno(@NonNull Context context, ArrayList<AlumnoItem> list) {
        super(context, 0, list);
        mContext = context;
        mAlumnoItems = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.alumno_item, parent, false);

        AlumnoItem currentAlumnoItem = mAlumnoItems.get(position);

        ImageView image = listItem.findViewById(R.id.image_alumno);
        String imageName = currentAlumnoItem.getMatricula();
        int resID = mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());
        image.setImageResource(resID);

        TextView name = listItem.findViewById(R.id.nombre_alumno);
        name.setText(currentAlumnoItem.getNombre());

        TextView matricula = listItem.findViewById(R.id.matricula_alumno);
        matricula.setText(currentAlumnoItem.getMatricula());

        return listItem;
    }
}
