package com.gambler.mutstatelist;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Model> models =  new ArrayList<>();
        models.add(new Model("Rajendra"));
        models.add(new Model("Jitendra"));
        models.add(new Model("Dharmendra"));
        GenericAdpapter<Model, ModelViewHolder> stringGenericViewHolerGenericAdpapter
                =  new GenericAdpapter(models) {
            @NonNull
            @Override
            public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null);
                return new ModelViewHolder (view);
            }
        };
        RecyclerView recyclerView = ((RecyclerView)findViewById(R.id.items));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(stringGenericViewHolerGenericAdpapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


        // making http call and fetching menu json


        ItemTouchHelper.SimpleCallback itemTouchHelperCallback1 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Row is swiped from recycler view
                // remove it from adapter
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        // attaching the touch helper to recycler view
        new ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }

    @Override
    public void onHalfSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }

    @Override
    public void onFullSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }
}
