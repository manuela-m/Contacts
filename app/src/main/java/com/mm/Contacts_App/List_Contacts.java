package com.mm.Contacts_App;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class List_Contacts extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    private My_Adapter myRecyclerViewAdapter;

    public OnListFragmentClickInteractionListener mListener;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_contact, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecycler);
        com.mm.Contacts_App.My_Adapter myAdapter = new My_Adapter(mListener);
        recyclerView.setAdapter(myAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentClickInteractionListener) {
            mListener = (OnListFragmentClickInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void notifyDataChange(){
        myRecyclerViewAdapter.notifyDataSetChanged();
    }


public interface OnListFragmentClickInteractionListener {
    void OnListFragmentClickInteraction(Data.Contact contact, int position);

}

}
