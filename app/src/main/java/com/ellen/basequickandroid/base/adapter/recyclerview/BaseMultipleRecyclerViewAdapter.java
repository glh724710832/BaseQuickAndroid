package com.ellen.basequickandroid.base.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

public abstract class BaseMultipleRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private WeakReference<Context> contextWeakReference;

    public BaseMultipleRecyclerViewAdapter(Context context){
        contextWeakReference = new WeakReference<>(context);
    }

    public Context getContext(){
        return contextWeakReference.get();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        return getNewBaseViewHolder(viewGroup,itemType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        showData(baseViewHolder,position);
    }

    @Override
    public int getItemCount() {
        return getItemSize();
    }

    @Override
    public int getItemViewType(int position) {
        return getMultipleItemViewType(position);
    }

    protected abstract int getMultipleItemViewType(int position);
    protected abstract int getItemSize();
    protected abstract BaseViewHolder getNewBaseViewHolder(@NonNull ViewGroup viewGroup, int itemType);
    protected abstract void showData(BaseViewHolder baseViewHolder, int position);
}