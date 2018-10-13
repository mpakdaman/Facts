package com.example.mina_pc.myapplication9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.toolbox.Volley.newRequestQueue;
public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] MyArray;

    RequestQueue requestQueue;

    JsonArrayRequest jsonArrayRequest;

    String url="https://jsonplaceholder.typicode.com/posts";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


int x =0;
        listView = findViewById(R.id.Textlist);

        requestQueue = newRequestQueue(this);

        //MyArray=new String[10] ;

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    public void onResponse(JSONArray response) {
                        try {

                            MyArray = new String[10];

                            for (int i = 0; i <10; i++) {

                                MyArray[i] = response.getJSONObject(i).getString("title");
                            }



                            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>( MainActivity.this,android.R.layout.simple_list_item_1,MyArray);


                            listView.setAdapter(myAdapter);

                        } catch (JSONException j) {
                            j.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()

        {

            public void onErrorResponse(VolleyError error) {
            }
        }
        );

        requestQueue.add(jsonArrayRequest);
    }

}














