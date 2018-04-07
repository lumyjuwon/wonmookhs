package wonmookapp.hs.kr.wonmookhs;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.facebook.FacebookSdk.getApplicationContext;

public class LoginFragment extends Fragment implements View.OnClickListener{

    //define view objects
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonSignin;
    TextView textviewSingin;
    TextView textviewMessage;
    TextView textviewFindPassword;
    ProgressDialog progressDialog;
    //define firebase object
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        //initializig firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            //이미 로그인 되었다면 이 액티비티를 종료함
            getActivity().finish();
            startActivity(new Intent(getApplicationContext(), DeveloperActivity.class));
        }
        //initializing views
        editTextEmail = (EditText) rootView.findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) rootView.findViewById(R.id.editTextPassword);
        textviewSingin = (TextView) rootView.findViewById(R.id.textViewSignin);
        textviewMessage = (TextView) rootView.findViewById(R.id.textviewMessage);
        textviewFindPassword = (TextView) rootView.findViewById(R.id.textViewFindpassword);
        buttonSignin = (Button) rootView.findViewById(R.id.buttonSignup);
        progressDialog = new ProgressDialog(getActivity());

        //button click event
        buttonSignin.setOnClickListener(this);
        textviewSingin.setOnClickListener(this);
        textviewFindPassword.setOnClickListener(this);

        return rootView;
    }


    //firebase userLogin method
    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(), "이메일을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(), "비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("로그인중입니다");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            getActivity().finish();
                            startActivity(new Intent(getApplicationContext(), DeveloperActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "회원정보가 일치하지 않습니다", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        if(view == buttonSignin) {
            userLogin();
        }
        if(view == textviewSingin) {
            Toast.makeText(getApplicationContext(), "lumyjuwon@gmail.com으로 연락하시기 바랍니다", Toast.LENGTH_LONG).show();
        }
        if(view == textviewFindPassword) {
            startActivity(new Intent(getActivity(), FindActivity.class));
        }
    }
}