package MITSUBISHI_G50;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class test2 {//�ާ@�ϥ�JDOM�ѪRXML���?

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName="D:/tmp/test1.xml";
		test2 jdomXml=new test2();
		
		System.out.println("===============3.�ק�XML?�e�A?�X�ק�Z����?");
		jdomXml.update(fileName, "liushu", "chongkai");
		/*
		System.out.println("===============1.?��jdom?��XML���");
		if(jdomXml.createXMLFile(fileName, "GB2312")==1)
			System.out.println("?��JDOM?��XML��󦨥\�I");
		else
			System.out.println("?��JDOM?��XML���?!");
		System.out.println("===============2.?��JDOM?��XML���");
		jdomXml.read(jdomXml.getDocument(fileName));
		System.out.println("===============3.�ק�XML?�e�A?�X�ק�Z����?");
		jdomXml.update(fileName, "rongshu", "chongkai");
		System.out.println("===============4.?��???002��??,?�X�ק�Z�����");
		jdomXml.delete(fileName, "002");
		*/
		
	}
	
	//�ͦ��@?�s��Document  
	public Document createDocument(){
		Document document=new Document();
		return document;
	}
	//?�ؤ@???
	public Element createElement(String paramName,String paramValue){
		Element element=new Element(paramName);
		element.setText(formatTextForXML(paramValue));
		return element;
	}
	//?�� XML���
	public int createXMLFile(String fileName,String encoding){
		int returnValue=0;
		Document document=createDocument();
		Element treesElement=createElement("trees", null);
		Element treeElement=new Element("tree");
		treeElement.setAttribute("id","001");
		treeElement.setAttribute("name","rongshu");
		
		Element typeElement=new Element("type");
		typeElement.setText("style");
		typeElement.setAttribute("id","xiaoshu");
		treeElement.addContent(typeElement);  //�K�[ �l??
		
		
		Element descElement=new Element("description");
		descElement.setText(formatTextForXML("It is a big tree"));
		treeElement.addContent(descElement);
		
		treesElement.addContent(treeElement);
		
		Element tree1Element=new Element("tree");
		tree1Element.setAttribute("id","002");
		tree1Element.setAttribute("name","yangshu");
		Element type1Element=new Element("type");
		type1Element.setText("style");
		type1Element.setAttribute("id","dashu");
		tree1Element.addContent(type1Element);
		Element desc1Element=new Element("description");
		desc1Element.setText(formatTextForXML("The tree grows taller from day to day"));
		tree1Element.addContent(desc1Element);
		treesElement.addContent(tree1Element);
		
		
		Element tree2Element=new Element("tree");
		tree2Element.setAttribute("id","003");
		tree2Element.setAttribute("name","songshu");
		Element desc2Element=new Element("description");
		desc2Element.setText(formatTextForXML("The tree is very beautiful"));
		tree2Element.addContent(desc2Element);
		treesElement.addContent(tree2Element);
		
		Element flowerElement=new Element("flower");
		flowerElement.setText("rose");
		treesElement.addContent(flowerElement);
		
		document.addContent(treesElement);
		try {
			saveFile(fileName,document,encoding);
			returnValue=1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("?��XML���?:"+e.getMessage());
		}
		return returnValue;
		
	}
	//?��xml
	public void read(Document document){
		try {
			Format format=Format.getPrettyFormat(); 
			format.setEncoding("GB2312");
			
			XMLOutputter xmlOutputter=new XMLOutputter(format);
			xmlOutputter.output(document, System.out);
		} catch (Exception e) {
			System.out.println("?��XML���?�G"+e.getMessage());
		}
	}
	//�ק� xml��???
	public int update(String fileName,String oldName,String newName){
		int returnValue=0;
		Document document=getDocument(fileName);
		List list=document.getRootElement().getChildren();
		for (int i = 0; i < list.size(); i++) {
			Element element=(Element)list.get(i);
			Attribute attribute=element.getAttribute("name");
			if(attribute!=null){
				if(attribute.getValue().equals(oldName)){
					attribute.setValue(newName);
				}
			}
		}
		
		list=document.getRootElement().getChildren("flower");
		Iterator iter=list.iterator();
		if(iter.hasNext()){
			Element el=(Element)iter.next();
			el.setText("lily");
			Element date=new Element("date");
			date.setText("2009-04-10");
			date.setAttribute("type","calendar");
			el.addContent(date);
		}
		
		try {
			showFile(fileName,document);
			returnValue=1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ק�XML���X?:"+e.getMessage());
		}
		
		return returnValue;
		
		
	}
	//?��XML ??
	public boolean delete(String fileName,String id){
		boolean returnVlalue=false;
		Document doc=getDocument(fileName);
		Element root=doc.getRootElement();
		List list=root.getChildren("tree");
		for (int i = 0; i < list.size(); i++) {
			Element element=(Element)list.get(i);
			if (element.getAttribute("id").getValue().equals(id)) {
				root.removeContent(element);
			}
		}
		try {
			showFile(fileName, doc);
			returnVlalue=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnVlalue;
				
	}
	
	private void showFile(String fileName, Document document) {
		// TODO Auto-generated method stub
		Format format=Format.getPrettyFormat();
		format.setEncoding("GB2312");
		format.setIndent("�@");
		try {
			XMLOutputter xmlOutputter=new XMLOutputter(format);
			FileWriter fileWriter=new FileWriter(fileName);
			xmlOutputter.output(document, fileWriter);
			xmlOutputter.output(document, System.out);
		} catch (Exception e) {
			System.out.println("XML���?�X�챱��x�X?:"+e.getMessage());
		}
	}

	private Document getDocument(String fileName) {
		// TODO Auto-generated method stub
		Document document=null;
		try {
			SAXBuilder saxBuilder=new SAXBuilder();
			document=saxBuilder.build(new File(fileName));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("?�J��?:"+e.getMessage());
			return null;
		}
		return document;
	}

	private boolean saveFile(String fileName, Document document, String encoding) {
		// TODO Auto-generated method stub
		Format format=Format.getPrettyFormat();
		if(encoding!=null){
			format.setEncoding(encoding);
		}
		format.setIndent(" "); //?�mxml���??
		try {
			XMLOutputter xmlOutputter=new XMLOutputter(format);
			FileWriter fileWriter=new FileWriter(fileName);
			xmlOutputter.output(document, fileWriter);
		} catch (Exception e) {
			System.out.println("�O�s���X?:"+e.getMessage());
			return false;
		}
		return true;
	}

	private String formatTextForXML(String sourceString) {
		// TODO Auto-generated method stub
		if (sourceString==null) {
			return null;
		}
		int stLen=0;
		StringBuffer reString= new StringBuffer();
		String deString="";
		stLen=sourceString.length();
		for (int i = 0; i < stLen; i++) {
			char ch=sourceString.charAt(i);
			switch (ch) {
			case '<':
				deString="<";
				break;
			case '>':
				deString=">";
				break;
			case '\"':
				deString="\"";
				break;
			case '&':
				deString="&";
				break;
			case 13:
				deString="\n";
				break;
			default:
				deString=""+ch;
				break;
			}
			reString.append(deString);
		}
		return reString.toString();
	}	
	
	
}