package com.board.controller.action;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory ist = new ActionFactory();
	public static ActionFactory getIst() {return ist;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if (command.equals("loginForm")) ac = new LoginFormAction();
		else if (command.equals("login")) ac = new LoginAction();
		else if (command.equals("boardList")) ac = new BoardListAction();
		else if (command.equals("boardview")) ac = new BoardViewAction();
		else if (command.equals("boardwriteform")) ac = new BoardWriteFormAction();
		else if (command.equals("boardwrite")) ac = new BoardWriteAction();
		else if (command.equals("logout")) ac = new LogoutAction();
		else if (command.equals("joinForm")) ac = new JoinFormAction();
		else if (command.equals("idcheck")) ac = new IdcheckAction();
		else if (command.equals("join")) ac = new JoinAction();
		else if (command.equals("editmemberForm")) ac = new EditMemberFormAction();
		else if (command.equals("editMember")) ac = new EditMemberAction();
		else if (command.equals("boardpassform")) ac = new BoardPassformAction();
		else if (command.equals("boardCheckPass")) ac = new BoardCheckPassAction();
		else if (command.equals("boardupdateform")) ac = new BoardUpdateFormAction();
		else if (command.equals("boardUpdate")) ac = new BoardUpdateAction();
		else if (command.equals("boardDelete")) ac = new BoardDeleteAction();
		else if (command.equals("addReply")) ac = new AddReplyAction();
		else if (command.equals("deleteReply")) ac = new DeleteReplyAction();
		
		return ac;
	}
}