package com.spanishenglishtravelhandbook;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static com.spanishenglishtravelhandbook.R.id.toolbar;

public class CategoryPhrasesActivity extends AppCompatActivity {

    ArrayList<TravelPhraseData> travelList;
    ListView phrasesListView;
    ArrayAdapter<String> phraseListViewAdapter;
    Toolbar toolbar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_phrases);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        travelList = getIntent().getParcelableArrayListExtra("phrases");

        setupPhrasesListView();

        Toast toast = Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_SHORT);
        toast.setMargin(50, 50);
        toast.show();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void setupPhrasesListView() {
        final Context context = this;
        phrasesListView = (ListView) findViewById(R.id.phrasesListView);
        populatePhrasesListView(travelList);
        phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });
    }

    public void populatePhrasesListView(ArrayList travelPhrasesList) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < travelPhrasesList.size(); ++i) {
            TravelPhraseData tempTravelPhraseData = new TravelPhraseData();
            tempTravelPhraseData = (TravelPhraseData) travelPhrasesList.get(i);
            list.add(tempTravelPhraseData.getTravelPhrase());
        }
        phraseListViewAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        phrasesListView.setAdapter(phraseListViewAdapter);

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("CategoryPhrases Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
