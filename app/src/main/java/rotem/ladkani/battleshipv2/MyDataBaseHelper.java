package rotem.ladkani.battleshipv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String DataBaseName = "MyDataBase.db";
    public static final int DataBaseVersion = 1;
    public static final String TableName = "Users";
    public static final String USER_ID = "id"; // Added ID column
    public static final String USER_NAME = "UserName";
    public static final String USER_EMAIL = "UserEmail"; // Corrected column name
    public static final String USER_PWD = "UsersPwd";
    public static final String USER_PHONE = "UsersPhone";



//constructor
    public MyDataBaseHelper(@Nullable Context context) {
        super(context,DataBaseName, null, 1);
        this.context = context;
    }
//crate table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TableName +
                " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " +
                USER_PWD + " TEXT, " +
                USER_EMAIL + " TEXT, " +
                USER_PHONE + " TEXT)";
        db.execSQL(query);
    }//update table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }//adding new user
    void AddUser(String userID ,String userName, String userPwd, String userEmail, String userPhone){
        SQLiteDatabase db  =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_ID,userID);
        cv.put(USER_NAME,userName);
        cv.put(USER_PWD,userPwd);
        cv.put(USER_EMAIL,userEmail);
        cv.put(USER_PHONE,userPhone);
        long result = db.insert(TableName,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }
}
