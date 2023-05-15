package edu.itstep.a08recyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private RecyclerView rvNumbers;
    public NumberAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNumbers = findViewById(R.id.rvNumbers);
        ArrayList<Contact> updatedData  = (ArrayList<Contact>)getIntent().getSerializableExtra("contact-list");
        if(updatedData == null)
            adapter = new NumberAdapter(this, R.layout.list_item, ContactList.returnList());
        else {
            adapter = new NumberAdapter(this, R.layout.list_item, updatedData);
        }
        rvNumbers.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        );
        rvNumbers.setLayoutManager(layoutManager);

    }
}