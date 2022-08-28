package com.selimhatipoglu.w022.ui.home;

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
import com.selimhatipoglu.w022.RecylerModel;
import com.selimhatipoglu.w022.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    RecyclerView recyclerView;
    ArrayList<RecylerModel> recylerModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recylerView);
        recylerModels = new ArrayList<>();
        recylerModels.add(new RecylerModel("telefon","1250"));
        recylerModels.add(new RecylerModel("bilgisayar","3000"));

        recylerModels.add(new RecylerModel("televizyon","6000"));
        recylerModels.add(new RecylerModel("masa","500"));
        recylerModels.add(new RecylerModel("sandalye","300"));
        recylerModels.add(new RecylerModel("kapı","600"));



        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(recylerModels);

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