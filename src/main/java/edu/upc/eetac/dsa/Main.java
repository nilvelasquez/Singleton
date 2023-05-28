package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import java.util.MissingResourceException;

public class Main {
    public static void main(String[] args) {

        I18NManager i18n = I18NManager.getInstance();
        Logger logger = Logger.getLogger(I18NManager.class);

        try {
            logger.info(i18n.getText("ca", "l1") + "\t");
            logger.info(i18n.getText("es", "l1") + "\t");
            logger.info(i18n.getText("it", "l1") + "\t");
            logger.info(i18n.getText("pt", "l1") + "\t");

            logger.info(i18n.getText("ca", "l2") + "\t");
            logger.info(i18n.getText("es", "l2") + "\t");
            logger.info(i18n.getText("it", "l2") + "\t");
            logger.info(i18n.getText("pt", "l2") + "\t");

            logger.info(i18n.getText("XX", "l2") + "\t");
        }

        catch (MissingResourceException e) { logger.info(e.getMessage()); }
    }
}
