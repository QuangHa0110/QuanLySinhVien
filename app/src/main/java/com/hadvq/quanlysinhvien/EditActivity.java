package com.hadvq.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_edit);
        Init();
        FillData();
        Back();
        UpdateData();
    }
    public void Init(){
        textViewMSSV = (TextView) findViewById(R.id.txtViewMSSV);
        textViewName = (TextView) findViewById(R.id.txtViewName);
        textViewEmail = (TextView) findViewById(R.id.txtViewEmail);

        edtMSSV = (EditText) findViewById(R.id.edtMSSV);
        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtBirthday = (EditText) findViewById(R.id.edtBirthday);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSave = (Button) findViewById(R.id.btnSave);
        db = new DatabaseHandler(this);
    }
    public void FillData(){
        Intent intent = getIntent();
        long studentId = intent.getLongExtra("STUDENT_ID", 0);
        Student student = db.getStudent(studentId);
        edtMSSV.setText(String.valueOf(student.getMSSV()).toString());
        edtName.setText(student.getName().toString());
        edtEmail.setText(student.getEmail().toString());
        edtBirthday.setText(student.getBirthday().toString());
    }
    public void Back(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void UpdateData(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student( Integer.valueOf(edtMSSV.getText().toString()),
                        edtName.getText().toString(),
                        edtEmail.getText().toString(), edtBirthday.getText().toString());
                db.updateStudent(student);
            }
        });
    }
}
