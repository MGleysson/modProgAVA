package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import com.avaje.ebean.*;


@Entity
public class Curso extends Model {
	
	public static Finder<String,Curso> find = new Finder<String,Curso>(Curso.class);
	
	@Id
	private String idcurso;
	
	@Constraints.Required
	private String nomecurso;
	
	
	public String getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(String id) {
		this.idcurso = id;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nome) {
		this.nomecurso = nome;
	}
	

}
