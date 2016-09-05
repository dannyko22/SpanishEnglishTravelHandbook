package com.spanishenglishtravelhandbook;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.IOException;
import java.util.ArrayList;

public class activity_notepadrecycler extends AppCompatActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    NotepadDatabaseHelper notepadDBHelper;
    ArrayList<NotepadData> notepadDataList;
    notepadRecyclerAdapter mAdapter;
    final Integer resultCode = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_notepadrecycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Notepad");

        setupRecyclerList();
    }

    public void setupRecyclerList()
    {
        mRecyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final Context context = this;

        final GestureDetector mGestureDetector =
                new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }
                });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {


            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {


                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    int position = recyclerView.getChildLayoutPosition(child);
                    NotepadData selectedNoteItem = notepadDataList.get(position);
                    Intent intent = new Intent(context, NotepadActivity.class);

                    intent.putExtra("notes", selectedNoteItem);
                    startActivityForResult(intent, resultCode );


                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        setupDatabaseHelper();
        notepadDataList = new ArrayList<NotepadData>();
        notepadDataList = notepadDBHelper.getAllNotepadData();
        setupNotepadList();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);
        NotepadData _notepadData = (NotepadData) data.getParcelableExtra("notepaddata");
        notepadDataList.get(_notepadData.getID()-1).setTitle(_notepadData.getTitle());
        notepadDataList.get(_notepadData.getID()-1).setBody(_notepadData.getBody());
        notepadDataList.get(_notepadData.getID()-1).setModifiedDate(_notepadData.getUnModifiedDate());

        mAdapter.notifyDataSetChanged();
        notepadDBHelper.updateNotepadData(_notepadData.getID(), _notepadData.getTitle(), _notepadData.getBody(), _notepadData.getModifiedDate());

    }

    public void setupNotepadList()
    {
        mAdapter = new notepadRecyclerAdapter(notepadDataList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setupDatabaseHelper()
    {
        notepadDBHelper = new NotepadDatabaseHelper(this);

        try {
            notepadDBHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            notepadDBHelper.openDataBase();
        }catch(SQLException sqle){
            throw sqle;
        }

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
