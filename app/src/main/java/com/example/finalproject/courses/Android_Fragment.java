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

public class Android_Fragment extends Fragment {
    ImageView iv_back ;
    LinearLayout layout_lvl1 , layout_lvl2 , layout_lvl3 , layout_lvl4 , layout_lvl5 ,
            layout_lvl6 , layout_lvl7 , layout_lvl8 , layout_lvl9, layout_lvl10 ;
    Button btn_java , btn_basics_android , btn_kotlin , btn_other ,btn_jetpack ,
            btn_RX_java , btn_Rest_Api , btn_Room_database , btn_Design_patterns , btn_Projects;
    TextView mohamed_java , adel_java , mohamed_android , jaafar , kotlin_link1 , kotlin_link2 ,
            other_link1 , other_link2, other_link3, other_link4 , Jetpack_link1 , RXJava_link1 ,
            Rest_Api_link1 , Rest_Api_link2 , Room_database_link1 , design_patterns_link1 ,
            design_patterns_link2 , projects_link1 , projects_link2 ;

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
        View view = inflater.inflate(R.layout.fragment_android_, container, false);


        iv_back = view.findViewById(R.id.arrow_back);
        //lvl1
        mohamed_java = view.findViewById(R.id.mohamed);
        adel_java = view.findViewById(R.id.adel);
        //lvl2
        mohamed_android = view.findViewById(R.id.mohamed_essa);
        jaafar = view.findViewById(R.id.jaafar_mohammed);
        //lvl3
        kotlin_link1 = view.findViewById(R.id.kotlin_link1);
        kotlin_link2 = view.findViewById(R.id.kotlin_link2);
        //lvl4
        other_link1 = view.findViewById(R.id.other1);
        other_link2 = view.findViewById(R.id.other2);
        other_link3 = view.findViewById(R.id.other3);
        other_link4 = view.findViewById(R.id.other4);
        //lvl5
        Jetpack_link1 = view.findViewById(R.id.android_jetpack);
        //lvl6
        RXJava_link1  = view.findViewById(R.id.rxjava_link1);
        //lvl7
        Rest_Api_link1 = view.findViewById(R.id.rest_api_link1);
        Rest_Api_link2 = view.findViewById(R.id.rest_api_link2);
        //lvl8
        Room_database_link1 = view.findViewById(R.id.room_database_link1);
        //lvl9
        design_patterns_link1 = view.findViewById(R.id.design_patterns_link1);
        design_patterns_link2 = view.findViewById(R.id.design_patterns_link2);
        //lvl10
        projects_link1 = view.findViewById(R.id.projects_link1);
        projects_link2 = view.findViewById(R.id.projects_link2);

        //layout_links
        layout_lvl1 = view.findViewById(R.id.level1_android);
        layout_lvl2 = view.findViewById(R.id.level2_android);
        layout_lvl3 =view.findViewById(R.id.level3_android);
        layout_lvl4 =view.findViewById(R.id.level4_android);
        layout_lvl5 =view.findViewById(R.id.level5_android);
        layout_lvl6 =view.findViewById(R.id.level6_android);
        layout_lvl7 =view.findViewById(R.id.level7_android);
        layout_lvl8 =view.findViewById(R.id.level8_android);
        layout_lvl9 =view.findViewById(R.id.level9_android);
        layout_lvl10 =view.findViewById(R.id.level10_android);

        //btns
        btn_java = view.findViewById(R.id.basics_java);
        btn_basics_android = view.findViewById(R.id.basics_android);
        btn_kotlin = view.findViewById(R.id.kotlin);
        btn_other = view.findViewById(R.id.other);
        btn_jetpack = view.findViewById(R.id.jetpack);
        btn_RX_java = view.findViewById(R.id.rx_java);
        btn_Rest_Api = view.findViewById(R.id.rest_api);
        btn_Room_database = view.findViewById(R.id.room_database);
        btn_Design_patterns = view.findViewById(R.id.design_patterns);
        btn_Projects = view.findViewById(R.id.projects);

