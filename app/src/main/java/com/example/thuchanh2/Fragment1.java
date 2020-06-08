package com.example.thuchanh2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
//fragment cho ten quan co
public class Fragment1 extends ListFragment {
    ArrayAdapter<String> adapter;
    ItemClicked itemClickedItf;// activi nao muon dung fragment phai implement interface
    public interface ItemClicked{
        void itemClick(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        itemClickedItf = (ItemClicked) context;
    }

    public Fragment1() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_1, container, false);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] ten = getResources().getStringArray(R.array.ten_quan_co);
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,ten);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        itemClickedItf.itemClick(position);
    }
}
