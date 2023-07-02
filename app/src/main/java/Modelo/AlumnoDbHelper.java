package Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
import java.util.SplittableRandom;

public class AlumnoDbHelper extends SQLiteOpenHelper{

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String COMMA_SEP = " ,";

    private static final String SQL_CREATE_ALUMNO = "CREATE TABLE " +
            DefineTabla.Alumnos.TABLE_NAME + " (" +
            DefineTabla.Alumnos.COLUMN_NAME_ID + "INTEGER PRIMARY KEY, " +
            DefineTabla.Alumnos.COLUMN_NAME_MATRICULA + TEXT_TYPE +
            DefineTabla.Alumnos.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Alumnos.COLUMN_NAME_CARRERA + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Alumnos.COLUMN_NAME_FOTO + INTEGER_TYPE + ")";

    private static final String SQL_DELETE_ALUMNO = "CREATE TABLE " +
            DefineTabla.Alumnos.TABLE_NAME;
    private static final String DATABASE_NAME = "sistema.db";
    private static final int DATABASE_VERCION = 1;








    public AlumnoDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERCION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(SQL_CREATE_ALUMNO);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il){
        sqLiteDatabase.execSQL(SQL_DELETE_ALUMNO);
        onCreate(sqLiteDatabase);
    }


}
