package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		String[] nameAry = {"ȫ�浿", "��浿", "ȫ�浿", "�ڱ浿", "ȫ�浿", "Ȳ�浿"};
		
		String search = "ȫ�浿";
		int count = 0;
		// for�ݺ��� Ȱ��
		for(String name : nameAry) { // for(int i = 0; i < nameAry.length; i++)
			if(name.equals(search)) { // nameAry[i].equals(search)
				count++;
			}
		}
		System.out.println(search + "�� �� " + count + "�� �Դϴ�");
		
		// ���� ū���� �����ÿ�
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for(int num : scores) { // for(int i = 0; i < scores.length; i++)
			if(maxScore < num) { // if(maxScore < scores[i])
				maxScore = num; // maxScore = scores[i];
			}
		}
		System.out.println("���� ū ���� " + maxScore + "�Դϴ�");
				
	} // end main
} // end class
