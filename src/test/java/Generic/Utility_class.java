package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility_class {

	public static String Reading_properties(String skey) throws IOException
	{
		FileInputStream fis=new FileInputStream("F:\\Eclipse\\automation\\utility.properties");
		Properties p=new Properties();  
		p.load(fis);
		return p.getProperty(skey);
		
	}
	
}
