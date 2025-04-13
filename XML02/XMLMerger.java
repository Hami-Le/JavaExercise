
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLMerger {

    public static void mergeXMLFiles(String[] inputFiles, String outputFile, boolean nested) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document mergedDoc = builder.newDocument();
        Element root = mergedDoc.createElement("merged");
        mergedDoc.appendChild(root);

        for (String path : inputFiles) {
            Document doc = builder.parse(new File(path));
            Element rootElement = doc.getDocumentElement();

            if (nested) {
                Element wrapper = mergedDoc.createElement("file");
                wrapper.setAttribute("src", path);

                Node imported = mergedDoc.importNode(rootElement, true);
                wrapper.appendChild(imported);
                root.appendChild(wrapper);
            } else {
                NodeList children = rootElement.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    Node node = children.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Node imported = mergedDoc.importNode(node, true);
                        root.appendChild(imported);
                    }
                }
            }
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(mergedDoc);
        StreamResult result = new StreamResult(new File(outputFile));
        transformer.transform(source, result);
    }
}
