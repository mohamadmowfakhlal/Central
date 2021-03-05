package com.example.central;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import androidx.navigation.fragment.navArgs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Device> DeviceList = ((MainActivity) getActivity()).getObjectList();
        listView= view.getRootView().findViewById(R.id.list_view);
        String[] listItem = getResources().getStringArray(R.array.array_technology);

        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(itemsAdapter);

        //Integer count = SecondFragmentArgs.fromBu ndle(getArguments()).getMyArg();
        //String countText = getString(R.string.random_heading, count);
        TextView headerView = view.getRootView().findViewById(R.id.textview_header);
       // headerView.setText(countText);
        //Random random = new java.util.Random();
        //Integer randomNumber = 0;
        //if (count > 0) {
     //       randomNumber = random.nextInt(count + 1);
       // }

        //TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        //randomView.setText(randomNumber.toString());

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    // Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(getActivity(), DeviceList);
    // Attach the adapter to a ListView
        ListView listView =  view.getRootView().findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    public class UsersAdapter extends ArrayAdapter<Device> {
        public UsersAdapter(Context context, List<Device> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Device device = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.deviceID);
            TextView tvHome = (TextView) convertView.findViewById(R.id.MAC);
            // Populate the data into the template view using the data object
            tvName.setText(device.deviceID);
            tvHome.setText(device.MAC);
            // Return the completed view to render on screen
            return convertView;
        }
    }
}