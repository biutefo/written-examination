package question4;

import java.io.File;
import java.util.Scanner;

/**
 * 4.输入一个路径，如果路径是文件，输出文件的大小；如果是文件夹，输出文件夹下所有文件的大小。
 * @author Xin
 *
 */
public class Main {

	static long size=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入路径：");
		String path = sc.nextLine();
		long itemSize = itemSize(path);
		System.out.println("文件或文件夹内总文件大小："+itemSize);
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
