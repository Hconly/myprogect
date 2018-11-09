package org.lq.question.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lq.question.entity.RadOptions;
import org.lq.question.entity.RmdQuestions;
import org.lq.question.service.RmdQuestionsService;
import org.lq.question.service.impl.RmdQuestionsServiceImpl;
import org.lq.question.util.CastUtil;

import oracle.net.aso.q;

/**
 * Servlet implementation class AddQuestionsServelt
 */
@WebServlet("/AddQuestionsServelt")
public class AddQuestionsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//试题类型
		String quest_type = request.getParameter("quest_type");
		//题干
		String question = request.getParameter("question");
		//选项
		String option_A = request.getParameter("option_A");
		String option_B = request.getParameter("option_B");
		String option_C = request.getParameter("option_C");
		String option_D = request.getParameter("option_D");
		String option_E = request.getParameter("option_E");
		
		//答案
			String correct = "";
			
			if("1".equals(quest_type)||"3".equals(quest_type)) {
				correct = request.getParameter("correct");
			}else if("2".equals(quest_type)) {
				String str [] = request.getParameterValues("correct");
				for (String string : str) {
					correct+=string+",";
				}
			}
				
		//知识点类型类型
		String quest_ctgr = request.getParameter("quest_ctgr");
		//描述
		String descrpt = request.getParameter("descrpt");
		
		RmdQuestions questions = RmdQuestions.builder()
				.correct(correct)
				.descrpt(descrpt)
				.quest_ctgr(CastUtil.castInt(quest_ctgr))
				.quest_type(CastUtil.castInt(quest_type))
				.question(question)
				.build();
		
		RadOptions options = RadOptions.builder()
				.option_A(option_A)
				.option_B(option_B)
				.option_C(option_C)
				.option_D(option_D)
				.option_E(option_E)
				.build();
	
		RmdQuestionsService questionsService = new RmdQuestionsServiceImpl();
		boolean bool = false;
		if("3".equals(quest_type)) {
			bool=questionsService.addQuestions(questions, null);
		}else {
			
			bool= questionsService.addQuestions(questions, options);
		}
		
		response.sendRedirect("GetParentCatagory?method=questions");		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
