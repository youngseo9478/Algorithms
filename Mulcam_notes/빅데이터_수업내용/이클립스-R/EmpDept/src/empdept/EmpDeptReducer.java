package empdept;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EmpDeptReducer extends Reducer<Text, Text, Text, Text>{

	// K : 10(부서번호)
	// V : {"E,1200", "D,ACCOUNTING,NEW YORK", "E,5000"} //다른 값들이 들어옴
	
	Text outValue = new Text();
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {  //10번 부서는 10번 부서끼리 주루륵 들어올 것이기 때문에 아래서 sum하는건 부서별 연봉합계인것
		
		int sum = 0;
		String dname = null;
		String dloc = null;
		Iterator<Text> iter = values.iterator();
		while(iter.hasNext()){
			String data = iter.next().toString(); 
			//V에 들어올 값 중 어떤 형식의 값일지 모름 (D?,E?)
			String[] colums = data.split(",");
			if(colums[0].equals("D")){
				dname = colums[1];
				dloc = colums[2];
			}else if(colums[0].equals("E")){
				int salary = Integer.parseInt(colums[1]);
				sum = sum+salary;
			}
		}
		
		outValue.set(sum+"\t"+dname+"\t"+dloc);
		context.write(key, outValue);
		
	}
}
