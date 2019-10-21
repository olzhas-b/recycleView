package com.example.recyclerviewinfragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_First extends Fragment {

    View view;
    private RecyclerView myrecyclerView;
    private List<Basic> array_image;
    private FragmentCommunication mCommunicator;
    public Fragment_First() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.post_f, container, false);
        myrecyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),array_image,mCommunicator);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        array_image = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            array_image.add(new Basic(R.drawable.first_pic));
            array_image.add(new Basic(R.drawable.second_pic));
            array_image.add(new Basic(R.drawable.third_pic));
        }
    }

}
