package org.example;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.example.vista.Visor;

import java.io.StringReader;

public class Main {

    public static void main(String[] args) throws Exception {
        
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Visor vs = new Visor();
            vs.setLocationRelativeTo(null);
            vs.setVisible(true);
        });
    }
}
