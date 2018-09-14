package com.example.android.android_me.ui;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;
    private int mListIndex;
    private static final String TAG = "BodyPartFragments";

    public static final String IMAGE_ID = "image_part_id";
    public static final String LIST_INDEX = "list_index_part";

    public BodyPartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        if(saveInstanceState != null) {
           mImageIds = saveInstanceState.getIntegerArrayList(IMAGE_ID);
           mListIndex = saveInstanceState.getInt(LIST_INDEX);
        }

        View rootview= inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootview.findViewById(R.id.layout_body_part_image);

        if(mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        } else {
            Log.v(TAG, "This fragment has a null list");
        }

        return rootview;
    }

    public void setmImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setmListIndex(int index) {
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }

}
