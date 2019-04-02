package com.gambler.mutstatelist;

import android.support.annotation.NonNull;

import android.view.View;
import android.widget.TextView;

class ModelViewHolder extends GenericVH {
    private TextView mTextView;
    public View bg,fg;
    public ModelViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView =  itemView.findViewById(R.id.item);
        bg = itemView.findViewById(R.id.bg);
        fg = itemView.findViewById(R.id.fg);
    }

    @Override
    public void pos(Object ds) {
        super.pos(ds);
        Model model  = (Model) ds;
        mTextView.setText(model.getModel());
    }
}
