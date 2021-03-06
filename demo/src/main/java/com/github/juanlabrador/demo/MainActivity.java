package com.github.juanlabrador.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.github.juanlabrador.panellayout.ButtonLayout;
import com.github.juanlabrador.panellayout.PanelLayout;
import com.github.juanlabrador.panellayout.PopupLayout;
import com.github.juanlabrador.panellayout.SwitchLayout;
import com.github.juanlabrador.panellayout.ValidatorTextLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private PanelLayout mPanelLayout;
    private PanelLayout mPanelLayout2;

    private PopupLayout mPopupLayout;

    private String[] country = new String[] {
            "Venezuela",
            "EEUU",
            "Colombia",
    };

    private ArrayList<String> age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = new ArrayList<>();
        for (int i = 1; i <= 20; i++)
            age.add(String.valueOf(i));
        init();
    }

    private void init() {
        mPanelLayout = (PanelLayout) findViewById(R.id.group);
        mPanelLayout.addTextLayout("Name", "Juan Labrador");
        mPanelLayout.addTextLayout("Age", "23");
        mPanelLayout.addTextLayout("Developed by", "Juan Labrador");

        mPanelLayout2 = (PanelLayout) findViewById(R.id.group2);

        mPanelLayout2.addExtendTextLayout(R.mipmap.marker, "Address", "Caracas, VZLA");

        //mPanelLayout2.addSwitchLayout("Switch ON", true);

        /*final ValidatorTextLayout mValidator = mPanelLayout2.addValidatorLayout("Email");

        mValidator.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mValidator.getContent().equals("juan@email.com")) {
                    mValidator.dataCheck();
                } else if (mValidator.getContent().equals("juan@dd.e")) {
                    mValidator.dataError();
                } else {
                    mValidator.dataProgress();
                }
            }
        });*/


        /*SwitchLayout mSwitch = mPanelLayout2.addSwitchLayout("Switch OFF");
        mPanelLayout2.addSwitchLayout("Switch ON Custom Color", Color.CYAN);

        mSwitch.isChecked();
        mSwitch.setChecked(true);*/

        /*mPanelLayout2.addButtonLayout("Phone", "+ 58 424 0000000", R.mipmap.phone);
        ButtonLayout mEmail = mPanelLayout2.addButtonLayout("Email", "juanjavierlabrador@gmail.com", R.mipmap.message);
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mEmail.getContent();*/


        //mPopupLayout = mPanelLayout2.addPopupLayout("Gender", R.menu.menu_gender);

        //mPanelLayout2.addPopupLayout("Country", country);
        //mPanelLayout2.addPopupLayout("Age", age);


        // mPanelLayout2.addMultiEditTextLayout("Write a comment ...");
        //mPassword.isPassword(true);
        //mPassword.isNumber(true);
    }
}
