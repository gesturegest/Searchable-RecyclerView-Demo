package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models;

/**
 * Created with Android Studio
 * User: Xaver
 * Date: 24/05/15
 */
public class ExampleModel implements Comparable<ExampleModel> {

    private final String mText;

    public ExampleModel(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    @Override
    public int compareTo(ExampleModel another) {
        return mText.compareTo(another.mText);
    }

}
