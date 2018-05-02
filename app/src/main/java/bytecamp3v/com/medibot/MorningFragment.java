package bytecamp3v.com.medibot;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MorningFragment extends Fragment {

    String name;
    RecyclerView medicinesView;
    DatabaseReference mRef;
    CustomAdapter adapter;
    List<Medicine> medicines = new ArrayList<>();
    void setName(String name) {
        this.name = name;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_morning,container,false);
        medicinesView = rootView.findViewById(R.id.morningList);
        medicinesView.setHasFixedSize(true);
        medicinesView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new CustomAdapter(rootView.getContext(),medicines);
        medicinesView.setAdapter(adapter);
        mRef = FirebaseDatabase.getInstance().getReference().child("Person").child(name).child("morning");
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("TAG",dataSnapshot.toString());
                Medicine medicine = dataSnapshot.getValue(Medicine.class);
                medicines.add(medicine);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                Medicine medicine = dataSnapshot.getValue(Medicine.class);
                int mednum = Integer.valueOf(dataSnapshot.getKey());
                Log.d("Number","num-"+mednum);
                medicines.remove(mednum-1);
                medicines.add(mednum-1,medicine);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }

}
