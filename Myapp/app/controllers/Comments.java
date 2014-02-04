package controllers;

import java.security.Security;

import play.mvc.With;

@Check("admin")
@With(Secure.class)
public class Comments extends CRUD {

}
