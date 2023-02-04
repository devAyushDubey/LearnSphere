package com.example.guru_cares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link gururewards#newInstance} factory method to
 * create an instance of this fragment.
 */
public class gururewards extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public gururewards() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment gururewards.
     */
    // TODO: Rename and change types and number of parameters
    public static gururewards newInstance(String param1, String param2) {
        gururewards fragment = new gururewards();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_gururewards, container, false);

        TextView rewards, trans;
        rewards = (TextView) v.findViewById(R.id.rewards);
        trans = (TextView) v.findViewById(R.id.trans);

        LinearLayout translist;
        HorizontalScrollView rewardlist;

        translist = (LinearLayout) v.findViewById(R.id.translist);
        rewardlist = (HorizontalScrollView) v.findViewById(R.id.rewardlist);

        rewardlist.setVisibility(View.VISIBLE);
        translist.setVisibility(View.GONE);

        rewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rewardlist.setVisibility(View.VISIBLE);
                translist.setVisibility(View.GONE);
            }
        });


        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rewardlist.setVisibility(View.INVISIBLE);
                translist.setVisibility(View.GONE);
            }
        });




        return v;
    }
}