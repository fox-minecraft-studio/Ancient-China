package com.fox.ancientchina.core.time.calendar;

import com.fox.ancientchina.core.api.ISerializableData;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 农历定义
 * @author yaesey
 */
public class Calendar {
    private int year;
    private int branch,stem;

    private int month,day;

    private boolean isNextMonthALeapMonth;
    private boolean doesNextMonthHasTwoJieQi;

    public static final Calendar BEGIN_CALENDAR = new Calendar(2020,12,7,7,1);


    public Calendar(int year,int month,int day,int stem,int branch) {
        this.year = year;
        this.stem = stem;
        this.branch = branch;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public String getYearString() {
        return nameOfStems[stem - 1] + nameOfBranches[branch - 1];
    }

    public String getShengXiao() {
        return nameOfShengXiao[branch - 1];
    }

    //天干
    private String[] nameOfStems = {"甲","乙","丙","丁","戊","已","庚","辛","壬","癸"};
    //地支
    private String[] nameOfBranches = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
    //生肖
    private String[] nameOfShengXiao = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
}
