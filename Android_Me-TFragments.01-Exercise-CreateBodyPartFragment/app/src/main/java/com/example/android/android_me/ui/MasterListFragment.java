package com.example.android.android_me.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class MasterListFragment extends Fragment {


    onImageClickListener mCallBack;

    public interface onImageClickListener {
        void onImageSelected(int position);
    }

    @Override
    //aca es cuando un fragment se ata asi mismo con la actividad
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mCallBack= (onImageClickListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnImageClickListener");
        }
    }

    public MasterListFragment(){

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_master_list, container, false);

        final GridView gridView = (GridView) rootview.findViewById(R.id.grid_view_items_parts);

        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallBack.onImageSelected(position);
            }
        });

        return rootview;

    }


}
