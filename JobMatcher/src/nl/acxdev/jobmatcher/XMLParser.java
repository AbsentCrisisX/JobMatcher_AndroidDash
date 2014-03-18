package nl.acxdev.jobmatcher;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLParser {
	//Constructor
	public XMLParser(){}
	
	//Retrieve the XML feed
	public String getXmlFromUrl(String url) {
		String xml = null;
		try {
			DefaultHttpClient hc = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			HttpResponse httpResponse = hc.execute(httpPost);
			HttpEntity he = httpResponse.getEntity();
			xml = EntityUtils.toString(he);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xml;
	}
	
	//Get the XML as a document for parsing
	public Document getDom(String xml){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is); 
		} catch (ParserConfigurationException e) {
			return null;
		} catch (SAXException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	        return doc;
	}
	
	//Get the value of a defined element from the XML
	public final String getElementVal( Node elem ) {
		Node child;
		if( elem != null){
			 if (elem.hasChildNodes()){
				 for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
					 if( child.getNodeType() == Node.TEXT_NODE  ){
						 return child.getNodeValue();
					 }
				 }
			 }
		}
	     return "";
	 }
	
	// Define the element to get the value of.
	public String getVal(Element item, String str) {		
		NodeList n = item.getElementsByTagName(str);		
		return this.getElementVal(n.item(0));
	}
}