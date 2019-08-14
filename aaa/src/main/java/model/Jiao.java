package model;

import java.io.Serializable;

public class Jiao implements Serializable {

 private Integer id;
 private Integer js;
 private String  text;
 private String  checked;
 
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getChecked() {
	return checked;
}
public void setChecked(String checked) {
	this.checked = checked;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getJs() {
	return js;
}
public void setJs(Integer js) {
	this.js = js;
}

}
