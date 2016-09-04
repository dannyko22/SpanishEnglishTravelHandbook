package com.spanishenglishtravelhandbook;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class NotepadActivity extends AppCompatActivity {

    NotepadData notepadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notepad);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notepad");

        Bundle data = getIntent().getExtras();
        notepadData = data.getParcelable("notes");

        setupNotepad();

//        Toast toast = Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_SHORT);
//        toast.setMargin(50, 50);
//        toast.show();

    }

    public void setupNotepad()
    {
        EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
        LinedEditText bodyEditText = (LinedEditText)findViewById(R.id.bodyEditText);

        titleEditText.setText(notepadData.getTitle());
        bodyEditText.setText(notepadData.getBody());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
