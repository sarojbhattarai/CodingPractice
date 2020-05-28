package np.com.sarojb.famouspersonbiographies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    static int version = 1;
    static String name = "Database";
    ArrayList<FamousPersons> listofPersons = new ArrayList<>();


    String databaseQuery = "CREATE TABLE \"USER\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"name\"\tTEXT NOT NULL UNIQUE,\n" +
            "\t\"imageUrl\"\tTEXT,\n" +
            "\t\"fieldOfWork\"\tTEXT,\n" +
            "\t\"shortDesc\"\tTEXT,\n" +
            "\t\"longDesc\"\tTEXT,\n" +
            "\t\"isFavourite\"\tTEXT DEFAULT \"true\"\n" +
            ");";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);

    }

    public void insertData(ContentValues contentValues) {
        getWritableDatabase().insert("USER", "", contentValues);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(databaseQuery);
    }

    public ArrayList<FamousPersons> getFamousPersonFromDatabase() {
        ArrayList<FamousPersons> list = new ArrayList<>();
        String sql = "SELECT * FROM USER";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()) {
            FamousPersons fp = new FamousPersons();
            fp.id = Integer.valueOf(cursor.getString(cursor.getColumnIndex("id")));
            fp.name = cursor.getString(cursor.getColumnIndex("name"));
            fp.imageUrl = cursor.getString(cursor.getColumnIndex("imageUrl"));
            fp.fieldOfWork = cursor.getString(cursor.getColumnIndex("fieldOfWork"));
            fp.shortdesc = cursor.getString(cursor.getColumnIndex("shortDesc"));
            fp.longdesc = cursor.getString(cursor.getColumnIndex("longDesc"));
            fp.isEnabled = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("isFavourite")));
            list.add(fp);
        }
        cursor.close();
        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
