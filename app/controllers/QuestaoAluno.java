package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.*;
import models.Questao;

public class QuestaoAluno extends Controller {
	
	private Form<Questao> questaoForm = Form.form(Questao.class);
	
	public Result listar_questoes_aluno() {
		List<Questao> questoes = Questao.find.all();
		return ok(listaQuestoesAluno.render(questoes));
	}
	
	public Result responder_questao(String id) {
		Questao questao = Questao.find.byId(id);
		Form<Questao> form = questaoForm.fill(Questao.find.byId(id));
		return ok(respondeQuestao.render(id, questao, form, questaoForm));
	}
	
	public Result avaliar_resposta(String id) {
		
		Questao questao = Questao.find.byId(id);
		Form<Questao> form = questaoForm.fill(Questao.find.byId(id));
		
		Form<Questao> dados = questaoForm.bindFromRequest();
		
		
		
		if(questao.getRespostaquestao() == dados.get().getRespostaquestao()){
			flash("sucesso","Parabéns, você acertou a questão!");
		}else{
			flash("erro","Oops, você errou a questão!");
		}
		
		return ok(respondeQuestao.render(id, questao, form, questaoForm));
	}

}
