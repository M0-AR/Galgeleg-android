package com.example.galgeleg.version_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.item.ResultItem;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {
    private String[] mWordList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTextView = itemView.findViewById(R.id.word_in_list);
        }
        public TextView getTextView() {
            return mTextView;
        }
    }

    public WordListAdapter(String[] mWordList, Context context) {
        this.mWordList = mWordList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_in_list, parent, false);
        ViewHolder resultViewHolder = new ViewHolder(view);
        return resultViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(mWordList[position]);

    }


    @Override
    public int getItemCount() {
        return mWordList.length;
    }
}
