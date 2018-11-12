package com.example.dangeti.baby;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class babyfact extends AppCompatActivity {
    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babyfact);
    }

    public void test(View view) {

        edt1 = (EditText) findViewById(R.id.editText);
        String str1 = edt1.getText().toString();

        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
        i.putExtra(SearchManager.QUERY,str1);//implicit intent
        startActivity(i);
    }
}


