/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import rep.entities.Request;
import req.constraint.AddRequestInfo;
import req.facade.RequestFacadeLocal;
/**
 *
 * @author Guest
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {
   
    @Size(min = 3, max = 60, message = "{request.size}", groups = AddRequestInfo.class)
    private String newRequest;
        
    private HtmlDataTable requestDataTable;
    
    private HtmlInputText newReqInputText;

    /**
     * Get the value of requestDataTable
     *
     * @return the value of requestDataTable
     */
    public HtmlDataTable getRequestDataTable() {
        return requestDataTable;
    }

    /**
     * Set the value of requestDataTable
     *
     * @param requestDataTable new value of requestDataTable
     */
    public void setRequestDataTable(HtmlDataTable requestDataTable) {
        this.requestDataTable = requestDataTable;
    }


    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }
    
    public String addRequest(){
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RequestsList>> validateProperty = validator.validateProperty(this, "newRequest", AddRequestInfo.class);
        if (!validateProperty.isEmpty()) {
            String message = validateProperty.iterator().next().getMessage();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(getNewReqInputText().getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
            return null;
        }
        
        Request req = new Request();
        req.setRequestDate(LocalDate.now());
        req.setRequestText(newRequest);
        requestFacade.create(req);
        setNewRequest("");
        return null;
    }
    
    public String deleteRequest(){
        Request req = (Request) getRequestDataTable().getRowData();
        requestFacade.remove(req);
        return null;
    }

    /**
     * Creates a new instance of RequestsList
     */
    @Inject
    private RequestFacadeLocal requestFacade;
    public List<Request> getAllRequests() {
        return requestFacade.findAll();
    }
    public RequestsList() {
    }
    
    public HtmlInputText getNewReqInputText() {
        return newReqInputText;
    }
    public void setNewReqInputText(HtmlInputText newReqInputText) {
        this.newReqInputText = newReqInputText;
    }
    
}
