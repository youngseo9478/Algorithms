package empdept;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EmpDeptReducer extends Reducer<Text, Text, Text, Text>{

	// K : 10(�μ���ȣ)
	// V : {"E,1200", "D,ACCOUNTING,NEW YORK", "E,5000"} //�ٸ� ������ ����
	
	Text outValue = new Text();
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {  //10�� �μ��� 10�� �μ����� �ַ縤 ���� ���̱� ������ �Ʒ��� sum�ϴ°� �μ��� �����հ��ΰ�
		
		int sum = 0;
		String dname = null;
		String dloc = null;
		Iterator<Text> iter = values.iterator();
		while(iter.hasNext()){
			String data = iter.next().toString(); 
			//V�� ���� �� �� � ������ ������ �� (D?,E?)
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
