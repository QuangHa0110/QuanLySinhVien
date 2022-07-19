package com.hadvq.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    private TextView textViewMSSV;
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewBirthday;
    private EditText edtMSSV;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtBirthday;
    private Button btnBack;
    private Button btnSave;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Init();
        Back();
        SaveData();
    }

    public void Init() {
        textViewMSSV = (TextView) findViewById(R.id.txtViewMSSV);
        textViewName = (TextView) findViewById(R.id.txtViewName);
        textViewEmail = (TextView) findViewById(R.id.txtViewEmail);
        textViewBirthday = (TextView) findViewById(R.id.txtViewBirthday);

        edtMSSV = (EditText) findViewById(R.id.edtMSSV);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtBirthday = (EditText) findViewById(R.id.edtBirthday);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSave = (Button) findViewById(R.id.btnSave);
        db = new DatabaseHandler(this);
    }

    public void Back() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void SaveData() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(Integer.valueOf(edtMSSV.getText().toString()),
                        edtName.getText().toString(),
                        edtEmail.getText().toString(), edtBirthday.getText().toString());
                db.addStudent(student);
            }
        });
    }
}
