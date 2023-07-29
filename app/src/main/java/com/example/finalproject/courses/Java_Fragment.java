package com.example.finalproject.courses;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
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

public class Java_Fragment extends Fragment {
    LinearLayout layout_lvl1 , layout_lvl2 , layout_lvl3 , layout_lvl4 , layout_lvl5 , layout_lvl6 , layout_lvl7 , layout_lvl8  ;
    Button btn_basics , btn_oop , btn_framework , btn_java_api ,btn_multi_threading , btn_jdbc , btn_javafx , btn_advanced_java;
    ImageView iv_back;
    TextView mohamed,adel;
    TextView mohamed_oop,adel_oop;
    TextView link1,link2,java_api,java_thread,jdbc_link1,jdbc_link2,javafx_link1,javafx_link2,advanced_java_link1,advanced_java_link2;

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
        View view =  inflater.inflate(R.layout.fragment_java, container, false);

        mohamed = view.findViewById(R.id.mohamed);
        adel = view.findViewById(R.id.adel);

        mohamed_oop = view.findViewById(R.id.mohamed_oop);
        adel_oop = view.findViewById(R.id.adel_oop);

        link1 = view.findViewById(R.id.link1);
        link2 = view.findViewById(R.id.link2);

        java_api =view.findViewById(R.id.java_api_id);

        java_thread =view.findViewById(R.id.java_thread);

        jdbc_link1 =view.findViewById(R.id.jdbc_link1);
        jdbc_link2 =view.findViewById(R.id.jdbc_link2);

        javafx_link1 =view.findViewById(R.id.javafx_link1);
        javafx_link2 =view.findViewById(R.id.javafx_link2);

        advanced_java_link1 =view.findViewById(R.id.advanced_java_link1);
        advanced_java_link2 =view.findViewById(R.id.advanced_java_link2);

        layout_lvl1 = view.findViewById(R.id.level1_java);
        layout_lvl2 = view.findViewById(R.id.level2_java);
        layout_lvl3 =view.findViewById(R.id.level3_java);
        layout_lvl4 =view.findViewById(R.id.level4_java);
        layout_lvl5 =view.findViewById(R.id.level5_java);
        layout_lvl6 =view.findViewById(R.id.level6_java);
        layout_lvl7 =view.findViewById(R.id.level7_java);
        layout_lvl8 =view.findViewById(R.id.level8_java);

        btn_basics = view.findViewById(R.id.basics);
        btn_oop = view.findViewById(R.id.oop);
        btn_framework = view.findViewById(R.id.framework);
        btn_java_api = view.findViewById(R.id.javaapi);
        btn_multi_threading = view.findViewById(R.id.multi_threading);
        btn_jdbc = view.findViewById(R.id.jdbc);
        btn_javafx = view.findViewById(R.id.javafx);
        btn_advanced_java = view.findViewById(R.id.advanced_java);

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
                        goLink("https://www.youtube.com/watch?v=FbviMTJ_vP8&list=PL1DUmTEdeA6K7rdxKiWJq6JIxTvHalY8f");
                    }
                });

                adel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=mNvJipMTKSM&list=PLCInYL3l2AajYlZGzU_LVrHdoouf8W6ZN");
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
                        goLink("https://www.youtube.com/watch?v=M3Na5luSx50&list=PL1DUmTEdeA6Icttz-O9C3RPRF8R8Px5vk");
                    }
                });

                adel_oop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=FaaM6uVbuJM&list=PLCInYL3l2AagY7fFlhCrjpLiIFybW3yQv");
                    }
                });
            }
        });

        layout_lvl3.setVisibility(view.GONE);
        btn_framework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl3.getVisibility() == View.VISIBLE) {
                    layout_lvl3.setVisibility(View.GONE);
                } else {
                    layout_lvl3.setVisibility(View.VISIBLE);
                }

                link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=Jv5EevtkKJM");
                    }
                });

                link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=Jv5EevtkKJM");
                    }
                });
            }
        });

        layout_lvl4.setVisibility(view.GONE);
        btn_java_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl4.getVisibility() == View.VISIBLE) {
                    layout_lvl4.setVisibility(View.GONE);
                } else {
                    layout_lvl4.setVisibility(View.VISIBLE);
                }

                java_api.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=Jv5EevtkKJM");
                    }
                });
            }
        });

        layout_lvl5.setVisibility(view.GONE);
        btn_multi_threading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl5.getVisibility() == View.VISIBLE) {
                    layout_lvl5.setVisibility(View.GONE);
                } else {
                    layout_lvl5.setVisibility(View.VISIBLE);
                }

                java_thread.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=r_MbozD32eo");
                    }
                });
            }
        });

        layout_lvl6.setVisibility(view.GONE);
        btn_jdbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl6.getVisibility() == View.VISIBLE) {
                    layout_lvl6.setVisibility(View.GONE);
                } else {
                    layout_lvl6.setVisibility(View.VISIBLE);
                }

                jdbc_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=0qweiKy-k5g&list=PLd5-bvEurdb9qAeYdqCfmhXojCA4XVF5t");
                    }
                });
                jdbc_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=BOUMR85B-V0&list=PLhs1urmduZ2-yp3zID5rMEmXDETN8xvMo");
                    }
                });
            }
        });

        layout_lvl7.setVisibility(view.GONE);
        btn_javafx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl7.getVisibility() == View.VISIBLE) {
                    layout_lvl7.setVisibility(View.GONE);
                } else {
                    layout_lvl7.setVisibility(View.VISIBLE);
                }

                javafx_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=jD4CrfT2kek&list=PLwj1YcMhLRN1ISKdFo23inpSYyzXWrGDm");
                    }
                });
                javafx_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=9XJicRt_FaI");
                    }
                });
            }
        });

        layout_lvl8.setVisibility(view.GONE);
        btn_advanced_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl8.getVisibility() == View.VISIBLE) {
                    layout_lvl8.setVisibility(View.GONE);
                } else {
                    layout_lvl8.setVisibility(View.VISIBLE);
                }

                advanced_java_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=lZkgv4mdkd4");
                    }
                });
                advanced_java_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=tj5sLSFjVj4&t=8s");
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

        return view;
    }

    //================================================================================
    private void goLink(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    //=============================================================================
}








