package difficulty1;

import java.util.Scanner;

public class YYYYMMDD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String date = sc.next();
			String year = date.substring(0,4);
			String month = date.substring(4, 6);
			String day = date.substring(6,8);
			System.out.println("#"+tc+" "+check(year,month,day));
		}
		sc.close();
	}
	static String check(String y, String m, String d){
		int month = Integer.parseInt(m);
		int day = Integer.parseInt(d);
		if(month<1||month>12){
			return "-1";
		}else if(day<1||day>31){
			return "-1";
		}else if(month==4||month==6||month==9||month==11&&day>30){
			return "-1";
		}else if(month==2&&day>28){
			return "-1";
		}else{
			return y+"/"+m+"/"+d;
		}		
	}
}
