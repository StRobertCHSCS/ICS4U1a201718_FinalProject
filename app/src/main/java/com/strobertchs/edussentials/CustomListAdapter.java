package com.strobertchs.edussentials;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Travis on 2017-12-21.
 */

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the list of countries
    private final String[] periodArray;

    public CustomListAdapter(Activity context, String[] periodArrayParam){

        super(context,R.layout.listview_row , periodArrayParam);
        this.context=context;
        this.periodArray = periodArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView periodTextField = (TextView) rowView.findViewById(R.id.PeriodTextViewID);

        //this code sets the values of the objects to values from the arrays
        periodTextField.setText(periodArray[position]);

        return rowView;

    };

}
