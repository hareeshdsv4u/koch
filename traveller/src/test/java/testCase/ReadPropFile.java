package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

public String getProperty(String Keyname) throws IOException {
	Properties Prop = new Properties();
	String filepath = "C:\\Users\\LaKsHmI K!RaN\\Desktop\\Koch code\\traveller\\src\\test\\java\\testDataPackage\\propfile.properties";
	FileInputStream fileIn= new FileInputStream(filepath);
	Prop.load(fileIn);
	String key = Prop.getProperty(Keyname);
	
	return key;
	
}
}
