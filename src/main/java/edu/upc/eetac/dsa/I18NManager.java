package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class I18NManager {

    private static I18NManager instance;
    private ResourceBundle ca, es, it, pt;
    private final static Logger logger = Logger.getLogger(I18NManager.class);

    private I18NManager() {

        this.ca = ResourceBundle.getBundle("ca");
        this.es = ResourceBundle.getBundle("es");
        this.it = ResourceBundle.getBundle("it");
        this.pt = ResourceBundle.getBundle("pt");
    }

    public static I18NManager getInstance() {

        if (instance == null) instance = new I18NManager();

        return instance;
    }

    public String getText(String r, String l) throws MissingResourceException {

        logger.info("Language: " + r + " key: " + l);

        ResourceBundle rb = switch (r) {

            case "ca" -> this.ca;
            case "es" -> this.es;
            case "it" -> this.it;
            case "pt" -> this.pt;
            default   -> throw new MissingResourceException("Resource not found.", r, l);
        };

        return rb.getString(l);
    }

    public void clear() { instance = null; }
}
