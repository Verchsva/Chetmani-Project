package com.chetmani.verchsva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chetmani.verchsva.HomePage.HomePage;
import com.google.firebase.database.DatabaseReference;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtname, txtcmpname, txtcity, mbnumber;
    Button button;
    DatabaseReference reff;
    Member member;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtname = (EditText) findViewById(R.id.txtName);
        txtcmpname = (EditText) findViewById(R.id.txtCmpName);
        txtcity = (EditText) findViewById(R.id.txtCity);
        mbnumber = (EditText) findViewById(R.id.mbNumber);
        Button btnLogin = findViewById(R.id.btnLogin);
        member = new Member();
        btnLogin.setOnClickListener(this);
        reff = Utils.getInstance().getReference().child("Member");
        sharedPref = SharedPref.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPref.isUserRegistered()) {
            openActivity2();
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        String trim = txtname.getText().toString().trim();
        if (trim.isEmpty()) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }
        String trm = txtcmpname.getText().toString().trim();
        if (trm.isEmpty()) {
            Toast.makeText(this, "Enter Company Name", Toast.LENGTH_SHORT).show();
            return;
        }
        String tri = txtcity.getText().toString().trim();
        if (tri.isEmpty()) {
            Toast.makeText(this, "Enter Your City", Toast.LENGTH_SHORT).show();
            return;
        }
        String t = mbnumber.getText().toString().trim();
        if (t.isEmpty()) {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            return;
        }
        openActivity2();
        Member();
    }

    public void Member() {
        member.setName(txtname.getText().toString().trim());
        member.setCmpName(txtcmpname.getText().toString().trim());
        member.setCity(txtcity.getText().toString().trim());
        member.setMbNumber(mbnumber.getText().toString().trim());
        reff.push().setValue(member);
        sharedPref.setUserRegistered(true);
        Toast.makeText(Login.this, "Namaskar", Toast.LENGTH_LONG).show();
    }

    public void openActivity2() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}



