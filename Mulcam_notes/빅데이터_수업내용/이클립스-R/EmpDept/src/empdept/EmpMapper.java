package empdept;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpMapper extends Mapper<LongWritable, Text, Text, Text> {

	// ��¿� ����� Ű��� ��ü
	Text outKey = new Text();
	Text outValue = new Text();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		String emp = value.toString();
		// ,�� ����ܼ߰� ������� ���ڿ� �迭�� ��ܼ� split�� �� �� ��
		String[] colums = emp.split(",");
		// StringTokenizer st = new StringTokenizer(intputStr, ",");
		String deptno = colums[7];
		String salary = colums[5];

		outKey.set(deptno);
		outValue.set("E," + salary);
		// ��¿� ������ �ɸ� filter
		if (Integer.parseInt(salary) > 1000)
			context.write(outKey, outValue);
	}

}
