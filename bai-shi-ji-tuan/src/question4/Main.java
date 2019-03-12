package question4;

import java.io.File;
import java.util.Scanner;

/**
 * 4.����һ��·�������·�����ļ�������ļ��Ĵ�С��������ļ��У�����ļ����������ļ��Ĵ�С��
 * @author Xin
 *
 */
public class Main {

	static long size=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����·����");
		String path = sc.nextLine();
		long itemSize = itemSize(path);
		System.out.println("�ļ����ļ��������ļ���С��"+itemSize);
	}

	static long itemSize(String path) {
		
		File file = new File(path);
		if(!file.exists()) return 0;
		if(file.isFile()) return file.length();
		return dirItemSize(new File(path));
		
	}

	static long dirItemSize(File file) {
		if(file.isFile()) {
			size+=file.length();
			return 0;
		}
		File[] childFiles = file.listFiles();
		for(File childFile :childFiles) {
			dirItemSize(childFile);
		}
		return size;
	}

}
