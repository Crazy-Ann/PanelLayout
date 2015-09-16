package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class PanelLayout extends LinearLayout {

    private static String TAG = "GroupLayout";
    private Context mContext;
    private TypedArray mTypedArray;
    private LayoutInflater mLayoutInflater;
    private LinearLayout mGroupContent;
    private LinearLayout mItemContent;

    // Background Attributes

    private int mDefaultBackgroundBorderColor = Color.TRANSPARENT;
    private int mDefaultBackgroundColor = Color.WHITE;
    private int mDefaultSeparatorColor = Color.LTGRAY;
    private boolean mDefaultBorder = true;
    private int mDefaultCornerRadius = 12;

    // Text Attributes

    private int mDefaultLabelTextColor = Color.BLACK;
    private int mDefaultContentTextColor = Color.GRAY;
    private int mDefaultTextSize = 14;

    // Extend Text Attributes
    private int mDefaultExtendLabelTextColor = Color.GRAY;
    private int mDefaultExtendContentTextColor = Color.BLACK;

    public PanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.GroupLayoutAttrs);
        initialize();
        initializeAttrs(mTypedArray);
    }

    private void initialize() {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutInflater.inflate(R.layout.panel_layout, this);
        mGroupContent = (LinearLayout) findViewById(R.id.group_layout);
        mItemContent = (LinearLayout) findViewById(R.id.item_layout);
        mItemContent.setVisibility(View.GONE);
    }

    private void initializeAttrs(TypedArray attrsArray) {
        mDefaultBackgroundColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_backgroundColor, mDefaultBackgroundColor);
        mDefaultBackgroundBorderColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_backgroundBorderColor, mDefaultBackgroundBorderColor);

        mDefaultBorder = attrsArray.getBoolean(R.styleable.GroupLayoutAttrs_withBorder, mDefaultBorder);
        mDefaultSeparatorColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_separatorColor, mDefaultSeparatorColor);

        mDefaultLabelTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_labelTextColor, mDefaultLabelTextColor);
        mDefaultContentTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_contentTextColor, mDefaultContentTextColor);

        mDefaultExtendLabelTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_labelTextColor, mDefaultExtendLabelTextColor);
        mDefaultExtendContentTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_contentTextColor, mDefaultExtendContentTextColor);


        mDefaultTextSize = attrsArray.getDimensionPixelSize(R.styleable.GroupLayoutAttrs_textSizeLayout,
                getResources().getDimensionPixelSize(R.dimen.size_text));


        setBackgroundColor();
        setBackgroundBorderColor();
    }

    public void setBackgroundColor() {
        GradientDrawable mDrawable = new GradientDrawable();
        mDrawable.setColor(mDefaultBackgroundColor);

        // With border
        if (mDefaultBorder != false) {
            mDrawable.setCornerRadius(mDefaultCornerRadius);
        }

        mItemContent.setBackground(mDrawable);
    }

    public void setBackgroundBorderColor() {
        GradientDrawable mDrawable = new GradientDrawable();
        mDrawable.setColor(mDefaultBackgroundBorderColor);

        // With border
        if (mDefaultBorder != false) {
            mDrawable.setCornerRadius(mDefaultCornerRadius);
            mDrawable.setColor(mDefaultBackgroundBorderColor);
            mGroupContent.setPadding(1, 1, 1, 1);
        } else { // Without border
            mDrawable.setColor(mDefaultBackgroundBorderColor);
            mGroupContent.setPadding(0, 1, 0, 1);
        }

        mGroupContent.setBackground(mDrawable);
    }

    /**-------------------------------------------------------------------------------------*/
    /**--------------------------------TEXT LAYOUT------------------------------------------*/

    /**
     *
     * @param label
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label
     * @return TextLayout
     */
    public TextLayout addTextLayout(String label) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @return TextLayout
     */
    public TextLayout addTextLayout(String label, String content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label, String content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label, int content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EDIT TEXT LAYOUT---------------------------------*/

    /**
     *
     * @param label
     * @param content
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(String label, String content) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setContent(content);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(String label) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(int label, String content) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setContent(content);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(int label) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**--------------------------------------------------------------------------*/
    /**------------------------MULTI TEXT LAYOUT---------------------------------*/

    /**
     *
     * @param content
     * @return MultiTextLayout
     */
    public MultiTextLayout addMultiTextLayout(int content) {
        MultiTextLayout mMultiTextLayout = new MultiTextLayout(mContext);
        mMultiTextLayout.setContent(content);
        mMultiTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiTextLayout);

        return mMultiTextLayout;
    }

    /**
     *
     * @param content
     * @return MultiTextLayout
     */
    public MultiTextLayout addMultiTextLayout(String content) {
        MultiTextLayout mMultiTextLayout = new MultiTextLayout(mContext);
        mMultiTextLayout.setContent(content);
        mMultiTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiTextLayout);

        return mMultiTextLayout;
    }

    /**-------------------------------------------------------------------------------*/
    /**------------------------MULTI EDIT TEXT LAYOUT---------------------------------*/

    /**
     * Create MultiEditText
     * @param hint
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     * Create MultiEditText
     * @param hint
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(String hint) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint
     * @param content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint, int content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint
     * @param content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(String hint, int content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint
     * @param content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint, String content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------POPUP LAYOUT-------------------------------------*/

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String content, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String content, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, ArrayList<String> menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param content
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, String[] menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, ArrayList<String> menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, ArrayList<String> menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, ArrayList<String> menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String[] menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String[] menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label
     * @param menu
     * @param icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String[] menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------BUTTON LAYOUT-------------------------------------*/

    /**
     *
     * @param label
     * @param content
     * @param icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(String label, String content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @param icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, int content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label
     * @param content
     * @param icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, String content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label
     * @param icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label
     * @param icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(String label, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------SWITCH LAYOUT-------------------------------------*/

    /**
     *
     * @param label
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label
     * @param check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label
     * @param check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label
     * @param color
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, int color) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     * @param label
     * @param color
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, int color) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label
     * @param color
     * @param check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, int color, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     * @param label
     * @param color
     * @param check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, int color, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------VALIDATOR TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param label label text
     * @param content content text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(String label, String content) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setContent(content);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);


        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(String label) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @param content content text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(int label, String content) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setContent(content);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(int label) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param icon
     * @param label
     * @param content
     * @return ExtendTextLayout
     */
    public ExtendTextLayout addExtendTextLayout(int icon, String label, String content) {
        ExtendTextLayout mExtendTextLayout = new ExtendTextLayout(mContext);
        mExtendTextLayout.setLabel(label);
        mExtendTextLayout.setIcon(icon);
        mExtendTextLayout.setContent(content);
        mExtendTextLayout.setLabelColor(mDefaultExtendLabelTextColor);
        mExtendTextLayout.setContentColor(mDefaultExtendContentTextColor);
        mExtendTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendTextLayout);

        return mExtendTextLayout;
    }

    /**
     *
     * @param icon
     * @param label
     * @param content
     * @return ExtendTextLayout
     */
    public ExtendTextLayout addExtendTextLayout(int icon, int label, String content) {
        ExtendTextLayout mExtendTextLayout = new ExtendTextLayout(mContext);
        mExtendTextLayout.setLabel(label);
        mExtendTextLayout.setIcon(icon);
        mExtendTextLayout.setContent(content);
        mExtendTextLayout.setLabelColor(mDefaultExtendLabelTextColor);
        mExtendTextLayout.setContentColor(mDefaultExtendContentTextColor);
        mExtendTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendTextLayout);

        return mExtendTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND EDIT TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param icon
     * @param label
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, String label) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon
     * @param label
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, int label) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon
     * @param label
     * @param content
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, String label, String content) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setContent(content);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon
     * @param label
     * @param content
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, int label, String content) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setContent(content);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------GROUP LAYOUT-------------------------------------*/


    /**
     *
     * @return View
     */
    public View getLastField() {
        View view = null;
        if (!isEmpty()){
            view =  mItemContent.getChildAt(mItemContent.getChildCount() - 1);
        }
        return view;
    }

    private void identifyObject() {
        if (isEmpty()) {
            mItemContent.setVisibility(View.VISIBLE);
        } else if (getLastField() instanceof TextLayout) {
            ((TextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof EditTextLayout) {
            ((EditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof MultiTextLayout) {
            ((MultiTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof MultiEditTextLayout) {
            ((MultiEditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof PopupLayout) {
            ((PopupLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ButtonLayout) {
            ((ButtonLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof SwitchLayout) {
            ((SwitchLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ValidatorTextLayout) {
            ((ValidatorTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendTextLayout) {
            ((ExtendTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendEditTextLayout) {
            ((ExtendEditTextLayout) getLastField()).showSeparator();
        }
    }

    public void addField(View v) {
        mItemContent.addView(v);
    }

    public void clear() {
        mItemContent.removeAllViewsInLayout();
    }

    /**
     *
     * @return size panel
     */
    public int size() {
        return mItemContent.getChildCount();
    }

    /**
     *
     * @return true if is empty
     */
    public boolean isEmpty() {
        return mItemContent.getChildCount() == 0;
    }

}

