package com.example.crudfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DatainRecyclerView extends AppCompatActivity {

    RecyclerView rcy;
    MyAdapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datain_recycler_view);
        rcy = (RecyclerView) findViewById(R.id.recycle);

        rcy.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference().child("Student");
        FirebaseRecyclerOptions<DbHelper> options =
                new FirebaseRecyclerOptions.Builder<DbHelper>()
                        .setQuery(query, DbHelper.class)
                        .build();
        Log.d("userdata",String.valueOf(options));
        adpt = new MyAdapter(options);
        rcy.setAdapter(adpt);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adpt.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adpt.stopListening();
    }
}