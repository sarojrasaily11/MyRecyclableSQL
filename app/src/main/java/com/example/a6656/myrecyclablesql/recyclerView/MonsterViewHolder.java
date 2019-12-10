package com.example.a6656.myrecyclablesql.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a6656.myrecyclablesql.R;
import com.example.a6656.myrecyclablesql.entity.Monster;

//we create this view hlder representing the recycler_item_view.xml
//with this lass we can manipulate the view
public class MonsterViewHolder extends RecyclerView.ViewHolder {

    public final ImageView monsterImageView;
    public final TextView monsterName;
    public final TextView monsterDescription;



    public MonsterViewHolder(View itemView) {
            super(itemView);

            monsterImageView = itemView.findViewById(R.id.monsterImageView);
            monsterName = itemView.findViewById(R.id.monsterName);
            monsterDescription = itemView.findViewById(R.id.monsterDescription);
        }

        public void updateMonster (Monster monster){
            monsterImageView.setImageResource(R.drawable.ic_monster_1);
            monsterName.setText(monster.getName());
            monsterDescription.setText(monster.getDescription());
        }

}
