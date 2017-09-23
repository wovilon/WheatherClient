package wovilonapps.wheatherclient.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "WeatherClient_DB";
    private static final int DATABASE_VERSION = 1;

    DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CITIES =
                "CREATE TABLE CitiesTable (id ID, city City)";
        db.execSQL(CREATE_TABLE_CITIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + "CitiesTable");
        onCreate(db);
    }
}