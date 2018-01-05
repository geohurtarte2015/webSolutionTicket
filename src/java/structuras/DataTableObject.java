package structuras;


import java.util.ArrayList;
import java.util.List;
import pojo.Ticket;

public class DataTableObject {

 
 String  sEcho;
 
 String sColumns;
 
 ArrayList<Object> aaData;
 

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

 public List<Object> getAaData() {
  return aaData;
 }

 public void setAaData(List<Object> aaData) {
  this.aaData = (ArrayList<Object>) aaData;
 }
 
 
 
}
