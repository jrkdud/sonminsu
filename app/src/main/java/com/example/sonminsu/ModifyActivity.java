package com.example.sonminsu;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;



public class ModifyActivity extends AppCompatActivity {
    private EditText et_id, et_pass, et_pass2, et_name, et_email;
    private Button btn_modify;
    private ImageButton eye, eye2, back;
    private boolean isEyeOff = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티 시작시 처음으로 실행되는 생명주기!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_pass2 = findViewById(R.id.et_pass2);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        back = findViewById(R.id.back_btn);
        eye = findViewById(R.id.eye);
        eye2 = findViewById(R.id.eye2);


        //환경설정 버튼
        ImageButton settingsButton = findViewById(R.id.settings_btn);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });


        //back 버튼 이전 화면으로 돌아가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티를 종료합니다. 이 코드가 없으면 이전 액티비티로 돌아갔다가 뒤로 가기 버튼을 누르면 현재 액티비티로 다시 돌아오게 됩니다.
            }
        });

        // 보이기 숨기기 이미지버튼
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEyeOff) {
                    // 비밀번호 보이기
                    eye.setImageResource(R.drawable.eye);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // 비밀번호 숨기기
                    eye.setImageResource(R.drawable.eyeoff);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                isEyeOff = !isEyeOff;
                et_pass.setSelection(et_pass.getText().length()); // 커서를 마지막으로 이동
            }
        });
        eye2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEyeOff) {
                    // 비밀번호 보이기
                    eye2.setImageResource(R.drawable.eye);
                    et_pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // 비밀번호 숨기기
                    eye2.setImageResource(R.drawable.eyeoff);
                    et_pass2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                isEyeOff = !isEyeOff;
                et_pass2.setSelection(et_pass2.getText().length()); // 커서를 마지막으로 이동
            }
        });

        // 회원수정 버튼 클릭 시 수행
        btn_modify = findViewById(R.id.btn_modify);


    }
}
