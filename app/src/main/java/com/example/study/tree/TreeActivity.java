package com.example.study.tree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.study.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeActivity extends AppCompatActivity {
    private ListView mListView;
    private NodeTreeAdapter mAdapter;
    private LinkedList<Node> mLinkedList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        mListView = (ListView) findViewById(R.id.id_tree);
        mAdapter = new NodeTreeAdapter(this, mListView, mLinkedList);
        mListView.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        List<Node> data = new ArrayList<>();
        addOne(data);
        List<Node> nodes = NodeHelper.sortNodes(data);
        mLinkedList.addAll(nodes);
        mAdapter.notifyDataSetChanged();
    }

    private void addOne(List<Node> data) {
        //data.add(new Dept(1, 0, "总公司"));//可以直接注释掉此项，即可构造一个森林

        data.add(new Dept(2, 1, "一级部门第一个"));
        data.add(new Dept(21,2,"二级部门第一个"));
        data.add(new Dept(22,2,"二级部门第一个"));

        data.add(new Dept(3,1,"一级部门第二个"));
        data.add(new Dept(31,3,"二级部门第一个"));

        data.add(new Dept(4,1,"三级部门第一个"));
    }

}
