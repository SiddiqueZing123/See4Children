package com.zingbytes.see4children.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zingbytes.see4children.R;
import com.zingbytes.see4children.activity.adapter.HomeRecyclerAdapter;
import com.zingbytes.see4children.activity.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zingbyte-Ajay on 1/10/2018.
 */

public class HomeFragment extends Fragment {

    private RecyclerView recycler_home;
    HomeRecyclerAdapter mAdapter;
    private List<HomeModel> homeModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home Page");
        homeModelList=new ArrayList<HomeModel>();
        recycler_home=(RecyclerView)view.findViewById(R.id.recycler_home) ;
        GetHomeData();
        mAdapter = new HomeRecyclerAdapter(homeModelList,getActivity());
        Log.e("homeModelList",homeModelList.toString());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recycler_home.setLayoutManager(mLayoutManager);
        recycler_home.setItemAnimator(new DefaultItemAnimator());
        recycler_home.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recycler_home.setAdapter(mAdapter);
        return view;
    }

   public  void GetHomeData(){
       HomeModel homeModel = new HomeModel();
       homeModel.setName("Crack Jack Ngo");
       homeModel.setDescription("NGO has more than 200 childrens who are living on donation.");
       homeModelList.add(homeModel);

       homeModel = new HomeModel();
       homeModel.setName("Crack Jack Ngo");
       homeModel.setDescription("NGO has more than 200 childrens who are living on donation.");
       homeModelList.add(homeModel);

       homeModel = new HomeModel();
       homeModel.setName("Crack Jack Ngo");
       homeModel.setDescription("NGO has more than 200 childrens who are living on donation.");
       homeModelList.add(homeModel);

       homeModel = new HomeModel();
       homeModel.setName("Crack Jack Ngo");
       homeModel.setDescription("NGO has more than 200 childrens who are living on donation.");
       homeModelList.add(homeModel);

       homeModel = new HomeModel();
       homeModel.setName("Crack Jack Ngo");
       homeModel.setDescription("NGO has more than 200 childrens who are living on donation.");
       homeModelList.add(homeModel);
       mAdapter = new HomeRecyclerAdapter(homeModelList,getActivity());
       recycler_home.setAdapter(mAdapter);
}
}
