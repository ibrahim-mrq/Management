package com.android.management.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.management.R;
import com.android.management.controller.adapter.EpisodesAdapter;
import com.android.management.helpers.Constants;
import com.android.management.model.Episodes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EpisodesActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Toolbar toolbar;
    private TextView tvTool;
    private ImageView imgBackTool;
    private SwipeRefreshLayout swipeToRefresh;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FloatingActionButton fab;

    private ArrayList<Episodes> list = new ArrayList<>();
    private EpisodesAdapter adapter;
    private String center_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tvTool = findViewById(R.id.tv_tool);
        imgBackTool = findViewById(R.id.img_back_tool);
        swipeToRefresh = findViewById(R.id.swipe_to_refresh);
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressBar);
        fab = findViewById(R.id.fab);
        swipeToRefresh.setOnRefreshListener(this);

        tvTool.setText(getString(R.string.episodes));
        imgBackTool.setOnClickListener(view -> onBackPressed());

        adapter = new EpisodesAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        initEpisodes(center_name);

        fab.setOnClickListener(view ->
                startActivity(new Intent(this, EpisodeDetailActivity.class)
                        .putExtra(Constants.KEY, Constants.TYPE_ADD)
                        .putExtra(Constants.TYPE, center_name)
                ));

    }

    private void initEpisodes(String center_name) {
        progressBar.setVisibility(View.VISIBLE);
        list.clear();
        String imagePath = "android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.logo;
        for (int i = 0; i < 10; i++) {
            list.add(new Episodes(i, "a" + i, "admin", "center_name",
                    "مركز التحفيظ", 1, 1, 10
                    , "مركز التحفيظ مركز التحفيظ مركز التحفيظ مركز التحفيظ مركز التحفيظ ",
                    "gaza", imagePath));
        }
        progressBar.setVisibility(View.GONE);
        swipeToRefresh.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        initEpisodes(center_name);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}