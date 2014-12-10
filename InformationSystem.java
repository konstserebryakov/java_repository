package ru.ncedu.serebryakov.library;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

import java.io.*;

public class InformationSystem {
	private Document document;
	
	public InformationSystem() {
		this.document = null;
	}
	
	public void help() {
		System.out.println("You can do something in format <action> <arguments>.\n"
				+ "Action may be help(no arguments), find(string that you want to find "
				+ "or * if you want to print everything)");
	}
	
	public void printAllElements() throws ParserConfigurationException, SAXException, IOException {
		if (this.document == null) {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File("library.xml"));
		}
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName() + " id Author Title Publishing date Number of pages");
		NodeList nList = document.getElementsByTagName("book");
		for (int i = 0; i < nList.getLength(); i++) {
		    Element element = (Element) nList.item(i);
		    System.out.println(element.getNodeName() + " " +
		    		element.getElementsByTagName("id").item(0).getTextContent() + " " +
		    		element.getElementsByTagName("author").item(0).getTextContent() + " " +
		    		element.getElementsByTagName("title").item(0).getTextContent() + " " +
		    		element.getElementsByTagName("pubdate").item(0).getTextContent() + " " + 
		    		element.getElementsByTagName("numpages").item(0).getTextContent());
		}
	}
	
	public void start() throws ParserConfigurationException, SAXException, IOException {
		this.printAllElements();
		this.help();
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		InformationSystem is = new InformationSystem();
		is.start();
	}

}
