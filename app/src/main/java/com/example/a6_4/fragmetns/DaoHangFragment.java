package com.example.a6_4.fragmetns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.a6_4.R;
import com.example.a6_4.daohang.DaoHang;
import com.example.a6_4.daohang.DaoHangAdapter;
import com.example.a6_4.landscape.landscapeAdapter;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class DaoHangFragment extends Fragment {
    private View view;
    private SearchView searchView;
    private DaoHang[] daoHangs = {new DaoHang("基本租车规则","预定流程，修改订单，取车流程，车辆使用归还"),new DaoHang("预付订单","预付订单规则"),new DaoHang("注册登录","会员注册，找回密码，修改密码"),new DaoHang("事故处理","事故处理，车辆事故处理指引，基本保障服务服务费说明，增值业务"),new DaoHang("其他费用","车辆押金，信用卡托改,超期租赁"),new DaoHang("芝麻信用","免押金租车服务，详细规则，什么是芝麻信用分？"),new DaoHang("友情提示","客服热线，投诉，避开高峰取车还车"),};
    private List<DaoHang> daoHangList = new ArrayList<>();
    private DaoHangAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载系统里面的布局文件
        view = inflater.inflate(R.layout.activity_frag_daohang, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        XBanner banner = getActivity().findViewById(R.id.banner);
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("https://img1.baidu.com/it/u=2366909382,3145439918&fm=26&fmt=auto&gp=0.jpg");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Ffile108.mafengwo.net%2Fs9%2FM00%2F19%2F0C%2FwKgBs1fKgjKAJ1kOAAXN8_JK1rE85.jpeg%3FimageView2%2F2%2Fw%2F530%2Fh%2F8000%2Fq%2F100&refer=http%3A%2F%2Ffile108.mafengwo.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584012&t=78219918d67a5e0f5d319fb65ac3d554");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2F100c0m000000e0a497861.jpg&refer=http%3A%2F%2Fyouimg1.c-ctrip.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584069&t=9de8358b5ccfa3b97743eb2196385b2b");
        imgesUrl.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fs9.sinaimg.cn%2Fmw690%2F001HKgoIzy6Ml06pUBWe8%26690&refer=http%3A%2F%2Fs9.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626584574&t=27de5d9099323502eb2269784eb64141");
        // 为XBanner绑定数据
        banner.setData(imgesUrl,null);//第二个参数为提示文字资源集合
        // XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DaoHangFragment.this).load(imgesUrl.get(position)).into((ImageView) view);
            }
        });

        searchView = (SearchView) getActivity().findViewById(R.id.search_view);
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

        init();
        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView_daohang);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DaoHangAdapter(daoHangList);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        daoHangList.clear();
        //            Random random = new Random();
        //            int index = random.nextInt(landscapes.length);
        //            landscapeList.add(landscapes[index]);
        daoHangList.addAll(Arrays.asList(daoHangs));
    }

}


