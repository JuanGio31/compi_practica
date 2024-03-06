/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.vista;

import java.io.File;
import javax.swing.JOptionPane;
import org.example.modelo.utilidades.FilesControl;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.example.modelo.proyecto.Proyecto;

/**
 * @author giovanic
 */
public class Visor extends javax.swing.JFrame {

    private final FilesControl filesControl;
    private DefaultTreeModel modelo_directorio;
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode nodoSeleccionado;
    private String path;

    /**
     * Creates new form Visor
     */
    public Visor() {
        initComponents();
        setTitle("SQL-EMULE");

        filesControl = new FilesControl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pestanias = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        paneGen1 = new org.example.vista.PaneGen();
        jScrollPane1 = new javax.swing.JScrollPane();
        jdirectorio = new javax.swing.JTree();
        btnArchivoNuevo = new javax.swing.JButton();
        btnCarpetaNueva = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAcept = new javax.swing.JButton();
        zonaTrabajo = new javax.swing.JTabbedPane();
        area_consultas = new javax.swing.JPanel();
        area_errores = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCargar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        pestanias.addTab("tab1", jPanel2);

        jdirectorio.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jdirectorioValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jdirectorio);

        btnArchivoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nuevoArchivo.png"))); // NOI18N
        btnArchivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoNuevoActionPerformed(evt);
            }
        });

        btnCarpetaNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/carpeta.png"))); // NOI18N
        btnCarpetaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarpetaNuevaActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editarArchivo.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAcept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aceptar.png"))); // NOI18N
        btnAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneGen1Layout = new javax.swing.GroupLayout(paneGen1);
        paneGen1.setLayout(paneGen1Layout);
        paneGen1Layout.setHorizontalGroup(
            paneGen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneGen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneGen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(paneGen1Layout.createSequentialGroup()
                        .addComponent(btnAcept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArchivoNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCarpetaNueva)))
                .addContainerGap())
        );
        paneGen1Layout.setVerticalGroup(
            paneGen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneGen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(paneGen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneGen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCarpetaNueva)
                        .addComponent(btnArchivoNuevo))
                    .addComponent(btnEdit)
                    .addComponent(btnAcept))
                .addContainerGap())
        );

        javax.swing.GroupLayout area_consultasLayout = new javax.swing.GroupLayout(area_consultas);
        area_consultas.setLayout(area_consultasLayout);
        area_consultasLayout.setHorizontalGroup(
            area_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        area_consultasLayout.setVerticalGroup(
            area_consultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        zonaTrabajo.addTab("Consultas", area_consultas);

        javax.swing.GroupLayout area_erroresLayout = new javax.swing.GroupLayout(area_errores);
        area_errores.setLayout(area_erroresLayout);
        area_erroresLayout.setHorizontalGroup(
            area_erroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        area_erroresLayout.setVerticalGroup(
            area_erroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        zonaTrabajo.addTab("Errores", area_errores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneGen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pestanias)
                    .addComponent(zonaTrabajo))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pestanias, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zonaTrabajo))
                    .addComponent(paneGen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        btnCargar.setText("Cargar Proyecto");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCargar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        Proyecto tmp = filesControl.leerArchivoIde();
        if (tmp != null) {
            root = new DefaultMutableTreeNode(tmp.getNombre());
            path = tmp.getPath();
            actualizar();
        } else {
            modelo_directorio = new DefaultTreeModel(new DefaultMutableTreeNode("error"));
            jdirectorio.setModel(modelo_directorio);
            JOptionPane.showMessageDialog(null, "Error en el archivo ide, revisa que las rutas sean correctas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void actualizar() {
        root.removeAllChildren();

        modelo_directorio = new DefaultTreeModel(root);
        crea(root, new File(path));
        jdirectorio.setModel(modelo_directorio);
    }

    private void btnArchivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoNuevoActionPerformed
        System.out.println("Btn Archivo nuevo");
    }//GEN-LAST:event_btnArchivoNuevoActionPerformed

    private void btnCarpetaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarpetaNuevaActionPerformed
        System.out.println("Btn Nuevo Directorio");
    }//GEN-LAST:event_btnCarpetaNuevaActionPerformed

    private void jdirectorioValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jdirectorioValueChanged
        nodoSeleccionado = (DefaultMutableTreeNode) jdirectorio.getLastSelectedPathComponent();
    }//GEN-LAST:event_jdirectorioValueChanged

    private void btnAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptActionPerformed
        if (nodoSeleccionado != null) {
            String txt = filesControl.getContenido(obtenerRuta());
            jTextArea1.setText(txt);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningun elemento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptActionPerformed

    private String obtenerRuta() {
        if (nodoSeleccionado != null) {
            String pathSelect = "";
            Object[] paths = jdirectorio.getSelectionPath().getPath();
            for (int i = 0; i < paths.length; i++) {
                pathSelect += paths[i];
                if (i + 1 < paths.length) {
                    pathSelect += File.separator;
                }
            }

            File p = new File(path);
            return p.getParentFile().getAbsolutePath() + "/" + pathSelect;

        } else {
            JOptionPane.showMessageDialog(null, "No hay ningun elemento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

    }//GEN-LAST:event_btnEditActionPerformed

    private void crea(DefaultMutableTreeNode nodo, File carpeta) {
        //obtener los n. hijos para ir creando nodos.
        File[] archivos = carpeta.listFiles();
        //si es fichero, crear nodo, si es carpeta, crear y llamar recursivamente
        if (archivos != null) { //tiene directorio o archivo dentro
            int contador = 0;
            for (File f : archivos) {
                DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(f.getName());
                modelo_directorio.insertNodeInto(hijo, nodo, contador);
                contador++;
                if (f.isDirectory()) {
                    crea(hijo, f);
                }
            }
        } else {
            //no tiene hijos(subdir), es un nodo hoja, fin llamada recursiva
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel area_consultas;
    private javax.swing.JPanel area_errores;
    private javax.swing.JButton btnAcept;
    private javax.swing.JButton btnArchivoNuevo;
    private javax.swing.JMenuItem btnCargar;
    private javax.swing.JButton btnCarpetaNueva;
    private javax.swing.JButton btnEdit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jdirectorio;
    private org.example.vista.PaneGen paneGen1;
    private javax.swing.JTabbedPane pestanias;
    private javax.swing.JTabbedPane zonaTrabajo;
    // End of variables declaration//GEN-END:variables
}