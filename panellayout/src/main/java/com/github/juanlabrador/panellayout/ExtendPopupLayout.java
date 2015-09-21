package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juanlabrador on 17/09/15.
 */
public class ExtendPopupLayout extends LinearLayout implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private static String TAG = "PopupLayout";
    private Context mContext;
    private LayoutInflater mInflater;
    private TextView mLabel;
    private TextView mContent;
    private ImageView mIcon;
    private ImageView mButton;
    private View mSeparator;
    private PopupMenu mPopup;

    // Menu content
    private int mMenu;
    private ArrayList<String> mCustomMenu;
    private String[] mCustomMenu2;

    // Get item
    private int mItemPosition;
    private String mItemTitle;

    public ExtendPopupLayout(Context context) {
        super(context);
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setLabel(String label){
        mLabel.setText(label);
    }

    public void setContent(String text) {
        mContent.setText(text);
    }

    public void setContent(int text) {
        mContent.setText(text);
    }

    public void setLabel(int label) {
        mLabel.setText(label);
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public void setIconButton(int image){
        mButton.setImageResource(image);
    }

    public void setIcon(int image){
        mIcon.setImageResource(image);
    }

    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    public void setMenu(int menu) {
        mMenu = menu;
    }

    public void setCustomMenu(ArrayList<String> customMenu) {
        mCustomMenu = customMenu;
    }

    public void setCustomMenu(String[] customMenu) {
        mCustomMenu2 = customMenu;
    }

    private void initialize() {
        mInflater.inflate(R.layout.extend_popup_layout, this);
        mLabel = (TextView) findViewById(R.id.extend_text_label);
        mContent = (TextView) findViewById(R.id.extend_content_text);
        mButton = (ImageView) findViewById(R.id.icon_one_button);
        mIcon = (ImageView) findViewById(R.id.icon);
        mButton.setOnClickListener(this);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendPopupLayout)){
            return false;
        } else {
            return true;
        }
    }

    private void showPopupMenu(View view, int menu) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT, 0, R.style.PopupMenu);
        else
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenuInflater().inflate(menu, mPopup.getMenu());
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        mContent.setText(menuItem.getTitle().toString());
        mItemPosition = menuItem.getOrder();
        return true;
    }

    public int getItemPosition() {
        return mItemPosition;
    }

    /**
     * Get item select title
     * @return
     */
    public String getItemTitle() {
        return mItemTitle;
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, String.valueOf(mMenu));
        if (mMenu != 0) {
            showPopupMenu(view, mMenu);
        } else if (mCustomMenu != null) {
            showPopupCustomMenu(view, mCustomMenu);
        } else if (mCustomMenu2 != null) {   // If String[] not null
            showPopupCustomMenu(view, mCustomMenu2);
        }
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void setTextSize(int size) {
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    private void showPopupCustomMenu(View view, ArrayList<String> menu) {
        mCustomMenu = menu;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT, 0, R.style.PopupMenu);
        else
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenu().clear();
        for (int i = 0; i < mCustomMenu.size(); i++) {
            mPopup.getMenu().add(0, 0, i, mCustomMenu.get(i));
        }
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }

    /**
     * Show popup menu with String[] array
     * @param view
     * @param menu
     */
    private void showPopupCustomMenu(View view, String[] menu) {
        mCustomMenu2 = menu;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1)
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT, 0, R.style.PopupMenu);
        else
            mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenu().clear();
        for (int i = 0; i < mCustomMenu2.length; i++) {
            mPopup.getMenu().add(0, 0, i, mCustomMenu2[i]);
        }
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }
}