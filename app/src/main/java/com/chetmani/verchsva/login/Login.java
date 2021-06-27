package com.chetmani.verchsva.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.chetmani.verchsva.HomePage.HomePage;
import com.chetmani.verchsva.Member;
import com.chetmani.verchsva.R;
import com.chetmani.verchsva.SharedPref;
import com.chetmani.verchsva.Utils;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;

import java.util.concurrent.TimeUnit;

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
        Button btnGetOtp = findViewById(R.id.btnGetOtp);
        member = new Member();
        reff = Utils.getInstance().getReference().child("Member");
        sharedPref = SharedPref.getInstance(this);
        final ProgressBar progressBar = findViewById(R.id.pb_sending_otp);
        btnGetOtp.setOnClickListener(this);
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
        if (!t.isEmpty()) {
            if (t.length() == 10) {

                openActivity2();
            }
        } else {
            Toast.makeText(this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
        }

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

        final ProgressBar progressBar= findViewById(R.id.pb_sending_otp);
        final Button btnGeOtp= findViewById(R.id.btnGetOtp);
        progressBar.setVisibility(View.VISIBLE);
        btnGeOtp.setVisibility(View.INVISIBLE);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mbnumber.getText().toString(), 60, TimeUnit.SECONDS, this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        progressBar.setVisibility(View.GONE);
                        btnGeOtp.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                        progressBar.setVisibility(View.GONE);
                        btnGeOtp.setVisibility(View.VISIBLE);
                        Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                        progressBar.setVisibility(View.GONE);
                        btnGeOtp.setVisibility(View.VISIBLE);
                        Intent intent = new Intent(getApplicationContext(), VerifyOtp.class);
                        intent.putExtra("mobile",mbnumber.getText().toString());
                        intent.putExtra("backendotp",backendotp);
                        startActivity(intent);
                    }
                }
        );
//
    }


}



