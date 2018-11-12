package com.example.dangeti.baby;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Signin extends Activity{
	Intent i=null;
	ImageView im=null;
	EditText tv1,tv2,tv3,tv4;
	boolean flag=false;
	SQLiteDatabase db=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin);
		im=(ImageView)findViewById(R.id.show_hide);
		tv1=(EditText)findViewById(R.id.name);
		tv2=(EditText)findViewById(R.id.email_id);
		tv3=(EditText)findViewById(R.id.phone);
		tv4=(EditText)findViewById(R.id.password);
		db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);
		db.execSQL("create table if not exists login(name varchar,mobile_no varchar,email_id varchar,password varchar,flag varchar)");
		
		im.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
			
				if(flag==false)
				{
					im.setImageResource(R.drawable.hide);
					tv4.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
					flag=true;
				}
				else
				{
					im.setImageResource(R.drawable.show);
					tv4.setInputType(129);
					flag=false;
					
				}
			}
		});
	}
	
	public void action(View v)
	{
	switch(v.getId())
	{
	case R.id.login: 
		i=new Intent(this,Login.class);
		startActivityForResult(i, 500);
		overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom); 
		finish();
		break;
	case R.id.signin:
		String name=tv1.getText().toString();
		String email_id=tv2.getText().toString();
		String mobile_no=tv3.getText().toString();
		String password=tv4.getText().toString();
		if(name==null||name==""||name.length()<3)
		{
			show("Please Enter Correct Name.");
		}
		else if(mobile_no==null||mobile_no==""||mobile_no.length()<10)
		{
			show("Please Enter Correct mobile number.");
		}
		else if(email_id==null||email_id==""||email_id.length()<10)
		{
			show("Please Enter Correct Email id.");
		}
		else if(password==null||password==""||password.length()<6)
		{
			show("Please Enter Strong Password.");
		}
		else
		{
			db.execSQL("insert into login values('"+name+"','"+mobile_no+"','"+email_id+"','"+password+"','nothing')");
			i=new Intent(this,Welcome.class);
			startActivityForResult(i, 500);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); 
			db.close();
			finish();
		}
		break;
	}
  }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	} 
	
	public void show(String str)
	{
	Toast.makeText(this, str, Toast.LENGTH_LONG).show();	
	}
}
