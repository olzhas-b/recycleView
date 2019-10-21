package com.example.recyclerviewinfragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {
    public int counter = 0;
    Context mContext;

    List<Basic> mData;
   private FragmentCommunication mCommunicator;

    public RecyclerViewAdapter(Context mContext, List<Basic> mData,FragmentCommunication communication) {
        this.mData = mData;
        this.mContext = mContext;
        mCommunicator=communication;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycleview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v,mCommunicator);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        holder.imgage.setImageResource(mData.get(position).getPhoto());
        holder.buttonClick.setText("LIKE");
        holder.buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;

                String line =  String.valueOf(counter);
                try {
                    FileOutputStream fileOutput = mContext.openFileOutput("my_file.xml", MODE_PRIVATE);
                    fileOutput.write(line.getBytes());
                    fileOutput.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgage;
        private Button buttonClick;
        FragmentCommunication mComminication;

        public MyViewHolder( View itemView, FragmentCommunication Communicator) {
            super(itemView);
            buttonClick = (Button) itemView.findViewById(R.id.ButtonClick);
            imgage = (ImageView) itemView.findViewById(R.id.ImageInRecycle);
            mComminication=Communicator;
        }

    }

}

