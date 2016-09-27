package HoneyWell;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ComparatorDevice implements Comparator{

 public int compare(Object arg0, Object arg1) {
  Device user0=(Device)arg0;
  Device user1=(Device)arg1;
  int flag=user0.getId().compareTo(user1.getId());
  return flag;
 }
 
}
