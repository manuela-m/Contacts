package com.mm.Contacts_App;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class My_Adapter extends RecyclerView.Adapter{

    private List_Contacts.OnListFragmentClickInteractionListener mListener;

    public My_Adapter(List_Contacts.OnListFragmentClickInteractionListener listener){
        mListener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);

        return  new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        ((ListViewHolder)holder).bindView(position);

       final Data.Contact current_contact = Data.CONTACTS.get(position);
        ((ListViewHolder) holder).mView.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context mContext = v.getContext();
                Data.Contact contact = Data.CONTACTS.get(position);
                AlertDialog dialog = new AlertDialog.Builder(mContext).setMessage("Czy usunąć " + contact.name+ " ?").setCancelable(false)
                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                delete(position);
                            }
                        }).setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });

        ((ListViewHolder) holder).mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Context mContext = v.getContext();
                Data.Contact contact = Data.CONTACTS.get(position);

                AlertDialog dialog = new AlertDialog.Builder(mContext).setMessage("Zadzwonić do " + contact.name+ " ?").setCancelable(true)
                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Data.Contact contact = Data.CONTACTS.get(position);
                                Toast.makeText(mContext,"Trwa łączenie ... " ,Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            }
        });

        ((ListViewHolder) holder).mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.OnListFragmentClickInteraction(current_contact,position);
                }

            }
        });

    }




    @Override
    public int getItemCount() {
        return Data.CONTACTS.size();
    }


    private class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView mItemText;
        private ImageView mItemImage;
        private ImageButton mItemTrash;
        LinearLayout parentLayout;
        public View mView;
        private int position;



        public ListViewHolder(View itemView) {
            super(itemView);
            mItemText= (TextView) itemView.findViewById(R.id.name);
            mItemImage=(ImageView) itemView.findViewById(R.id.image);
            mItemTrash=(ImageButton) itemView.findViewById(R.id.trash);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mView= itemView;




        }
        public void bindView (int position){
            Data.Contact contact= Data.CONTACTS.get(position);
            mItemText.setText(contact.name);
            this.position=position;

           mItemImage.setImageResource(contact.picture);

        }



    }
        public void delete(int position){

        Data.CONTACTS.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, Data.CONTACTS.size());
        notifyDataSetChanged();
        }


}




