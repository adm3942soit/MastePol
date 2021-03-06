package ua.com.masterpol.controllers;

/**
 * Created by Oxana on 29.08.2015.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "fileUploadController")
@RequestScoped
public class uploadFilesBean {

    //Primitives
    private static final int BUFFER_SIZE = 6124;
    private String folderToUpload;
    private String nameFile;
    /** Creates a new instance of UploadBean */
    public uploadFilesBean() {
    }

    public String getNameFile() {
        return nameFile;
    }

    public void handleFileUpload(FileUploadEvent event) {

        ExternalContext extContext =
                FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath
                ("//WEB-INF//files//" + event.getFile().getFileName()));
        this.nameFile=event.getFile().getFileName();
        System.out.println(extContext.getRealPath
                ("//WEB-INF//files//" + event.getFile().getFileName()));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[BUFFER_SIZE];

            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg =
                    new FacesMessage("File Description", "file name: " +
                            event.getFile().getFileName() + "<br/>file size: " +
                            event.getFile().getSize() / 1024 +
                            " Kb<br/>content type: " +
                            event.getFile().getContentType() +
                            "<br/><br/>The file was uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (IOException e) {
            e.printStackTrace();

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }

    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
