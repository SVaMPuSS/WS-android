package com.example.mytelegram.Contact;

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

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private LayoutInflater inflater;
    private List<Contact> contacts;


    public ContactsAdapter(Context context, List<Contact> contacts) {
        inflater = LayoutInflater.from(context);
        this.contacts = contacts;
    }


    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        Contact c = contacts.get(position);
        holder.ContactName.setText(c.getName());
        holder.Icon.setImageDrawable(Drawable.createFromPath(c.getImage()));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        private ImageView Icon;
        private TextView ContactName;

        ContactsViewHolder(View view) {
            super(view);
            Icon = view.findViewById(R.id.ivContactIcon);
            ContactName = view.findViewById(R.id.tvContactName);
        }
    }

}
