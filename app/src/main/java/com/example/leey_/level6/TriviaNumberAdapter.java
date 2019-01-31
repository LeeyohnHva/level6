package com.example.leey_.level6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TriviaNumberAdapter extends RecyclerView.Adapter<TriviaNumberAdapter.ViewHolder> {
    private List<TriviaNumber> values;

    public TriviaNumberAdapter(List<TriviaNumber> triviaDataset) {
        values = triviaDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.left_image_row, parent, false);
        } else {
            view = inflater.inflate(R.layout.right_image_row, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int number = values.get(position).getNumber();
        String text = values.get(position).getText();
        holder.number.setText(String.valueOf(number));
        holder.description.setText(text);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView number;
        public TextView description;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            number = view.findViewById(R.id.number);
            description = view.findViewById(R.id.text);


        }
    }
}
