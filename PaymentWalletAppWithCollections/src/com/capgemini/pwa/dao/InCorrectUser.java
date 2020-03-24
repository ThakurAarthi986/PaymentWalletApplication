package com.capgemini.pwa.dao;

@SuppressWarnings("serial")
public class InCorrectUser extends Exception {
	public InCorrectUser (final String msg){
        super(msg);
}
}

