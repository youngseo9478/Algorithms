package mapreduce;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCount {
	// 매퍼 작성...
	// Mapper를 상속받아서 map함수 구현
	static class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		Text outKey = new Text();
		IntWritable outValue = new IntWritable(1);

		// Hello World, Welcome to hell // 이런 문장이 있다면
		// 저 문장 하나를 위해 map함수가 한번 호출 될 것이고,

		// map함수의 입력은
		// 1(라인넘버), Hello World, Welcome to hell
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			// super.map(key, value, context);
			String inputStr = value.toString();
			// inputStr이 "Hello World, Welcome to hell"이런 문장

			// 입력 라인 문자열 값을 공백으로 구분하기 위한 객체 생성
			StringTokenizer st = new StringTokenizer(inputStr, " ");

			// 더이상 구분자가 없을때까지 한 덩어리씩 꺼내오는 반복문
			while (st.hasMoreTokens()) {
				outKey.set(st.nextToken());
				context.write(outKey, outValue);
			}

		}
	}

	static class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

		// 출력에 사용할 IntWritable 객체
		IntWritable outValue = new IntWritable();

		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			int count = 0;
			Iterator<IntWritable> iter = values.iterator();
			while (iter.hasNext()) {
				// count++; 컴바이너를 쓸거면 이렇게하면 안됨
				count += iter.next().get();
			}
			outValue.set(count);
			context.write(key, outValue);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		// job 셋팅해서 제출하기
		// Job job = new Job(); //예외는 처리하지말고 throws해버리기
		Configuration conf = new Configuration();
		// conf.set("key", "value");
		Job job = Job.getInstance(conf); // 권장

		// job이 가질 이름
		job.setJobName("word_count");

		// java jar jar파일 클래스명(메인함수가있는) 리눅스에서 이렇게하면 실행이 됨
		// hadoop jar [jar파일명] [클래스명]
		// job을 구성하는 클래스가 누구인지?
		job.setJarByClass(WordCount.class);

		// 사용하는 매퍼클래스
		job.setMapperClass(WordMapper.class);

		// 사용하는 리듀서클래스
		job.setReducerClass(WordReducer.class);

		// job의 입력파일 포맷(InputFormat)
		job.setInputFormatClass(TextInputFormat.class);

		// job의 출력파일 포맷(OutputFormat)
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// job에서 읽어들일 파일 경로'들'
		for (int i = 0; i < args.length - 1; i++) {
			FileInputFormat.addInputPath(job, new Path(args[i]));
			// job의 결과물을 저장할 경로
			FileOutputFormat.setOutputPath(job, new Path(args[args.length - 1]));
		}

		// 사용할 리듀서의 갯수, 컴바이너클래스...
		job.setCombinerClass(WordReducer.class);
		job.setNumReduceTasks(2);
		// job 제출
		job.waitForCompletion(true);
	}
}