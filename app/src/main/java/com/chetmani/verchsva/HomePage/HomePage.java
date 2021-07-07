package com.chetmani.verchsva.HomePage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.chetmani.verchsva.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.contact:
                        fragment = new ContactFragment();
                        break;
                    case R.id.bank:
                        fragment = new BankFragment();
                        break;

                    case R.id.news:
                        fragment = new NewsFragment();
                        break;

                    case R.id.gallery:
                        fragment = new GalleryFragment();
                        break;



                }
                if (fragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                }
            }
        });
    }
}