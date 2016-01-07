package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.*;
import models.Questao;

public class QuestaoCRUD extends Controller {
	
	private Form<Questao> questaoForm = Form.form(Questao.class);
	
	public Result listar_questoes() {
		List<Questao> questoes = Questao.find.all();
		return ok(listaQuestoes.render(questoes));
	}

	public Result criar_questao() {
		return ok(novaQuestao.render(questaoForm));
	}
	
	public Result salvar_questao() {
		
		Form<Questao> dados = questaoForm.bindFromRequest();
		
		if (dados.hasErrors()) {
			flash("erro","Por favor, preencha o campo corretamente.");
			return ok(novaQuestao.render(questaoForm));
		}
		
		Questao questao = dados.get();
		questao.save();
		
		flash("sucesso","Questão salva com sucesso!");
		
		return redirect(routes.QuestaoCRUD.listar_questoes());
	
	}
	
	public Result detalhar_questao(String id) {
		Form<Questao> form = questaoForm.fill(Questao.find.byId(id));
		return ok(acaoQuestao.render(id,form));
	}

	
	public Result alterar_questao(String id) {
			
		Form<Questao> formAlteracao = questaoForm.bindFromRequest();
		//Form<Curso> formAlteracao = cursoForm.fill(Curso.find.byId(id));
		
		if (formAlteracao.hasErrors()) {
			return badRequest(acaoQuestao.render(id,formAlteracao));
		}
		
		Questao questao = formAlteracao.get();
		//String idString = Long.toString(id);
		questao.update(id);
		
		flash("sucesso","Questão "+ questao.getTituloquestao() + " alterada com sucesso!");
		
		return redirect(routes.QuestaoCRUD.listar_questoes());
	}
	
	
	public Result remover_questao(String id) {
		Questao.find.ref(id).delete();
		
		flash("sucesso","Questão removida com sucesso");
		
		return redirect(routes.QuestaoCRUD.listar_questoes());
	}
	
}

