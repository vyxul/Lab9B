package com.example.steven.makeacall;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    
    TextView result;
    EditText FirstName, LastName;
    String phone_number;

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PHONE_NUMBER = "PhoneNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        result = findViewById(R.id.Result);
        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);


    }
    
    public void FindButton (View view){
        String FName = FirstName.getText().toString();
        String LName = LastName.getText().toString();

        String AUTHORITY = "com.example.st1013838.phonebook.MyContentProvider";
        String TABLE_ITEM = "Contacts";
        String projection[] = {FIRST_NAME, LAST_NAME, PHONE_NUMBER};
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_ITEM);
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(CONTENT_URI, projection, "FirstName = ? AND LastName = ?", new String[]{FName, LName}, null);


        if (!cursor.moveToFirst())
            result.setText(FName + " " + LName + " not found.");

        else {
            result.setText(cursor.getString(2));
            phone_number = cursor.getString(2);
        }
    }
    
    public void CallButton (View view){

        try{
            Uri uri = Uri.parse("tel: " + phone_number);
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            Log.i("Phone Call App", phone_number);
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Application failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
