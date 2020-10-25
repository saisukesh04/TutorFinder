package com.vithack.tutorfinder.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vithack.tutorfinder.LoginActivity;
import com.vithack.tutorfinder.MainActivity;
import com.vithack.tutorfinder.R;
import com.vithack.tutorfinder.utils.FeedAdapter;
import com.vithack.tutorfinder.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedFragment extends Fragment {

    @BindView(R.id.feed_recycler) RecyclerView feed_recycler;

    String URL = "https://abc-institutions.000webhostapp.com/all_posts.php";

    ProgressDialog progressDialog;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_feed, container, false);

        ButterKnife.bind(this,root);
        List<Post> postList = new ArrayList<>();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                String postby_id, subject, classes, medium, salary, location, p_university, deadline;

                if (!response.equalsIgnoreCase("0 results")) {
                    Log.i("Info:", response);
                    try {
                        JSONArray postsInfo = new JSONArray(response);
                        for(int i=0;i<postsInfo.length();i++) {
                            JSONObject jsonObj = postsInfo.getJSONObject(i);
                            postby_id = jsonObj.get("postby_id").toString();
                            subject = jsonObj.get("subject").toString();
                            classes = jsonObj.get("class").toString();
                            medium = jsonObj.get("medium").toString();
                            salary = jsonObj.get("salary").toString();
                            location = jsonObj.get("location").toString();
                            p_university = jsonObj.get("p_university").toString();
                            deadline = jsonObj.get("deadline").toString();
                            Post post = new Post(postby_id,subject,medium,salary,location,p_university,deadline,classes);
                            postList.add(post);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getContext(), "E-mail and password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);

        FeedAdapter adapter = new FeedAdapter(postList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        feed_recycler.setLayoutManager(layoutManager);
        feed_recycler.setAdapter(adapter);

        return root;
    }
}