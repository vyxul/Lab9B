package com.example.steven.makeacall;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    
    TextView result;
    EditText FName, LName;

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PHONE_NUMBER = "PhoneNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        result = findViewById(R.id.Result);
        FName = findViewById(R.id.FirstName);
        LName = findViewById(R.id.LastName);

        String AUTHORITY = "com.example.st1013838.phonebook.MyContentProvider";
        String TABLE_ITEM = "Contacts";
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_ITEM);
        ContentResolver contentResolver = getContentResolver();
        String projection[] = {FIRST_NAME, LAST_NAME, PHONE_NUMBER};
        Cursor cursor = contentResolver.query(CONTENT_URI, projection, null, null, null);

    }
    
    public void FindButton (View view){
        Toast.makeText(this, "Find Button is not implemented yet.", Toast.LENGTH_SHORT).show();
    }
    
    public void CallButton (View view){
        Toast.makeText(this, "Call Button is not implemented yet.", Toast.LENGTH_SHORT).show();
    }
}
