package com.example.finalproject.courses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.finalproject.HomeFragment.CoursesFragment;
import com.example.finalproject.R;

public class cpp_Fragment extends Fragment {
    LinearLayout layout_lvl1 , layout_lvl2 , layout_lvl3 , layout_lvl4 , layout_lvl5 ;
    Button btn_basics , btn_oop , btn_data_Structure ,btn_multi_threading, btn_file_streams ;
    TextView mohamed,adel;
    TextView mohamed_oop,adel_oop ;
    TextView mohamed_data,adel_data;
    TextView multi_threading , file_streams1 , file_streams2 ;
    ImageView iv_back ;

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cpp_, container, false);
        //lvl1
        mohamed = view.findViewById(R.id.mohamed);
        adel = view.findViewById(R.id.adel);
        //lvl2
        mohamed_oop = view.findViewById(R.id.mohamed_oop);
        adel_oop = view.findViewById(R.id.adel_oop);
        //lvl3
        mohamed_data = view.findViewById(R.id.mohamed_data);
        adel_data = view.findViewById(R.id.adel_data);
        //lvl4
        multi_threading = view.findViewById(R.id.cpp_thread);
        //lvl5
        file_streams1 = view.findViewById(R.id.file_streams_link1);
        file_streams2 = view.findViewById(R.id.file_streams_link2);

        layout_lvl1 = view.findViewById(R.id.level1_cpp);
        layout_lvl2 = view.findViewById(R.id.level2_cpp);
        layout_lvl3 =view.findViewById(R.id.level3_cpp);
        layout_lvl4 =view.findViewById(R.id.level4_cpp);
        layout_lvl5 =view.findViewById(R.id.level5_cpp);

        btn_basics = view.findViewById(R.id.basics);
        btn_oop = view.findViewById(R.id.oop);
        btn_data_Structure = view.findViewById(R.id.data_structure);
        btn_file_streams = view.findViewById(R.id.file_streams);
        btn_multi_threading = view.findViewById(R.id.multi_threading);

        layout_lvl1.setVisibility(view.GONE);
        btn_basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl1.getVisibility() == View.VISIBLE) {
                    layout_lvl1.setVisibility(View.GONE);
                } else {
                    layout_lvl1.setVisibility(View.VISIBLE);
                }

                mohamed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://youtu.be/AtVmk025uDY");
                    }
                });

                adel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PLCInYL3l2AajFAiw4s1U4QbGszcQ-rAb3");
                    }
                });
            }
        });

        layout_lvl2.setVisibility(view.GONE);
        btn_oop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl2.getVisibility() == View.VISIBLE) {
                    layout_lvl2.setVisibility(View.GONE);
                } else {
                    layout_lvl2.setVisibility(View.VISIBLE);
                }

                mohamed_oop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PL1DUmTEdeA6KLEvIO0NyrkT91BVle8BOU");
                    }
                });

                adel_oop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PLCInYL3l2Aaiq1oLvi9TlWtArJyAuCVow");
                    }
                });
            }
        });

        layout_lvl3.setVisibility(view.GONE);
        btn_data_Structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl3.getVisibility() == View.VISIBLE) {
                    layout_lvl3.setVisibility(View.GONE);
                } else {
                    layout_lvl3.setVisibility(View.VISIBLE);
                }

                mohamed_data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PL1DUmTEdeA6JlommmGP5wicYLxX5PVCQt");
                    }
                });

                adel_data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PLCInYL3l2AajqOUW_2SwjWeMwf4vL4RSp");
                    }
                });
            }
        });

        layout_lvl4.setVisibility(view.GONE);
        btn_multi_threading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl4.getVisibility() == View.VISIBLE) {
                    layout_lvl4.setVisibility(View.GONE);
                } else {
                    layout_lvl4.setVisibility(View.VISIBLE);
                }

                multi_threading.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://youtu.be/wXBcwHwIt_I");
                    }
                });
            }
        });

        layout_lvl5.setVisibility(view.GONE);
        btn_file_streams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl5.getVisibility() == View.VISIBLE) {
                    layout_lvl5.setVisibility(View.GONE);
                } else {
                    layout_lvl5.setVisibility(View.VISIBLE);
                }

                file_streams1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://youtu.be/TF2-F2duY6c");
                    }
                });

                file_streams2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://youtu.be/TwtQhd3lg2A");
                    }
                });
            }
        });

        iv_back = view.findViewById(R.id.arrow_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment courses_f = new CoursesFragment();
                fragmentTransaction.setCustomAnimations(
                                R.anim.fade_in,     // exit
                                R.anim.slide_out,  // enter
                                R.anim.fade_in,   // exit
                                R.anim.slide_out // enter
                        )
                        .replace(R.id.fragment_container, courses_f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view ;
    }
    //================================================================================
    private void goLink(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    //=============================================================================

}