        layout_lvl1.setVisibility(view.GONE);
        btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl1.getVisibility() == View.VISIBLE) {
                    layout_lvl1.setVisibility(View.GONE);
                } else {
                    layout_lvl1.setVisibility(View.VISIBLE);
                }

                mohamed_java.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/playlist?list=PL1DUmTEdeA6K7rdxKiWJq6JIxTvHalY8f");
                    }
                });

                adel_java.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=mNvJipMTKSM&list=PLCInYL3l2AajYlZGzU_LVrHdoouf8W6ZN");
                    }
                });
            }
        });

        layout_lvl2.setVisibility(view.GONE);
        btn_basics_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl2.getVisibility() == View.VISIBLE) {
                    layout_lvl2.setVisibility(View.GONE);
                } else {
                    layout_lvl2.setVisibility(View.VISIBLE);
                }

                mohamed_android.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=nFin_KqJ98M&list=PLMYF6NkLrdN8giOLjGRx81fjEIaE5ef-8");
                    }
                });

                jaafar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/playlist?list=PLQYjhn7xrRna6k47sEYUq2alw9Jtu-Tmz");
                    }
                });
            }
        });

        layout_lvl3.setVisibility(view.GONE);
        btn_kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl3.getVisibility() == View.VISIBLE) {
                    layout_lvl3.setVisibility(View.GONE);
                } else {
                    layout_lvl3.setVisibility(View.VISIBLE);
                }

                kotlin_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=5flXf8nuq60");
                    }
                });

                kotlin_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=BBWyXo-3JGQ&t=2s");
                    }
                });
            }
        });

        layout_lvl4.setVisibility(view.GONE);
        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl4.getVisibility() == View.VISIBLE) {
                    layout_lvl4.setVisibility(View.GONE);
                } else {
                    layout_lvl4.setVisibility(View.VISIBLE);
                }

                other_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=WgnacaujuvU&t=1s");
                    }
                });

                other_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=-vAI7RSPxOA");
                    }
                });

                other_link3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=312RhjfetP8&t=10s");
                    }
                });

                other_link4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=z0F2QTAKsWU");
                    }
                });
            }
        });

        layout_lvl5.setVisibility(view.GONE);
        btn_jetpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (layout_lvl5.getVisibility() == View.VISIBLE) {
                    layout_lvl5.setVisibility(View.GONE);
                } else {
                    layout_lvl5.setVisibility(View.VISIBLE);
                }

                Jetpack_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=-TWz30owX_I&t=1s");
                    }
                });
            }
        });

        layout_lvl6.setVisibility(view.GONE);
        btn_RX_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl6.getVisibility() == View.VISIBLE) {
                    layout_lvl6.setVisibility(View.GONE);
                } else {
                    layout_lvl6.setVisibility(View.VISIBLE);
                }

                RXJava_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/playlist?list=PLXjbGq0ERjFq0KvT7clQoOxM5TTd03yji");
                    }
                });
            }
        });

        layout_lvl7.setVisibility(view.GONE);
        btn_Rest_Api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl7.getVisibility() == View.VISIBLE) {
                    layout_lvl7.setVisibility(View.GONE);
                } else {
                    layout_lvl7.setVisibility(View.VISIBLE);
                }

                Rest_Api_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=xPi-z3nOcn8");
                    }
                });

                Rest_Api_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=lMcznhiHdJE&list=PLXjbGq0ERjFpkwKH5jgwgstKj-twzhOqk");
                    }
                });
            }
        });

        layout_lvl8.setVisibility(view.GONE);
        btn_Room_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl8.getVisibility() == View.VISIBLE) {
                    layout_lvl8.setVisibility(View.GONE);
                } else {
                    layout_lvl8.setVisibility(View.VISIBLE);
                }

                Room_database_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=SkvNpRKnZNE&list=PLXjbGq0ERjFq5Y3vEK1v0ic5oEAqmpHa7");
                    }
                });
            }
        });

        layout_lvl9.setVisibility(view.GONE);
        btn_Design_patterns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl9.getVisibility() == View.VISIBLE) {
                    layout_lvl9.setVisibility(View.GONE);
                } else {
                    layout_lvl9.setVisibility(View.VISIBLE);
                }

                design_patterns_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/playlist?list=PLXjbGq0ERjFoCtb7aH910dtddLePNI6w7");
                    }
                });

                design_patterns_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=v4PbYeweaO4");
                    }
                });
            }
        });

        layout_lvl10.setVisibility(view.GONE);
        btn_Projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_lvl10.getVisibility() == View.VISIBLE) {
                    layout_lvl10.setVisibility(View.GONE);
                } else {
                    layout_lvl10.setVisibility(View.VISIBLE);
                }

                projects_link1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink("https://www.youtube.com/watch?v=XuqmMcTJzkU&list=PLXjbGq0ERjFqhIXvkiOsaoTUXdetg82J1&index=1");
                    }
                });

                projects_link2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goLink("https://www.youtube.com/watch?v=8YPXv7xKh2w&t=63s");
                    }
                });
            }
        });

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