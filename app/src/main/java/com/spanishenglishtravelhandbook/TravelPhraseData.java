package com.spanishenglishtravelhandbook;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/**
 * Created by Danny on 08/05/2016.
 */
public class TravelPhraseData {

    //private variables
    int _id;
    String category;
    String homePhrase;
    String travelPhrase;

    // constructor.  empty data.
    public TravelPhraseData(){
        this._id = -1;
        this.category = null;
        this.homePhrase = null;
        this.travelPhrase = null;
    }

    // constructor
    public TravelPhraseData(int id, String category, String homePhrase, String travelPhrase){
        this._id = id;
        this.homePhrase = homePhrase;
        this.category = category;
        this.travelPhrase = travelPhrase;
    }


    public void setID(Integer id)
    {
        _id = id;
    }

    public void setCategory(String _category)
    {
        this.category = _category;
    }

    public void setHomePhrase(String _homePhrase)
    {
        this.homePhrase = _homePhrase;
    }

    public void setTravelPhrase(String _travelPhrase)
    {
        this.travelPhrase = _travelPhrase;
    }

}
