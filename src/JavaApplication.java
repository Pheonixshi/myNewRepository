/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JavaApplication {
    public static void main(String[] args) throws IOException {
        String myJSON = FileReader.loadFileIntoString("json/student.json",
        "UTF-8");

        JSONObject student=JSONObject.fromObject(myJSON);

        int id= student.getInt("student_id");
        String fName=student.getString("first_name");
        String lName=student.getString("last_name");
        String dob=student.getString("date_birth");
        boolean active=student.getBoolean("active");
        double gpa=student.getDouble("GPA");
        
        System.out.println(id + " - " + fName + " - "
        + lName+ " - " +dob+ " - " +gpa);
    
        JSONArray listCourses=student.getJSONArray("results");
        JSONObject singleCourse;
        String title, cid;
        double mark1111;
        for (int i = 0; i < listCourses.size(); i++) {
            singleCourse = listCourses.getJSONObject(i);
            cid=singleCourse.getString("course_id");
            title=singleCourse.getString("course_title");
            mark=singleCourse.getDouble("mark");
            System.out.println("\t" + cid + ", " + title + ", " + mark + ".");
        }
        
        JSONObject employee= new JSONObject();
        
            employee.accumulate("employeeid", "123456");
            employee.accumulate("fname", "Zied");
            employee.accumulate("lname", "Zaier");
            employee.accumulate("sin", 123456789);
            employee.accumulate("retired",false);
            employee.accumulate("salary", 9999.99);
        
        JSONObject address= new JSONObject();
            address.accumulate("streetnumber", 1001);
            address.accumulate("streetname", "Sherbrooke");
            address.accumulate("postalcode", "H3S1S1");
            employee.accumulate("address", address);
        
        JSONArray projects = new JSONArray();
        JSONObject project = new JSONObject();
            project.accumulate("name","mobile app project");
            project.accumulate("nbrh",55);
            projects.add(project);
            project.clear();
            
            project.accumulate("name","Backend project");
            project.accumulate("nbrh",77);
            projects.add(project);
            project.clear();
            
            project.accumulate("name","Database project");
            project.accumulate("nbrh",100);
            projects.add(project);
            employee.accumulate("projects", projects);
        
        FileWriter.saveStringIntoFile("json/employee." + "json", employee.toString());
    }
}