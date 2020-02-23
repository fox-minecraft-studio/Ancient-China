package com.fox.ancientchina.core.time.calendar;

/**
 * 农历定义
 * @author yaesey
 */
public class Calendar {
    private int year;
    private int branch,stem;

    private int month,day;

    private boolean isNextMonthABigMonth = true;               //判断下个月是否为大月
    private boolean doesNextMonthHasTwoJieQi = true;            //判断该月是否有两个中气

    /** 2020.12.27，农历庚子年冬月初七，小月，冬至*/
    public static final Calendar BEGIN_CALENDAR = new Calendar(2020,12,7,7,1);


    public Calendar(int year,int month,int day,int stem,int branch) {
        this.year = year;
        this.stem = stem;
        this.branch = branch;
        this.month = month;
        this.day = day;
    }

    public String getYearString() {
        return nameOfStems[stem - 1] + nameOfBranches[branch - 1];
    }

    public String getShengXiao() {
        return nameOfShengXiao[branch - 1];
    }

    /**
     * <b>注意：每次调用本方法，农历的状态会立即改变<b/>
     */
    public void updateCalendar() {
        this.day = ++day;
        if (this.day > getDaysOfThisMonth()){
            this.day = 1;
            this.month = ++month;
            this.isNextMonthABigMonth = !isNextMonthABigMonth;
        }
        if (this.month > 12){
            this.month = 1;
            this.year = ++year;
            this.stem = ++stem;
            this.branch = ++branch;
        }
        if (this.stem > 12){
            this.stem = 1;
        }if (this.branch > 12){
            this.branch = 1;
        }
    }

    /**
     * 给出这个月的天数
     * @return
     */
    private int getDaysOfThisMonth() {
        if (!isNextMonthABigMonth)
            return 30;
        else
            return 29;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //天干
    private String[] nameOfStems = {"甲","乙","丙","丁","戊","已","庚","辛","壬","癸"};
    //地支
    private String[] nameOfBranches = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
    //生肖
    private String[] nameOfShengXiao = {"鼠","牛","虎","兔","龙","蛇","马","羊","猴","鸡","狗","猪"};
}
