package org.alfresco.extension.pdftoolkit.repo.action.executer;

import java.util.List;

import org.alfresco.extension.pdftoolkit.constants.PDFToolkitConstants;
import org.alfresco.repo.action.ParameterDefinitionImpl;
import org.alfresco.service.cmr.action.Action;
import org.alfresco.service.cmr.action.ParameterDefinition;
import org.alfresco.service.cmr.dictionary.DataTypeDefinition;
import org.alfresco.service.cmr.repository.NodeRef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PDFRotateActionExecuter extends BasePDFActionExecuter {

	/**
     * The logger
     */
    private static Log         logger                   = LogFactory.getLog(PDFRotateActionExecuter.class);

    /**
     * Action constants
     */
    public static final String NAME                     = "pdf-rotate";
    
	@Override
	protected void executeImpl(Action action, NodeRef actionedUponNodeRef) 
	{
		NodeRef result = pdfToolkitService.rotatePDF(actionedUponNodeRef, action.getParameterValues());
		action.setParameterValue(PARAM_RESULT, result);
	}

	/**
     * Add parameter definitions
     */
    @Override
    protected void addParameterDefinitions(List<ParameterDefinition> paramList)
    {
        paramList.add(new ParameterDefinitionImpl(PDFToolkitConstants.PARAM_DESTINATION_FOLDER, DataTypeDefinition.NODE_REF, false, getParamDisplayLabel(PDFToolkitConstants.PARAM_DESTINATION_FOLDER)));
        paramList.add(new ParameterDefinitionImpl(PDFToolkitConstants.PARAM_DEGREES, DataTypeDefinition.TEXT, true, getParamDisplayLabel(PDFToolkitConstants.PARAM_DEGREES)));
        paramList.add(new ParameterDefinitionImpl(PDFToolkitConstants.PARAM_DESTINATION_NAME, DataTypeDefinition.TEXT, false, getParamDisplayLabel(PDFToolkitConstants.PARAM_DESTINATION_NAME)));
        paramList.add(new ParameterDefinitionImpl(PDFToolkitConstants.PARAM_PAGE, DataTypeDefinition.TEXT, false, getParamDisplayLabel(PDFToolkitConstants.PARAM_PAGE), false));

        super.addParameterDefinitions(paramList);
    }
}
