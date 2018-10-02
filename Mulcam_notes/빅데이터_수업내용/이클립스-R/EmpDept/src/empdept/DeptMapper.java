package empdept;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DeptMapper extends Mapper<LongWritable, Text, Text, Text>{
	
	Text outKey = new Text();
	Text outValue = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		//<10, "D,ACCOUNTING,NEW YORK">으로 출력하도록 작성
		
		String dept = value.toString();
		String[] colums = dept.split(",");
		String deptno = colums[0];
		String dname = colums[1];
		String dloc = colums[2];
		
		outKey.set(deptno);
		outValue.set("D,"+dname+","+dloc);
		context.write(outKey, outValue);
	}
}
