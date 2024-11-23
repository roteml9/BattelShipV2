package rotem.ladkani.battleshipv2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    Button toRegistretion;
     UserDetails user;
     EditText emailLogin;
     EditText pswLogin;
     Button countinueLoging;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.LoginEmail);
        pswLogin = findViewById(R.id.LoginPsw);
        countinueLoging = findViewById(R.id.LoginCountinueB);
        countinueLoging.setOnClickListener(new View.OnClickListener() {
            @Override//moving to home screen
            public void onClick(View v) {
                Editable editable = emailLogin.getText();
                String emailLoginS = editable.toString();
                user.setUsrEmail(emailLoginS);

                Editable editable2 = pswLogin.getText();
                String pswLoginS = editable2.toString();
                user.setUsrPsw(pswLoginS);
                Intent intent = new Intent(Login.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        toRegistretion = findViewById(R.id.LoginRegisterB);
        toRegistretion.setOnClickListener(new View.OnClickListener() {
            @Override//moving to register screen
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}