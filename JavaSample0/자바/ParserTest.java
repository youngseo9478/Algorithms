package day30;
/*parser : ����, �м�   ->�Ľ�
 * �������� �������̽��� �� �ִ�. -> �������� ���µ��� 
 * ��ɻ��� �����Ǵ°� �Ȱ�����(���ļҵ�� ������) ��ü�� ���� �ٸ� �� ����ϰԵ�*/

interface Parsable
{
	//���� �м� ����� �����Ѵ�.
	public abstract void parse(String fileName);
}

class ParserManager
{
	//����Ÿ���� parsable�������̽���.
	public static Parsable getParser(String type)
	{
		if(type.equals("XML"))
		{
			return new XMLParser();
		}//if,else �� �������ó�� �ΰ������Ȱ��� ����ε� �����϶�� �������� ����� �����̰� �������ڸ� if�� �� ����� �� �����ؼ� ����.
		else
		{
			Parsable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
}

class XMLParser implements Parsable
{
	public void parse(String fileName)
	{
		System.out.println(fileName+"- XML parsing completed");
	}
}
class HTMLParser implements Parsable
{
	public void parse(String fileName)
	{
		System.out.println(fileName+"- HTML parsing completed");
	}
}

public class ParserTest {

	public static void main(String[] args)
	{
		Parsable parser = ParserManager.getParser("XML");
		parser.parse("document1.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
		
	}
}
