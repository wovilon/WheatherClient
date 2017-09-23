package wovilonapps.wheatherclient.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class DbUpdator {
    private SQLiteDatabase db;
    private Cursor c;
    private Context context;

    public DbUpdator(Context context){
        this.context=context;
        DbHelper dbHelper=new DbHelper(context);
        db=dbHelper.getWritableDatabase();
        c=db.rawQuery("SELECT * FROM CitiesTable", null);
    }

    public void addCityToDb(String city){
        int id=0;
        boolean cityAlreadyExists = false;
        for(int i=0; i<c.getCount(); i++){
            c.moveToPosition(i);
            if (c.getString(c.getColumnIndex("city")).equals(city)){
                cityAlreadyExists = true;
                break;
            }
        }
        if (!cityAlreadyExists){
            ContentValues data=new ContentValues();
            data.put("id",id);
            data.put("city", city);
            db.insert("CitiesTable", null, data);
            data.clear();
        }


    }


    public ArrayList<String> getAllCitiesFromDb(){
        ArrayList<String> cities = new ArrayList<>();
        for (int i=0; i < c.getCount(); i++){
            c.moveToPosition(i);
            cities.add(c.getString(c.getColumnIndex("city")));
        }
        return cities;
    }

    public String getCityFromDb(int i){
        c.moveToPosition(i);
        return c.getString(c.getColumnIndex("city"));
    }



}
