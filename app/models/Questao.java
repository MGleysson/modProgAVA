package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import com.avaje.ebean.*;


@Entity
public class Questao extends Model {
	
	public static Finder<String,Questao> find = new Finder<String, Questao>(Questao.class);
	
	@Id
	private String idquestao;
	
	@Constraints.Required
	private String tituloquestao;
	
	@Constraints.Required
	private String enunciadoquestao;
	
	@Constraints.Required
	private char respostaquestao;

	public String getIdquestao() {
		return idquestao;
	}

	public void setIdquestao(String idquestao) {
		this.idquestao = idquestao;
	}

	public String getTituloquestao() {
		return tituloquestao;
	}

	public void setTituloquestao(String tituloquestao) {
		this.tituloquestao = tituloquestao;
	}

	public String getEnunciadoquestao() {
		return enunciadoquestao;
	}

	public void setEnunciadoquestao(String enunciadoquestao) {
		this.enunciadoquestao = enunciadoquestao;
	}
	
	public char getRespostaquestao() {
		return respostaquestao;
	}

	public void setRespostaquestao(char respostaquestao) {
		this.respostaquestao = respostaquestao;
	}


}
