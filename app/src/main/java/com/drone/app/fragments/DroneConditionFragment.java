package com.drone.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drone.app.R;
import com.drone.app.adapters.FlightListHandler;
import com.drone.app.models.FlightModel;
import com.drone.app.utility.DatabaseHelper;
import com.drone.app.utility.RecyclerItemClickListener;
import com.drone.app.utility.RecyclerViewAdapter;

import java.util.List;
import java.util.UUID;

public class DroneConditionFragment extends Fragment {
    View view;

    List<FlightModel> flights;
    DatabaseHelper database;
   // RecyclerView list;

    Button test_button;

    public DroneConditionFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        database=new DatabaseHelper();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_drone_condition, container, false);

        //database.getAllFlights(this::SetupListView);

        test_button = (Button) view.findViewById(R.id.button);

        return view;
    }

    @Override
    public void onStart(){
        super.onStart();

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String id = UUID.randomUUID().toString();
            double mot_t = 0;
            double rot_t = 0;
            boolean test = true;

            database.add_flight(id, mot_t, rot_t, test, System.currentTimeMillis());

            }
        });
    }



/*
    public void SetupListView(List<FlightModel> flights){
        list = view.findViewById(R.id.flight_list_id);

        list.setLayoutManager(new LinearLayoutManager(list.getContext()));

        list.setAdapter(new RecyclerViewAdapter(flights));

        list.addOnItemTouchListener(
        new RecyclerItemClickListener(list.getContext(), list, new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                RecyclerViewAdapter adapter = (RecyclerViewAdapter) list.getAdapter();

                database.get_flight(adapter.getFlight(position).getFlightId(), flight ->{
                    SetupGraphView(flight);
                } );
            }

            @Override
            public void onItemLongClick(View view, int position){}
        })

       );
    }
*/
    private void SetupGraphView(FlightModel flight){
        double x = 0.0;
             //   GraphView graph = (GraphView) findViewById(R.id.)
    }
}