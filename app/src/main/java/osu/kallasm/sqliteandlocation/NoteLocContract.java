package osu.kallasm.sqliteandlocation;

import android.provider.BaseColumns;

public class NoteLocContract implements BaseColumns{
    public static final String DB_NAME = "note_location";
    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_NAME_NOTE = "note";
    public static final String COLUMN_NAME_LAT = "lattitude";
    public static final String COLUMN_NAME_LONG = "longitude";
    public static final int DB_VERSION = 4;

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + "(" +
            NoteLocContract._ID + " INTEGER PRIMARY KEY NOT NULL, " +
            NoteLocContract.COLUMN_NAME_NOTE + " VARCHAR(255), " +
            NoteLocContract.COLUMN_NAME_LAT + " REAL, " +
            NoteLocContract.COLUMN_NAME_LONG + " REAL" +
            ");";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + NoteLocContract.TABLE_NAME;

}
