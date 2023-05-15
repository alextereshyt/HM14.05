package edu.itstep.a08recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditContactActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etLastName;
    private EditText etPhone;
    private Button btnSave;

    private List<Contact> contacts;

    private  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnSave);


        contacts =  (ArrayList<Contact>)getIntent().getSerializableExtra("contact-list");
        position = getIntent().getIntExtra("position",-1);


        etName.setText(contacts.get(position).getName());
        etLastName.setText(contacts.get(position).getLastName());
        etPhone.setText(contacts.get(position).getPhone());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contacts.get(position).setName(etName.getText().toString());
                contacts.get(position).setLastName(etLastName.getText().toString());
                contacts.get(position).setPhone(etPhone.getText().toString());


                Toast.makeText(EditContactActivity.this, "Changes saved", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditContactActivity.this, MainActivity.class);
                intent.putExtra("contact-list", (Serializable) contacts);
                intent.putExtra("position", position);
                startActivity(intent);
                finish();
            }
        });
    }
}
