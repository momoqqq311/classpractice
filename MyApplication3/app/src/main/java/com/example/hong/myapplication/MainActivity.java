package com.example.hong.myapplication;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
    }

    public void onclick(View v) {
        if (v.getId() == R.id.button) {
            Toast.makeText(getApplicationContext(), "일반 메세지 창입니다.", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.button2) {
            String x = e1.getText().toString();
            String y = e2.getText().toString();
            int num1 = Integer.parseInt(x);
            int num2 = Integer.parseInt(y);
            Toast toastView = Toast.makeText(this, "일반 메세지 창입니다.", Toast.LENGTH_SHORT);
            toastView.setGravity(Gravity.LEFT | Gravity.TOP, num1, num2);
            toastView.show();
        } else if (v.getId() == R.id.button3) {
            View view = getLayoutInflater().inflate(R.layout.mytoast, null);
            TextView msg = (TextView) view.findViewById(R.id.textView);
            msg.setText("레이아웃으로 만든 토스트 창입니다");
            Toast toastView = new Toast(this);
            String x = e1.getText().toString();
            String y = e2.getText().toString();
            int num1 = Integer.parseInt(x);
            int num2 = Integer.parseInt(y);
            toastView.setDuration(Toast.LENGTH_SHORT);
            toastView.setGravity(Gravity.CENTER, num1, num2);
            toastView.setView(view);
            toastView.setView(view);
            toastView.show();
        } else if (v.getId() == R.id.button4) {
            Snackbar.make(v, "Message", 1000).setAction("ok", new View.OnClickListener() {
                public void onClick(View v) {
                }
            }).show();
        } else if (v.getId() == R.id.button5) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            dlg.setTitle("기본대화상자")
                    .setMessage("이것은 기본 대화상자 입니다.")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", null)
                    .show();

        } else if (v.getId() == R.id.button6) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            String data[] = {"치킨", "피자"};
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setSingleChoiceItems(data, 1, null)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", null)
                    .show();

        } else if (v.getId() == R.id.button7) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            final String data[] = {"치킨", "피자", "짜장", "짬뽕"};
            final boolean checked[] = {true, false, true, false};
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checked[which] = isChecked;
                            String food = "";
                            int j = 0;
                            for (int i = 0; i < checked.length; i++) {
                                if (checked[i] == true) {
                                    food = food+ ","+data[i];
                                }
                            }
                            Toast.makeText(getApplicationContext(), food + "선택되었습니다", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "확인을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();


        } else {
            View diaview = View.inflate(this, R.layout.mytoast, null);
            final EditText et = (EditText)diaview.findViewById(R.id.editText3);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            String data[] = {"치킨", "피자"};
            dlg.setTitle("먹고 싶은 메뉴는?")
                    .setView(diaview)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", null)
                    .show();

    }

}
}
