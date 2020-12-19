package com.naserkarimi.recyclerviewanimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final int animationType;
    private ArrayList<String> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    public RecyclerViewAdapter(ArrayList dataSet, int animationType) {
        localDataSet = dataSet;
        this.animationType = animationType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        switch (animationType) {
            case 1:
                setFadeIn(viewHolder.itemView, position);
                break;
            case 2:
                setFadeOut(viewHolder.itemView, position);
                break;
            case 3:
                setScale(viewHolder.itemView, position);
                break;
            case 4:
                setRotateRight(viewHolder.itemView, position);
                break;
            case 5:
                setRotateLeft(viewHolder.itemView, position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    //-----------------------------------------------------------------------------

    private final static int FADE_CYCLE = 8;
    private final static int FADE_DURATION = 200;
    private final static float MIN_ALPHA = 0.1f;

    private void setFadeIn(View view, int position) {
        float percentFloat;
        int div, mod = 0;
        mod = position % FADE_CYCLE;
        div = position / FADE_CYCLE;
        float percent = (100 * mod) / FADE_CYCLE;
        if (div % 2 == 0)
            percentFloat = percent / 100;
        else
            percentFloat = 1 - (percent / 100);
        view.setAlpha(percentFloat + MIN_ALPHA);
        AlphaAnimation anim = new AlphaAnimation(0.0f, percentFloat + MIN_ALPHA);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    private void setFadeOut(View view, int position) {
        float percentFloat;
        int div, mod = 0;
        mod = position % FADE_CYCLE;
        div = position / FADE_CYCLE;
        float percent = (100 * mod) / FADE_CYCLE;
        if (div % 2 == 1)
            percentFloat = percent / 100;
        else
            percentFloat = 1 - (percent / 100);
        view.setAlpha(percentFloat + MIN_ALPHA);
        AlphaAnimation anim = new AlphaAnimation(0.0f, percentFloat + MIN_ALPHA);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    //-----------------------------------------------------------------------------

    private final static int SCALE_DURATION = 1000;
    private final static int SCALE_CYCLE = 8;
    private final static float MIN_SCALE = 0.2f;
    private final static float MIN_SIZE = 0.1f;

    private void setScale(View view, int position) {
        float percentFloat;
        int div, mod = 0;
        mod = position % SCALE_CYCLE;
        div = position / SCALE_CYCLE;
        float percent = (100 * mod) / SCALE_CYCLE;
        if (div % 2 == 0)
            percentFloat = percent / 100;
        else
            percentFloat = 1 - (percent / 100);
        view.setScaleY(percentFloat + MIN_SIZE / MIN_SCALE);
        view.setScaleX(percentFloat + MIN_SIZE / MIN_SCALE);
        ScaleAnimation anim = new ScaleAnimation(
                percentFloat + MIN_SIZE / MIN_SCALE, 1f,
                percentFloat + MIN_SIZE / MIN_SCALE, 1f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f);
        anim.setDuration(SCALE_DURATION);
        view.startAnimation(anim);
    }

    //-----------------------------------------------------------------------------

    private final static int ROTATE_DURATION = 1000;
    private final static int ROTATE_CYCLE = 8;
    private final static int DIV_ROTATE = 3;

    private void setRotateRight(View view, int position) {
        float percentFloat;
        int div, mod = 0;
        mod = position % ROTATE_CYCLE;
        div = position / ROTATE_CYCLE;
        float percent = (100 * mod) / ROTATE_CYCLE;
        if (div % 2 == 0)
            percentFloat = percent;
        else
            percentFloat = 100 - percent;
        view.setRotation(percentFloat / DIV_ROTATE);
        RotateAnimation anim = new RotateAnimation(percentFloat / DIV_ROTATE, 0);
        anim.setDuration(ROTATE_DURATION);
        view.startAnimation(anim);
    }

    private void setRotateLeft(View view, int position) {
        float percentFloat;
        int div, mod = 0;
        mod = position % ROTATE_CYCLE;
        div = position / ROTATE_CYCLE;
        float percent = (100 * mod) / ROTATE_CYCLE;
        if (div % 2 == 0)
            percentFloat = -percent;
        else
            percentFloat = -100 + percent;
        view.setRotation(percentFloat / DIV_ROTATE);
        RotateAnimation anim = new RotateAnimation(percentFloat / DIV_ROTATE, 0);
        anim.setDuration(ROTATE_DURATION);
        view.startAnimation(anim);
    }
}
