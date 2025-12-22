package com.bsdl.medium._0341;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = dfs(nestedList);
        index = 0;
    }

    private List<Integer> dfs(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>(nestedList.size());
        for(NestedInteger nestedInteger: nestedList) {
            if(nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            }else {
                list.addAll(dfs(nestedInteger.getList()));
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return list.get(index++);
        }else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}

