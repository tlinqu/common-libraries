package gov.samhsa.acs.xdsb.registry.wsclient.adapter;


import gov.samhsa.acs.xdsb.common.XdsbDocumentType;
import gov.samhsa.acs.xdsb.registry.wsclient.XdsbRegistryWebServiceClient;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryRequest;
import oasis.names.tc.ebxml_regrep.xsd.query._3.AdhocQueryResponse;
import oasis.names.tc.ebxml_regrep.xsd.query._3.ResponseOptionType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.AdhocQueryType;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.SlotType1;
import oasis.names.tc.ebxml_regrep.xsd.rim._3.ValueListType;

public class XdsbRegistryAdapter {

	private XdsbRegistryWebServiceClient xdsbRegistry;
	
	/** The Constant SLOT_NAME_XDS_DOCUMENT_ENTRY_PATIENT_ID. */
	public static final String SLOT_NAME_XDS_DOCUMENT_ENTRY_PATIENT_ID = "$XDSDocumentEntryPatientId";
	
	public static final String SLOT_NAME_XDS_DOCUMENT_ENTRY_FORMAT_CODE = "$XDSDocumentEntryFormatCode";
	
	public static final String FORMAT_CODE_CLINICAL_DOCUMENT = "'CDAR2/IHE 1.0^^Connect-a-thon formatCodes'";
	
	public static final String FORMAT_CODE_PRIVACY_CONSENT = "'1.3.6.1.4.1.19376.1.5.3.1.1.7^^IHE BPPC'";

	public XdsbRegistryAdapter(XdsbRegistryWebServiceClient xdsbRegistry) {
		this.xdsbRegistry = xdsbRegistry;
	}

	public AdhocQueryResponse registryStoredQuery(final String patientId, final XdsbDocumentType documentType) {
		// Create registryStoredQuery
		AdhocQueryRequest registryStoredQuery = new AdhocQueryRequest();
		// Set response option to return all metadata of the documents in the
		// response
		setResponseOptionToGetAllMetadata(registryStoredQuery);

		// Create a query type that will find documents by given patient id
		AdhocQueryType adhocQueryType = createFindDocumentsByPatientIdQueryType();
		registryStoredQuery.setAdhocQuery(adhocQueryType);
		
		addPatientId(adhocQueryType, patientId);
		
		addEntryStatusApproved(adhocQueryType);
		
		addFormatCode(adhocQueryType, documentType, "");

		
		//skipped the steps and directly calling the service.....
		return registryStoredQuery(registryStoredQuery);
	}
	
	public AdhocQueryResponse registryStoredQuery(AdhocQueryRequest adhocQueryRequest) {
		return xdsbRegistry.registryStoredQuery(adhocQueryRequest);
	}
	
	
	AdhocQueryType createFindDocumentsByPatientIdQueryType() {
		AdhocQueryType adhocQueryType = new AdhocQueryType();
		// FindDocuments by patientId
		adhocQueryType.setId("urn:uuid:14d4debf-8f97-4251-9a74-a90016b0af0d");
		return adhocQueryType;
	}
	
	void addFormatCode(AdhocQueryType adhocQueryType, XdsbDocumentType xdsbDocumentType, String messageId) {
		SlotType1 formatCodeSlotType = new SlotType1();
		formatCodeSlotType.setName(SLOT_NAME_XDS_DOCUMENT_ENTRY_FORMAT_CODE);
		ValueListType formatCodeValueListType = new ValueListType();

		if (xdsbDocumentType.equals(XdsbDocumentType.CLINICAL_DOCUMENT)) {
			formatCodeValueListType.getValue().add(FORMAT_CODE_CLINICAL_DOCUMENT);
			
		} else if (xdsbDocumentType.equals(XdsbDocumentType.PRIVACY_CONSENT)) {
			formatCodeValueListType.getValue().add(FORMAT_CODE_PRIVACY_CONSENT);
			
		} else {
			System.out.println("Unsupported XDS.b document format code");
			//throw new Exception("Unsupported XDS.b document format code");
		}

		formatCodeSlotType.setValueList(formatCodeValueListType);
		adhocQueryType.getSlot().add(formatCodeSlotType);
	}
	
	void setResponseOptionToGetAllMetadata(AdhocQueryRequest registryStoredQuery) {
		ResponseOptionType responseOptionType = new ResponseOptionType();
		responseOptionType.setReturnComposedObjects(true);
		responseOptionType.setReturnType("LeafClass");
		registryStoredQuery.setResponseOption(responseOptionType);
	}
	
	void addPatientId(AdhocQueryType adhocQueryType, String patientUniqueId) {
		if (!patientUniqueId.startsWith("'") || !patientUniqueId.endsWith("'")) {
			patientUniqueId = patientUniqueId.replace("'", "");
			StringBuilder builder = new StringBuilder();
			builder.append("'");
			builder.append(patientUniqueId);
			builder.append("'");
			patientUniqueId = builder.toString();
		}
		SlotType1 patientIdSlotType = new SlotType1();
		patientIdSlotType.setName(SLOT_NAME_XDS_DOCUMENT_ENTRY_PATIENT_ID);
		ValueListType patientIdValueListType = new ValueListType();
		patientIdValueListType.getValue().add(patientUniqueId); // PatientId
		patientIdSlotType.setValueList(patientIdValueListType);
		adhocQueryType.getSlot().add(patientIdSlotType);
	}
	
	void addEntryStatusApproved(AdhocQueryType adhocQueryType) {
		SlotType1 statusSlotType = new SlotType1();
		statusSlotType.setName("$XDSDocumentEntryStatus");
		
		ValueListType statusValueListType = new ValueListType();
		statusValueListType.getValue().add("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved')");
		//statusValueListType.getValue().add("('urn:oasis:names:tc:ebxml-regrep:StatusType:Approved', 'urn:oasis:names:tc:ebxml-regrep:StatusType:Deprecated')");
		
		statusSlotType.setValueList(statusValueListType);
		adhocQueryType.getSlot().add(statusSlotType);
	}

}