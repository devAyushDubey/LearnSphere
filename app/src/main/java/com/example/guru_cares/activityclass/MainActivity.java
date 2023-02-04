package com.example.guru_cares.activityclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.guru_cares.Fragmentclass.Attendance;
import com.example.guru_cares.Fragmentclass.Dash;
import com.example.guru_cares.Fragmentclass.Home;
import com.example.guru_cares.Fragmentclass.ProfileInfo;
import com.example.guru_cares.R;
import com.example.guru_cares.Fragmentclass.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav=findViewById(R.id.navigation_bar);


        Intent i= getIntent();
        Bundle b = i.getExtras();
        String username = (String) b.get("username");
        String userid = (String) b.get("userid");
        String studentcode = username.substring(0,3);
        //String studentcode = "200";
        String gradename = (String) b.get("gradename");
        String sectionname = (String) b.get("sectionname");


        //Sending it to home fragment
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("userid", userid);
        bundle.putString("check", "false");
        bundle.putInt("position", 99);
        bundle.putString("gradename", gradename);
        bundle.putString("sectionname", sectionname);

        FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            Fragment Home = new Home();
            Home.setArguments(bundle);
            t.replace(R.id.fragment, Home);
            t.commit();
//
//        ImageView homebtn = (ImageView) findViewById(R.id.home);
//        ImageView attendancebtn = (ImageView) findViewById(R.id.attendance);
//        ImageView dashbtn = (ImageView) findViewById(R.id.dash);
//        ImageView userbtn = (ImageView) findViewById(R.id.user);


//        Fetching data from login java file


//        if(studentcode.equals("100"))
//        {
//            FragmentManager m = getSupportFragmentManager();
//            FragmentTransaction t = m.beginTransaction();
//            Fragment Home = new Home();
//            Home.setArguments(bundle);
//            t.replace(R.id.fragment, Home);
//            t.commit();
////            homebtn.setImageResource(R.drawable.homecolor);
//        }
//
//        else if(studentcode.equals("200"))
//        {
//            FragmentManager m = getSupportFragmentManager();
//            FragmentTransaction t = m.beginTransaction();
//            Fragment Home = new Home();
//            Home.setArguments(bundle);
//            t.replace(R.id.fragment, Home);
//            t.commit();
////            homebtn.setImageResource(R.drawable.homecolor);
//        }

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId())
                {
                    case R.id.homemenu:
                        fragment = new Home();
                        fragment.setArguments(bundle);

                        break;
                    case R.id.attendancemenu:
                    fragment=new Attendance();

                        break;
                    case R.id.dashboardmenu:
                        fragment=new Dash();

                        break;
                    case R.id.profilemenu:
                        fragment=new User();
                        fragment.setArguments(bundle);

                        break;
                }
                FragmentManager m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();
            t.replace(R.id.fragment, fragment);
            t.commit();
                return true;
            }
        });
//
//
//        homebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if(studentcode.equals("100"))
//                {
//
//                    FragmentManager m = getSupportFragmentManager();
//                    FragmentTransaction t = m.beginTransaction();
//                    Fragment Home = new Home();
//                    Home.setArguments(bundle);
//                    t.replace(R.id.fragment, Home);
//                    t.commit();
//                    homebtn.setImageResource(R.drawable.homecolor);
//                    attendancebtn.setImageResource(R.drawable.attendance);
//                    dashbtn.setImageResource(R.drawable.dashboard);
//                    userbtn.setImageResource(R.drawable.user);
//
//                }
//                else if(studentcode.equals("200"))
//                {
//                    FragmentManager m = getSupportFragmentManager();
//                    FragmentTransaction t = m.beginTransaction();
//                    Fragment Home = new Home();
//                    Home.setArguments(bundle);
//                    t.replace(R.id.fragment, Home);
//                    t.commit();
//                    homebtn.setImageResource(R.drawable.homecolor);
//                    homebtn.setImageResource(R.drawable.homecolor);
//                    attendancebtn.setImageResource(R.drawable.attendance);
//                    dashbtn.setImageResource(R.drawable.dashboard);
//                    userbtn.setImageResource(R.drawable.user);
//
//
//                }
//
//            }
//        });
//
//
//
//        attendancebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                t.replace(R.id.fragment, new Attendance());
//                t.commit();
//                homebtn.setImageResource(R.drawable.home);
//                attendancebtn.setImageResource(R.drawable.schedule);
//                dashbtn.setImageResource(R.drawable.dashboard);
//                userbtn.setImageResource(R.drawable.user);
//            }
//        });
//
//        dashbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                t.replace(R.id.fragment, new Dash());
//                t.commit();
//                homebtn.setImageResource(R.drawable.home);
//                attendancebtn.setImageResource(R.drawable.attendance);
//                dashbtn.setImageResource(R.drawable.dashboardcolor);
//                userbtn.setImageResource(R.drawable.user);
//            }
//        });
//
//        userbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                FragmentManager m = getSupportFragmentManager();
//                FragmentTransaction t = m.beginTransaction();
//                Fragment user = new User();
//                user.setArguments(bundle);
//                t.replace(R.id.fragment, user);
//                t.commit();
//                homebtn.setImageResource(R.drawable.home);
//                attendancebtn.setImageResource(R.drawable.attendance);
//                dashbtn.setImageResource(R.drawable.dashboard);
//                userbtn.setImageResource(R.drawable.profilelogo);
//            }
//        });
    }


}