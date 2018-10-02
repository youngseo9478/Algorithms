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

		// job이 가질 이름
		job.setJobName("EmpDept");

		// java jar jar파일 클래스명(메인함수가있는) 리눅스에서 이렇게하면 실행이 됨
		// hadoop jar [jar파일명] [클래스명]
		// job을 구성하는 클래스가 누구인지?
		job.setJarByClass(EmpDept.class);

		// 사용하는 매퍼클래스
		// job.setMapperClass(WordMapper.class);

		// 사용하는 리듀서클래스
		job.setReducerClass(EmpDeptReducer.class);

		// job의 입력파일 포맷(InputFormat)
		// 두놈이 혹시 다른 입력포맷을 쓸지도 모르잖아 .. 일단 보류 (지금은 똑같게 했지만!)
		// job.setInputFormatClass(TextInputFormat.class);

		// job의 출력파일 포맷(OutputFormat)
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		// job에서 읽어들일 파일 경로'들'
		// 매퍼별로 입력받을 파일이 다름.. 각각 지정해줘야할 듯
		// for (int i = 0; i < args.length - 1; i++) {
		// FileInputFormat.addInputPath(job, new Path(args[i]));
		// }
		
		MultipleInputs.addInputPath(job, new Path(arg0[0]), TextInputFormat.class, EmpMapper.class);
		MultipleInputs.addInputPath(job, new Path(arg0[1]), TextInputFormat.class, DeptMapper.class);
		
		
		
		// job의 결과물을 저장할 경로
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
