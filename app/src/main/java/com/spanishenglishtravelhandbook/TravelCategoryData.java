package com.spanishenglishtravelhandbook;

/**
 * Created by Danny on 08/05/2016.
 */
public class TravelCategoryData {

    //private variables
    int _id;
    String category;

    // constructor.  empty data.
    public TravelCategoryData(){
        this._id = -1;
        this.category = null;
    }

    // constructor
    public TravelCategoryData(int id, String category){
        this._id = id;
        this.category = category;
    }

    public void setID(Integer id)
    {
        _id = id;
    }

    public void setCategory(String _category)
    {
        this.category = _category;
    }
}
