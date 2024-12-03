package com.example.smartfarmer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private FirebaseAuth auth;

    private TextView textView1,textView2;
    private EditText editText1,editText2,editText3;
    private Button button1,button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        auth = FirebaseAuth.getInstance();
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        editText1 = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextTextPassword1);
        editText3 = findViewById(R.id.editTextTextPassword2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText1.getText().toString().trim();
                String pass = editText2.getText().toString().trim();
                String sPass = editText3.getText().toString().trim();
                if(user.isEmpty()){
                    editText1.setError("Поле e-mail не может быть пустым");
                }
                if(pass.isEmpty()){
                    editText2.setError("Поле Пароль не может быть пустым");
                }
                if(sPass.isEmpty()){
                    editText2.setError("Поле Подтверждение пароля не может быть пустым");
                }
                else {
                    if (pass.equals(sPass)) {
                        auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignIn.this, "Успешная регистрация", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SignIn.this, "Не удалось зарегистрироваться " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else{
                        Toast.makeText(SignIn.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, LogIn.class);
                startActivity(intent);
            }
        });


    }
}