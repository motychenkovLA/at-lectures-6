package com.example;


import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class SoapClientExample {

    private String namespaceURI = null;
    private String soapUrl = null;
    private String serviceName = null;

    private String namespace = null;
    private String soapAction = null;

    private final boolean useXSLT = true;

    public SoapClientExample() {
        setSoapParams();
        callSoapWebService(soapUrl, soapAction);
    }

    private void setSoapParams() {

        namespaceURI = "http://www.dataaccess.com/webservicesserver/";
        soapUrl = "https://www.dataaccess.com/webservicesserver/numberconversion.wso";
        serviceName = "NumberToDollars";

        namespace = "web"; // Namespace";
        soapAction = namespaceURI + "/" + serviceName;
    }

    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(namespace, namespaceURI);

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem;
        SOAPElement soapBodyElem1;

        soapBodyElem = soapBody.addChildElement(serviceName, namespace);
        soapBodyElem1 = soapBodyElem.addChildElement("dNum", namespace);
        soapBodyElem1.addTextNode("15");

    }

    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println('\n');

        return soapMessage;
    }

    private void callSoapWebService(String destination, String soapAction) {
        SOAPConnectionFactory soapFactory = null;
        SOAPConnection soapConnect = null;
        SOAPMessage soapRequest = null;
        SOAPMessage soapResponse = null;
        try {
            soapFactory = SOAPConnectionFactory.newInstance();
            soapConnect = soapFactory.createConnection();

            soapRequest = createSOAPRequest(soapAction);

            soapResponse = soapConnect.call(soapRequest, destination);

            if (!useXSLT) {
                System.out.println("Response SOAP Message:");
                soapResponse.writeTo(System.out);
                System.out.println();
            } else
                printSOAPMessage(soapResponse);

            soapConnect.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\n"
                    + "Make sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }


    private void printSOAPMessage(SOAPMessage soapResponse) {
        TransformerFactory transformerFactory;
        Transformer transformer;
        try {

            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();

            Source content;
            content = soapResponse.getSOAPPart().getContent();

            StreamResult result = new StreamResult(System.out);
            transformer.transform(content, result);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SoapClientExample();
        System.exit(0);
    }
}
