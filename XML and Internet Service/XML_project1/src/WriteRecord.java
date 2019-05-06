import java.io.File;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class WriteRecord {
	void write(String name){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler(){
				String tagname;
				public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
					tagname = name;
				}
				
				public void characters(char ch[], int start, int length){
					if(tagname.equals("lastlogin")){
						ch = new Date().toString().toCharArray();
					}
				}
				
				public void endElement(String uri, String lname, String name) throws SAXException{
					// Do nothings
				}
			};
			saxparser.parse(new File(name+".xml"), handler);
			
		}catch(Exception e){
			
		}
	}
}
