package com.blitzfeng.materialdesign;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_index)
public class IndexActivity extends Activity {

    @ViewInject(R.id.btn_enter)
    private Button enterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  //      setEnterAnim();
        ViewUtils.inject(this);
        init();
    }
    @TargetApi(21)
    private void setEnterAnim(){
        if(Build.VERSION.SDK_INT>=21){
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Explode().setDuration(1000));
            getWindow().setExitTransition(new Explode());
        }

    }
    private void init() {
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this,MainActivity.class);

                start(intent);

            }
        });
    }
    @TargetApi(21)
    private void start(Intent intent){
        if(Build.VERSION.SDK_INT>=21){
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(IndexActivity.this).toBundle());
        }else{
            startActivity(intent);
        }
    }


}
