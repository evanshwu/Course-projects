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


public class rtnprocess2 {
	ArrayList<String> alist = new ArrayList<String>();
	
	void savepack(String book){
		getdd(book);
		save();
	}
	
	
	void save(){
		File saveFile=new File("library.xml");
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
	
	void getdd(final String what){
			try {
	        	SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxparser = factory.newSAXParser();
	            
	            DefaultHandler handler = new DefaultHandler(){
	            	String tagname, bookname;
	            	@Override
	            	public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
	            		tagname = name;
	            		if(name.equals("libraries")){
	            			alist.add("<libraries>");
	            		}else if(name.equals("data")){
	            			alist.add("<data>");
	            		}else if(name.equals("libraryname")){
	            			alist.add("<libraryname>");
	            		}else if(name.equals("libraryinfo")){
	            			alist.add("<libraryinfo>");
	            		}else if(name.equals("librarytel")){
	            			alist.add("<librarytel>");
	            		}else if(name.equals("librarysite")){
	            			alist.add("<librarysite>");
	            		}else if(name.equals("libraryaddr")){
	            			alist.add("<libraryaddr>");
	            		}else if(name.equals("books")){
	            			alist.add("<books>");
	            		}else if(name.equals("bdata")){
	            			alist.add("<bdata>");
	            		}else if(name.equals("bookname")){
	            			alist.add("<bookname>");
	            		}else if(name.equals("ISBN")){
	            			alist.add("<ISBN>");
	            		}else if(name.equals("author")){
	            			alist.add("<author>");
	            		}else if(name.equals("bookshelf")){
	            			alist.add("<bookshelf>");
	            		}else if(name.equals("serial")){
	            			alist.add("<serial>");
	            		}else if(name.equals("returned")){
	            			alist.add("<returned>");
	            		}else if(name.equals("checkoutdate")){
	            			alist.add("<checkoutdate>");
	            		}else if(name.equals("returndate")){
	            			alist.add("<returndate>");
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
	            		if(name.equals("libraries")){
	            			alist.add("</libraries>");
	            		}else if(name.equals("data")){
	            			alist.add("</data>");
	            		}else if(name.equals("libraryinfo")){
	            			alist.add("</libraryinfo>");
	            		}else if(name.equals("librarytel")){
	            			alist.add("</librarytel>");
	            		}else if(name.equals("librarysite")){
	            			alist.add("</librarysite>");
	            		}else if(name.equals("libraryaddr")){
	            			alist.add("</libraryaddr>");
	            		}else if(name.equals("books")){
	            			alist.add("</books>");
	            		}else if(name.equals("bdata")){
	            			alist.add("</bdata>");
	            		}else if(name.equals("bookname")){
	            			alist.add("</bookname>");
	            		}else if(name.equals("ISBN")){
	            			alist.add("</ISBN>");
	            		}else if(name.equals("author")){
	            			alist.add("</author>");
	            		}else if(name.equals("bookshelf")){
	            			alist.add("</bookshelf>");
	            		}else if(name.equals("serial")){
	            			alist.add("</serial>");
	            		}else if(name.equals("returned")){
	            			alist.add("</returned>");
	            		}else if(name.equals("checkoutdate")){
	            			alist.add("</checkoutdate>");
	            		}else if(name.equals("returndate")){
	            			alist.add("</returndate>");
	            		}else if(name.equals("libraryname")){
	            			alist.add("</libraryname>");
	            		}
	            	}
	            };
				saxparser.parse(new File("library.xml"), handler);
				
	         } catch (Exception e) {
	           e.printStackTrace();
	         }
		
	}
}
