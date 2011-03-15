package org.open2jam.gui;
/*
 * SkinConfiguration.java
 *
 * Created on 14-mar-2011, 12:06:38
 */

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.open2jam.render.SkinChecker;

/**
 *
 * @author CdK
 */
public class SkinConfiguration extends javax.swing.JFrame {

    /** the config xml */
    private static final URL resources_xml = SkinConfiguration.class.getResource("/resources/resources.xml");
    static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /** Creates new form SkinConfiguration */
    public SkinConfiguration() {
        initComponents();
        initLogic();

        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setTitle("Skin configuration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initLogic()
    {
        // skin load
        try {
            SkinChecker sb = new SkinChecker("o2jam");
            SAXParserFactory.newInstance().newSAXParser().parse(resources_xml.openStream(), sb);

            System.out.println(sb.getStyles());
        } catch (ParserConfigurationException ex) {
            logger.log(Level.SEVERE, "Skin load error {0}", ex);
        } catch (org.xml.sax.SAXException ex) {
            logger.log(Level.SEVERE, "Skin load error {0}", ex);
        } catch (java.io.IOException ex) {
            logger.log(Level.SEVERE, "Skin load error {0}", ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}