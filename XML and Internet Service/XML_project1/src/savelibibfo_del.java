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


public class savelibibfo_del {
	
	void readandsave(ArrayList<ArrayList<String>> dd, int no){
		File saveFile=new File("library.xml");
        try {
                FileWriter br=new FileWriter(saveFile);
                br.write("<?xml version='1.0' ?>");
            	br.write("<libraries>");
                for(int i = 0; i<dd.size();i++){
                	if(i==no){
                		
                	}else{
                		br.write("<data>");
                		br.write("<libraryinfo>");
                		br.write("<libraryname>");
                		br.write(dd.get(i).get(0));
                		br.write("</libraryname>");
                		br.write("<librarytel>");
                		br.write(dd.get(i).get(1));
                		br.write("</librarytel>");
                		br.write("<librarysite>");
                		br.write(dd.get(i).get(2));
                		br.write("</librarysite>");
                		br.write("<libraryaddr>");
                		br.write(dd.get(i).get(3));
                		br.write("</libraryaddr>");
                		br.write("</libraryinfo>");
                		br.write("<books>");
                		for(int j=4;j<dd.get(i).size();j+=8){	
                    		br.write("<bdata>");
                    		br.write("<bookname>");
                    		br.write(dd.get(i).get(j));
                    		br.write("</bookname>");
                    		br.write("<ISBN>");
                    		br.write(dd.get(i).get(j+1));
                    		br.write("</ISBN>");
                    		br.write("<author>");
                    		br.write(dd.get(i).get(j+2));
                    		br.write("</author>");
                    		br.write("<bookshelf>");
                    		br.write(dd.get(i).get(j+3));
                    		br.write("</bookshelf>");
                    		br.write("<serial>");
                    		br.write(dd.get(i).get(j+4));
                    		br.write("</serial>");
                    		br.write("<returned>");
                    		br.write(dd.get(i).get(j+5));
                    		br.write("</returned>");
                    		br.write("<checkoutdate>");
                    		br.write(dd.get(i).get(j+6));
                    		br.write("</checkoutdate>");
                    		br.write("<returndate>");
                    		br.write(dd.get(i).get(j+7));
                    		br.write("</returndate>");
                    		br.write("</bdata>");
                    	}// End for
                		br.write("</books>");
                    	br.write("</data>");
                	}// End if
                }// End for
                
                br.write("</libraries>");
                br.close();
            
                //JOptionPane.showMessageDialog(null, "A book has been deleted!");
                
        } catch (IOException ex) {
            System.out.println("IOException Caught\n");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Exception Caught: \n" + ex.getMessage() + "\n");
            System.out.println("Error place: \n");
            ex.printStackTrace();
        }
		
		
	}

}
