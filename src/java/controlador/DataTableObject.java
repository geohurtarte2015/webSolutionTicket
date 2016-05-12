package controlador;


import java.util.List;

public class DataTableObject {

 
 String  sEcho;
 
 String sColumns;
 
 List<Student> aaData;
 

 public String getsEcho() {
  return sEcho;
 }

 public void setsEcho(String sEcho) {
  this.sEcho = sEcho;
 }

 public String getsColumns() {
  return sColumns;
 }

 public void setsColumns(String sColumns) {
  this.sColumns = sColumns;
 }

 public List<Student> getAaData() {
  return aaData;
 }

 public void setAaData(List<Student> aaData) {
  this.aaData = aaData;
 }
 
 
 
}
