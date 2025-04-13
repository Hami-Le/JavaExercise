import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {

    // Export danh sách user (trừ mật khẩu) ra XML
    public static void exportUsersToXML(List<User> users, String filePath) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();
            Element root = doc.createElement("users");
            doc.appendChild(root);

            for (User user : users) {
                Element userElement = doc.createElement("user");

                Element username = doc.createElement("username");
                username.appendChild(doc.createTextNode(user.getUsername()));
                userElement.appendChild(username);

                root.appendChild(userElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File(filePath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Import user từ XML (gồm username và passwordHash)
    public static List<User> importUsersFromXML(String filePath) throws Exception {
        List<User> userList = new ArrayList<>();

        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            throw new Exception("File không tồn tại.");
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        if (!doc.getDocumentElement().getNodeName().equals("users")) {
            throw new Exception("File XML không đúng định dạng.");
        }

        NodeList nodeList = doc.getElementsByTagName("user");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                String username = elem.getElementsByTagName("username").item(0).getTextContent();
                String hash = elem.getElementsByTagName("passwordHash").item(0).getTextContent();

                userList.add(new User(username, hash));
            }
        }

        return userList;
    }
}
