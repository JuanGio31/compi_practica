package org.example;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.example.vista.Visor;

public class Main {

    public static void main(String[] args) throws Exception {
//        int a = 5 + 5 * 7 * 9;
//        System.out.println(a + "\n");
//
//        StringReader tmp = new StringReader("5+5*7*9");
//        Parser pa = new Parser(new A_Lexer(tmp));
//        System.out.println(pa.parse().value);

        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Visor vs = new Visor();
            vs.setLocationRelativeTo(null);
            vs.setVisible(true);
        });
    }
}
