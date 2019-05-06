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


public class savelibinfo2 {
	ArrayList<String> alist = new ArrayList<String>();
	
	void readandsave(DefaultListModel lm){
		getdd();
		save(lm);
	}
	
	
	void save(DefaultListModel lm){
		File saveFile=new File("library.xml");
        try {
                FileWriter br=new FileWriter(saveFile);
            
                for(int i = 0; i<alist.size();i++){
                    br.write(alist.get(i));
                }
                for(int j = 0; j<(lm.getSize())/4 ;j++){
                br.write("<data>");
                br.write("<libraryinfo>");
                br.write("<libraryname>");
                br.write(lm.get(j).toString());
                br.write("</libraryname>");
                br.write("<librarytel>");
                br.write(lm.get(j+1).toString());
                br.write("</librarytel>");
                br.write("<librarysite>");
                br.write(lm.get(j+2).toString());
                br.write("</librarysite>");
                br.write("<libraryaddr>");
                br.write(lm.get(j+3).toString());
                br.write("</libraryaddr>");
                br.write("</libraryinfo>");
                br.write("<books>");
                br.write("</books>");
                br.write("</data>");
                
                }
                br.write("</libraries>");
                br.close();
            
                JOptionPane.showMessageDialog(null, "library has successfully added!");
                
        } catch (IOException ex) {
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
            System.out.println("Error place: \n");
            ex.printStackTrace();
        }
	}
	
	void getdd(){
			try {
	        	SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxparser = factory.newSAXParser();
	            
	            DefaultHandler handler = new DefaultHandler(){
	            	String tagname;
	            	@Override
	            	public void startElement(String uri, String localname, String name, org.xml.sax.Attributes attributes) throws SAXException{
	            		tagname = name;
	            		if(name.equals("libraries")){
	            			alist.add("<libraries>");
	            		}else if(name.equals("data")){
	            			alist.add("<data>");
	            		}else if(name.equals("libraryinfo")){
	            			alist.add("<libraryinfo>");
	            		}else if(name.equals("libraryname")){
	            			alist.add("<libraryname>");
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
	                		alist.add(str);
	            	}
	            	
	            	@Override
	            	public void endElement(String uri, String lname, String name) throws SAXException{
	            		if(name.equals("data")){
	            			alist.add("</data>");
	            		}else if(name.equals("libraryinfo")){
	            			alist.add("</libraryinfo>");
	            		}else if(name.equals("libraryname")){
	            			alist.add("</libraryname>");
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
	            		}
	            	}
	            };
				saxparser.parse(new File("library.xml"), handler);
				
	         } catch (Exception e) {
	           e.printStackTrace();
	         }
		
	}
}
