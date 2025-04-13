package xmlcrud;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLHandler {
    private static final String FILE_PATH = "students.xml";

    // Tạo mới file XML nếu chưa có
    public static void createXMLFile() throws Exception {
        File file = new File(FILE_PATH);
        if (file.exists()) return;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("students");
        doc.appendChild(root);

        saveXML(doc);
    }

    // Thêm student mới
    public static void addStudent(String id, String name) throws Exception {
        Document doc = getDocument();

        Element student = doc.createElement("student");
        student.setAttribute("id", id);

        Element nameElem = doc.createElement("name");
        nameElem.setTextContent(name);
        student.appendChild(nameElem);

        doc.getDocumentElement().appendChild(student);
        saveXML(doc);
    }

    // Xóa student theo ID
    public static void deleteStudent(String id) throws Exception {
        Document doc = getDocument();

        NodeList students = doc.getElementsByTagName("student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            if (student.getAttribute("id").equals(id)) {
                doc.getDocumentElement().removeChild(student);
                break;
            }
        }

        saveXML(doc);
    }

    // Cập nhật tên student
    public static void updateStudent(String id, String newName) throws Exception {
        Document doc = getDocument();

        NodeList students = doc.getElementsByTagName("student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            if (student.getAttribute("id").equals(id)) {
                student.getElementsByTagName("name").item(0).setTextContent(newName);
                break;
            }
        }

        saveXML(doc);
    }

    // Hiển thị tất cả student
    public static void displayAll() throws Exception {
        Document doc = getDocument();

        NodeList students = doc.getElementsByTagName("student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            String id = student.getAttribute("id");
            String name = student.getElementsByTagName("name").item(0).getTextContent();
            System.out.println("ID: " + id + " - Name: " + name);
        }
    }

    // Helpers
    private static Document getDocument() throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(file);
    }

    private static void saveXML(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}
