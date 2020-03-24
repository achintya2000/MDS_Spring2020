package com.example.mds_spring2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.main_toolbar);
        //setActionBar(toolbar);

//        Button addBtn = findViewById(R.id.addBtn);
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText editText1 = findViewById(R.id.editText1);
//                EditText editText2 = findViewById(R.id.editText2);
//                TextView result = findViewById(R.id.textView);
//
//                int num1 = Integer.parseInt(editText1.getText().toString());
//                int num2 = Integer.parseInt(editText2.getText().toString());
//
//                result.setText(num1 + num2 + "");
//            }
//        });

//        Button secondActivityBtn = findViewById(R.id.nextActivityBtn);
//        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
//                startActivity(startIntent);
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings_dest) {
            Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
