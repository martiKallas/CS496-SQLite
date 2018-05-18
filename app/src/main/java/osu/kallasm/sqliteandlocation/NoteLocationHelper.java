package osu.kallasm.sqliteandlocation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteLocationHelper extends SQLiteOpenHelper {
    public NoteLocationHelper(Context context){
        super(context, NoteLocContract.DB_NAME, null, NoteLocContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NoteLocContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(NoteLocContract.SQL_DROP_TABLE);
    }
}
