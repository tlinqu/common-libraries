
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package gov.samhsa.c2s.common.xdsbclient.registry.wsclient;

import java.util.logging.Logger;

import ihe.iti.xds_b._2007.DocumentRegistryPortType;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-17T13:06:15.558-04:00
 * Generated source version: 3.1.12
 * 
 */

@javax.jws.WebService(
                      serviceName = "DocumentRegistry_Service",
                      portName = "DocumentRegistry_Port_Soap12",
                      targetNamespace = "urn:ihe:iti:xds-b:2007",
                      wsdlLocation = "file:./src/main/resources/wsdl/XDS.b_DocumentRegistry.wsdl",
                      endpointInterface = "ihe.iti.xds_b._2007.DocumentRegistryPortType")
                      
public class DocumentRegistry_Port_Soap12Impl implements DocumentRegistryPortType {

    private static final Logger LOG = Logger.getLogger(DocumentRegistry_Port_Soap12Impl.class.getName());

    /* (non-Javadoc)
     * @see ihe.iti.xds_b._2007.DocumentRegistryPortType#documentRegistryRegistryStoredQuery(oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest body)*
     */
    public oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse documentRegistryRegistryStoredQuery(oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest body) { 
        LOG.info("Executing operation documentRegistryRegistryStoredQuery");
        System.out.println(body);
        try {
            AdhocQueryResponse _return = new AdhocQueryResponse();
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ihe.iti.xds_b._2007.DocumentRegistryPortType#documentRegistryPRPAIN201304UV02(org.hl7.v3.PRPAIN201304UV02 body)*
     */
    public org.hl7.v3.MCCIIN000002UV01 documentRegistryPRPAIN201304UV02(org.hl7.v3.PRPAIN201304UV02 body) { 
        LOG.info("Executing operation documentRegistryPRPAIN201304UV02");
        System.out.println(body);
        try {
            org.hl7.v3.MCCIIN000002UV01 _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ihe.iti.xds_b._2007.DocumentRegistryPortType#documentRegistryPRPAIN201302UV02(org.hl7.v3.PRPAIN201302UV02 body)*
     */
    public org.hl7.v3.MCCIIN000002UV01 documentRegistryPRPAIN201302UV02(org.hl7.v3.PRPAIN201302UV02 body) { 
        LOG.info("Executing operation documentRegistryPRPAIN201302UV02");
        System.out.println(body);
        try {
            org.hl7.v3.MCCIIN000002UV01 _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ihe.iti.xds_b._2007.DocumentRegistryPortType#documentRegistryRegisterDocumentSetB(oasis.names.tc.ebxml_regrep.xsd.lcm._3.SubmitObjectsRequest body)*
     */
    public oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType documentRegistryRegisterDocumentSetB(oasis.names.tc.ebxml_regrep.xsd.lcm._3.SubmitObjectsRequest body) { 
        LOG.info("Executing operation documentRegistryRegisterDocumentSetB");
        System.out.println(body);
        try {
            oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ihe.iti.xds_b._2007.DocumentRegistryPortType#documentRegistryPRPAIN201301UV02(org.hl7.v3.PRPAIN201301UV02 body)*
     */
    public org.hl7.v3.MCCIIN000002UV01 documentRegistryPRPAIN201301UV02(org.hl7.v3.PRPAIN201301UV02 body) { 
        LOG.info("Executing operation documentRegistryPRPAIN201301UV02");
        System.out.println(body);
        try {
            org.hl7.v3.MCCIIN000002UV01 _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
