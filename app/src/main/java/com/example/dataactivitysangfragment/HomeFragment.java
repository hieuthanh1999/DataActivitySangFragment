package com.example.dataactivitysangfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.dataactivitysangfragment.databinding.HomefragmentBinding;

public class HomeFragment extends Fragment {
    HomefragmentBinding binding;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private MainActivity mainActivity;
    private static onDataInterface onDataInterface;

    public  static HomeFragment getInstance(User user)
    {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.homefragment, container, false);
        Unit();
        mainActivity = (MainActivity) getActivity();
        return binding.getRoot();
    }

    private void Unit() {
        User user= (User) getArguments().get("user");
        binding.name.setText(user.getName());
        binding.age.setText(String.valueOf(user.getAge()));
        binding.adress.setText(user.getAdress());


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendata2();
            }
        });
    }

    private void sendata2() {
        String name = binding.name.getText().toString().trim();
        Integer age = Integer.parseInt(binding.age.getText().toString().trim());
        String adress = binding.adress.getText().toString().trim();
        User user = new User(name, age, adress );
        onDataInterface = mainActivity;
        onDataInterface.onData(user);
    }


}
