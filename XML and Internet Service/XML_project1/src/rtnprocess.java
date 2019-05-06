import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class rtnprocess {
	ArrayList<String> alist = new ArrayList<String>();
	
	void savepack(String name, String book){
		getdd(name, book);
		save(name);
	}
	
	
	void save(String who){
		File saveFile=new File(who+"_history.xml");
        try {
                FileWriter br=new FileWriter(saveFile);
            
                for(int i = 0; i<alist.size();i++){
                    br.write(alist.get(i));
                }
                
                br.close();
            
                JOptionPane.showMessageDialog(null, "Book has successfully returned!");
                
        } catch (IOException ex) {
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
            System.out.println("Error place: \n");
            ex.printStackTrace();
        }
	}
	
	void getdd(String who, final String what){
			try {
	        	SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxparser = factory.newSAXParser();
	            
	            DefaultHandler handler = new DefaultHandler(){
	            	String tagname, bookname;
	            	@Override
	            	public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
	            		tagname = name;
	            		if(name.equals("history")){
	            			alist.add("<history>");
	            		}else if(name.equals("fname")){
	            			alist.add("<fname>");
	            		}else if(name.equals("item")){
	            			alist.add("<item>");
	            		}else if(name.equals("bookname")){
	            			alist.add("<bookname>");
	            		}else if(name.equals("ISBN")){
	            			alist.add("<ISBN>");
	            		}else if(name.equals("borrow")){
	            			alist.add("<borrow>");
	            		}else if(name.equals("due")){
	            			alist.add("<due>");
	            		}else if(name.equals("returned")){
	            			alist.add("<returned>");
	            		}else if(name.equals("data")){
	            			alist.add("<data>");
	            		}else if(name.equals("quantities")){
	            			alist.add("<quantities>");
	            		}
	            	}
	            	
	            	
	            	@Override
	            	public void characters(char ch[], int start, int length){
	            		// Change to String
	            			String str = new String(ch, start, length);
	            			if(tagname.equals("bookname")){
	            				bookname = str.trim();
	            			}
	            			if(tagname.equals("returned")){
	            				if(bookname.equals(what.trim())){
	            					str = new String("1".toCharArray(), 0, "1".length());
	            					alist.add("1");
	            				}else{
	            					alist.add(str);
	            				}
	            			}else{
	            				alist.add(str);
	            			}

	            	}
	            	
	            	@Override
	            	public void endElement(String uri, String lname, String name) throws SAXException{
	            		if(name.equals("history")){
	            			alist.add("</history>");
	            		}else if(name.equals("fname")){
	            			alist.add("</fname>");
	            		}else if(name.equals("bookname")){
	            			alist.add("</bookname>");
	            		}else if(name.equals("ISBN")){
	            			alist.add("</ISBN>");
	            		}else if(name.equals("borrow")){
	            			alist.add("</borrow>");
	            		}else if(name.equals("due")){
	            			alist.add("</due>");
	            		}else if(name.equals("returned")){
	            			alist.add("</returned>");
	            		}else if(name.equals("item")){
	            			alist.add("</item>");
	            		}else if(name.equals("data")){
	            			alist.add("</data>");
	            		}else if(name.equals("quantities")){
	            			alist.add("</quantities>");
	            		}
	            	}
	            };
				saxparser.parse(new File(who+"_history.xml"), handler);
				
	         } catch (Exception e) {
	           e.printStackTrace();
	         }
		
	}
}
