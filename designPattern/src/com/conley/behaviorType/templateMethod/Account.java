package com.conley.behaviorType.templateMethod;

public abstract class Account {
	/**
     * 模板方法，计算利息数额
     * @return    返回利息数额
     */
    public final double calculateInterest(){
        double interestRate = doCalculateInterestRate();//利率
        String accountType = doCalculateAccountType();//账号类型
        double amount = calculateAmount(accountType);//该账号类型下的金额总数
        return amount * interestRate;
    }
    /**
     * 基本方法留给子类实现
     */
    protected abstract String doCalculateAccountType();
    /**
     * 基本方法留给子类实现
     */
    protected abstract double doCalculateInterestRate();
    /**
     * 基本方法，已经实现
     */
    private double calculateAmount(String accountType){
        /**
         * 省略相关的业务逻辑
         */
        return 7243.00;
    }
}
