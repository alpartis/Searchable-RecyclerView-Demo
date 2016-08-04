package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;

import com.github.wrdlbrnft.searchablerecyclerviewdemo.R;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models.ExampleModel;
import com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.fragments.MainFragment;



public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private final String    LOGTAG = ExampleViewHolder.class.getSimpleName();
    private final View      _myView;
    private final TextView  _textView;
    private final Space     _spaceView;

    public ExampleViewHolder(View itemView) {
        super(itemView);
        _myView = itemView;
        _textView = (TextView) itemView.findViewById(R.id.tvText);
        _textView.setOnClickListener(this);
        _spaceView = (Space) itemView.findViewById(R.id.space);
    }

    public void bind(ExampleModel model) {
        _textView.setText(model.getText());
    }

    @Override
    public void onClick(View v)
    {
        Log.d(LOGTAG, "onClick(): user touched me at position: " + Integer.toString(getAdapterPosition()));
        if (v.getId() == R.id.tvText) {
            _spaceView.setVisibility(View.VISIBLE);
            ((MainFragment)_myView.getTag()).scrollTo(getAdapterPosition());
        }
    }
}
