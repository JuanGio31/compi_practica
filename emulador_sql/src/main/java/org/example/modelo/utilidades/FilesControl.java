package org.example.modelo.utilidades;

import org.example.modelo.proyecto.Archivo;
import org.example.modelo.proyecto.Carpeta;
import org.example.modelo.proyecto.Proyecto;
import org.w3c.dom.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

/**
 * Clase que gestiona los ficheros
 *
 * @author giovanic
 */
public class FilesControl {

    /**
     * Metodo para obtener un file
     *
     * @param filtro la extension predeterminada que se muestra en el
     * filechooser
     * @return File
     */
    public File seleccionarArchivo(FileNameExtensionFilter filtro) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(null);
        switch (respuesta) {
            case JFileChooser.APPROVE_OPTION -> {
                return fileChooser.getSelectedFile();
            }
            case JFileChooser.CANCEL_OPTION, JFileChooser.ERROR_OPTION -> {
                return null;
            }
        }
        return null;
    }

    /**
     * Metodo para leer un archivo .ide, y obtener los distintos eatributos de
     * las etiquetas que se encuentran en dicho archivo. estas etiquetas
     * serviran para para instarciar un Objeto tipo Proyecto. retornara un
     * objeto -> Proyecto.
     *
     * @return Proyecto
     */
    public Proyecto leerArchivoIde() {
        Proyecto proyecto_temp = null;
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.ide", "ide");
            File ide = seleccionarArchivo(filtro);

            // Crea un DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsea el archivo XML
            Document doc = dBuilder.parse(ide);

            // Normaliza la estructura del documento
            doc.getDocumentElement().normalize();

            //Obtener nombre del proyecto
            proyecto_temp = new Proyecto(doc.getDocumentElement().getAttribute("nombre"));

            //Accede a los elementos... carpeta.
            NodeList listaCarpetas = doc.getElementsByTagName("CARPETA");
            for (int i = 0; i < listaCarpetas.getLength(); i++) {
                Element carpeta = (Element) listaCarpetas.item(i);
                String nombre = carpeta.getAttribute("nombre");
                proyecto_temp.agregarCarpeta(new Carpeta(nombre));
            }

            // Accede a los elementos del archivo
            NodeList listaArchivos = doc.getElementsByTagName("ARCHIVO");
            for (int i = 0; i < listaArchivos.getLength(); i++) {
                Element archivo = (Element) listaArchivos.item(i);
                String nombre = archivo.getAttribute("nombre");
                String ubicacion = archivo.getAttribute("ubicacion");
                proyecto_temp.agregarArchivo(new Archivo(nombre, ubicacion));
            }

            String ruta_proyecto = ide.getAbsolutePath().replace(ide.getName(), proyecto_temp.getNombre());
            proyecto_temp.setPath(ruta_proyecto);

            File directorio_proyecto = new File(ruta_proyecto);
            if (!directorio_proyecto.exists()) {
                directorio_proyecto.mkdir();
                crearDirectorios(proyecto_temp);
                crearArchivos(proyecto_temp);
            } else {
                crearDirectorios(proyecto_temp);
                crearArchivos(proyecto_temp);
            }
            proyecto_temp.mostrar();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error > " + e.getMessage());
            return null;
        }

        return proyecto_temp;
    }

    private void crearDirectorios(Proyecto proyecto_temp) throws IOException {
        for (int i = 0; i < proyecto_temp.getArchivos().size(); i++) {
            String rutaAchivoTmp = proyecto_temp.getArchivos().get(i).getUbicacion();
            String ruta_carpetas = rutaAchivoTmp.replace(proyecto_temp.getArchivos().get(i).getNombre() + ".csv", "");

            String nombre_tmp = proyecto_temp.getArchivos().get(i).getNombre();
            boolean encontrado = proyecto_temp.getArchivos().get(i).getUbicacion().contains(nombre_tmp);
            if (!encontrado) {
                throw new IOException("La ubicacion y nombre del archivo no coincide");
            }

            File dirTmp = new File(ruta_carpetas);
            if (!dirTmp.exists()) {
                dirTmp.mkdirs();
            }
        }
    }

    private void crearArchivos(Proyecto proyecto_temp) {
        for (int i = 0; i < proyecto_temp.getArchivos().size(); i++) {
            File archivoTmp = new File(proyecto_temp.getArchivos().get(i).getUbicacion());

            if (!archivoTmp.exists()) {
                try {
                    archivoTmp.createNewFile();
                } catch (IOException ex) {
                    System.out.println("Error > " + ex.getMessage());
                }
            }
        }
    }

    public String getContenido(String f) {
        String cont = "";
        try {
            cont = getArchivo(f);
        } catch (NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    public String getContenido() {
        String cont = "";
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.py", "PY");
            File myObj = seleccionarArchivo(filtro);
            cont = getArchivo(myObj.getAbsolutePath());
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    //-------------------------Se obtiene el contenido del Archivo----------------//
    private String getArchivo(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try {
            //ruta puede ser de tipo String o tipo File
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }

        } catch (IOException e) {
        } //finally se utiliza para que si todo ocurre correctamente o si ocurre
        //algun error se cierre el archivo que anteriormente abrimos
        finally {
            try {
                br.close();
            } catch (IOException ex) {
            }
        }
        return contenido;
    }

    private File createFile(String fileName) {
        try {
            File myObj = new File("example/" + fileName + ".dot");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            return myObj;
        } catch (IOException e) {
        }
        return null;
    }

    public void writeFile(String contenido, String fileName) {
        try {
            File file = createFile(fileName);
            try (FileWriter myWriter = new FileWriter(file)) {
                myWriter.write(contenido);
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException | NullPointerException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Metodo para eliminar un archivo.
     *
     * @param file_name ruta del archivo y nombre
     */
    public void eliminarArchivo(String file_name) {
        File file = new File(file_name);
        file.delete();
    }

    /**
     * Elimina los archivos con una determinada extensión de una carpeta
     *
     * @param path Carpeta de la cual eliminar los archivos
     * @param extension Extensión de los archivos a eliminar
     */
    public void eliminarPorExtension(String path, final String extension) {
        File[] archivos = new File(path).listFiles((File archivo) -> {
            if (archivo.isFile()) {
                return archivo.getName().endsWith('.' + extension);
            }
            return false;
        });
        for (File archivo : archivos) {
            archivo.delete();
        }
    }
}
