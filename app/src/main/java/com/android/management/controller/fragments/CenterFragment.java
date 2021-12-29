package com.android.management.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.management.R;
import com.android.management.controller.activities.CenterActivity;
import com.android.management.controller.activities.MainActivity;
import com.android.management.controller.adapter.CenterAdapter;
import com.android.management.helpers.Constants;
import com.android.management.model.Center;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CenterFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeToRefresh;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FloatingActionButton fab;

    private ArrayList<Center> list = new ArrayList<>();
    private CenterAdapter adapter;

    public CenterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_center, container, false);

        initView(root);

        return root;
    }

    private void initView(View root) {
        MainActivity.tv_toolbar.setText(getString(R.string.centers));

        swipeToRefresh = root.findViewById(R.id.swipe_to_refresh);
        recyclerView = root.findViewById(R.id.recycler_view);
        progressBar = root.findViewById(R.id.progressBar);
        fab = root.findViewById(R.id.fab);
        swipeToRefresh.setOnRefreshListener(this);

        adapter = new CenterAdapter(list, requireActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        initCenter();

        fab.setOnClickListener(view -> {
            startActivity(new Intent(requireActivity(), CenterActivity.class)
                    .putExtra(Constants.KEY, Constants.TYPE_ADD)
            );
        });

    }

    private void initCenter() {
        progressBar.setVisibility(View.VISIBLE);
        list.clear();
        String imagePath = "android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.logo;
        for (int i = 0; i < 10; i++) {
            list.add(new Center(0, "a " + i, "gaza", imagePath,
                    "gaza", 12, 15, 10, "محمد علي"));
        }
        progressBar.setVisibility(View.GONE);
        swipeToRefresh.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        initCenter();
    }

}