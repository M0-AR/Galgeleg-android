package com.example.galgeleg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder>{
    private ArrayList<ResultItem> mResultList;

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;


        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTextView1 = itemView.findViewById(R.id.textView1);
            this.mTextView2 = itemView.findViewById(R.id.textView2);
            this.mTextView3 = itemView.findViewById(R.id.textView3);
        }
    }

    public ResultAdapter(ArrayList<ResultItem> mResultList) {
        this.mResultList = mResultList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        ResultViewHolder resultViewHolder = new ResultViewHolder(view);
        return resultViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultItem currentResultItem = mResultList.get(position);

        holder.mTextView1.setText(currentResultItem.getResultMessage());
        holder.mTextView2.setText(currentResultItem.getCorrectLetters());
        holder.mTextView3.setText(currentResultItem.getWrongLetters());
    }


    @Override
    public int getItemCount() {
        return mResultList.size();
    }
}
