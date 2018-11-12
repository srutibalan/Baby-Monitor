package com.example.dangeti.baby;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class Welcome extends Activity{
TextView tv;
    Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

	}
    public void cry(View view)
    {
        i=new Intent(this,babymonitor.class);
        startActivityForResult(i,500);
    }
    public void facts(View view)
    {
        i=new Intent(this,babyfact.class);
        startActivityForResult(i,500);
    }
    public void sleep(View view)
    {
        i=new Intent(this,sleep.class);
        startActivityForResult(i,500);
    }
}
