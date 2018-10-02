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
	// ���� �ۼ�...
	// Mapper�� ��ӹ޾Ƽ� map�Լ� ����
	static class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		Text outKey = new Text();
		IntWritable outValue = new IntWritable(1);

		// Hello World, Welcome to hell // �̷� ������ �ִٸ�
		// �� ���� �ϳ��� ���� map�Լ��� �ѹ� ȣ�� �� ���̰�,

		// map�Լ��� �Է���
		// 1(���γѹ�), Hello World, Welcome to hell
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			// super.map(key, value, context);
			String inputStr = value.toString();
			// inputStr�� "Hello World, Welcome to hell"�̷� ����

			// �Է� ���� ���ڿ� ���� �������� �����ϱ� ���� ��ü ����
			StringTokenizer st = new StringTokenizer(inputStr, " ");

			// ���̻� �����ڰ� ���������� �� ����� �������� �ݺ���
			while (st.hasMoreTokens()) {
				outKey.set(st.nextToken());
				context.write(outKey, outValue);
			}

		}
	}

	static class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

		// ��¿� ����� IntWritable ��ü
		IntWritable outValue = new IntWritable();

		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			int count = 0;
			Iterator<IntWritable> iter = values.iterator();
			while (iter.hasNext()) {
				// count++; �Ĺ��̳ʸ� ���Ÿ� �̷����ϸ� �ȵ�
				count += iter.next().get();
			}
			outValue.set(count);
			context.write(key, outValue);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		// job �����ؼ� �����ϱ�
		// Job job = new Job(); //���ܴ� ó���������� throws�ع�����
		Configuration conf = new Configuration();
		// conf.set("key", "value");
		Job job = Job.getInstance(conf); // ����

		// job�� ���� �̸�
		job.setJobName("word_count");

		// java jar jar���� Ŭ������(�����Լ����ִ�) ���������� �̷����ϸ� ������ ��
		// hadoop jar [jar���ϸ�] [Ŭ������]
		// job�� �����ϴ� Ŭ������ ��������?
		job.setJarByClass(WordCount.class);

		// ����ϴ� ����Ŭ����
		job.setMapperClass(WordMapper.class);

		// ����ϴ� ���༭Ŭ����
		job.setReducerClass(WordReducer.class);

		// job�� �Է����� ����(InputFormat)
		job.setInputFormatClass(TextInputFormat.class);

		// job�� ������� ����(OutputFormat)
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// job���� �о���� ���� ���'��'
		for (int i = 0; i < args.length - 1; i++) {
			FileInputFormat.addInputPath(job, new Path(args[i]));
			// job�� ������� ������ ���
			FileOutputFormat.setOutputPath(job, new Path(args[args.length - 1]));
		}

		// ����� ���༭�� ����, �Ĺ��̳�Ŭ����...
		job.setCombinerClass(WordReducer.class);
		job.setNumReduceTasks(2);
		// job ����
		job.waitForCompletion(true);
	}
}