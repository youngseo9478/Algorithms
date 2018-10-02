package empdept;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text> {

	// 출력에 사용할 키밸류 객체
	Text outKey = new Text();
	Text outValue = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		String emp = value.toString();
		// ,로 찢어발겨서 순서대로 문자열 배열에 담겨서 split이 좀 더 편리
		String[] colums = emp.split(",");
		// StringTokenizer st = new StringTokenizer(intputStr, ",");
		String deptno = colums[7];
		String salary = colums[5];

		outKey.set(deptno);
		outValue.set("E," + salary);
		// 출력에 조건을 걸면 filter
		if (Integer.parseInt(salary) > 1000)
			context.write(outKey, outValue);
	}

}
