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

public class Register extends AppCompatActivity {
    UserDetails user;
    EditText regEmail;
    EditText regPsw;
    EditText regPhd;
    Button regCountinue;
    Button regBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        regEmail = findViewById(R.id.regEmail);
        regPsw = findViewById(R.id.regPsw);
        regPhd = findViewById(R.id.regPhd);
        regBack = findViewById(R.id.regbackB);
        regCountinue = findViewById(R.id.regCountinueB);
        regBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        regCountinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editable0 = regEmail.getText();
                user.setUsrEmail(editable0.toString());

                Editable editable1 = regPsw.getText();
                user.setUsrPsw(editable1.toString());

                Editable editable2 = regPhd.getText();
                user.setUsrPhone(editable2.toString());
                Intent intent = new Intent(Register.this, HomeScreen.class);
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