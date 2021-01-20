package com.example.recycleviewk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.res.Resources;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int[] Images = {R.drawable.abricos, R.drawable.apelsin, R.drawable.granat, R.drawable.grusha, R.drawable.ingir,
            R.drawable.kiwi, R.drawable.marakuya, R.drawable.papaya, R.drawable.sliva, R.drawable.apple};

    String[] listItems;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = getResources().getStringArray(R.array.name_fruits);
        Intent intent = new Intent(this, MainActivity.class);

        ListAdapter adapter = new ListAdapter();
        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                setContentView(R.layout.pictures);
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageResource(Images[position]);
                startActivity(intent);
            }

        });

        RecyclerView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_item_divider, null));
        list.addItemDecoration(dividerItemDecoration);
        adapter.setItems(listItems);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) return;
    }
}
