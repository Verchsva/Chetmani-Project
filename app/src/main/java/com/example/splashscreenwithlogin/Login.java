package com.example.splashscreenwithlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity implements View.OnClickListener {
      EditText txtname,txtcmpname,txtcity,mbnumber;
      Button button;
      DatabaseReference reff;
      Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtname=(EditText)findViewById(R.id.txtName);
        txtcmpname=(EditText)findViewById(R.id.txtCmpName);
        txtcity=(EditText)findViewById(R.id.txtCity);
        mbnumber=(EditText)findViewById(R.id.mbNumber);
        Button btnLogin=findViewById(R.id.btnLogin);
        member=new Member();
        btnLogin.setOnClickListener(this);
        reff=FirebaseDatabase.getInstance().getReference().child("Member");
    }

    @Override
    public void onClick(View view) {
        openActivity2();
        Member();
    }
    public void Member(){
        int pnumber=Integer.parseInt(mbnumber.getText().toString().trim());

        member.setName(txtname.getText().toString().trim());
        member.setCmpName(txtcmpname.getText().toString().trim());
        member.setCity(txtcity.getText().toString().trim());
        member.setMbNumber(pnumber);

        reff.push().setValue(member);
        Toast.makeText(Login.this,"Data inserted",Toast.LENGTH_LONG).show();
    }
    public void openActivity2() {
        Intent intent=new Intent(this,Homepage.class);
        startActivity(intent);
    }

}
