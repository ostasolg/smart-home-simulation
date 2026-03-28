package cz.cvut.fel.omo.report;

import cz.cvut.fel.omo.visitors.FinancialReportVisitor;
import cz.cvut.fel.omo.visitors.StartReportVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Saving reports into a file
 */
public class Report {

    private FileOutputStream log;

    /**
     * Create a new report
     * @param name name of the report
     */
    public Report(String name) {
        try {
            log = new FileOutputStream(name, false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Write a message into the report
     * @param text written into the report
     */
    public void writeToReport(String text) {
        text += System.lineSeparator();
        try {
            log.write(text.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(StartReportVisitor.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(FinancialReportVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * End writing and close the report
     */
    public void endReport() {
        try {
            log.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}