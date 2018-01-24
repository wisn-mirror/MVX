package com.wisn.mvx.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wisn.mvx.R;
import com.wisn.mvx.demo1.presenter.UserPresenter;
import com.wisn.mvx.demo1.view.IUserView;

public class Demo1Activity extends AppCompatActivity implements View.OnClickListener, IUserView {

    private EditText id;
    private EditText FristName;
    private EditText LastName;
    private Button save;
    private Button load;

    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        initView();
    }

    private void initView() {
        id = (EditText) findViewById(R.id.id);
        FristName = (EditText) findViewById(R.id.FristName);
        LastName = (EditText) findViewById(R.id.LastName);
        save = (Button) findViewById(R.id.save);
        load = (Button) findViewById(R.id.load);

        save.setOnClickListener(this);
        load.setOnClickListener(this);
        userPresenter = new UserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                submit();
                break;
            case R.id.load:
                userPresenter.loadUser(getId());
                break;
        }
    }

    private void submit() {
        // validate
        String idString = id.getText().toString().trim();
        if (TextUtils.isEmpty(idString)) {
            Toast.makeText(this, "id", Toast.LENGTH_SHORT).show();
            return;
        }

        String FristNameString = FristName.getText().toString().trim();
        if (TextUtils.isEmpty(FristNameString)) {
            Toast.makeText(this, "FristNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String LastNameString = LastName.getText().toString().trim();
        if (TextUtils.isEmpty(LastNameString)) {
            Toast.makeText(this, "LastNameString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        userPresenter.saveUser();
    }

    @Override
    public int getId() {
        return Integer.parseInt(id.getText().toString().trim());
    }

    @Override
    public String getFirstName() {
        return FristName.getText().toString();
    }

    @Override
    public String getLastName() {
        return LastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        FristName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        LastName.setText(lastName);
    }
}
