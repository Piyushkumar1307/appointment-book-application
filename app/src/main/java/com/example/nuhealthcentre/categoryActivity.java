package com.example.nuhealthcentre;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class categoryActivity extends AppCompatActivity {

    EditText catid, cate;
    Button insert, update, delete, view;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        catid = findViewById(R.id.catid);
        cate = findViewById(R.id.cate);


        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);
        DB = new DBHelper1(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catidTXT = catid.getText().toString();
                String cateTXT = cate.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(catidTXT, cateTXT);
                if (checkinsertdata == true)
                    Toast.makeText(categoryActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(categoryActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catidTXT = catid.getText().toString();
                String cateTXT = cate.getText().toString();


                Boolean checkupdatedata = DB.updateuserdata(catidTXT, cateTXT);
                if (checkupdatedata == true)
                    Toast.makeText(categoryActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(categoryActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String catidTXT = catid.getText().toString();

                Boolean checkdeletedata = DB.deletedata(catidTXT);
                if (checkdeletedata == true)
                    Toast.makeText(categoryActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(categoryActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    Toast.makeText(categoryActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Catid :" + res.getString(0) + "\n");
                    buffer.append("Cat :" + res.getString(1) + "\n");

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(categoryActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }

}