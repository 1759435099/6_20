package com.example.a6_4.daohang;

import android.widget.TextView;

import org.w3c.dom.Text;

public class DaoHang {
    String title_1,title_2;

    public String getTitle_1() {
        return title_1;
    }

    public String getTitle_2() {
        return title_2;
    }

    public DaoHang(String title_1, String title_2) {
        this.title_1 = title_1;
        this.title_2 = title_2;
    }
}
