package empdept;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class EmpDept extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {
		Job job = Job.getInstance(getConf());

		// job�� ���� �̸�
		job.setJobName("EmpDept");

		// java jar jar���� Ŭ������(�����Լ����ִ�) ���������� �̷����ϸ� ������ ��
		// hadoop jar [jar���ϸ�] [Ŭ������]
		// job�� �����ϴ� Ŭ������ ��������?
		job.setJarByClass(EmpDept.class);

		// ����ϴ� ����Ŭ����
		// job.setMapperClass(WordMapper.class);

		// ����ϴ� ���༭Ŭ����
		job.setReducerClass(EmpDeptReducer.class);

		// job�� �Է����� ����(InputFormat)
		// �γ��� Ȥ�� �ٸ� �Է������� ������ ���ݾ� .. �ϴ� ���� (������ �Ȱ��� ������!)
		// job.setInputFormatClass(TextInputFormat.class);

		// job�� ������� ����(OutputFormat)
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		// job���� �о���� ���� ���'��'
		// ���ۺ��� �Է¹��� ������ �ٸ�.. ���� ����������� ��
		// for (int i = 0; i < args.length - 1; i++) {
		// FileInputFormat.addInputPath(job, new Path(args[i]));
		// }
		
		MultipleInputs.addInputPath(job, new Path(arg0[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(arg0[1]), TextInputFormat.class, DeptMapper.class);
		
		
		
		// job�� ������� ������ ���
		FileOutputFormat.setOutputPath(job, new Path(arg0[2]));

		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static void main(String[] args) throws Exception {
		if(args.length!=3){
			System.out.println("arg0 : Emp data");
			System.out.println("arg1 : Dept data");
			System.out.println("arg2 : output folder");
			System.exit(0);
		}
		ToolRunner.run(new EmpDept(), args);
	}
}
