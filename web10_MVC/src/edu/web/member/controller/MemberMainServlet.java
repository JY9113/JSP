package edu.web.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.member.service.MemberServiceImple;
import edu.web.member.domain.MemberVO;

/**
 * Servlet implementation class MemberMainServlet
 */
@WebServlet(name = "memberMain", urlPatterns = { "/member-main" })
public class MemberMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceImple service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMainServlet() {
        super();
        service = MemberServiceImple.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = new ArrayList<>();
		list = service.read();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
