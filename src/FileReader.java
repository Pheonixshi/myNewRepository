/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
public class FileReader {
    public static String loadFileIntoString(String filePath, String fileEncoding) throws
        FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream("json/student.json"), "UTF-8");
    }
}
