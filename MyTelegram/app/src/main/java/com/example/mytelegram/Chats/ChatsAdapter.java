package com.example.mytelegram.Chats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytelegram.R;

import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder> {

    private LayoutInflater inflater;
    private List<Chat> chats;

    public ChatsAdapter(Context context, List<Chat> list) {
        chats = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ChatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //если за место parent передать null то, шаблон R.layout.item_chat не будет нормально изображён
        //по всей видимости из-за того что не может получить ширину родительского view
        View view = inflater.inflate(R.layout.item_chat, parent, false);
        return new ChatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatsAdapter.ChatsViewHolder holder, int position) {
        Chat c = chats.get(position);
        switch (c.getStatus()) {
            case Chat.DELIVERED:
                holder.status.setImageResource(R.drawable.icon_delivered);
                break;
            case Chat.DELIVERED_AND_READ:
                holder.status.setImageResource(R.drawable.icon_delivered_and_read);
                break;
        }
        holder.chatIcon.setImageResource(R.drawable.meme);
        holder.chatName.setText(c.getName());
        // UTC +3
        String buf = "";
        if (c.getMessageTime().toZonedDateTime().getMinute() < 10)
            buf += "0";
        holder.messageTime.setText(c.getMessageTime().toZonedDateTime().plusHours(3).getHour() + ":" + buf + +c.getMessageTime().toZonedDateTime().getMinute());
        if (c.getLastSender().equals("")) {
            holder.sender.setVisibility(View.GONE);
        } else {
            holder.sender.setText(c.getLastSender());
        }
        holder.lastMessage.setText(c.getLastMessage());
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public static class ChatsViewHolder extends RecyclerView.ViewHolder {

        private ImageView chatIcon;
        private TextView chatName;
        private TextView sender;
        private TextView lastMessage;
        private TextView messageTime;
        private ImageView status;

        public ChatsViewHolder(View itemView) {
            super(itemView);
            chatIcon = itemView.findViewById(R.id.ivUserIcon);
            chatName = itemView.findViewById(R.id.tvChatName);
            sender = itemView.findViewById(R.id.tvSender);
            lastMessage = itemView.findViewById(R.id.tvMessage);
            messageTime = itemView.findViewById(R.id.tvMessageTime);
            status = itemView.findViewById(R.id.ivStatus);
        }
    }
}
