package com.chetmani.verchsva.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chetmani.verchsva.HomePage.HomePage;
import com.chetmani.verchsva.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyOtp extends AppCompatActivity {

//    EditText inputnumber1,inputnumber2,inputnumber3,inputnumber4,inputnumber5,inputnumber6;
//
//    String getotpbackend;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_verify_otp);
//
//        final Button verifyOtpOnClick= findViewById(R.id.btnLogin);
//
//        inputnumber1=findViewById(R.id.inputOtp1);
//        inputnumber2=findViewById(R.id.inputOtp2);
//        inputnumber3=findViewById(R.id.inputOtp3);
//        inputnumber4=findViewById(R.id.inputOtp4);
//        inputnumber5=findViewById(R.id.inputOtp5);
//        inputnumber6=findViewById(R.id.inputOtp6);
//
//        TextView textView=findViewById(R.id.textmobileshownumber);
//        textView.setText(String.format(
//                "+91-%s",getIntent().getStringExtra("mobile")
//        ));
//
//        getotpbackend=getIntent().getStringExtra("backendotp");
//
//        final ProgressBar progressBarVerifyOtp=findViewById(R.id.pb_verify_otp);
//
//        verifyOtpOnClick.setOnClickListener(new View.OnClickListener() {
//            String t1 = inputnumber1.getText().toString().trim();
//            String t2 = inputnumber2.getText().toString().trim();
//            String t3 = inputnumber3.getText().toString().trim();
//            String t4 = inputnumber4.getText().toString().trim();
//            String t5 = inputnumber5.getText().toString().trim();
//            String t6 = inputnumber6.getText().toString().trim();
//            @Override
//            public void onClick(View v) {
//                if (!t1.isEmpty() && !t2.isEmpty() && !t3.isEmpty() && !t4.isEmpty() && !t5.isEmpty() && !t6.isEmpty()){
//
//                    String entercodeotp= inputnumber1.getText().toString()+
//                            inputnumber2.getText().toString()+
//                            inputnumber3.getText().toString()+
//                            inputnumber4.getText().toString()+
//                            inputnumber5.getText().toString()+
//                            inputnumber6.getText().toString();
//
//
//                    if (getotpbackend!= null){
//                        progressBarVerifyOtp.setVisibility(View.VISIBLE);
//                        verifyOtpOnClick.setVisibility(View.INVISIBLE);
//
//                        PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(
//                                getotpbackend,entercodeotp
//                        );
//                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
//                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        progressBarVerifyOtp.setVisibility(View.GONE);
//                                        verifyOtpOnClick.setVisibility(View.VISIBLE);
//
//                                        if(task.isSuccessful()){
//                                            Intent intent =new Intent(getApplicationContext(), HomePage.class);
//                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                            startActivity(intent);
//                                        }
//                                        else {
//                                            Toast.makeText(VerifyOtp.this,"Enter the correct Otp",Toast.LENGTH_SHORT).show();
//                                        }
//
//                                    }
//                                });
//                    }
//                    //                    Toast.makeText(VerifyOtp.this,"otp verified",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(VerifyOtp.this,"Please enter all Numbers",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        numberotpmove();
//
//        TextView resendlabel =findViewById(R.id.resendOtp);
//
//        resendlabel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+91" +getIntent().getStringExtra("mobile"), 60, TimeUnit.SECONDS, VerifyOtp.this,
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//
//                                Toast.makeText(VerifyOtp.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                getotpbackend=newbackendotp;
//                                Toast.makeText(VerifyOtp.this, "OTP sended successfully", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );
//            }
//        });
//
//
//    }
//
//    private void numberotpmove(){
//        inputnumber1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!s.toString().trim().isEmpty()){
//                    inputnumber2.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        inputnumber2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!s.toString().trim().isEmpty()){
//                    inputnumber3.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        inputnumber3.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!s.toString().trim().isEmpty()){
//                    inputnumber4.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        inputnumber4.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!s.toString().trim().isEmpty()){
//                    inputnumber5.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        inputnumber5.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                if (!s.toString().trim().isEmpty()){
//                    inputnumber6.requestFocus();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
}