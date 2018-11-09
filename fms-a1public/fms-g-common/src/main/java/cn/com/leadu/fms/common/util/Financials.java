package cn.com.leadu.fms.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class Financials {
    private static final NumberFormat nfPercent;
    private static final NumberFormat nfCurrency;

    static {

        // 百分比格式
        nfPercent = NumberFormat.getPercentInstance();
        nfPercent.setMinimumFractionDigits(2);
        nfPercent.setMaximumFractionDigits(4);

        // 货币格式
        nfCurrency = NumberFormat.getCurrencyInstance();
        nfCurrency.setMinimumFractionDigits(2);
        nfCurrency.setMaximumFractionDigits(2);
    }

    /**
     * 显示适当的货币格式
     *
     * @param number
     * @return localized currency string (e.g., "$1,092.20").
     */
    public static String formatCurrency(double number) {
        return nfCurrency.format(number);
    }

    /**
     * 显示适当的百分比格式
     *
     * @param number
     * @return percentage string (e.g., "7.00%").
     */
    public static String formatPercent(double number) {
        return nfPercent.format(number);
    }

    /**
     * 将字符串转为double
     *
     * @param s
     * @return <code>double</code> representing percentage as a decimal.
     * @throws ParseException
     *             if string is not a valid representation of a percent.
     */
    public static double stringToPercent(String s) throws ParseException {
        return nfPercent.parse(s).doubleValue();
    }

    /**
     *
     * @param rate 年利率
     * @param arptr 现金流
     * @return
     * @throws IllegalArgumentException
     */
    public static double npv(double rate, double[] arptr)     throws IllegalArgumentException{
        if (arptr == null)
        {
          throw new IllegalArgumentException(
            "There exists illegal parameter:arptr");
        }
        double npv = 0.0D;
        double r1 = 1.0D + rate;
        double trate = r1;
        for (int i = 0; i < arptr.length; i++)
        {
          npv += arptr[i] / trate;
          trate *= r1;
        }
        return npv;
     }
    /**
     * pv函数
     * @param Rate 利率
     * @param nPer 期限
     * @param Pmt 未来值租金
     * @param FV 尾款
     * @param Type   0 期末 1:期初
     * @return
     */
    public static double PV(double Rate, int nPer, double Pmt, double FV, boolean Type)
    {
        double ann = Math.pow(1 + Rate, nPer);
        return (FV + Pmt * (1 + (Type ? Rate : 0)) * ((ann - 1) / Rate)) / ann;
    }
    
    /** 
     * 实际利率法 
     * @param pv 现值 
     * @param pmt  未来值租金
     * @param nPer 期数
     * @return 利率 
     */  
    public static double rate(double pv,double pmt,int nPer){ 
    	int cnt=200;int ina=10;
        double rate = 1,x,jd = 0.1,side = 0.1,i = 1;  
        do{  
            x = pv/pmt - (Math.pow(1+rate, nPer)-1)/(Math.pow(rate+1, nPer)*rate);  
            if(x*side>0){side = -side;jd *=10;}  
            rate += side/jd;  
        }while(i++<cnt&&Math.abs(x)>=1/Math.pow(10, ina));  
        if(i>cnt)return Double.NaN;  
        return rate;  
    }  
    /**
     * Emulates Excel/Calc's PMT(interest_rate, number_payments, PV, FV, Type)
     * function, which calculates the mortgage or annuity payment / yield per
     * period.
     *
     * @param r
     *            - 利率 期利率
     * @param nper
     *            - 总支付/期数.
     * @param pv
     *            - 融资金额
     * @param fv
     *            - 尾款
     * @param type
     *            - 付款时间 0 期末 1:期初.
     * @return <code>double</code> representing periodic payment amount.
     */
    public static double pmt(double r, int nper, double pv, double fv, int type) {

        // pmt = r / ((1 + r)^N - 1) * -(pv * (1 + r)^N + fv)
        double pmt = 0.0;
        if(r==0.0){
        	pmt=-(pv+fv)/nper;
        }else{
        	pmt=r / (Math.pow(1 + r, nper) - 1)* -(pv * Math.pow(1 + r, nper) + fv);
        }


        // account for payments at beginning of period versus end.
        if (type == 1)
            pmt /= (1 + r);

        // return results to caller.
        return pmt;
    }

    /**
     * Overloaded pmt() call omitting type, which defaults to 0.
     *
     * @see #pmt(double, int, double, double, int)
     */
    public static double pmt(double r, int nper, double pv, double fv) {
        return pmt(r, nper, pv, fv, 0);
    }

    /**
     * Overloaded pmt() call omitting fv and type, which both default to 0.
     *
     * @see #pmt(double, int, double, double, int)
     */
    public static double pmt(double r, int nper, double pv) {
        return pmt(r, nper, pv, 0);
    }

    /**
 	   基于固定利率及等额分期付款方式 返回某项投资的未来值
     * @param r
     *            - 每一期的利率
     * @param nper
     *            - 贷款期数.
     * @param c
     *            - periodic payment amount.
     * @param pv
     *            - 贷款金额.
     * @param type
     *            - 付款时间 0 期末 1:期初.
     * @return <code>double</code> representing future principal value.
     */
    public static double fv(double r, int nper, double c, double pv, int type) {

        // account for payments at beginning of period versus end.
        // since we are going in reverse, we multiply by 1 plus interest rate.
        if (type == 1)
            c *= (1 + r);

        // fv = -(((1 + r)^N - 1) / r * c + pv * (1 + r)^N);
        double fv = 0.0;
        if(r==0.0){
        	fv=0.0;
        }else{
        	fv=-((Math.pow(1 + r, nper) - 1) / r * c + pv* Math.pow(1 + r, nper));
        }

        // return results to caller.
        return fv;
    }

    /**
     * Overloaded fv() call omitting type, which defaults to 0.
     *
     * @see #fv(double, int, double, double, int)
     */
    public static double fv(double r, int nper, double c, double pv) {
        return fv(r, nper, c, pv);
    }

    /**
		指定在一段时间内对定期定额支付且利率固定的年金所支付的利息值。
     *
     * @param r
     *            -  为各期利率
     * @param per
     *            - 用于计算其利息数额的期数，必须在 1 到 nper 之间。
     * @param nper
     *            - 为总投资期，即该项投资的付款期总数。
     * @param pv
     *            - 为现值，即从该项投资开始计算时已经入帐的款项，或一系列未来付款的当前值的累积和，也称为本金。
     * @param fv
     *            - 为未来值，或在最后一次付款后希望得到的现金余额。如果省略 fv，则假设其值为零（例如，一笔贷款的未来值即为零）。
     * @param type
     *            -  数字 0 或 1，用以指定各期的付款时间是在期初还是期末。如果省略 type，则假设其值为零
     * @return <code>double</code> representing interest portion of payment.
     *
     * @see #pmt(double, int, double, double, int)
     * @see #fv(double, int, double, double, int)
     */
    public static double ipmt(double r, int per, int nper, double pv,
            double fv, int type) {

        // Prior period (i.e., per-1) balance times periodic interest rate.
        // i.e., ipmt = fv(r, per-1, c, pv, type) * r
        // where c = pmt(r, nper, pv, fv, type)
        double ipmt = fv(r, per - 1, pmt(r, nper, pv, fv, type), pv, type) * r;

        // account for payments at beginning of period versus end.
        if (type == 1)
            ipmt /= (1 + r);

        // return results to caller.
        return ipmt;
    }

    /**
     * 指定在定期定额支付且利率固定的年金的指定期间内的本金偿付额。
     *
     * @param r
     *            - periodic interest rate represented as a decimal.
     * @param per
     *            - period (payment number) to check value at.
     * @param nper
     *            - number of total payments / periods.
     * @param pv
     *            - present value -- borrowed or invested principal.
     * @param fv
     *            - future value of loan or annuity.
     * @param type
     *            - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing principal portion of payment.
     *
     * @see #pmt(double, int, double, double, int)
     * @see #ipmt(double, int, int, double, double, int)
     */
    public static double ppmt(double r, int per, int nper, double pv,
            double fv, int type) {
    	//System.out.println(pmt(r, nper, pv, fv, type));
    	//System.out.println(ipmt(r, per, nper, pv, fv, type));
        return pmt(r, nper, pv, fv, type) - ipmt(r, per, nper, pv, fv, type);
    }
    /**
     * 获取内部收益率
     * 百分制 年利率
     * @param cashFlows
     * @return
     */

    public static  double getIRR(final double[] cashFlows){
    	double estimatedResult = 40.5;
    	double d = 0.0;
        for(int i=0;i<cashFlows.length;i++){
        	d+=cashFlows[i];
        }
        if(d<0){
        	estimatedResult=0.1;
        }
    	double irr= getIRR(cashFlows, estimatedResult);
    	irr=irr*100*12;
    	irr=irr<0.0001?0.00:irr;
    	return irr;
    }
    /**
     * 内部收益率
     * @param cashFlows
     * @param estimatedResult
     * @return
     */

    public static  double getIRR(final double[] cashFlows,final double estimatedResult) {

		double result = Double.NaN;

		if (cashFlows != null && cashFlows.length > 0) {
			if (cashFlows[0] != 0.0) {
				final double noOfCashFlows = cashFlows.length;

				double sumCashFlows = 0.0;
				int noOfNegativeCashFlows = 0;
				int noOfPositiveCashFlows = 0;
				for (int i = 0; i < noOfCashFlows; i++) {
					sumCashFlows += cashFlows[i];
					if (cashFlows[i] > 0) {
						noOfPositiveCashFlows++;
					} else if (cashFlows[i] < 0) {
						noOfNegativeCashFlows++;
					}
				}

				if (noOfNegativeCashFlows > 0 && noOfPositiveCashFlows > 0) {
					double irrGuess = 0.1;
					if (!Double.isNaN(estimatedResult)) {
						irrGuess = estimatedResult;
						if (irrGuess <= 0.0)
							irrGuess = 0.5;
					}

					double irr = 0.0;
					if (sumCashFlows < 0) {
						irr = -irrGuess;
					} else {
						irr = irrGuess;
					}

					final double minDistance = 0.000000123031;//0.000000123031

					final double cashFlowStart = cashFlows[0];
					final int maxIteration = 100;
					boolean wasHi = false;
					double cashValue = 0.0;
					for (int i = 0; i <= maxIteration; i++) {
						cashValue = cashFlowStart;
						for (int j = 1; j < noOfCashFlows; j++) {
							cashValue += cashFlows[j] / Math.pow(1.0 + irr, j);
						}
						if (Math.abs(cashValue) < 0.01) {
							result = irr;
							break;
						}
						if (cashValue > 0.0) {
							if (wasHi) {
								irrGuess /= 2;
							}

							irr += irrGuess;

							if (wasHi) {
								irrGuess -= minDistance;
								wasHi = false;
							}

						} else {
							irrGuess /= 2;
							irr -= irrGuess;
							wasHi = true;
						}
						if (irrGuess <= minDistance) {
							result = irr;
							break;
						}
					}
				}
			}
		}
		return result;
	}

	/**我的还款计划表fms项目
	 * @param finTotal  融资金额
	 * @param finalAmount  尾付金额
	 * @param finPeriodType  融资期限（月）
	 * @param repayRate  还款频率
	 * @param intrstRate  年利率
	 * @param repayMode  还款方式 1  “等额本金” 2 “等额本息” 3 “5050分期收取” 4 5050一次性收取
	 * @param repayDay  还款日
	 * @param rentPayMode 租金支付模式
	 * @return System.out.println([][=0]"首期租金-->利息总额-->租金总和");
	 * @return System.out.println([][>0]"还款日期-->租金-->本金-->利息-->剩余本金-->剩余本金");
	 */

	public static String[][] findmyrepaymentplan(BigDecimal finTotal, BigDecimal finalAmount, String finPeriodType, String repayRate, BigDecimal intrstRate, String repayMode, String repayDay, String rentPayMode) {
		return findmyrepaymentplan(finTotal.doubleValue(),
				finalAmount.doubleValue(),
				Integer.valueOf(finPeriodType),
				Integer.valueOf(repayRate), intrstRate.doubleValue(),
				repayMode, Integer.valueOf(repayDay), Integer.valueOf(rentPayMode)
				);
	}

	/**我的还款计划表fms项目
	 * @param finTotal  融资金额
	 * @param annualAmount  年供金额
	 * @param finPeriodType  融资期限（月）
	 * @param repayRate  还款频率
	 * @param intrstRate  年利率
	 * @param repayMode  还款方式  2 “等额本息”
	 * @param repayDay  还款日
	 * @param rentPayMode 租金支付模式 1-期初，0-期末
	 * @return System.out.println([][=0]"首期租金-->利息总额-->租金总和");
	 * @return System.out.println([][>0]"还款日期-->租金-->本金-->利息-->剩余本金-->期利率");
	 */

	public static String[][] findmyrepaymentplanAnnual(BigDecimal finTotal,  BigDecimal annualAmount, String finPeriodType, String repayRate, BigDecimal intrstRate, String repayMode, String repayDay, String rentPayMode) {
		String[][] repaySked = new String[100][100];
		String skmonth,repayDate;
		//根据规则得出首期还款月
		if(rentPayMode.equals("0")){
			skmonth= DateUtils.getNextMonth();//下个收款月份
			repayDate=DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
		} else {
			if(Integer.valueOf(repayDay) > Integer.valueOf(DateUtils.getCurrentDay())){
				skmonth= DateUtils.getNowDateStr(DateUtils.formatStr_yyyy+DateUtils.formatStr_mm);//当月
			}else{
				skmonth= DateUtils.getNextMonth();//下个收款月份
			}
			repayDate=DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
		}

		//计算租金
		//直租年供的场合
		double customerInterestRate = intrstRate.doubleValue();
		DecimalFormat df = new DecimalFormat("0.0000");
		double sumCustomerInterestRate = 0.0;
		//期数
		int loanTerm = Integer.valueOf(finPeriodType)/Integer.valueOf(repayRate);
		//初始化rate
		double rate = 0.0;
		for (int i=1;i<loanTerm;i++){
			if (loanTerm == 36){
				if (i <= 3){
					rate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -(i*12))));
				}
				if (i != 12 && i != 24 && i != 36) {
					sumCustomerInterestRate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -i)));
				}
			} else if(loanTerm == 48){
				if (i <= 4){
					rate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -(i*12))));
				}
				if (i != 12 && i != 24 && i !=36 && i != 48) {
					sumCustomerInterestRate += Double.parseDouble(df.format(Math.pow((1 + customerInterestRate/12), -i)));
				}
			}
		}
		BigDecimal M16 = CommonUtils.TrimBigDecimal(annualAmount.multiply(new BigDecimal(rate)));
		BigDecimal monthlySupply = CommonUtils.roundUpBigDecimal(BigDecimalUtils.divide(
				CommonUtils.TrimBigDecimal(finTotal).subtract(M16), new BigDecimal(sumCustomerInterestRate), 0));

		//贷款利息=月供*(贷款期数-年供期数) + 年供*年供期数 - 融资额
		//年供期数=贷款期限/12
		BigDecimal amount1 = CommonUtils.TrimBigDecimal(monthlySupply)
				.multiply(new BigDecimal(loanTerm).subtract(BigDecimalUtils.divide(new BigDecimal(loanTerm), new BigDecimal("12"), 0)));
		BigDecimal amount2 = annualAmount.multiply(BigDecimalUtils.divide(new BigDecimal(loanTerm), new BigDecimal("12"),0));
		BigDecimal loanInterest = CommonUtils.roundUpBigDecimal(amount1.add(amount2).subtract(finTotal));
		//首期租金-->利息总额-->租金总和
		repaySked[0][0] = monthlySupply.toString();
		repaySked[0][1] = loanInterest.toString();
		repaySked[0][2] = amount1.add(amount2).toString();

		//剩余本金
		BigDecimal restPrincipal = new BigDecimal("0");
		BigDecimal intrestSum = new BigDecimal("0");
		BigDecimal rent;
		//月利率
		BigDecimal monthRate = intrstRate.divide(new BigDecimal("12"), BigDecimal.ROUND_HALF_UP, 2);
		for (int i=1;i<=loanTerm;i++){
			if(i==1){
				restPrincipal = finTotal;
			}
			//还款日期
			repaySked[i][0] = repayDate;
			//租金
			//每一年的最后一期，年供
			if(i%12 ==0){
				rent = CommonUtils.TrimBigDecimal(annualAmount);
				repaySked[i][1] = rent.toString();
			}else {
				rent = CommonUtils.TrimBigDecimal(monthlySupply);
				repaySked[i][1] = rent.toString();
			}
			//利息=剩余本金*利率
			BigDecimal interest = BigDecimalUtils.divide(restPrincipal.multiply(intrstRate), new BigDecimal("12"), 0);
			//本金 = 租金-利息
			BigDecimal principal = rent.subtract(interest);

			if(i<loanTerm){
				//租金
				repaySked[i][3] = interest.toString();
				//本金
				repaySked[i][2] = principal.toString();
				//剩余本金 = 剩余本金-本金
				restPrincipal = restPrincipal.subtract(principal);
				repaySked[i][4] = restPrincipal.toString();
			}else{
				repaySked[i][3] = loanInterest.subtract(intrestSum).toString();
				//最后一期本金 = 剩余本金
				repaySked[i][2] = restPrincipal.toString();
				//剩余本金 = 0
				repaySked[i][4] = "0";
			}

			//期利率-月利率
			repaySked[i][5] = monthRate.toString();
			//利息合计
			intrestSum = intrestSum.add(interest);
			//下一期日期
			skmonth= DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(repayDate), Integer.valueOf(repayRate))).substring(0, 6);//下个收款月份
			repayDate = DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));

		}

		return repaySked;
	}
	/**我的还款计划表fms项目
	 * @param finTotal  融资金额
	 * @param annualAmount  年供金额
	 * @param finPeriodType  融资期限（月）
	 * @param repayRate  还款频率
	 * @param irr  年利率
	 * @param repayMode  还款方式  2 “等额本息”
	 * @param repayDay  还款日
	 * @param rentPayMode 租金支付模式 1-期初，0-期末
	 * @return System.out.println([][=0]"首期租金");
	 * @return System.out.println([][>0]"还款日期-->租金-->本金-->利息-->剩余本金-->期利率");
	 */

	public static String[][] findmyrepaymentplanAnnualByIrr(BigDecimal finTotal,  BigDecimal annualAmount, String finPeriodType, String repayRate,
															BigDecimal irr, String repayMode, String repayDay, String rentPayMode, double[] rentList) {
		String[][] repaySked = new String[100][100];
		String skmonth,repayDate;
		//根据规则得出首期还款月
		if(rentPayMode.equals("0")){
			skmonth= DateUtils.getNextMonth();//下个收款月份
			repayDate=DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
		} else {
			if(Integer.valueOf(repayDay) > Integer.valueOf(DateUtils.getCurrentDay())){
				skmonth= DateUtils.getNowDateStr(DateUtils.formatStr_yyyy+DateUtils.formatStr_mm);//当月
			}else{
				skmonth= DateUtils.getNextMonth();//下个收款月份
			}
			repayDate=DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
		}

		//期数
		int loanTerm = Integer.valueOf(finPeriodType)/Integer.valueOf(repayRate);
		//初始化rate
		double rate = 0.0;

		//首期租金-->利息总额-->租金总和
		repaySked[0][0] = String.valueOf(rentList[0]);

		//剩余本金
		BigDecimal restPrincipal = new BigDecimal("0");
		BigDecimal intrestSum = new BigDecimal("0");
		BigDecimal rent ;
		//月利率
		BigDecimal monthRate = irr.divide(new BigDecimal("12"), BigDecimal.ROUND_HALF_UP, 2);
		for (int i=1;i<=loanTerm;i++){
			if(i==1){
				restPrincipal = finTotal;
			}
			repaySked[i][1] = String.valueOf(rentList[i-1]);
			rent = new BigDecimal(rentList[i-1]);
			//还款日期
			repaySked[i][0] = repayDate;
			//租金

			//利息=剩余本金*利率
			BigDecimal interest = BigDecimalUtils.divide(restPrincipal.multiply(irr), new BigDecimal("12"), 0);
			//本金 = 租金-利息
			BigDecimal principal = rent.subtract(interest);

			if(i<loanTerm){
				//租金
				repaySked[i][3] = interest.toString();
				//本金
				repaySked[i][2] = principal.toString();
				//剩余本金 = 剩余本金-本金
				restPrincipal = restPrincipal.subtract(principal);
				repaySked[i][4] = restPrincipal.toString();
			}else{
				repaySked[i][3] = interest.toString();
				//最后一期本金 = 剩余本金
				repaySked[i][2] = restPrincipal.toString();
				//剩余本金 = 0
				repaySked[i][4] = "0";
			}

			//期利率-月利率
			repaySked[i][5] = monthRate.toString();
			//利息合计
			intrestSum = intrestSum.add(interest);
			//下一期日期
			skmonth= DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(repayDate), Integer.valueOf(repayRate))).substring(0, 6);//下个收款月份
			repayDate = DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));

		}

		return repaySked;
	}


	/**我的还款计划表
     * @param dkje  融资金额
     * @param wfje  尾付金额
     * @param hkqx  还款期数（月）
     * @param hkpl  还款频率
     * @param lilv  年利率
     * @param hkfs  还款方式 1  “等额本金” 2 “等额本息” 3 “5050分期收取” 4 5050一次性收取
     * @param hkri  还款日
	 * @param zfms  支付模式 0 “期末支付”  1 “期初支付”
     * @return System.out.println([][=0]"首期租金-->利息总额-->租金总和");
     * @return System.out.println([][>0]"还款日期-->租金-->本金-->利息-->剩余本金-->期利率");
     */
    public static  String[][] findmyrepaymentplan(double dkje,double wfje,int hkqx,int hkpl,double lilv,String hkfs,int hkri, int zfms){
    	String[][] rmp = new String[100][100];
		String skmonth="";
		String skrq="";
		if(zfms == 0){
			skmonth= DateUtils.getNextMonth();//下个收款月份
//    	String skrq = DateUtil.getNextMonth()+(hkri<10?"0"+hkri:(hkri+""));	//还款日期
			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
		} else {
			if(hkri > Integer.valueOf(DateUtils.getCurrentDay())){
				skmonth= DateUtils.getNowDateStr(DateUtils.formatStr_yyyy+DateUtils.formatStr_mm);//当月
			}else{
				skmonth= DateUtils.getNextMonth();//下个收款月份
			}
			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
		}

    	double zujinze = 0.0;//费用总支付
    	double lixize = 0.0;//利息总额
        if(hkfs.equals("1")){
    		double bj = 0.0;
    		double sybj=dkje;
    		bj=CommonUtils.round2((dkje-wfje)/(hkqx/hkpl));
    		double ce = bj*(hkqx/hkpl)-(dkje-wfje);
    		for(int i=1;i<=hkqx/hkpl;i++){
    			double lx = CommonUtils.round2(sybj*((lilv/12)*hkpl));
    			double zj = CommonUtils.round2(bj+lx);
    			rmp[i][0]=skrq;	//还款日期
    			rmp[i][1]=zj+"";												//租金
    			rmp[i][2]=bj+"";												//本金
    			rmp[i][3]=lx+"";												//利息
    			if(i==hkqx/hkpl){
    				zj=CommonUtils.round2(bj+lx+wfje-ce);
    				rmp[i][1]=zj+"";											//租金
    				rmp[i][2]=CommonUtils.round2(bj-ce)+"";						//本金
    				sybj=CommonUtils.round2(sybj-bj-wfje+ce);
        			rmp[i][4]=sybj+"";											//剩余本金
    			}else{
    				sybj=sybj-bj;
        			rmp[i][4]=CommonUtils.round2(sybj)+"";						//剩余本金
    			}

    			if(i==1){
    				rmp[0][0] =zj+"";//首期租金
    			}
    			rmp[i][5]=(lilv/12)*hkpl+"";												//期利率
    			skmonth= DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(skrq), hkpl)).substring(0, 6);//下个收款月份
    			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
//    			skrq=DateUtil.getStringDate(DateUtil.getAddMonth(DateUtil.getDateForString(skrq), hkpl));

    			lixize+=lx;
    			zujinze+=zj;
    		}
    	}
    	if(hkfs.equals("2")||hkfs.equals("3")||hkfs.equals("4")){
    		double zj = CommonUtils.round0(pmt((lilv/12)*hkpl, hkqx/hkpl, -dkje, wfje, zfms));
    		rmp[0][0] =zj+"";//首期租金
    		double sybj=dkje;
    		for(int i=1;i<=hkqx/hkpl;i++){
    			double bj = CommonUtils.round2(ppmt((lilv/12)*hkpl,i, hkqx/hkpl, -dkje, wfje, 0));
    			double lx = CommonUtils.round2(zj-bj);
    			rmp[i][0]=skrq;	//还款日期
    			rmp[i][1]=zj+"";												//租金
    			rmp[i][2]=bj+"";												//本金
    			rmp[i][3]=lx+"";												//利息
    			if(i==hkqx/hkpl){
    				bj =sybj;
    				zj = CommonUtils.round0(zj+wfje);
        			lx = CommonUtils.round2(zj-bj);
        			rmp[i][0]=skrq;	//还款日期
        			rmp[i][1]=zj+"";						//租金
        			rmp[i][2]=bj+"";												//本金
        			rmp[i][3]=lx+"";												//利息
        			sybj=CommonUtils.round2(sybj-bj);
        			rmp[i][4]=sybj+"";												//剩余本金
    			}else{
    				sybj=CommonUtils.round2(sybj-bj);
        			rmp[i][4]=sybj+"";												//剩余本金
    			}
    			rmp[i][5]=(lilv/12)*hkpl+"";													//期利率
    			skmonth=DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(skrq), hkpl)).substring(0, 6);//下个收款月份
    			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
