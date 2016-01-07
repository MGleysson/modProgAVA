package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.*;
import models.Curso;

public class CursoCRUD extends Controller {
	
	private Form<Curso> cursoForm = Form.form(Curso.class);
	
	public Result listar_cursos() {
		List<Curso> cursos = Curso.find.all();
		return ok(listaCursos.render(cursos));
		//return TODO;
	}

	public Result criar_curso() {
		return ok(novoCurso.render(cursoForm));
	}
	
	public Result salvar_curso() {
		Form<Curso> dados = cursoForm.bindFromRequest();
		
		if (dados.hasErrors()) {
			flash("erro","Por favor, preencha o campo corretamente.");
			return ok(novoCurso.render(cursoForm));
		}
		
		Curso curso = dados.get();
		curso.save();
		
		flash("sucesso","Curso salvo com sucesso!");
		
		return redirect(routes.CursoCRUD.listar_cursos());
		
	}
	
	public Result detalhar_curso(String id) {
		Form<Curso> form = cursoForm.fill(Curso.find.byId(id));
		return ok(acaoCurso.render(id,form));
	}

	
	public Result alterar_curso(String id) {
			
		Form<Curso> formAlteracao = cursoForm.bindFromRequest();
		//Form<Curso> formAlteracao = cursoForm.fill(Curso.find.byId(id));
		
		if (formAlteracao.hasErrors()) {
			return badRequest(acaoCurso.render(id,formAlteracao));
		}
		
		Curso curso = formAlteracao.get();
		//String idString = Long.toString(id);
		curso.update(id);
		
		flash("sucesso","Curso "+ curso.getNomecurso() + " alterado com sucesso!");
		
		return redirect(routes.CursoCRUD.listar_cursos());
	}
	
	
	public Result remover_curso(String id) {
		Curso.find.ref(id).delete();
		
		flash("sucesso","Curso removido com sucesso");
		
		return redirect(routes.CursoCRUD.listar_cursos());
	}
	
}
