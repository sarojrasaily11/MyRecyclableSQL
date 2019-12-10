package com.example.a6656.myrecyclablesql.recyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a6656.myrecyclablesql.R;
import com.example.a6656.myrecyclablesql.entity.Monster;

import java.util.List;

public class MonsterRecyclerViewAdapter extends RecyclerView.Adapter<MonsterViewHolder>{
    List<Monster> monsters;
    Context context;

    public MonsterRecyclerViewAdapter(List<Monster> monsters, Context context) {
        this.monsters = monsters;
        this.context = context;
    }


    /*
create a view holder whenever the recyclerview needs a new one. this is the moment when the row is inflated,passed to the viewholder object and each child view can be found and stored.
*/

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       //inflate the custom layout (recycler_item_view.xml

        LayoutInflater inflater = LayoutInflater.from(context);
        View monsterView = inflater.inflate(R.layout.recycler_item_view, viewGroup, false);

        // return a new holder instance

        MonsterViewHolder monsterViewHolder = new MonsterViewHolder(monsterView);

        return monsterViewHolder;
    }
/*
takes a viewholder and sets the proper list data (from the list) on the view
 */
    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder monsterViewHolder, int i) {
// get the data frm the list at the position

        Monster monster = monsters.get(i);
        monsterViewHolder.updateMonster(monster);
    }

    @Override
    public int getItemCount() {
        return monsters.size();
    }
}
