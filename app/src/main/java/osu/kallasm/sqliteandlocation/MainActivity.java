/*  Author: Marti Kallas
    Date: 5/17/2018
    Description: Oregon State University CS496 SQLite and Permissions assignment
    Sources: CS496 lectures
 */
package osu.kallasm.sqliteandlocation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
   private SQLiteDatabase sqlDB = null;
   private NoteLocationHelper dbHelper = null;
   private Cursor cursor;
   private SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new NoteLocationHelper(this);
        sqlDB = dbHelper.getWritableDatabase();
        Button save = (Button) findViewById(R.id.sqSaveEntry);
        updateListView();
    }

    private void updateListView(){
        if (!retrieveAllData()) return;
        ListView SQLView = (ListView) findViewById(R.id.sqSavedList);
        cursorAdapter = new SimpleCursorAdapter(this,
                R.layout.list_layout,
                cursor,
                new String[]{NoteLocContract.COLUMN_NAME_NOTE,
                        NoteLocContract.COLUMN_NAME_LAT,
                        NoteLocContract.COLUMN_NAME_LONG},
                new int[]{R.id.listNote, R.id.listLattitude, R.id.listLongitude},
                0);
        SQLView.setAdapter(cursorAdapter);
    }

    private boolean retrieveAllData(){
        if (sqlDB == null) return false;
        if(cursorAdapter != null && cursorAdapter.getCursor() != null){
            if(!cursorAdapter.getCursor().isClosed()){
                cursorAdapter.getCursor().close();
            }
        }
        cursor = sqlDB.query(NoteLocContract.TABLE_NAME,
            new String[]{NoteLocContract._ID, NoteLocContract.COLUMN_NAME_NOTE,
                NoteLocContract.COLUMN_NAME_LAT, NoteLocContract.COLUMN_NAME_LONG},
                null, null, null, null, null);

        return true;
    }

    public void onSave(View v){
        if (sqlDB == null) return;
        //get note text
        String note;
        EditText field = (EditText)findViewById(R.id.sqEntry);
        note = field.getText().toString();
        field.setText("");
        if (note.length() > 255) note = note.substring(0, 255);

        //get lat and long
        Location loc = getLatLong();

        //Enter results in DB
        ContentValues testValues = new ContentValues();
        testValues.put(NoteLocContract.COLUMN_NAME_NOTE, note);
        testValues.put(NoteLocContract.COLUMN_NAME_LAT, loc.getLattitude());
        testValues.put(NoteLocContract.COLUMN_NAME_LONG, loc.getLongitude());
        sqlDB.insert(NoteLocContract.TABLE_NAME, null, testValues);

        //update list
        updateListView();
    }

    private Location getLatLong() {
        //check for permission
        Location loc = new Location(44.5, -123.2);
        //if permission
        return loc;
    }

}
