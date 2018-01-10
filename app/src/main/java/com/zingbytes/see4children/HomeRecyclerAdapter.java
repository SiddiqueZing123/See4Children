package com.zingbytes.see4children.activity.adapter;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zingbytes.see4children.R;
import com.zingbytes.see4children.activity.model.HomeModel;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.UserViewHolder> {

        private List<HomeModel> homeModelList;
          Context context;
         public   int id;
    ProgressDialog progress;


        public HomeRecyclerAdapter(List<HomeModel> homeModelList, Context context) {
            this.homeModelList = homeModelList;
            this.context = context;

        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // inflating recycler item view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

            return new UserViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int position) {
            holder.text_name.setText(homeModelList.get(position).getName());
            holder.text_description.setText(homeModelList.get(position).getDescription());
            holder.img_rightarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"hii",Toast.LENGTH_LONG).show();
                }
            });


        }

        @Override
        public int getItemCount() {
            return homeModelList.size();
        }

        /**
         * ViewHolder class
         */
        public class UserViewHolder extends RecyclerView.ViewHolder {

            public TextView text_name,text_description;
            public ImageView img_rightarrow;


            public UserViewHolder(View view) {
                super(view);
                text_name = (TextView) view.findViewById(R.id.text_name);
                text_description = (TextView) view.findViewById(R.id.text_description);
                img_rightarrow=(ImageView)view.findViewById(R.id.img_rightarrow);

            }

            }
        }


