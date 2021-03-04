package com.example.central;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

public class FirstFragment extends Fragment {
    EditText username;
    EditText password;
    Toast myToast;

    //TextView login;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        username = fragmentFirstLayout.findViewById(R.id.username);
        password = fragmentFirstLayout.findViewById(R.id.password);
        //login = fragmentFirstLayout.findViewById(R.id.textview_first);
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

/*        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
               FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
               NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });*/
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //boolean result = signin(view);
                // Get the value of the text view
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();
                // Instantiate the RequestQueue.
                RequestQueue queue =  Volley.newRequestQueue(getActivity().getApplicationContext());
                String url ="http://ec2-3-120-27-130.eu-central-1.compute.amazonaws.com/users/check/"+ user_name +"?password="+pass_word+ "";

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if(response.equals("success"))
                                {
                                    myToast = Toast.makeText(getActivity(), "welcome !", Toast.LENGTH_SHORT);

                                }
                                else
                                    myToast = Toast.makeText(getActivity(), "failed to login !", Toast.LENGTH_SHORT);
                                myToast.show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        myToast.setText("That didn't work!");
                    }
                });
// Add the request to the RequestQueue.
                queue.add(stringRequest);
/*
                final boolean[] result = new boolean[1];
                final AtomicReference<String> firstNameRef = new AtomicReference<>();
                // User user = new User("ella","ali");
                AndroidNetworking.get("https://ec2-3-120-27-130.eu-central-1.compute.amazonaws.com/users")
                        //   .addPathParameter("username", user_name)
                        // .addQueryParameter("password", pass_word)
                        //       .addBodyParameter(user)
                        .build().getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("onResponse: "+response);
                        firstNameRef.set(response);
                        username.setText(response);
                        myToast = Toast.makeText(getActivity(), "welcome !", Toast.LENGTH_SHORT);
                        result[0] = true;
                        myToast.show();
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("onError: "+anError.getErrorDetail());
                        myToast = Toast.makeText(getActivity(), "incorrect password!", Toast.LENGTH_SHORT);
                        result[0] = false;
                        myToast.show();
                    }
                });
*/
            }
        });

    }

   // private boolean signin(View view) {




        //login.setText(user_name + pass_word);
        // Convert value to a number and increment it
        //Integer count = Integer.parseInt(countString);
        //count++;
        // Display the new value in the text view.
        //username.setText(count.toString());

        //return result[0];
  //  }
}