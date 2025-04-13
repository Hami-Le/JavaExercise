import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XMLHandler {

    private static final String FILE_PATH = "students.xml";

    public static void readXML() throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        NodeList students = doc.getElementsByTagName("student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            System.out.println("ID: " + student.getAttribute("id"));
            System.out.println("Name: " + student.getElementsByTagName("name").item(0).getTextContent());
        }
    }

    public static void writeXML(String id, String name) throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        Element root = doc.getDocumentElement();

        Element student = doc.createElement("student");
        student.setAttribute("id", id);

        Element nameElement = doc.createElement("name");
        nameElement.setTextContent(name);
        student.appendChild(nameElement);

        root.appendChild(student);

        saveXML(doc);
    }

    public static void deleteStudentById(String id) throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(file);

        NodeList list = doc.getElementsByTagName("student");
        for (int i = 0; i < list.getLength(); i++) {
            Element student = (Element) list.item(i);
            if (student.getAttribute("id").equals(id)) {
                student.getParentNode().removeChild(student);
                break;
            }
        }

        saveXML(doc);
    }

    private static void saveXML(Document doc) throws Exception {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        t.transform(source, result);
    }
}
