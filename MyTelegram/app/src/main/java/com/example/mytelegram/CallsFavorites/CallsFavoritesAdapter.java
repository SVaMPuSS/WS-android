package com.example.mytelegram.CallsFavorites;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mytelegram.R;

import java.util.List;

public class CallsFavoritesAdapter extends RecyclerView.Adapter<CallsFavoritesAdapter.CallsFavoritesViewHolder> {

    private final LayoutInflater inflater;
    private final List<CallFavorite> calls;

    public CallsFavoritesAdapter(Context context, List<CallFavorite> list) {
        inflater = LayoutInflater.from(context);
        this.calls = list;
    }

    @Override
    public CallsFavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_favorites,parent, false);
        return new CallsFavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CallsFavoritesAdapter.CallsFavoritesViewHolder holder, int position) {
        CallFavorite cf = calls.get(position);
        holder.timeCall.setText(cf.getTimeCall().toZonedDateTime().plusHours(3).getHour()+":"+ cf.getTimeCall().toZonedDateTime().getMinute());
        holder.icon.setImageDrawable(Drawable.createFromPath(cf.getImageLink()));
        holder.name.setText(cf.getName());
        holder.lastActivity.setText("Period: "+ cf.getCallDuration() + " min");
        switch (cf.getTypeResponse()) {
            case CallFavorite.ACCEPT_CALL:
                holder.typeCall.setImageResource(R.drawable.icon_accepted_call);
                break;
            case CallFavorite.CANCEL_CALL:
                holder.typeCall.setImageResource(R.drawable.icon_cancel_call);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return calls.size();
    }

    public static class CallsFavoritesViewHolder extends RecyclerView.ViewHolder {
         ImageView typeCall;
         ImageView icon;
         TextView name;
         TextView lastActivity;
         TextView timeCall;

        CallsFavoritesViewHolder(View view) {
            super(view);
            typeCall = view.findViewById(R.id.ivTypeCall);
            icon = view.findViewById(R.id.ivUserIcon);
            name = view.findViewById(R.id.tvContactName);
            lastActivity = view.findViewById(R.id.tvPeriodCall);
            timeCall = view.findViewById(R.id.tvLastActivity);
        }
    }
}
