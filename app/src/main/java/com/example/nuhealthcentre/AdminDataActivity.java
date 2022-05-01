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

public class AdminDataActivity extends AppCompatActivity {

    EditText docid, mobile, first, last, email, specialization;
    Button insert, update, delete, view, special;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_data);

        docid = findViewById(R.id.doc);
        mobile = findViewById(R.id.password);
        first = findViewById(R.id.fname);
        last = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        specialization = findViewById(R.id.category);
        special = findViewById(R.id.specs);

        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);
        DB = new DBHelper(this);

        special.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAdmin();
            }
        });



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String docidTXT = docid.getText().toString();
                String mobileTXT = mobile.getText().toString();
                String firstTXT = first.getText().toString();
                String lastTXT = last.getText().toString();
                String emailTXT = email.getText().toString();
                String specializationTXT = specialization.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(docidTXT, mobileTXT, firstTXT, lastTXT, emailTXT, specializationTXT);
                if(checkinsertdata==true)
                    Toast.makeText(AdminDataActivity.this,"New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDataActivity.this,"New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String docidTXT = docid.getText().toString();
                String mobileTXT = mobile.getText().toString();
                String firstTXT = first.getText().toString();
                String lastTXT = last.getText().toString();
                String emailTXT = email.getText().toString();
                String specializationTXT = specialization.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(docidTXT, mobileTXT, firstTXT, lastTXT, emailTXT, specializationTXT);
                if(checkupdatedata==true)
                    Toast.makeText(AdminDataActivity.this,"New Entry updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDataActivity.this,"New Entry Not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String docidTXT = docid.getText().toString();

                Boolean checkdeletedata = DB.deletedata(docidTXT);
                if(checkdeletedata==true)
                    Toast.makeText(AdminDataActivity.this,"New Entry deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminDataActivity.this,"New Entry Not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(AdminDataActivity.this,"No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer() ;
                while (res.moveToNext()){
                    buffer.append("Doc_id :"+res.getString(0)+"\n");
                    buffer.append("Mobile_no. :"+res.getString(1)+"\n");
                    buffer.append("first_name :"+res.getString(2)+"\n\n");
                    buffer.append("last_name :"+res.getString(3)+"\n\n");
                    buffer.append("email. :"+res.getString(4)+"\n\n");
                    buffer.append("specialization :"+res.getString(5)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AdminDataActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

    }
    public void openActivityAdmin(){
        Intent intent = new Intent(this, categoryActivity.class);
        startActivity(intent);
    }

}