//    			skrq=DateUtil.getStringDate(DateUtil.getAddMonth(DateUtil.getDateForString(skrq), hkpl));

    			lixize+=lx;
    			zujinze+=CommonUtils.round2(zj);

    			if(i==hkqx/hkpl&&lilv==0.0){
    				if(zujinze!=dkje){
        				double zujinc = CommonUtils.round2(dkje-zujinze);
        				rmp[i][1]=zj+zujinc+"";						//租金
        				rmp[i][3]=lx+zujinc+"";						//利息
        				lixize=lixize+zujinc;
        		    	zujinze=zujinze+zujinc;
        			}
    			}

    		}
    	}
    	rmp[0][1]=CommonUtils.round2(lixize)+"";rmp[0][2]=CommonUtils.round2(zujinze)+"";
    	return rmp;
    }

    /**我的财务还款计划表
     * @param dkje  融资金额
     * @param wfje  尾付金额
     * @param hkqx  还款期数（月）
     * @param hkpl  还款频率
     * @param lilv  年利率
     * @param hkfs  还款方式  “等额本息” “等额本金” “5050一次性收” “5050分期收”
     * @param hkri  还款日
     * @param zjarr 每期租金组合 按期数排序
     * @return
     */
    public static  String[][] findmyrepaymentplanByirr(double dkje,double wfje,int hkqx,int hkpl,double lilv,String hkfs,int hkri,double []zjarr){
    	String[][] rmp = new String[100][100];
//    	String skrq = DateUtil.getNextMonth()+(hkri<10?"0"+hkri:(hkri+""));	//还款日期
    	String skmonth=DateUtils.getNextMonth();//下个收款月份
    	String skrq=DateUtils.getNextDayByDay(skmonth, hkri);
        if(hkfs.equals("1")){//等额本金
    		double bj = 0.0;
    		double sybj=dkje;
    		bj=CommonUtils.round2((dkje-wfje)/(hkqx/hkpl));
    		double ce = bj*(hkqx/hkpl)-(dkje-wfje);
    		for(int i=1;i<=hkqx/hkpl;i++){
    			double lx = CommonUtils.round2(zjarr[i-1])-bj;
    			rmp[i][0]=skrq;	//还款日期
    			rmp[i][1]=CommonUtils.round2(zjarr[i-1])+"";						//租金
    			rmp[i][2]=bj+"";												//本金
    			rmp[i][3]=lx+"";												//利息
    			if(i==hkqx/hkpl){
    				bj=CommonUtils.round2(bj-ce+wfje);
    				lx=CommonUtils.round2(zjarr[i-1])-bj;
    				rmp[i][2]=bj+"";						//本金
    				rmp[i][3]=lx+"";			//利息
    				sybj=CommonUtils.round2(sybj-bj);
        			rmp[i][4]=sybj+"";											//剩余本金
    			}else{
    				sybj=sybj-bj;
        			rmp[i][4]=CommonUtils.round2(sybj)+"";
    			}

    			if(i==1){
    				rmp[0][0] =CommonUtils.round2(bj+lx)+"";//首期租金
    			}
    			rmp[i][5]=lx/(sybj+bj)*100+"";							   //期利率
//    			skrq=DateUtil.getStringDate(DateUtil.getAddMonth(DateUtil.getDateForString(skrq), hkpl));
    			skmonth=DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(skrq), hkpl)).substring(0, 6);//下个收款月份
    			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
    		}
    		return rmp;
    	}
    	if(hkfs.equals("2")||hkfs.equals("3")||hkfs.equals("4")){//等额本金 3-5050分期收取,4-5050一次性收取 

    		rmp[0][0] =zjarr[0]+"";//首期租金
    		double sybj=dkje;
    		for(int i=1;i<=hkqx/hkpl;i++){
    			double zj = zjarr[i-1];

    			double bj = CommonUtils.round2(ppmt((lilv/12)*hkpl,i, hkqx/hkpl, -dkje, wfje, 0));
    			double lx = CommonUtils.round2(zj-bj);
    			rmp[i][0]=skrq;	//还款日期
    			rmp[i][1]=zj+"";												//租金
    			rmp[i][2]=bj+"";												//本金
    			rmp[i][3]=lx+"";												//利息
    			if(i==hkqx/hkpl){
    				bj =sybj;
    				zj = CommonUtils.round2(zj);
        			lx = CommonUtils.round2(zj-bj);
        			rmp[i][0]=skrq;	//还款日期
        			rmp[i][1]=zj+"";						//租金
        			rmp[i][2]=bj+"";												//本金
        			rmp[i][3]=lx+"";												//利息
        			sybj=CommonUtils.round2(sybj-bj);
        			rmp[i][4]=sybj+"";												//剩余本金
    			}else{
    				sybj=CommonUtils.round2(sybj-bj);
        			rmp[i][4]=sybj+"";												//剩余本金
    			}
    			rmp[i][5]=(lilv/12)*hkpl+"";										//期利率
//    			skrq=DateUtil.getStringDate(DateUtil.getAddMonth(DateUtil.getDateForString(skrq), hkpl));
    			skmonth=DateUtils.getStringDate(DateUtils.getAddMonth(DateUtils.getDateForString(skrq), hkpl)).substring(0, 6);//下个收款月份
    			skrq=DateUtils.getNextDayByDay(skmonth, hkri);
    		}
    	}
    	return rmp;
    }

    public static void main(String[] args) {
    	double[] aa = new double[30];
    	 aa[0] = -311100.00;
    	 aa[1] = 26206.71;
    	 aa[2] = 26206.71;
    	 aa[3] = 26206.71;
    	 aa[4] = 26206.71;
    	 aa[5] = 26206.71;
    	 aa[6] = 26206.71;
    	 aa[7] = 26206.71;
    	 aa[8] = 26206.71;
    	 aa[9] = 26206.71;
    	 aa[10] = 26206.71;
    	 aa[11] = 26206.71;
    	 aa[12] = 26206.71;
    	 String [][] mypaln =Financials.findmyrepaymentplan(162000, 13500, 24, 1, 0.1288, "2", 5, 0);

    	 System.out.println(mypaln[0][0]);
//    	System.out.println("NPV---------------"+npv(0.0866/12,aa));
 //		¥2,783.97
//    	System.out.println("PV---------------#"+PV(0.0866/12,36,8641.67,0.0,false));
//    	System.out.println("RATE---------------#"+CommonUtil.round4(rate(123830.00,5304.85,24)*12+0.00005)*100);
    }
}