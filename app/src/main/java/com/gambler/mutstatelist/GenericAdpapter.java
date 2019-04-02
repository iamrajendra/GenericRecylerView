package com.gambler.mutstatelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class GenericAdpapter<T,TV extends GenericVH>  extends RecyclerView.Adapter<TV > {
    private  int layout;
    private List<T> mStringList;


    public GenericAdpapter(List<T> strings) {
        mStringList = strings;
    }



    @Override
    public void onBindViewHolder(@NonNull TV genericViewHoler, int i) {

        T ds=  mStringList.get(i);
      genericViewHoler.pos(ds);

    }

    @Override
    public int getItemViewType(int position) {
        return  this.layout;
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }
}
