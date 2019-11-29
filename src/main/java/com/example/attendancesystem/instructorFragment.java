package com.example.attendancesystem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class instructorFragment extends Fragment {
    private ArrayList<String> mNames =new ArrayList<>();
    private ArrayList<String> mImageUrls =new ArrayList<>();
    private ArrayList<String> mDescription=new ArrayList<>();
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Button editbtn;
    Button deletebtn;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_instructor, container, false);
        mImageUrls.add("1");
        mNames.add("Alaa Mohamed Rashidy");
        mDescription.add("Csc0012");
        mImageUrls.add("2");
        mNames.add("Mohamed Ayman Abd ElAziz");
        mDescription.add("Csc0022");
        mImageUrls.add("3");
        mNames.add("Mayar Yasser Abd ELMoniem ");
        mDescription.add("Csc0015");
        recyclerView = view.findViewById(R.id.recyclerv_view);
        editbtn = view.findViewById(R.id.editbtn);
        deletebtn = view.findViewById(R.id.deletebtn);
        adapter = new RecyclerViewAdapter(this, mNames, mImageUrls,mDescription);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    String deletedItem = null;
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            final int position = viewHolder.getAdapterPosition();
            final int i = 1;


            deletedItem= mNames.get(position);
            mNames.remove(position);
            adapter.notifyItemRemoved(position);
            Snackbar.make(recyclerView ,deletedItem , Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mNames.add(position , deletedItem);
                            adapter.notifyItemInserted(position);
                        }
                    }).show();
        }
    };


}
