package com.example.guest.contactapp.presentation.contactlist.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.contactapp.R;
import com.example.guest.contactapp.data.dto.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 04.02.2018.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private List<Contact> contacts;
    private AdapterClickListener listener;

    public ContactListAdapter(AdapterClickListener listener) {
        this.contacts = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, phone, desc;

        public ContactViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            desc = itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(view -> {
                if(listener!=null){
                    listener.onRowClick(getAdapterPosition(),contacts.get(getAdapterPosition()));
                }
            });
        }
    }

    private interface AdapterClickListener{
        void onRowClick(int position, Contact contact);
    }

}
