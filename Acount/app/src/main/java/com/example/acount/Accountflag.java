package com.example.acount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acount.R;
import dao.FlagDAO;
import model.Tb_flag;

public class Accountflag extends AppCompatActivity {

    private EditText txtFlag;// 创建EditText组件对象
    private Button btnflagSaveButton;// 创建Button组件对象
    private Button btnflagCancelButton;// 创建Button组件对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountflag);

        txtFlag = (EditText) findViewById(R.id.txtFlag);// 获取便签文本框
        btnflagSaveButton = (Button) findViewById(R.id.btnflagSave);// 获取保存按钮
        btnflagCancelButton = (Button) findViewById(R.id.btnflagCancel);// 获取取消按钮
        btnflagSaveButton.setOnClickListener(new View.OnClickListener() {// 为保存按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                String strFlag = txtFlag.getText().toString();// 获取便签文本框的值
                if (!strFlag.isEmpty()) {// 判断获取的值不为空
                    FlagDAO flagDAO = new FlagDAO(Accountflag.this);// 创建FlagDAO对象
                    Tb_flag tb_flag = new Tb_flag(flagDAO.getMaxId() + 1, strFlag);// 创建Tb_flag对象
                    flagDAO.add(tb_flag);// 添加便签信息
                    // 弹出信息提示
                    Toast.makeText(Accountflag.this, "〖新增便签〗数据添加成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Accountflag.this, "请输入便签！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnflagCancelButton.setOnClickListener(new View.OnClickListener() {// 为取消按钮设置监听事件
            @Override
            public void onClick(View arg0) {
                txtFlag.setText("");// 清空便签文本框
            }
        });
    }
}