package day5_7;
/*****ArrayList VS LinkeList(���Ի����ð���)*****/
/*���Ի����� ������쿡�� ��ũ�� ����Ʈ�� ������.
 *�������� �������� ��� ��̸���Ʈ�� �����ϴ�.*/
/*****ArrayList VS LinkeList(���ٽð���)*****/
/*�迭�� �������� �����͸� �������� ���̱⶧���� �̰�쿡�� ArrayList�� �� ����
 * ���ٽð��� ���� ��ũ�� ����Ʈ�� �� ���� �ɸ���.*/
import java.util.*;
public class QueueEx2 {

	static Queue q = new LinkedList(); //LinkedList�� ������ �ʴ� ������ Queue�ӿ� �پ��� ��ũ�帮��Ʈ�� ���߿� �ѹ��� ��Ƽ� ����� �� �ֱ⶧��
	static final int MAX_SIZE = 5; //ť�� �ִ� 5�������� ����ǵ��� �Ѵ�.
	
	public static void main(String[] args)
	{
		System.out.println("help�� �Է��ϸ� ������ �� �� �ֽ��ϴ�.");
		
		while(true){
			System.out.print(">>");
			try{
				//ȭ�����κ��� ���δ����� �Է¹޴´�.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();//trim�� ���� ���鹮�ڰ����� �������� �ڸ��°�.
				
				if("".equals(input)) continue; //�ƹ��͵� ��ġ�� �ٽ� �Է�â�� �Է´��
				
				if(input.equalsIgnoreCase("q")) //q �Է��ϸ� �ý�������
				{
					System.exit(0);
				}
				else if(input.equalsIgnoreCase("help"))
				{
					System.out.println("help - ������ �����ݴϴ�.");
					System.out.println("q �Ǵ� Q - ���α׷��� �����մϴ�.");
					System.out.println("history - �ֱٿ� �Է��� ��ɾ"+MAX_SIZE+"���� �����ݴϴ�.");
				}
				else if(input.equalsIgnoreCase("history"))
				{
					int i=0;
					//�Է¹��� history��ɾ ����ǰ�,
					save(input);
					//LinkedList �� ������ �����ش�.
					LinkedList tmp = (LinkedList)q; //�Ʊ������� Ŭ����Ÿ���� Queue�� �߱⶧���� ĳ�������ִ� ��.
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext())//hasNext() ����Ŀ�� ������ �����Ͱ� �ִ��� Ȯ���ϴ� �޼ҵ� (T/F)
					{
						System.out.println(++i+"."+it.next());//next() Ŀ���� ����Ű���ִ� ���� ������
					}
				}
				else
				{
					save(input); //�����Է��� ������ �������Ǵ� ��.
					//System.out.println(input);->�����ϱ� ������ �򰥷��� �ּ�ó���س�
				}//if(input.equalsIgnorCase("q")){
			}catch(Exception e)
			{
				System.out.println("�Է¿����Դϴ�");
			}
		}//while(true)
	}//main()
	
	public static void save(String input)
	{
		if(!"".equals(input))
			q.offer(input);
			
		if(q.size()>MAX_SIZE) //size()�� Collection�������̽��� ����
			q.remove(); //ť�� FIFO �׷��� �뷮���� �������� ������������ִ��ֵ���� ����
	}
}
