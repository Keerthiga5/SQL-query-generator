import java.util.Scanner;

public class SqlGenerator {

	public static void main(String[] args) {
		
		int year=0;
		String start_date,end_date;
		String tag="",sql="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the tag");
		tag=sc.nextLine();
		System.out.println("Enter the year");
		year=sc.nextInt();
		for(int mon=1;mon<=12;mon++)
		{
		if(mon<10)
		{
			start_date="'"+year+"-0"+mon+"-01'";
			if(mon<9)
				end_date="'"+year+"-0"+(mon+1)+"-01'";
			else
				end_date="'"+year+"-"+(mon+1)+"-01'";
		}
		else
		{
			start_date="'"+year+"-"+mon+"-01'";
			if(mon<12)
				end_date="'"+year+"-"+(mon+1)+"-01'";
			else
				end_date="'"+(year+1)+"-01-01'";
		}
		if(mon==1)
			sql+="select count(*) as count from Posts where Tags like '%<"+tag+
				">%' AND (Posts.CreationDate>"+start_date+" AND Posts.CreationDate<"+end_date+")";
		else
			sql+="\n UNION ALL select count(*) as count from Posts where Tags like '%<"+tag+
				">%' AND (Posts.CreationDate>"+start_date+" AND Posts.CreationDate<"+end_date+")";
		}
		System.out.println(sql);
	}
}
