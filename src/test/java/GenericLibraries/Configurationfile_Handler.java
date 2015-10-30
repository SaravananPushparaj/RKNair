package GenericLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configurationfile_Handler {
	
	public static void main(String[] args) throws Exception {
		String handepropertyfile = handlepropertyfile("xl_filename");
		System.out.println(handepropertyfile);
	}
	public static String handlepropertyfile(String Key) throws Exception
	{
		File f = new File("D:\\Java_Workbook\\sample\\Configuration.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		//System.out.println(prop.getProperty(Key));
		return prop.getProperty(Key);
		
	}

}
