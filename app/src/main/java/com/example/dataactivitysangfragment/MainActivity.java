package com.example.dataactivitysangfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.dataactivitysangfragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements onDataInterface {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);

        xuly();
    }

    private void xuly() {



        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendata();
            }
        });

    }
    public  void sendata()
    {
        String name = binding.name.getText().toString().trim();
        Integer age = Integer.parseInt(binding.age.getText().toString().trim());
        String adress = binding.adress.getText().toString().trim();
        User user = new User(name, age, adress );
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("user", user);
//        homeFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentlayout, HomeFragment.getInstance(user));
        fragmentTransaction.commit();

    }
    @Override
    public void onData(User user) {
        binding.name.setText(user.getName());
        binding.age.setText(String.valueOf(user.getAge()));
        binding.adress.setText(user.getAdress());
    }
}
