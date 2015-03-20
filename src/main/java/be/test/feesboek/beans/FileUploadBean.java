/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.test.feesboek.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author dimitridw
 */
@Named(value = "fileUploadBean")
@RequestScoped
public class FileUploadBean {

    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageBean.class);

    private UploadedFile file;

    /**
     * Creates a new instance of FileUploadBean
     */
    public FileUploadBean() {
    }

    public void upload() {
        LOGGER.debug("FILE UPLOAD: Check uploaded file");
        if (file != null) {
            LOGGER.debug("FILE UPLOAD: filename = {}", file.getFileName());
            LOGGER.debug("FILE UPLOAD: filesize = {}", file.getSize());

            //Set message
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            LOGGER.info("TRY WRITER");
            OutputStream out = null;
            InputStream filecontent = null;

            String path = "c:/temp";
            String fileName = file.getFileName();

            try {
                out = new FileOutputStream(new File(path + File.separator + fileName));
                filecontent = file.getInputstream();

                int read;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                LOGGER.info("File {} being uploaded to {}", fileName, path);

            } catch (FileNotFoundException fne) {
                LOGGER.error("Problems during file upload. Error: {0}",
                        new Object[]{fne.getMessage()});
            } catch (IOException ex) {
                LOGGER.error("Problems during file upload. Error: {0}", ex);
            } finally {
                LOGGER.info("Finalize");
            }
        }
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
