package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by juanlabrador on 16/09/15.
 */
public class ExtendEditTextLayout extends LinearLayout {

    private LayoutInflater mInflater;
    private TextView mLabel;
    private EditText mContent;
    private ImageView mIcon;
    private View mSeparator;

    public ExtendEditTextLayout(Context context) {
        super(context);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setIcon(int icon) {
        mIcon.setImageResource(icon);
    }

    public void setLabel(String text){
        mLabel.setText(text);
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContent(String text){
        mContent.setText(text);
    }

    public void setLabel(int label) {
        mLabel.setText(label);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setTextSize(float size) {
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setInputType(int input) {
        mContent.setInputType(input);
    }

    public void setMaxLength(int max) {
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(max);
        mContent.setFilters(filterArray);
    }

    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void isPassword(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isNumber(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_CLASS_NUMBER);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isEmail(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isURL(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        mContent.addTextChangedListener(textWatcher);
    }

    private void initialize() {
        mInflater.inflate(R.layout.extend_edit_text_layout, this);
        mLabel = (TextView) findViewById(R.id.extend_text_label);
        mContent = (EditText) findViewById(R.id.extend_edit_text_content);
        mIcon = (ImageView) findViewById(R.id.icon);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public EditText getEditText() {
        return mContent;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendEditTextLayout)){
            return false;
        } else {
            return true;
        }
    }
}
