package com.miguel_santos.com.example.lgc_thiengo_copia.extras;

import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.URLSpan;

public class URLSpanSemUnderline extends URLSpan {

    public URLSpanSemUnderline(String url) {
        super(url);
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }

}
