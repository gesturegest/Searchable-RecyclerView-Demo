package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.Person;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder.PersonViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final LayoutInflater mInflater;
    private final List<Person> mPersons;

    public PersonsAdapter(Context context, List<Person> models) {
        mInflater = LayoutInflater.from(context);
        mPersons = new ArrayList<>(models);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.item_example, parent, false);
        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        final Person person = mPersons.get(position);
        holder.bind(person);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public void animateTo(List<Person> persons) {
        applyAndAnimateRemovals(persons);
        applyAndAnimateAdditions(persons);
        applyAndAnimateMovedItems(persons);
    }

    private void applyAndAnimateRemovals(List<Person> newPersons) {
        for (int i = mPersons.size() - 1; i >= 0; i--) {
            final Person person = mPersons.get(i);
            if (!newPersons.contains(person)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<Person> newPersons) {
        for (int i = 0, count = newPersons.size(); i < count; i++) {
            final Person model = newPersons.get(i);
            if (!mPersons.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<Person> newPersons) {
        for (int toPosition = newPersons.size() - 1; toPosition >= 0; toPosition--) {
            final Person model = newPersons.get(toPosition);
            final int fromPosition = mPersons.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public Person removeItem(int position) {
        final Person person = mPersons.remove(position);
        notifyItemRemoved(position);
        return person;
    }

    public void addItem(int position, Person person) {
        mPersons.add(position, person);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final Person person = mPersons.remove(fromPosition);
        mPersons.add(toPosition, person);
        notifyItemMoved(fromPosition, toPosition);
    }

}
