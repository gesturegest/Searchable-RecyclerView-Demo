package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.Person;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView txt_rank;
    private TextView txt_name;

    public PersonViewHolder(View itemView) {
        super(itemView);
        txt_rank = (TextView) itemView.findViewById(R.id.txt_rank);
        txt_name = (TextView) itemView.findViewById(R.id.txt_name);
    }

    public void bind(Person person) {
        txt_rank.setText(person.getRank());
        txt_name.setText(person.getName());
    }

}
