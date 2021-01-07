package com.example.galgeleg.version_01.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.activity.GameActivity;

import static com.example.galgeleg.version_01.utilities.Constants.WORD;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {
    private static final String TAG = "WordListAdapter";
    private String[] mWordList;
    private Context context;
    private GetWord getWord;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTextView = itemView.findViewById(R.id.word_in_list);
            this.mCardView = itemView.findViewById(R.id.parent);
        }
        public TextView getTextView() {
            return mTextView;
        }
    }

    public WordListAdapter(String[] mWordList, Context context, GetWord getWord) {
        this.mWordList = mWordList;
        this.context = context;
        this.getWord = getWord;
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
        Log.d(TAG, "onBindViewHolder: called");
        holder.getTextView().setText(mWordList[position]);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWord.onGettingWord(mWordList[position]);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mWordList.length;
    }

    public interface GetWord {
        void onGettingWord(String word);
    }

}
