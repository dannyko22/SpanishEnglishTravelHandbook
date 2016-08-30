package com.spanishenglishtravelhandbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Danny on 29/08/2016.
 */

public class notepadRecyclerAdapter extends RecyclerView.Adapter<notepadRecyclerAdapter.ViewHolder> {
    private List<NotepadData> mNotes;
    private Context mContext;


    public notepadRecyclerAdapter(List<NotepadData> notes, Context context){
        mNotes = notes;
        mContext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notepadrecycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.noteTitle.setText(mNotes.get(position).getTitle());
        holder.noteBody.setText(mNotes.get(position).getBody());
        holder.noteDate.setText(mNotes.get(position).getModifiedDate());

    }



    @Override
    public int getItemCount() {
        return mNotes.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView noteTitle, noteBody, noteDate;



        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle = (TextView)itemView.findViewById(R.id.note_titleTextView);
            noteBody = (TextView)itemView.findViewById(R.id.note_bodyTextView);
            noteDate = (TextView) itemView.findViewById(R.id.note_dateTextView);
        }

    }

}
