package com.example.galgeleg.version_01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.model.ResultItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder>{
    private ArrayList<ResultItem> mResultList;

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView0;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;


        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTextView0 = itemView.findViewById(R.id.textView0);
            this.mTextView1 = itemView.findViewById(R.id.textView1);
            this.mTextView2 = itemView.findViewById(R.id.textView2);
            this.mTextView3 = itemView.findViewById(R.id.textView3);
            this.mTextView4 = itemView.findViewById(R.id.textView4);
        }
    }

    public ResultAdapter(ArrayList<ResultItem> mResultList) {
        this.mResultList = mResultList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_result, parent, false);
        ResultViewHolder resultViewHolder = new ResultViewHolder(view);
        return resultViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultItem currentResultItem = mResultList.get((mResultList.size() - 1) - position);

        holder.mTextView0.setText(currentResultItem.getDate().toString().trim());
        holder.mTextView1.setText(currentResultItem.getResultMessage());
        holder.mTextView2.setText(currentResultItem.getCorrectLetters());
        holder.mTextView3.setText(currentResultItem.getWrongLetters());
        holder.mTextView4.setText(currentResultItem.getPlayerName());
    }


    @Override
    public int getItemCount() {
        return mResultList.size();
    }
}
