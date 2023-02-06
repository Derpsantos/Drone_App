package com.drone.app.fragments;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drone.app.R;
import com.drone.app.adapters.FlightListHandler;
import com.drone.app.models.FlightModel;
import com.drone.app.utility.DatabaseHelper;
import com.drone.app.utility.RecyclerItemClickListener;
import com.drone.app.utility.RecyclerViewAdapter;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DroneConditionFragment extends Fragment {
    View view;

    List<FlightModel> flights;
    DatabaseHelper database;
    // RecyclerView list;

    Button test_button;
    TextView t3;
    TextView t4;
    TextView t6;
    TextView t7;

    boolean toggle;

    CountDownTimer countDowntimer;


    public DroneConditionFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new DatabaseHelper();
        Date date = new Date(System.currentTimeMillis());
        Long timestamp = datetoTimestamp(date);
        toggle = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_drone_condition, container, false);


        //database.getAllFlights(this::SetupListView);

        test_button = (Button) view.findViewById(R.id.button);
        t3 = view.findViewById(R.id.textView3);
        t4 = view.findViewById(R.id.textView4);
        t6 = view.findViewById(R.id.textView6);
        t7 = view.findViewById(R.id.textView7);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (toggle == true) {
                    countDowntimer = createTimer();
                    countDowntimer.start();
                    return;
                }
                if (countDowntimer != null) {
                    countDowntimer.onFinish();
                    countDowntimer.cancel();

                }
                //database.add_flight(id, mot_t, rot_t, test, System.currentTimeMillis());

            }
        });
    }

    public CountDownTimer createTimer() {
        return new CountDownTimer(10000, 200) {

            Random r = new Random();

            double motor = 80 + (80-20) * r.nextDouble();
            double battery = 50 + (50-10) * r.nextDouble();
            boolean rotor=false;

            final String id = UUID.randomUUID().toString();

            @Override
            public void onTick(long l) {
                motor = 80 + (80-20) * r.nextDouble();
                battery = 50 + (50-10) * r.nextDouble();
                t3.setText(String.format("Temperature of motor: %2f", motor) + " C");
                t4.setText(String.format("Temperature of battery: %2f" , battery) +" C");
                t6.setText("Rotor issue : " + rotor );
                t7.setText("Time left: " + l/1000 + "s");

            }

            @Override
            public void onFinish() {
                database.add_flight(id, motor, battery, rotor, System.currentTimeMillis());
                toggle = false;
            }
        };
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
    private void SetupGraphView(FlightModel flight) {
        double x = 0.0;
        //   GraphView graph = (GraphView) findViewById(R.id.)
    }

    public static Long datetoTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}