package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;
    Spinner ap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.username);
        ed2 = (EditText) findViewById(R.id.useremail);
        ed3 = (EditText) findViewById(R.id.userpswd);
        btn = (Button) findViewById(R.id.button);
        ap = (Spinner) findViewById(R.id.spin);
        String[] batch = {"1901F1","1901F2","1902G2"};
        ArrayAdapter<String> lala = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,batch);
        lala.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ap.setAdapter(lala);
        FirebaseApp.initializeApp(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String email = ed2.getText().toString();
                String pswd = ed3.getText().toString();
                String b = ap.getSelectedItem().toString();
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference tab = db.getReference("Student");
                DbHelper dd = new DbHelper(name,email,pswd,b);
                tab.child(b).push().setValue(dd);
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(i);
//
            }
        });
    }
}