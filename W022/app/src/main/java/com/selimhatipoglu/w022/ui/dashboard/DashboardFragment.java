package com.selimhatipoglu.w022.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.selimhatipoglu.w022.R;
import com.selimhatipoglu.w022.RecyclerAdapter;
import com.selimhatipoglu.w022.RecylerAdapterFav;
import com.selimhatipoglu.w022.RecylerModelFav;
import com.selimhatipoglu.w022.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    RecyclerView recyclerView;
    ArrayList<RecylerModelFav> favrecylerModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.recylerView1);
        favrecylerModels = new ArrayList<>();

        // to do:

       // favrecylerModels= RecyclerAdapter.getFavoritesrecylerModels();




        RecylerAdapterFav recyclerAdapter=new RecylerAdapterFav(favrecylerModels);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}