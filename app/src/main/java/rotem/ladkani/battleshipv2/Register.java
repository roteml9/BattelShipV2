package rotem.ladkani.battleshipv2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    UserDetails user;
    EditText UserEmail;
    EditText UserPwd;;
    EditText UserPhone;
    EditText UserName;
    EditText UserId;
    Button CountinueButton;
    Button regBack;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Initialize views
        UserEmail = findViewById(R.id.UserEmail);
        UserId = findViewById(R.id.UserID);
        UserName = findViewById(R.id.UserName);
        UserPwd = findViewById(R.id.UserPwd);
        UserPhone = findViewById(R.id.UserPhone);
        regBack = findViewById(R.id.regbackB);
        CountinueButton = findViewById(R.id.CountinueButton);
        CountinueButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override//adding new user by clicking on countinue
                    public void onClick(View v) {
                        MyDataBaseHelper mydb = new MyDataBaseHelper(Register.this);
                        mydb.AddUser(UserId.getText().toString(), UserName.getText().toString(), UserPwd.getText().toString(), UserEmail.getText().toString(), UserPhone.getText().toString());
                    }
                }
        );//returning to login screen
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}