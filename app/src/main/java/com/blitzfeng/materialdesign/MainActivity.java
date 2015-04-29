package com.blitzfeng.materialdesign;

import android.animation.Animator;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blitzfeng.materialdesign.adapter.MainAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity implements View.OnClickListener{

    @ViewInject(R.id.ib_1)
    private Button btn_1;
    @ViewInject(R.id.ib_2)
    private Button btn_2;
    @ViewInject(R.id.ib_3)
    private Button btn_3;
    @ViewInject(R.id.ib_4)
    private Button btn_4;
    @ViewInject(R.id.fl_bg)
    private FrameLayout bgFl;
    @ViewInject(R.id.iv_bg)
    private ImageView bgIv;
    @ViewInject(R.id.rl_btn)
    private RelativeLayout btnRl;
    @ViewInject(R.id.recylerView)
    private RecyclerView recyclerView;

    private MainAdapter adapter;
    private List<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(1000));
        getWindow().setExitTransition(null);
        ViewUtils.inject(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        bgIv.setOnClickListener(this);
        btnRl.setVisibility(View.INVISIBLE);

        list = getData();
        adapter = new MainAdapter(this,list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    private List<String> getData() {
        List<String> list = new ArrayList<String>();
        for (int i=0;i<10;i++)
            list.add("Item:"+i);
        return list;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_1:
                bgIv.setBackgroundResource(R.drawable.person_background);
                Animator animator = ViewAnimationUtils.createCircularReveal(bgFl,bgFl.getWidth()/2,bgFl.getHeight()/2,0f,bgFl.getHeight()/2);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(2000);
                animator.start();

                break;
            case R.id.ib_2:
                bgIv.setBackgroundResource(R.drawable.second);
                Animator animator2 = ViewAnimationUtils.createCircularReveal(bgFl,bgFl.getWidth()/2,bgFl.getHeight()/2,0f,bgFl.getHeight()/2);
                animator2.setInterpolator(new DecelerateInterpolator());
                animator2.setDuration(500);
                animator2.start();
                break;
            case R.id.ib_3:
                bgIv.setBackgroundResource(R.drawable.third);
                Animator animator3 = ViewAnimationUtils.createCircularReveal(bgFl,bgFl.getWidth()/2,bgFl.getHeight()/2,0f,bgFl.getHeight()/2);
                animator3.setInterpolator(new DecelerateInterpolator());
                animator3.setDuration(500);
                animator3.start();
                break;
            case R.id.ib_4:
                bgIv.setBackgroundResource(R.drawable.fourth);
                Animator animator4 = ViewAnimationUtils.createCircularReveal(bgFl,bgFl.getWidth()/2,bgFl.getHeight()/2,0f,bgFl.getHeight()/2);
                animator4.setInterpolator(new AccelerateInterpolator());
                animator4.setDuration(2000);
                animator4.start();
                break;
            case R.id.iv_bg:
                Animator animator5 = ViewAnimationUtils.createCircularReveal(bgFl,bgFl.getWidth()/2,bgFl.getHeight()/2,bgFl.getWidth(),0);
                animator5.setInterpolator(new AccelerateInterpolator());
                animator5.setDuration(2000);
                animator5.start();
                btnRl.setVisibility(View.VISIBLE);
                break;
        }

    }
}
